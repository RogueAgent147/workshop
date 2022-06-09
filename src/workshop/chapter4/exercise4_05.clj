(ns workshop.chapter4.exercise4-05)

(def our-randoms (repeatedly (partial rand-nth 100)))


(defn some-random-integers [size]
  (take size (repeatedly (fn [] (rand-nth 100)))))

(some-random-integers 3)

(map (partial * 10) [1 2 3 4])

(def apart (partial * 10))
(apart 5)

;; writing (partial * 10) is essentially the same thing as writing (fn [x] (* 10 x))

;; Keyword as functions

(:my-field {:my-field 43})

(def fields {:my-field 45})

(:my-field fields)