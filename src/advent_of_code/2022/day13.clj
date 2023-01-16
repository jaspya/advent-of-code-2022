(ns advent-of-code.2022.day13
  (:require [advent-of-code.utils :as utils]
            [clojure.edn :as edn]))

(defn compare-packets
  [left right]
  (if (and (number? left) (number? right))
    (when (not= left right) (< left right))
    (let [left (if (vector? left) left [left])
          right (if (vector? right) right [right])]
      (cond (and (empty? left) (empty? right)) nil
            (empty? right) false
            (empty? left) true
            :else (let [res (compare-packets (first left) (first right))]
                    (if (nil? res)
                      (compare-packets (vec (rest left)) (vec (rest right)))
                      res))))))

(defn puzzle1
  [file-path]
  (->> (utils/read-file file-path)
       (map edn/read-string)
       (partition 2 3)
       (map-indexed (fn [idx [left right]]
                      (if (compare-packets left right)
                        (inc idx)
                        0)))
       (reduce +)))
 
(defn puzzle2
  [file-path]
  (let [sorted (->> (utils/read-file file-path)
                    (map edn/read-string)
                    (remove nil?)
                    (concat [[[2]] [[6]]])
                    (sort compare-packets))]
    (* (inc (.indexOf sorted [[2]]))
       (inc (.indexOf sorted [[6]])))))
