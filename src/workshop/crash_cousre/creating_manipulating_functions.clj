(ns workshop.crash-cousre.creating-manipulating-functions)
(require '[clojure.string :refer [split-lines starts-with?]])
;; function definition

(defn hello [person]
  (str "hello " person))

(macroexpand
  '(defn hello [person]
     (str "hello " person)))

(defn ^:bench profile-me [ms]
  (println "Cruching bits for" ms "ms")
  (Thread/sleep ms))

(defn dont-profile-me [ms]
  (println "not expecting profiling"))

(defn- wrap [f]
  (fn [& args]
    (time (apply f args))))

(defn- make-profilable
  [v]
  (alter-var-root v (constantly (wrap @v))))

;; Comp
((comp inc +) 2 2)
;; when invoked with know argument comp returns the identity
(def mailing
  [{:name "Mack" :label "12 High St\nAnchorage\n99501"}
   {:name "John" :label "1 Low ln\nWales\n99783"}
   {:name "Jack" :label "4 The Plaza\nAntioch\n43793"}
   {:name "Mike" :label "30 Garden pl\nDallas\n75395"}
   {:name "Anna" :label "1 Blind Alley\nDallas\n75395"}])

(defn postcodes [mailing]
  (map #(last (clojure.string/split-lines (:label %))) mailing))

(postcodes mailing)

(defn postcodes-* [mailing]
  (map #(second (clojure.string/split-lines (:label %))) mailing))

(postcodes-* mailing)

(frequencies (postcodes mailing))

(zipmap (postcodes-* mailing) (postcodes mailing))

(defn postcode [mailing]
  (map
    (comp last split-lines :label) mailing))
(postcode mailing)
(frequencies (postcode mailing))


(get (frequencies (postcodes mailing)) "99501")

(defn postcode-** [mailing]
  (sequence (comp
              (map :label)
              (map split-lines)
              (map last)) mailing))
(postcode-** mailing)

(defn alaska? [postcode]
  (starts-with? postcode "99"))

(defn unique-postcodes [mailing]
  (sequence (comp
              (map :label)
              (map split-lines)
              (map last)
              (remove alaska?)
              (distinct)) mailing))

(unique-postcodes mailing)

;; compliment
((complement {:a 1 :b 2}) :c)
((complement  {:a 1 :b nil} ):b)

(filter (complement #{:a :b :c}) [:d 2 :a 4 5 :c])


(defn turning-left? [wheel]
  (= :left (:turn wheel)))

;; we defined right in terms of left

(def turning-right?
  (complement turning-left?))

(defn turning-left [wheel]
  (if (turning-left? wheel)
    (println "already turning left")
    (println "turning left")))

(defn turning-right [wheel]
  (if (turning-right? wheel)
    (println "already turning right")
    (println "turning right")))

(defn our-remove [pred coll]
  (filter (complement pred) coll))

(filter #{1 2 3} [1 1 1 2 2 2 3 3 4  5 6 7])
(our-remove #{1 2 3} [1 1 1 2 2 2 3 3 4  5 6 7])


;; identity
;; (identity [x])
(identity 1)

(mapcat identity {:a 1 :b 2 :c 3})

(defn custom-filter [x]
  (if (or (nil? x) (false? x))
    false
    true))

(filter custom-filter [0 1 2 false 3 4 nil 5])

;; The reason this works is that values like  false or nil are part of clojure logical false definitions
;; filter works using nil or false as markers for what items should or should not be in final result
;; identity passes values as they are filter can use them directly

(filter identity [0 1 2 false 3 4 nil 5])

(filter identity [1 2 3 4 nil])































;; Higher order functions
;; Threading macros
;; Function execution