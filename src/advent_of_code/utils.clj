(ns advent-of-code.utils 
  (:require [clojure.string :as str]))

(defn parse-int
  [^String string]
  (Integer/parseInt string))

(defn read-file
  [file-path]
  (str/split (slurp file-path) #"\n"))
