(ns workshop.chapter4.match.deps.deps.edn)

(require '[clojure.data.csv :as csv])
(require '[clojure.java.io :as io])

(with-open [r (io/reader "/home/nicholas/workshop/src/workshop/chapter4/match/deps/deps/vi.csv")]
  (first (csv/read-csv r)))

(with-open  [r (io/reader "/home/nicholas/workshop/src/workshop/chapter4/match/deps/deps/vi.csv")]
  (count (csv/read-csv r)))


(with-open [r (io/reader "/home/nicholas/workshop/src/workshop/chapter4/match/deps/deps/vi.csv")]
  (->> (csv/read-csv r)
       (map #(nth % 7))
       (take 6)))

(with-open [r (io/reader "/home/nicholas/workshop/src/workshop/chapter4/match/deps/deps/vi.csv")]
  (->> (csv/read-csv r)
       (map #(nth % 7))
       (take 7)
       doall))

