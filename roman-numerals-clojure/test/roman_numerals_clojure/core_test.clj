(ns roman-numerals-clojure.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals-clojure.core :refer :all]))

(deftest a-test
  (testing "additive cases"
           (is (= (to-roman 0) ""))
           (is (= (to-roman 1) "I"))
           (is (= (to-roman 2) "II"))
           (is (= (to-roman 3) "III"))
           (is (= (to-roman 5) "V"))
           (is (= (to-roman 6) "VI"))
           (is (= (to-roman 7) "VII"))
           (is (= (to-roman 10) "X"))
           (is (= (to-roman 11) "XI"))
           (is (= (to-roman 17) "XVII"))
           (is (= (to-roman 50) "L"))
           (is (= (to-roman 77) "LXXVII"))
           (is (= (to-roman 100) "C"))
           (is (= (to-roman 500) "D"))
           (is (= (to-roman 1000) "M"))
           (is (= (to-roman 3000) "MMM")))
  (testing "subractive cases"
           (is (= (to-roman 4) "IV"))
           (is (= (to-roman 14) "XIV"))
           (is (= (to-roman 24) "XXIV"))
           (is (= (to-roman 40) "XL"))
           (is (= (to-roman 9) "IX"))
           (is (= (to-roman 41) "XLI"))
           (is (= (to-roman 59) "LIX"))
           (is (= (to-roman 90) "XC"))
           (is (= (to-roman 400) "CD"))
           (is (= (to-roman 1900) "MCM"))))
