(ns advent-of-code.2022.day2
  (:require [clojure.string :as str]))

(def game-score
  {["A" "X"] 3 ["B" "X"] 0 ["C" "X"] 6
   ["A" "Y"] 6 ["B" "Y"] 3 ["C" "Y"] 0
   ["A" "Z"] 0 ["B" "Z"] 6 ["C" "Z"] 3})

(def score
  {"X" 1
   "Y" 2
   "Z" 3})

(defn- parse-file
  [file-path]
  (->> (str/split (slurp file-path) #"\n")
       (map #(str/split % #" "))))

(defn- solve
  [strategy-guide]
  (->> strategy-guide
       (map #(+ (game-score %) (score (last %))))
       (reduce +)))

(defn puzzle1
  [file-path]
  (solve (parse-file file-path)))

(def strategy->score
  {"X" 0
   "Y" 3
   "Z" 6})

(defn- strategy->action
  [[opponent strategy]]
  (let [score (strategy->score strategy)]
    (->> game-score
         (filter (fn [[[x _y] v]]
                   (and (= x opponent)
                        (= v score))))
         ffirst)))

(defn puzzle2
  [file-path]
  (solve (map strategy->action (parse-file file-path))))
