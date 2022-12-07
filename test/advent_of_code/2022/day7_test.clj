(ns advent-of-code.2022.day7-test
  (:require [advent-of-code.2022.day7 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day7/example.txt")

(def input-file
  "resources/advent_of_code/2022/day7/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 95437 (puzzle1 example-file))))

  (testing "solve"
    (is (= 1391690 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= 24933642 (puzzle2 example-file))))

  (testing "solve"
    (is (= 5469168 (puzzle2 input-file)))))
