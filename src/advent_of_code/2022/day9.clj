(ns advent-of-code.2022.day9
  (:require [advent-of-code.utils :as utils]))

(defn- move-head
  [[x y] direction]
  (case direction
    "U" [x (inc y)]
    "R" [(inc x) y]
    "D" [x (dec y)]
    "L" [(dec x) y]))

(defn- move-tail
  [[x y] [head-x head-y]]
  (let [x-diff (- x head-x)
        y-diff (- y head-y)]
    [(cond (= x-diff 2) (dec x)
           (= x-diff -2) (inc x)
           (= (abs y-diff) 2) head-x
           :else x)
     (cond (= y-diff 2) (dec y)
           (= y-diff -2) (inc y)
           (= (abs x-diff) 2) head-y
           :else y)]))

(defn- move-rest
  [rope direction]
  (reduce (fn [rope node]
            (conj rope (move-tail node (last rope))))
          [(move-head (first rope) direction)]
          (rest rope)))

(defn- move-rope
  [length instructions]
  (reduce (fn [state direction]
            (let [new-rope (move-rest (:rope state) direction)]
              (-> state
                  (assoc :rope new-rope)
                  (update :visited conj (last new-rope)))))
          {:rope (vec (repeat length [0 0]))
           :visited #{[0 0]}}
          instructions))

(defn- parse-to-single-instructions
  [instruction]
  (let [[direction amount] (utils/split-string #" " instruction)]
    (repeat (utils/parse-int amount) direction)))

(defn- solve
  [length file-path]
  (->> (utils/read-file file-path)
       (mapcat parse-to-single-instructions)
       (move-rope length)
       :visited
       count))

(defn puzzle1
  [file-path]
  (solve 2 file-path))

(defn puzzle2
  [file-path]
  (solve 10 file-path))
