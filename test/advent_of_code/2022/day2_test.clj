(ns advent-of-code.2022.day2-test
  (:require [advent-of-code.2022.day2 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file-path
  "resources/advent_of_code/2022/day2/example.txt")

(def file-path
  "resources/advent_of_code/2022/day2/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 15 (puzzle1 example-file-path))))

  (testing "solve"
    (is (= 13221 (puzzle1 file-path)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 12 (puzzle2 example-file-path))))

  (testing "solve"
    (is (= 13131 (puzzle2 file-path)))))
