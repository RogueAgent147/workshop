(ns workshop.chapter3.higher-order-programming)

(update {:item "Tomato" :price 1.0} :price (fn [x] (/ x 2)))

(update {:item "Tomato" :price 1.0} :price / 2)

(update {:item "Tomato" :fruit false} :fruit not)


(defn operate
  [f x] (f x))
(operate inc 3)

(operate clojure.string/capitalize "hello")

(defn operate-v1
  [f & args]
  (apply f args))

(operate-v1 + 1 2 3)
(operate-v1 str "It " "Should " "Concatenate!")

(defn random-fn [] (first (shuffle [+ - * /])))

((random-fn) 2 3)

(fn? random-fn)

(let [mysterious-fn (random-fn)]
  (mysterious-fn 3 5))

;; partial function

(def marketing-adder (partial + 0.99))
(marketing-adder 10 5)

(def format-price (partial str "$"))

(format-price "100")

;; composing functions

(defn sample [coll] (first (shuffle coll)))

(sample [1 2 3 4])

(def sample (comp first shuffle))
(sample [1 2 3 4])

((comp inc *) 2 3)


;; combine the use of partial and comp to compose a checkout function
;; with format price and marketing-adder function

(def checkout (comp (partial str "Only ") format-price marketing-adder))

(checkout 10 5 15 6 9)


;; A new way of writing anonymous functions

#()

(fn [s] (str "Hello" s))
;; is thesame as
#(str "Hello" %)

(fn [x y] (* (+ x 10) (+ y 20)))
;; is thesame as
#(* (+ %1 10) (+ %2 20))