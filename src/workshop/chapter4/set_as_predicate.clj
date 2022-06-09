(ns workshop.chapter4.set-as-predicate)
(require  '[clojure.string :as string])

(def alpha-set (set [:a :b :c]))

(alpha-set :z)
(alpha-set :a)

(hash-set :a :b :c)

;; The clojure.set library is built into clojure. This is extremely useful
;; library contains functions for performing set arithmetic such as intersection


(def animal-names ["turtle" "horse" "cat" "frog" "hawk" "worm"])

;; we want to remove all mammals from the list

(remove (fn [animal-name]
          (or (= animal-name "horse")
              (= animal-name "cat")))
        animal-names)

(remove #{"horse" "cat"} animal-names)

;; The clojure.string library is a standard library that provides many familiar string
;; manipulation functions such as split and join

(defn normalize [s] (string/trim (string/lower-case s)))

(normalize "  Some INFORMATION  ")

;; (comp function-c function-b function-a) from right to left
;; equivalent to this
;; (fn [x] (function-c (function-b (function-a x))

(def norm (comp string/trim string/lower-case))

(norm " some  INFORMATION")


(def remove-words #{"and" "an" "a" "of" "is"})

(remove (comp remove-words string/lower-case string/trim) ["February"  " THE " "4th"])
