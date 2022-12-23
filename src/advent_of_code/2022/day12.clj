(ns advent-of-code.2022.day12
  (:require [advent-of-code.pathfinding :as pathfinding]
            [advent-of-code.utils :as utils]))

(defn coordinates->keyword
  [i j]
  (keyword (str "F" i "-" j)))

(defn height->int
  [height]
  (when height
    (int (case height \S \a \E \z height))))

(defn- get-surrounding-fields
  [field i j]
  (let [height (height->int (get-in field [i j]))
        upper (inc height)]
    (->> [[(dec i) j]
          [(inc i) j]
          [i (dec j)]
          [i (inc j)]]
         (map (fn [[i j]]
                (when-let [target (height->int (get-in field [i j]))]
                  (when (<= target upper)
                    (coordinates->keyword i j)))))
         (remove nil?))))

(defn puzzle1
  [file-path]
  (let [field (->> (utils/read-file file-path)
                   (mapv #(into [] %)))
        control (->> (for [i (range (count field))
                           j (range (count (get field i)))]
                       (case (get-in field [i j])
                         \S [:start (coordinates->keyword i j)]
                         \E [:end (coordinates->keyword i j)]
                         nil))
                     (into {}))
        path (-> (into {} (for [i (range (count field))
                                j (range (count (get field i)))]
                            [(coordinates->keyword i j)
                             (->> (get-surrounding-fields field i j)
                                  (map #(vector % 1))
                                  (into {}))]))
                 (pathfinding/dijksta (:start control) (:end control)))]
    (dec (count path))))

(defn puzzle2
  [file-path]
  (let [field (->> (utils/read-file file-path)
                   (mapv #(into [] %)))
        control (->> (for [i (range (count field))
                           j (range (count (get field i)))]
                       (case (get-in field [i j])
                         \S [:start (coordinates->keyword i j)]
                         \E [:end (coordinates->keyword i j)]
                         nil))
                     (into {}))]
    (->> (for [n (range (count field))]
           (-> (into {} (for [i (range (count field))
                              j (range (count (get field i)))]
                          [(coordinates->keyword i j)
                           (->> (get-surrounding-fields field i j)
                                (map #(vector % 1))
                                (into {}))]))
               (pathfinding/dijksta (coordinates->keyword n 0) (:end control))
               count
               dec))
         sort
         first)))
