(ns roman-numerals-clojure.core)

(def symbols [[:M 1000]
              [:CM 900]
              [:D 500]
              [:CD 400]
              [:C 100]
              [:XC 90]
              [:L 50]
              [:XL 40]
              [:X 10]
              [:IX 9]
              [:V 5]
              [:IV 4]
              [:I 1]])

(defn to-roman [num]
  (if-let [[symbol value]     (->> symbols
                                   (filter (fn [[_ v]] (>= num v)))
                                   (first))]
    (str (name symbol) (to-roman (- num value)))
    ""))