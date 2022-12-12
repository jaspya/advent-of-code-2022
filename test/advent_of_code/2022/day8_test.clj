(ns advent-of-code.2022.day8-test
  (:require [advent-of-code.2022.day8 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day8/example.txt")

(def input-file
  "resources/advent_of_code/2022/day8/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 21 (puzzle1 example-file))))

  (testing "solve"
    (is (= 1776 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 8 (puzzle2 example-file))))

  (testing "solve"
    (is (= 234416 (puzzle2 input-file)))))
