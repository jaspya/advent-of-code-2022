(ns advent-of-code.2022.day3-test
  (:require [advent-of-code.2022.day3 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file-path
  "resources/advent_of_code/2022/day3/example.txt")

(def file-path
  "resources/advent_of_code/2022/day3/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 157 (puzzle1 example-file-path))))

  (testing "solve"
    (is (= 7878 (puzzle1 file-path)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 70 (puzzle2 example-file-path))))

  (testing "solve"
    (is (= 2760 (puzzle2 file-path)))))
