(ns advent-of-code.2022.day7
  (:require [advent-of-code.utils :as utils]
            [clojure.walk :as walk]))

(defn- change-directory
  [path folder]
  (case folder
    "/" ["/" :contents]
    ".." (pop (pop path))
    (conj path folder :contents)))

(defn- update-path
  [path instruction]
  (cond-> path 
    (= ["$" "cd"] (take 2 instruction))
    (change-directory (last instruction))))

(defn append-to-file-system
  [dir-or-size name file-system]
  (case dir-or-size
    "dir" (update file-system name #(or % {:size 0 :contents {}}))
    (assoc file-system name {:size (utils/parse-int dir-or-size)})))

(defn- update-file-system
  [path file-system [dir-or-size name]]
  (cond-> file-system
    (not= "$" dir-or-size)
    (update-in path (partial append-to-file-system dir-or-size name))))

(defn- process-instruction
  [[path file-system] instruction]
  [(update-path path instruction)
   (update-file-system path file-system instruction)])

(defn- calculate-directory-sizes
  [node]
  (cond-> node
    (and (map? node) (= 0 (:size node)))
    (assoc :size (reduce + (map :size (vals (:contents node)))))))

(defn- build-file-system
  [instructions]
  (->> instructions
       (map (partial utils/split-string #" "))
       (reduce process-instruction [[] {"/" {:size 0 :contents {}}}])
       last
       (walk/postwalk calculate-directory-sizes)))

(defn directory-sizes
  [file-path]
  (->> (utils/read-file file-path)
       build-file-system
       (tree-seq #(and (map? %) (or (not (:size %)) (:contents %))) vals)
       (filter pos-int?)
       (sort)))

(defn puzzle1
  [file-path]
  (->> (directory-sizes file-path)
       (filter (partial > 100000))
       (reduce +)))

(defn- size-needed
  [sizes]
  (- 30000000 (- 70000000 (last sizes))))

(defn find-smallest-directory-for-minimum
  [sizes]
  (->> sizes
       (filter (partial <= (size-needed sizes)))
       first))

(defn puzzle2
  [file-path]
  (->> (directory-sizes file-path)
       (find-smallest-directory-for-minimum)))
