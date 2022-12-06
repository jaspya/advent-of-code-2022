(ns advent-of-code.2022.day4-test
  (:require [advent-of-code.2022.day4 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file-path
  "resources/advent_of_code/2022/day4/example.txt")

(def file-path
  "resources/advent_of_code/2022/day4/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 2 (puzzle1 example-file-path))))

  (testing "solve"
    (is (= 466 (puzzle1 file-path)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 4 (puzzle2 example-file-path))))

  (testing "solve"
    (is (= 865 (puzzle2 file-path)))))
