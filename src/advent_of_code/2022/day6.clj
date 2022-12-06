(ns advent-of-code.2022.day6
  (:require [advent-of-code.utils :as utils]))

(defn- solve
  [number datastream]
  (->> (partition number 1 datastream)
       (keep-indexed (fn [idx itm]
                       (when (utils/all-unique? itm)
                         idx)))
       first
       (+ number)))

(defn- solve-all
  [file-path number]
  (->> (utils/read-file file-path)
       (map (partial solve number))))

(defn puzzle1
  [file-path]
  (solve-all file-path 4))

(defn puzzle2
  [file-path]
  (solve-all file-path 14))
