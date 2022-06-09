(ns workshop.chapter4.exercise4-03)


(def students  [{:name "Eliza" :year 1994}
                {:name "Salma" :year 1995}
                {:name "Jodie" :year 1997}
                {:name "Kaitlyn" :year 2000}
                {:name  "Alice" :year 2000}
                {:name "Pippa" :year 2002}
                {:name "Fleur" :year 2002}])

#(< (:year %) 2000)

(take-while #(< (:year %) 2000) students)
(drop-while #(< (:year %) 2000) students)

(map (fn [n] (* n 10))
     (filter odd? [1 2 3 4 5]))


;; Threading Macros

(def filtered (filter odd? [1 2 3 4 5]))

(map (fn [n] (* 10 n)) filtered)

(->> [1 2 3 4 5]
     (filter odd?)
     (map (fn [n] (* 10 n))))


;; using lazy sequence

(range 1 6)
(def our-seq (range 100))
(first our-seq)
(last our-seq)

;; map filter remove are lazy
;; This means that when we call
;; them on a lazy sequence, they do not force the calculation of the entire sequence