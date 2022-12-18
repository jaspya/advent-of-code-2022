(ns advent-of-code.2022.day11
  (:require [advent-of-code.utils :as utils]
            [clojure.string :as str]))

(defn parse-operation
  [operation]
  (let [[op amount] (-> (str/split operation #"= old ")
                        last
                        (str/split #" "))
        op (if (= op "*") * +)
        amount (if (= amount "old") :old (utils/parse-int amount))]
    #(op % (if (= amount :old) % amount))))

(defn- handle-item
  [monkeys index reductor]
  (let [monkey (nth monkeys index)
        operation (:operation monkey)
        item (-> (first (:items monkey))
                 operation
                 reductor)
        target (if (zero? (mod item (:test monkey)))
                 (:success monkey)
                 (:fail monkey))]
    (-> monkeys
        (update index #(update % :inspected inc))
        (update index #(update % :items (comp vec rest)))
        (update target #(update % :items conj item)))))

(defn- solve
  [monkeys rounds reductor]
  (->> (reduce (fn [monkeys _]
                 (reduce (fn [monkeys index]
                           (reduce (fn [monkeys _]
                                     (handle-item monkeys index reductor))
                                   monkeys
                                   (range (count (:items (nth monkeys index))))))
                         monkeys
                         (range (count monkeys))))
               monkeys
               (range rounds))
       (map :inspected)
       (sort >)
       (take 2)
       (apply *)))

(defn- parse-monkeys
  [file-path]
  (->> (utils/read-file file-path)
       (partition 6 7)
       (mapv (fn [[id items operation test success fail _]]
               (let [id (utils/parse-int (re-find #"\d+" id))
                     items (mapv utils/parse-int (re-seq #"\d+" items))
                     operation (parse-operation operation)
                     test (utils/parse-int (re-find #"\d+" test))
                     success (utils/parse-int (re-find #"\d+" success))
                     fail (utils/parse-int (re-find #"\d+" fail))]
                 {:id id
                  :items items
                  :operation operation
                  :test test
                  :success success
                  :fail fail
                  :inspected 0})))))

(defn puzzle1
  [file-path]
  (-> (parse-monkeys file-path)
      (solve 20 #(quot % 3))))

(defn puzzle2
  [file-path]
  (let [monkeys (parse-monkeys file-path)
        lcd (apply * (map :test monkeys))]
    (solve monkeys 10000 #(mod % lcd))))
