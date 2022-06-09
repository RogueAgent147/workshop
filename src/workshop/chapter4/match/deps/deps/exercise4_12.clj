(ns workshop.chapter4.match.deps.deps.exercise4-12)

(require
  '[clojure.data.csv :as csv]
  '[clojure.java.io :as io]
  '[semantic-csv.core :as sc])

(def accounts "/home/nicholas/workshop/src/workshop/chapter4/match/deps/deps/vi.csv")


(defn first-match
  [csv]
  (with-open [s (io/reader csv)]
    (->> (csv/read-csv s)
         sc/mappify
         first)))
(first-match accounts)

(defn five-matches
  [csv]
  (with-open [s (io/reader csv)]
    (->> (csv/read-csv s)
         sc/mappify
         (map #(select-keys % [:tourney_year_id
                               :winner_name
                               :loser_name
                               :winner_sets_won
                               :loser_sets_won]))
         (take 5)
         doall)))

(defn five-matches-init-sets
  [csv]
  (with-open [s (io/reader csv)]
    (->> (csv/read-csv s)
         sc/mappify
         (map #(select-keys %  [:tourney_year_id
                                :winner_name
                                :loser_name
                                :winner_sets_won
                                :loser_sets_won]))
         (sc/cast-with {:winner_sets_won sc->int
                        :loser_sets_won sc/->int})
         (take 5)
         doall))
  )

(five-matches-init-sets accounts)

(defn federal-wins
  [csv]
  (with-open [c (io/reader csv)]
    (->> (csv/read-csv c)
         sc/mappify
         (map #(select-keys % [:winner_name
                               :loser_name
                               :winner_sets_won
                               :loser_sets_won
                               :winner_games_won
                               :loser_games_won
                               :tourney_year_id
                               :tourney_slug]))
         doall)))

(defn federer-wins [csv]
  [csv]
  (with-open [x (io/reader csv)]
    (->> (csv/read-csv x)
         sc/mappify
         (filter #(= "Roger Federer" (:winner_name %)))
         (map #(select-keys % [:winner_name
                               :loser_name
                               :winner_sets_won
                               :loser_sets_won
                               :winner_games_won
                               :loser_games_won
                               :tourney_year_id
                               :tourney_slug]))
         doall)))

