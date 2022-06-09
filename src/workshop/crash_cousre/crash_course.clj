(ns workshop.crash-cousre.crash-course)

;; SYNTAX

;; forms
;; Literal representations of data structure (like numbers, strings, maps
;; and vectors)
;; operations

1
"a string"
["a" "vector" "of" "strings"]

;; (operator operand1 operand2 ... operandn)

(+ 1 2 3)
(str "It was the panda " "in the library " "with a dust buster")

;; Control Flow

(if true
  "By Zeus's hammer!"
  "By Aqua-man's trident!")

(if false
  "By Zeus's hammer!"
  "By Aqua-man's trident!")
(if false
  "By Odin's Elbow!")

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aqua-man's trident!"))

(if true
  (do (println "Get me the spoon")
      "Were making soup tonight")
  (do (println "Get me the large fork")
      "Were making yam porridge"))

(if false
  (do (println "Get me the spoon")
      "Were making soup tonight")
  (do (println "Get me the large fork")
      "Were making yam porridge"))

;; when

(when true
  (println "Success!")
  "abracadabra")

(when true
  (println "Get me the spoon")
  "Were making soup tonight")

(when false
  (println "Get me the large fork")
  "Were making yam porridge")

;; nil  true false Truthiness Equality and Boolean Expressions

(nil? 1)
(nil? nil)

(if "bears eat beets"
  "bears beets Battle-star Galactica")

