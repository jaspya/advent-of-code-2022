(ns advent-of-code.2022.day4
  (:require [advent-of-code.utils :as utils]))

(defn- parse-file
  [file-path]
  (->> (utils/read-file file-path)
       (map #(->> (utils/split-string #"," %)
                  (mapcat (partial utils/split-string #"-"))
                  (map utils/parse-int)))))

(defn- solve
  [file-path predicate]
  (->> (parse-file file-path)
       (filter predicate)
       count))

(defn- fully-contained?
  [[a b c d]]
  (or (and (<= a c)
           (>= b d))
      (and (<= c a)
           (>= d b))))

(defn puzzle1
  [file-path]
  (solve file-path fully-contained?))

(defn- overlap?
  [[a b c d]]
  (or (<= a c b)
      (<= c a d)))

(defn puzzle2
  [file-path]
  (solve file-path overlap?))
