(ns diamond-kata-clojure.core-test
  (:require [clojure.test :refer :all]
            [diamond-kata-clojure.core :refer :all]))

(defn- lines->str [& xs] (apply str (mapcat list xs (repeat "\n"))))

(deftest input-validation
  (testing "Should fail when input is not a letter"
    (are [x] (nil? (format-diamond x))
             \1
             \a
             \#
             )))

(deftest printing
  (testing "Should print diamond"
    (are [y xs] (= (apply lines->str xs) (format-diamond y))
                \A ["A"]

                \B [" A"
                    "B B"
                    " A"]

                \C ["  A"
                    " B B"
                    "C   C"
                    " B B"
                    "  A"]

                \D ["   A"
                    "  B B"
                    " C   C"
                    "D     D"
                    " C   C"
                    "  B B"
                    "   A"]
                )))
