(ns fizzbuzz-kata-clojure.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz-kata-clojure.core :refer :all]))



(defn item [n] (get (fizzbuzz) (dec n)))

(deftest fizzbuzz-test
  (testing "Fizzbuzz"
           (is (= (count (fizzbuzz)) 100))
           (is (= (item 1) "1"))
           (is (= (item 2) "2"))
           (is (= (item 3) "Fizz"))
           (is (= (item 6) "Fizz"))
           (is (= (item 5) "Buzz"))
           (is (= (item 10) "Buzz"))
           (is (= (item 15) "FizzBuzz"))
           (is (= (item 30) "FizzBuzz"))))
