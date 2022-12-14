(ns advent-of-code.utils 
  (:require [clojure.string :as str])
  (:import java.util.regex.Pattern))

(defn all-unique?
  [collection]
  (= (count collection) (count (set collection))))

(defn parse-int
  [^CharSequence string]
  (Integer/parseInt string))

(defn read-file
  [file-path]
  (str/split (slurp file-path) #"\n"))

(defn split-string
  [^Pattern re ^CharSequence s]
  (str/split s re))

(defn split-vector-at
  [vector at]
  (let [split (- (count vector) at)]
    [(subvec vector 0 split)
     (subvec vector split)]))
