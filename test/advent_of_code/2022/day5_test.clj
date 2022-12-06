(ns advent-of-code.2022.day5-test
  (:require [advent-of-code.2022.day5 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day5/example.txt")

(def input-file
  "resources/advent_of_code/2022/day5/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= "CMZ" (puzzle1 example-file))))

  (testing "solve"
    (is (= "MQTPGLLDN" (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= "MCD" (puzzle2 example-file))))

  (testing "solve"
    (is (= "LVZPSTTCZ" (puzzle2 input-file)))))
