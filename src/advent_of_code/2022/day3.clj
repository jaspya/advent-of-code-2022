(ns advent-of-code.2022.day3
  (:require [clojure.set :refer [intersection]]
            [advent-of-code.utils :as utils]))

(defn char->priority
  [char]
  (let [num (int char)]
    (if (>= num 97)
      (- num 96)
      (- num 38))))

(defn find-duplicate-priority
  [rucksack]
  (->> (map set rucksack)
       (apply intersection)
       first
       char->priority))

(defn solve
  [data]
  (reduce + (map find-duplicate-priority data)))

(defn puzzle1
  [file-path]
  (->> (utils/read-file file-path)
       (map #(split-at (/ (count %) 2) %))
       solve))

(defn puzzle2
  [file-path]
  (->> (utils/read-file file-path)
       (partition 3)
       solve))
