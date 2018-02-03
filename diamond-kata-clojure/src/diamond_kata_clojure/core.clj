(ns diamond-kata-clojure.core
  (:gen-class))

(defn spaces [count]
  (apply str (repeat count " ")))

(defn letter-index [letter]
  (- (int letter) (int \A)))

(defn print-with-gap [letter]
  (let [gap (spaces (- (* 2 (letter-index letter)) 1))]
    (if (= letter \A)
      "A\n"
      (str letter gap letter "\n"))))

(defn mirrored [range from to]
  (concat (range from to) [to] (reverse (range from to))))

(defn char-range [from to]
  (apply vector (map char (range (int from) (int to)))))

(defn char-range-closed [from to]
  (apply vector (map char (range (int from) (inc (int to))))))

(defn letter? [letter]
  (some #{letter} (char-range-closed \A \Z)))

(defn print-diamond [last-letter]
  (let [print-line           (fn [letter]
                               (str (spaces (- (letter-index last-letter) (letter-index letter)))
                                    (print-with-gap letter)))]
    (if (letter? last-letter)
      (apply str (map print-line (mirrored char-range \A last-letter))))))


(defn -main [x]
  (print (print-diamond (first x))))