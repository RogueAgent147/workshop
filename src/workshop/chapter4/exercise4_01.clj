(ns workshop.chapter4.exercise4-01)

;; maps
(map #(inc %) [1 2 3 4 5])

;; it returns a function called a transducer
(map #(inc %))

(map #(* 10 %) [1 2 3 4 5 6])

(map #(count %) ["Let's" "measure" "word" "length" "now"])

(map #(str % ": " (count %)) ["Let's" "measure" "word" "length" "now"])

;; filter

;; The result of filter is always subset of the input set.

(filter keyword? ["a" :b "c" :d "e" :f "g"])
(filter #(keyword? %) ["a" :b "c" :d "e" :f "g"])

(odd? 5)
(odd? 6)

(filter #(odd? %) [1 2 3 4 5])

;; we could also use the alter ego of filter, remove which does the exact inverse of filter

(remove #(odd? %) [1 2 3 4 5])

;; whether we keep everything or nothing filter always returns a sequence

(filter (constantly true) [1 2 3 4 5])
(filter (constantly false) ["a" :b "c" :d "e" :f "g"])

;; take-while and drop-while (take and drop)
;; The operate at the beginning of a sequence

(take 3 [1 2 3 4])
(drop 3 [1 2 3 4])

(take-while #(> 10 %) [2 9 4 12 3 99 1])
(drop-while #(> 10 %) [2 9 4 12 3 99 1])