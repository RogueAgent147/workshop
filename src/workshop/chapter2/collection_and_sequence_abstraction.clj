(ns workshop.chapter2.collection-and-sequence-abstraction)

(def language {:name "Clojure" :creator "Rich Hickey" :platforms ["Java"
                                                                  "JavaScript" ".NET"]})

(count language)

(count #{})
(empty? [])

(seq language)
(nth (seq language) 1)

(first #{:a :b :c})
(rest #{:a :b :c})

(last language)
(into [1 2 3 4 5] #{6 7 8 9})                               ; The are not in order because hashset are not sorted
(into #{1 2 3 4} [5 6 7 8])

(into #{} [1 2 3 3 3 4 4])
(sort (into #{} [1 2 3 3 3 4 4]))

(into {} [[:a 1] [:b 2] [:c 3]])
(into '() [1 2 3 4])

(concat '(1 2) '(3 4))
(into '(1 2) '(3 4))

;; A lot of clojure functions that operate on sequences will
;; return sequences no matter what the input type was. concat is one example

(concat #{1 2 3} #{1 2 3 4 5})
(concat {:a 1} ["Hello"])

;; sort
(def alphabet #{:a :b :c :d :e :f})
alphabet
(sort alphabet)
(sort [3 7 5 1 9])
(into [] *1)

(conj language [:created 2007])
(assoc [:a :b :c :d] 2 :z)

