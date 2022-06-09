(ns workshop.chapter3.parenthmazesv3)

(def weapon-fn-map
  {:fists (fn [health] (if (< health 100) (- health 10) health))
   :staff (partial + 35)
   :sword #(- % 100)
   :cast-iron-saucepan #(- % 100 (rand-int 50))
   :sweet-potato identity})

((weapon-fn-map :fists) 150)
((weapon-fn-map :fists) 50)
((weapon-fn-map :sword) 150)
((weapon-fn-map :cast-iron-saucepan) 200)

(defn strike
  "with one argument, strike a target with a default :fists `weapon` .
  With two argument, strike a target with `weapon` and return the
  target entity"
  ([target] (strike target :fists))
  ([target weapon]
   (let [weapon-fn (weapon weapon-fn-map)]
     (update target :health weapon-fn))))

(def enemy {:name "Arnold" :health 250})

(strike enemy :sweet-potato)
(strike enemy :sword)
(strike enemy :cast-iron-saucepan)

(strike (strike enemy :sword) :cast-iron-saucepan)


(defn mighty-strike
  "Strike a `target` with all weapons"
  [target]
  (let [weapon-fn (apply comp (vals weapon-fn-map))]
    (update target :health weapon-fn)))

(mighty-strike enemy)

(vals weapon-fn-map)

(vals)