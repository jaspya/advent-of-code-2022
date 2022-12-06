(ns advent-of-code.2022.day6-test
  (:require [advent-of-code.2022.day6 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day6/example.txt")

(def input-file
  "resources/advent_of_code/2022/day6/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= [7 5 6 10 11] (puzzle1 example-file))))

  (testing "solve"
    (is (= [1833] (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= [19 23 23 29 26] (puzzle2 example-file))))

  (testing "solve"
    (is (= [3425] (puzzle2 input-file)))))
