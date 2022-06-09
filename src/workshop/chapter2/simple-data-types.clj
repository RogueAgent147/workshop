
"I am a String"
"I am immutable"

(println "\"The measure of intelligence is the ability to change\"  - Albert 
          Einstein")

;; Strings are immutable

;; In the JVM implementation of Clojure strings are of the 
;; java.lang.String java type and they are implemented as collections
;; of java.lang.Character java type.

(first "a collection of characters")

(type *1)

(str "That's the way you " "con" "ca" "te" "nate")

;;blank?
;;capitalize
;;ends-with?
;;escape
;;includes?
(clojure.string/includes? "potatoes" "toes")
;;index-of

;;join
;;last-index-of
;;lower-case
;;re-quote-replacement
;;replace
;;replace-first
;;reverse
;;split
;;split-lines
;;starts-with?
;;trim
;;trim-newline
;;triml
;;trimr
;;upper-case 


;; Numbers 

(type 1)

(type 100000000000000000000000000000000)

(type 1000000000000000000)

(/ 3 4)
(/ 5 4)

(type 5/4)
(type 3/4)

1.2
(/ 3 4.0)

(* 1.0 2)
(type  (* 1.0 2))

(Math/PI)
(Math/random)
(Math/sqrt 9)
(Math/round 0.7)


;; Booleans 
;; Their value can be either be true or false and their literal 
;; notations are simply the lowercase true and false 

;; Symbols

(def foo "bar")
foo
(defn add-2 [x] (+ x 2)) 
add-2

;; Keywords

:foo 
:another_keyword

