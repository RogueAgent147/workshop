(ns workshop.chapter4.match.deps.deps.exercise4-14)

(require
  '[clojure.data.csv :as csv]
  '[clojure.java.io :as io]
  '[semantic-csv.core :as sc])


(defn match-query
  [csv pred]
  (with-open [x (io/reader csv)]
    (->> (csv/read-csv x)
         sc/mappify
         (filter pred)
         (map #(select-keys % [:winner_name
                               :loser_name
                               :winner_sets_won
                               :loser_sets_won
                               :winner_games_won
                               :loser_games_won
                               :tourney_year_id
                               :tourney_slug]))
         doall)))