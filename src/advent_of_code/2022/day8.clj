(ns advent-of-code.2022.day8
  (:require [advent-of-code.utils :as utils]))

(defn- loop-matrix
  [matrix f]
  (let [matrix-range (range (count matrix))]
    (reduce (fn [matrix x]
              (reduce (fn [matrix y]
                        (f matrix x y))
                      matrix
                      matrix-range))
            matrix
            matrix-range)))

(defn- count-down
  [field index]
  (loop-matrix field (fn [m x y]
                       (let [v1 (or (get-in m [(- x 1) y 0]) -1)
                             v2 (or (get-in m [(- x 1) y index]) -1)]
                         (assoc-in m [x y index] (max v1 v2))))))

(defn transpose
  [matrix]
  (apply mapv vector matrix))

(defn rotate
  [matrix]
  (->> (transpose matrix)
       (mapv (comp vec reverse))))

(defn count-down-all
  [field]
  (reduce (comp rotate count-down) field (range 1 5)))

(defn puzzle1
  [file-path]
  (->> (utils/read-file file-path)
       (mapv #(mapv (fn [i] [(utils/parse-int i)])
                    (utils/split-string #"" %)))
       (count-down-all)
       (apply concat)
       (filter (fn [[own a b c d]] (> own (min a b c d))))
       count))

(defn take-count
  [f range]
  (let [c (count range)
        res (count (take-while f (vec range)))]
    (if (< res c)
      (+ res 1)
      res)))

(defn- count-all-directions
  [field x y]
  (let [length (count field)
        s (get-in field [x y])]
    (* (take-count #(> s (get-in field [% y])) (range (+ x 1) length))
       (take-count #(> s (get-in field [% y])) (reverse (range 0 x)))
       (take-count #(> s (get-in field [x %])) (range (+ y 1) length))
       (take-count #(> s (get-in field [x %])) (reverse (range 0 y))))))

(defn puzzle2
  [file-path]
  (let [field (->> (utils/read-file file-path)
                   (mapv #(mapv (fn [i] (utils/parse-int i))
                                (utils/split-string #"" %))))]
     (->> (for [x (range (count field))]
            (for [y (range (count field))]
              (count-all-directions field x y)))
          flatten
          (apply max))))
