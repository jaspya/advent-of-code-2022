(ns advent-of-code.2022.day11-test
  (:require [advent-of-code.2022.day11 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day11/example.txt")

(def input-file
  "resources/advent_of_code/2022/day11/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 10605 (puzzle1 example-file))))

  (testing "solve"
    (is (= 61005 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 2713310158 (puzzle2 example-file))))

  (testing "solve"
    (is (= 20567144694 (puzzle2 input-file)))))
