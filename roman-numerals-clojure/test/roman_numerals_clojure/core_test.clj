(ns roman-numerals-clojure.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals-clojure.core :refer :all]))


(deftest roman-to-arabic
  (testing "additive cases"
    (are [roman arabic]
      (= (to-arabic roman) arabic)
      "I" 1
      "II" 2
      "III" 3
      "V" 5
      "VIII" 8
      "MDCLXVIII" 1668))

  (testing "subtractive cases"
    (are [roman arabic]
      (= (to-arabic roman) arabic)
      "IV" 4
      "IX" 9
      "MCMIV" 1904)))

(deftest arabic-to-roman
  (testing "additive cases"
    (are [arabic roman]
      (= (to-roman arabic) roman)
      0 ""
      1 "I"
      2 "II"
      3 "III"
      5 "V"
      6 "VI"
      7 "VII"
      10 "X"
      11 "XI"
      17 "XVII"
      50 "L"
      77 "LXXVII"
      100 "C"
      500 "D"
      1000 "M"
      3000 "MMM"))

  (testing "subractive cases"
    (are [arabic roman]
      (= (to-roman arabic) roman)
      4 "IV"
      14 "XIV"
      24 "XXIV"
      40 "XL"
      9 "IX"
      41 "XLI"
      59 "LIX"
      90 "XC"
      400 "CD"
      1900 "MCM")))
