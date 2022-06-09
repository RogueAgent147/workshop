(ns workshop.chapter4.exercise4-07)

(def game-users
  [{:id 9342
    :username "speedy"
    :current-points 45
    :remaining-lives 2
    :experience-level 5
    :status :active}
   {:id 9854
    :username "stealthy"
    :current-points 1201
    :remaining-lives 1
    :experience-level 8
    :status :speed-boost}
   {:id 3014
    :username "sneaky"
    :current-points 725
    :remaining-lives 7
    :experience-level 3
    :status :active}
   {:id 2051
    :username "forgetful"
    :current-points 89
    :remaining-lives 4
    :experience-level 5
    :status :imprisoned}
   {:id 1032
    :username "wandering"
    :current-points 2043
    :remaining-lives 12
    :experience-level 7
    :status :speed-boost}
   {:id 7213
    :username "slowish"
    :current-points 143
    :remaining-lives 0
    :experience-level 1
    :status :speed-boost}
   {:id 5633
    :username "smarter"
    :current-points 99
    :remaining-lives 4
    :experience-level 4
    :status :terminated}
   {:id 3954
    :username "crafty"
    :current-points 21
    :remaining-lives 2
    :experience-level 8
    :status :active}
   {:id 7213
    :username "smarty"
    :current-points 290
    :remaining-lives 5
    :experience-level 12
    :status :terminated}
   {:id 3002
    :username "clever"
    :current-points 681
    :remaining-lives 1
    :experience-level 8
    :status :active}])

(map :current-points game-users)

(def keep-statuses #{:active :imprisoned :speed-boost})

(map :status game-users)

(filter (comp  keep-statuses :status) game-users)
(map :current-points (filter (comp  keep-statuses :status) game-users))

;; tutor

(filter (fn [player] (keep-statuses (:status player))) game-users)
(->> game-users
     (filter (comp #{:active :imprisoned :speed-boost} :status))
     (map :current-points))

;;; Returning a list longer than the input with mapcat

(def alpha-lc ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j"])

(mapcat (fn [letter] [letter (clojure.string/upper-case letter)]) alpha-lc)

;; mapping with multiple inputs

(map (fn [a b] (+ a b)) [5 8 3 1 2] [5 2 7 9 8])

;; zipmap function that takes two sequence and combines them together in a map

(defn our-zipmap [xs ys]
  (->> (map (fn [x y] [x y]) xs ys)
       (into {})))

(our-zipmap [:a :b :c] [1 2 3])

(def meals ["breakfast" "lunch" "dinner" "midnight snack"])

(map (fn [idx meal] (str (inc idx) ". " meal)) (range) meals)

(map-indexed (fn [idx meal] (str (inc idx) ". " meal)) meals)

(def numbers [1 2 3 4 4 5 6 8])

(def broken (partition 4 numbers))
broken
(map (fn [[xs ys]] [xs ys]) broken)

(defn trial
  [partitioned-data]
  (->> (map (fn [[xs ys]] [xs ys]) partitioned-data)
       (into #{})))

(trial broken)