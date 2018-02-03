(ns diamond-kata-clojure.core-test
  (:require [clojure.test :refer :all]
            [diamond-kata-clojure.core :refer :all]))

(deftest input-validation
  (testing "Should fail when input is not a letter"
           (is (nil? (print-diamond \1)))
           (is (nil? (print-diamond \a)))
           (is (nil? (print-diamond \#)))))

(deftest printing
  (testing "Should print diamond"
           (is (= "A\n" (print-diamond \A)))
           (is
            (=
             (str
              " A\n"
              "B B\n"
              " A\n")
             (print-diamond \B)))
           (is
            (=
             (str
              "  A\n"
              " B B\n"
              "C   C\n"
              " B B\n"
              "  A\n")
             (print-diamond \C)))

           (is
            (=
             (str
              "   A\n"
              "  B B\n"
              " C   C\n"
              "D     D\n"
              " C   C\n"
              "  B B\n"
              "   A\n")
             (print-diamond \D)))))
