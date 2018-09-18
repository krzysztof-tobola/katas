(ns roman-numerals-clojure.core)

(def symbols [["M" 1000]
              ["CM" 900]
              ["D" 500]
              ["CD" 400]
              ["C" 100]
              ["XC" 90]
              ["L" 50]
              ["XL" 40]
              ["X" 10]
              ["IX" 9]
              ["V" 5]
              ["IV" 4]
              ["I" 1]])

(defn to-arabic [roman]
  (let [symbol-to-value   (into {} symbols)
        pattern           (->> symbols
                               (map first)
                               (interpose "|")
                               (apply str)
                               re-pattern)]
    (->> (re-seq pattern roman)
         (map symbol-to-value)
         (apply +))))


(defn to-roman [num]
  (if-let [[symbol value]     (->> symbols
                                   (filter (fn [[_ v]] (>= num v)))
                                   (first))]
    (str symbol (to-roman (- num value)))
    ""))