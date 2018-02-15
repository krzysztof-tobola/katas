(ns fizzbuzz-kata-clojure.core
  (:gen-class))


(defn divisible? [x y] (= 0 (mod x y)))

(defn to-fizzbuzz-string [x]
  (letfn
    [(fizz? [] (divisible? x 3))
     (buzz? [] (divisible? x 5))]
    (cond
      (and (fizz?) (buzz?))         "FizzBuzz"
      (fizz?)                       "Fizz"
      (buzz?)                       "Buzz"
      :else                         (str x))))

(defn fizzbuzz []
  (->> (range 1 101)
       (map to-fizzbuzz-string)
       (apply vector)))
