(ns workshop.chapter3.parenthmazes)


(defn welcome
  [player & friends]
  (println (str "Welcome to the parenthmazes " player "!"))
  (when (seq friends)
    (println (str "Sending " (count friends ) " friends request(s) to the
    following players: " (clojure.string/join ", "  friends)))))

(welcome "Jon")
(welcome "Jon" "Arya" "Tyrion" "Petyr")


(defn welcome-*
  ([player] (println  (str "Welocome to Parenthmazes (single-player mode), " player "!" )))
  ([player & friends]
   (println (str "welcome to Parenthmazes (multi-player mode), " player "!"))
   (println  (str "Sending " (count friends) " friend request(s) to the following
   players: " (clojure.string/join " , " friends)))))

(welcome-* "Jon")
(welcome-* "Jon" "Arya" "Tyrion" "Petyr")

(def weapon-damage {:fists 10 :staff 35 :sword 100 :cast-iron-saucepan 150})

(defn strike
  ([enemy] (strike enemy :fists))
  ([enemy weapon]
   (let [damage (weapon weapon-damage)]
     (update enemy :health - damage))))

(strike {:name "n00b-hunter" :health 100})

(strike {:name "n))b hunter" :health 100} :sword)

(strike {:name "n))b hunter" :health 100} :cast-iron-saucepan)






