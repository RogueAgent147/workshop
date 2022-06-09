(ns workshop.chapter3.exercise3-05)

(def player  {:name "Lea" :health 200 :position {:x 10 :y 10 :facing :north}})

(defmulti move (fn [players] (get-in players [:position :facing])))

(move player)

(defmethod move :north
  [entity]
  (update-in entity [:position :y] inc))

(defmethod move :south
  [entity]
  (update-in entity [:position :y] dec))

(defmethod move :west
  [entity]
  (update-in entity [:position :y] inc))

(defmethod move :east
  [entity]
  (update-in entity [:position :y] dec))

(defmethod move :default
  [entity]
  entity)

(move {:position {:x 10 :y 10 :facing :wall}})
(move {:position {:x 10 :y 10 :facing :west}})
(move {:position {:x 10 :y 10 :facing :south}})
(move {:position {:x 10 :y 10 :facing :east}})

