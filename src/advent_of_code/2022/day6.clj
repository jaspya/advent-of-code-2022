(ns advent-of-code.2022.day6
  (:require [advent-of-code.utils :as utils]))

(defn- find-unique-index
  [number data-stream idx _itm]
  (when (= number (count (set (subs data-stream idx (+ idx number)))))
    (+ idx number)))

(defn- solve
  [file-path number]
  (->> (utils/read-file file-path)
       (map #(keep-indexed (partial find-unique-index number %) %))
       (map first)))

(defn puzzle1
  [file-path]
  (solve file-path 4))

(defn puzzle2
  [file-path]
  (solve file-path 14))
