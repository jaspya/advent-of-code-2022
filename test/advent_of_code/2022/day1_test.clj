(ns advent-of-code.2022.day1-test
  (:require [advent-of-code.2022.day1 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file-path
  "resources/advent_of_code/2022/day1/example.txt")

(def file-path
  "resources/advent_of_code/2022/day1/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 24000 (puzzle1 example-file-path))))
  
  (testing "solve"
    (is (= 67027 (puzzle1 file-path)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 45000 (puzzle2 example-file-path))))
  
  (testing "solve"
    (is (= 197291 (puzzle2 file-path)))))
