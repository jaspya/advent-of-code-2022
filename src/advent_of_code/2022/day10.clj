(ns advent-of-code.2022.day10
  (:require [advent-of-code.utils :as utils]
            [clojure.string :as str]))

(defn- instruction->number
  [instruction]
  (some-> instruction
          (str/split #" ")
          second
          utils/parse-int))

(defn- solve
  [file-path f x]
  (->> (utils/read-file file-path)
       (mapcat #(if-let [n (instruction->number %)] [0 n] [0]))
       (reduce (fn [state number]
                 (-> state
                     (update :cycle inc)
                     (update :register #(+ % number))
                     (update :result (partial f (:cycle state) (:register state)))))
               {:cycle 1
                :register 1
                :result x})
       :result))

(defn- calculate-signal-strength
  [cycle register s]
  (if (zero? (mod (- cycle 20) 40))
    (+ s (* cycle register))
    s))

(defn puzzle1
  [file-path]
  (solve file-path calculate-signal-strength 0))

(defn- draw-pixel
  [line cycle register]
  (if (<= (dec register) (mod cycle 40) (inc register))
    (str line "#")
    (str line ".")))

(defn- draw-screen
  [cycle register b]
  (update b (quot (dec cycle) 40) #(draw-pixel % (dec cycle) register)))

(defn puzzle2
  [file-path]
  (solve file-path draw-screen []))
