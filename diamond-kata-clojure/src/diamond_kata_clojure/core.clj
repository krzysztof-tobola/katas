(ns diamond-kata-clojure.core
  (:gen-class))

(defn spaces [count]
  (apply str (repeat count " ")))

(defn letter-index [letter]
  (- (int letter) (int \A)))

(defn print-with-gap [letter]
  (let [gap (spaces (dec (* 2 (letter-index letter))))]
    (if (= letter \A)
      "A"
      (str letter gap letter))))

(defn mirrored [xs]
  (concat (butlast xs) (reverse xs)))

(defn char-range-closed [from to]
  (map char (range (int from) (inc (int to)))))

(def letters-set (set (char-range-closed \A \Z)))
(def letter? letters-set)

(defn format-diamond [last-letter]
  (letfn [(format-line [letter]
            (str (spaces (- (int last-letter) (int letter)))
                 (print-with-gap letter)
                 "\n"))]
    (if (letter? last-letter)
      (->>
        (char-range-closed \A last-letter)
        (mirrored)
        (map format-line)
        (apply str)))))

(defn -main [x]
  (print (format-diamond (first x))))