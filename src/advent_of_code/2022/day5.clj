(ns advent-of-code.2022.day5 
  (:require [clojure.string :as str]
            [advent-of-code.utils :as utils]))

(defn- parse-instruction
  [data row]
  (if (str/starts-with? row "move")
    (update data :moves #(conj % (re-seq #"[\d.]+" row)))
    (update data :crates #(conj % (re-seq #"[A-Z]|\s{4}" row)))))

(defn- parse-moves
  [moves]
  (->> moves
       reverse
       (map (partial map utils/parse-int))
       (map (fn [[amount from to]]
              [amount (dec from) (dec to)]))))

(defn- parse-crates
  [crates]
  (->> crates
       (remove nil?)
       (apply mapv vector)
       (mapv #(remove str/blank? %))
       (mapv vec)))

(defn- solve
  [file-path move-crate-fn]
  (let [{:keys [moves crates]}
        (->> (utils/read-file file-path)
             (reduce parse-instruction {}))]
    (->> (parse-moves moves)
         (reduce move-crate-fn (parse-crates crates))
         (map last)
         (apply str))))

(defn- move-crates
  [crates [amount from to]]
  (let [[new top] (utils/split-vector-at (get crates from) amount)]
    (-> (assoc crates from new)
        (update to #(vec (concat % top))))))

(defn- move-by-one
  [crates [amount from to]]
  (nth (iterate #(move-crates % [1 from to]) crates) amount))

(defn puzzle1
  [file-path]
  (solve file-path move-by-one))

(defn puzzle2
  [file-path]
  (solve file-path move-crates))
