
(defn meditate [s calm]
     (println "Clojure Meditate v1.0")
     (if calm
            (clojure.string/capitalize s)
            (str (clojure.string/upper-case s) "!")))

(defn meditate-revised=1 [s calmness-level]
  (println "Clojure Meditate v2.0")
  (if (< calmness-level 4)
    (str (clojure.string/upper-case s) " I TELL YA!")
    (if (<= 4 calmness-level 9)
      (clojure.string/capitalize s)
      (if (= 10 calmness-level)
        (clojure.string/reverse s)))))

(meditate-revised=1 "what we do now echoes in eternity" 1)

(meditate-revised=1 "what we do now echoes in eternity" 6)

(meditate-revised=1 "what we do now echoes in eternity" 10)

(meditate-revised=1 "What we do now echoes in eternity" 50)



(defn meditate-revised=2 [s calmness-level]
  (println "Clojure Meditate v2.0")
  (cond
    (< calmness-level 4) (str (clojure.string/upper-case s) " I TELL YA")
    (<= 4 calmness-level 9) (clojure.string/capitalize s)
    (= 10 calmness-level) (clojure.string/reverse s)))


(meditate-revised=2  "what we do now echoes in eternity" 1)

(meditate-revised=2  "what we do now echoes in eternity" 6)

(meditate-revised=2  "what we do now echoes in eternity" 10)

(meditate-revised=2  "what we do now echoes in eternity" 50)



