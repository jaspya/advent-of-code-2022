(ns advent-of-code.2022.day13-test
  (:require [advent-of-code.2022.day13 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day13/example.txt")

(def input-file
  "resources/advent_of_code/2022/day13/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 13 (puzzle1 example-file))))

  (testing "solve"
    (is (= 5720 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 140 (puzzle2 example-file))))

  (testing "solve"
    (is (= 23504 (puzzle2 input-file)))))
