(ns advent-of-code.2022.day9-test
  (:require [advent-of-code.2022.day9 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day9/example.txt")

(def example2-file
  "resources/advent_of_code/2022/day9/example2.txt")

(def input-file
  "resources/advent_of_code/2022/day9/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 13 (puzzle1 example-file))))

  (testing "solve"
    (is (= 6339 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 1 (puzzle2 example-file))))

  (testing "example2"
    (is (= 36 (puzzle2 example2-file))))

  (testing "solve"
    (is (= 2541 (puzzle2 input-file)))))
