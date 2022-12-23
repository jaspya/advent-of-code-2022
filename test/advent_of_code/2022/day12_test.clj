(ns advent-of-code.2022.day12-test
  (:require [advent-of-code.2022.day12 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day12/example.txt")

(def input-file
  "resources/advent_of_code/2022/day12/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 31 (puzzle1 example-file))))

  #_(testing "solve"
    "try A* for speed?"
    (is (= 352 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 29 (puzzle2 example-file))))

  #_(testing "solve"
    (is (= 345 (puzzle2 input-file)))))
