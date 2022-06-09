(ns workshop.chapter4.consuming-extracted-data-with-apply)

(apply max [3 9 6])

(let [a 5
      b nil
      c 18]
  (+ a b c))

(let [a 5
      b nil
      c 18]
  (apply + (filter integer? [a b c])))

;; min and max will fail if we apply them to an empty list:
(apply min [])
(apply max [])
;; supply at least one value ; this is made better because apply accepts non-list items before
;; list arguments
(apply min 0 [])
(apply max 0 [])