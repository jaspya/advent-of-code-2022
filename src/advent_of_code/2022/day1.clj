(ns advent-of-code.2022.day1
  (:require [advent-of-code.utils :as utils]
            [clojure.string :as str]))

(defn- parse-file
  [file-path]
  (->> (str/split (slurp file-path) #"\n\n")
       (map #(map utils/parse-int (str/split % #"\n")))))

(defn puzzle1
  [file-path]
  (->> (parse-file file-path)
       (map #(reduce + %))
       (apply max)))

(defn puzzle2
  [file-path]
  (->> (parse-file file-path)
       (map #(reduce + %))
       (sort >)
       (take 3)
       (reduce +)))
