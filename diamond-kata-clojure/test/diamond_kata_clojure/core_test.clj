(ns diamond-kata-clojure.core-test
  (:require [clojure.test :refer :all]
            [diamond-kata-clojure.core :refer :all]))

(deftest input-validation
  (testing "Should fail when input is not a letter"
           (is (nil? (print-diamond \1)))
           (is (nil? (print-diamond \a)))
           (is (nil? (print-diamond \#)))))

(defn lines [& x] (apply str (map #(str % "\n") x)))

(deftest printing
  (testing "Should print diamond"
           (is (= "A\n" (print-diamond \A)))
           (is
            (=
             (lines
              " A"
              "B B"
              " A")
             (print-diamond \B)))
           (is
            (=
             (lines
              "  A"
              " B B"
              "C   C"
              " B B"
              "  A")
             (print-diamond \C)))

           (is
            (=
             (lines
              "   A"
              "  B B"
              " C   C"
              "D     D"
              " C   C"
              "  B B"
              "   A")
             (print-diamond \D)))))
