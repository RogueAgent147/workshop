(ns workshop.crash-cousre.clojure-core)

(defn year-end-evaluation
  []
  (if (> (rand) 0.5)
    "You get a raise!"
    "Better luck next year!"))

(defn analysis
  [text]
  (str "Character count: " (count text)))

(defn analyze-file
  [filename]
  (analysis (slurp filename)))


(def great-baby-name "Rosanthony")

(let [great-baby-name "Bloodthunder"]
  great-baby-name)

(defn sum
  ([vals] (sum vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
     accumulating-total
     (sum (rest vals) (+ (first vals) accumulating-total)))))

(defn summ
  ([vals] (summ vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
     accumulating-total
     (recur (rest vals) (+ (first vals) accumulating-total)))))

;; Function Composition Instead of Attribute Mutation

(defn clean
  [text]
  (clojure.string/replace (clojure.string/trim text) #"lol" "LOL"))

(clean "My boa constructor is so sassy lol! ")

((comp inc *) 2 3)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
               :strength 4
               :dexterity 5}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(c-int character)
(c-str character)
(c-dex character)

(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

(spell-slots character)

(def spell-slots-comp (comp int inc #(/ % 2) c-int))

(spell-slots-comp character)

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))

(def strength-divider (two-comp #(/ % 2) c-str))

(strength-divider character)

(defn sleepy-identity
  "Return the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)
(time (sleepy-identity 5))
(time (sleepy-identity "Mr. Fantastico"))

(def memo-sleepy-identity (memoize sleepy-identity))
(time (memo-sleepy-identity 5))                             ; repl twice to see it effectiveness
(time (memo-sleepy-identity"Mr. Fantastico"))