(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

(= 1 1)
(= nil nil)
(= 1 2)

(or false nil :large-i-mean-venti :why-cant-i-just-say-large)
(or (= 0 1) (= "yes" "no"))
(or nil)

(and :free-wifi :hot-coffee)
(and :feeling-super-cool nil false)


;; Naming Values with def

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOOMED!")))

(error-message :mild)

;; Data Structures

;numbers
93
1.2
1/5

;strings
"Lord Voldemort"
"\" He who must be named\""
"\"Great cow of Moscow!\" - Hermes Conrad"

(def namee "Chewbacca")
(str "\"Uggllglglglglglglglll \" - " namee)

;; Maps
; hash maps and sorted maps

{}
{:first-name "Charlie"
 :last-name "McFishwich"}

{"string=key" +}

{:name {:first "john" :middle "jacob" :last "jingleheimerschmidt"}}

(hash-map :a 1 :b 2)

(get (hash-map :a 1 :b 2) :a)
(get (hash-map :a 1 :b {:c "ho hum"}) :b)

(get {:a 0 :b 1} :c)
(get {:a 0 :b 1} :c "unicorn?")

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
({:name "The Human Coffeepot"} :name)

;; keywords

:a
:rumplestiltsken
:34
:_?

(:a {:a 1 :b 2 :c 3})

(get {:a 1 :b 2 :c 3} :a)

(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")

;; vectors

[3 2 1]
(get [3 2 1] 0)
(get ["a" {:name "Pugsley Winter-bottom"} "c"] 1)
(get-in ["a" {:name "Pugsley Winter-bottom"} "c"] [1 :name])
(vector "creepy" "full" "moon")

(conj [1 2 3 4] 5)

;; lists

'(1 2 3 4)
(nth '(:a :b :c) 0)
(nth '(:a :b :c) 2)

(list 1 "two" {3 4})
(conj '(1 2 3) 4)

;; sets
;; clojure has two kinds of sets: hash-sets sorted-sets

#{"kurt vonnegut" 20 :icicle}
(hash-set 1 1 2 2)
(conj #{:a :b} :b)
(set [3 3 3 4 4])
(contains? #{:a :b} :a)
(contains? #{:a :b} 3)
(contains? #{nil} nil )

(:a #{:a :b})
(get #{:a :b} :a)
(get #{:a nil} nil)
(get #{:a :b} "kurt vonnegut")



;;;  Functions

;;Calling functions
;;How functions differ from macros and special forms
;;Defining functions
;;Anonymous functions
;;Returning functions

; ***1
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])

(or + -)
((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

(inc 1.1)
(map inc [0 1 2 3])

;*****2
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Zelda")

(defn no-params
  []
  "I take no parameters!")
(no-params)

(defn one-param
  [x]
  (str "I take one parameter: " x))
(one-param "Zelda")

(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))
(two-params "one" "two")

(defn x-chop
  "Describes the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name] (x-chop name "karate")))

(x-chop "Kanye West" "slap")
(x-chop "Kanye East")

(defn weird-arity
  ([]
   "Destiny dressed you this morning, my friend, and now Fear is
   trying to pull off your pants. If you give up, if you give in,
   you're gonna end up naked with Fear just standing there laughing
   at your dangling unmentionables! - the Tick")
  ([number]
   (inc number)))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The incredible Bulk")

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join things)))

;; Destructuring
;; it lets you concisely bind name to a value

(defn my-first
  [[first-thing]]
  first-thing)

(my-first ["oven" "bike" "war-axe"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

(defn announce-treasure-location
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

;; you can retain original map argument by using :as keyword

(defn receive-treasure-location
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng))
  (println treasure-location))

;******4

(map (fn [name] (str "HI " name))
     ["Dart Vader" "Mr. Magoo"])

((fn [x] (* x 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)

(def my-special-multiplier-* (fn rules ([x y] (* x y))
                               ([x] (rules x 2))))
(my-special-multiplier 12)

(#(* % 3) 8)

(#(str %1 " and " %2) "cornbread" "butter beans")

(#(identity %&) 1 "blarg" :yip)

;; Returning Functions

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def ice (inc-maker 4))
(ice 5)

;; pulling it all together

(def asym-hobbit-body-part
  [{ :name "head" :size 3}
   {:name "left-eye" :size 1}
  { :name "left-ear" :size 1}
  { :name "mouth" :size 1}
  { :name "nose" :size 1}
  {:name "neck" :size 2}
  {:name "left-shoulder" :size 3}
  {:name "left-upper-arm" :size 3}
  {:name "chest" :size 10}
  {:name "back" :size 10}
  {:name "left-forearm" :size 3}
  {:name "abdomen" :size 6}
  {:name "left-kidney" :size 1}
  {:name "left-hand" :size 2}
  {:name "left-knee" :size 2}
  {:name "left-thigh" :size 4}
  {:name "left-lower-leg" :size 3}
  {:name "left-achilles" :size 1}
  {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(def the-other-side (map matching-part asym-hobbit-body-part))
the-other-side

(defn symmetrize-body-parts
  "Expect a seq of maps that have :name and size"
  [asym-body-parts]
  (loop [all-parts-inn asym-body-parts
        complete-body []]
    (if (empty? all-parts-inn)
      complete-body
      (let [[part & remaining] all-parts-inn]
        (recur remaining
               (into complete-body
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-part)

(let [x 3]
  x)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(def x 0)
(let [x (inc x)] x)

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))

(defn recursive-printer
  ([] (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))

(recursive-printer)

;; Regular Expression
;; Regular expressions are tools for performing pattern matching on text
;; #"regular-expression"
;; The caret ^ is how the regular expression signals that it will match the next "left-" only if
;; it's at the beginning of the string
;; you can test with re-find which checks whether a string matches the pattern described regular
;; expression

(re-find #"^left-" "left-eye")
(re-find #"^left-" "cleft-chin")
(re-find #"^left-" "wongleblart")

;; Better Symmetrizer with reduce

(reduce + [1 2 3 4])
(reduce + 15 [1 2 3 4])

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))


(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-part)
(hit asym-hobbit-body-part)

(defn hope [love]
  (println (str "I love you " love)))
(hope "chinonso")

(vector 1 2 3 4)
(get (vector 1 2 3 4) 2)
(nth (list 1 2 3 4) 2)
(get (hash-map :a "a" :b "b") :a)
(apply hash-set (vector 1 2 3 3 4 1 2))

(defn centurion [x]
  (+ x 100))
(centurion 3)

(defn dec-maker [x]
  (fn [yoho]
    (- yoho x)))

(def dec9 (dec-maker 9))
(dec9 10)

(defn mapset [vec f]
  (let [final #{}]
    (into final
          (map f vec))))
(mapset [1 1 2 2] inc)

