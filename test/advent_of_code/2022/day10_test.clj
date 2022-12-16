(ns advent-of-code.2022.day10-test
  (:require [advent-of-code.2022.day10 :refer [puzzle1 puzzle2]]
            [clojure.test :refer [deftest is testing]]))

(def example-file
  "resources/advent_of_code/2022/day10/example.txt")

(def input-file
  "resources/advent_of_code/2022/day10/input.txt")

(deftest puzzle1-test
  (testing "example"
    (is (= 13140 (puzzle1 example-file))))

  (testing "solve"
    (is (= 13680 (puzzle1 input-file)))))

(deftest puzzle2-test
  (testing "example"
    (is (= ["##..##..##..##..##..##..##..##..##..##.."
            "###...###...###...###...###...###...###."
            "####....####....####....####....####...."
            "#####.....#####.....#####.....#####....."
            "######......######......######......####"
            "#######.......#######.......#######....."]
           (puzzle2 example-file))))

  (testing "solve"
    (is (= ["###..####..##..###..#..#.###..####.###.."
            "#..#....#.#..#.#..#.#.#..#..#.#....#..#."
            "#..#...#..#....#..#.##...#..#.###..###.."
            "###...#...#.##.###..#.#..###..#....#..#."
            "#....#....#..#.#....#.#..#....#....#..#."
            "#....####..###.#....#..#.#....####.###.."]
           (puzzle2 input-file)))))
