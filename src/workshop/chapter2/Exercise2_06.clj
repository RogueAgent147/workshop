(ns workshop.chapter2.Exercise2-06)


(def gemstone-db {
                  :ruby {
                         :name "Ruby"
                         :stock 480
                         :sales [1990 3644 6376 4918 7882 6737 2342 42523 2342]
                         :properties {
                                      :dispersion 0.018
                                      :hardness 9.0
                                      :refractive-index [1.77 1.78]
                                      :color "Red"
                                      }
                         }
                  })

(get (get (get gemstone-db :ruby) :properties) :hardness)
(:hardness (:properties (:ruby gemstone-db)))

(get-in gemstone-db [:ruby :properties :hardness])

(defn durability
  [db gemstone types]
  (get-in db [gemstone :properties types]))

(durability gemstone-db :ruby :hardness)

(assoc-in gemstone-db [:ruby :properties :color] "Near colorless through pink
through all shades of red to a deep crimson")

(defn update-color
  [db gemstone new-color]
  (assoc-in db [gemstone :properties :color] new-color))

(update-color gemstone-db :ruby :brown)

(update-in gemstone-db [:ruby :stock] dec)
;;(set! *print-level* 1)
(update-in gemstone-db [:ruby :stock] dec)
(set! *print-level* nil)
(update-in gemstone-db [:ruby :sales] conj 999)


(defn sell
  [db gemstone client-id]
  (let [clients-updated-db (update-in db [gemstone :sales] conj client-id)]
    (update-in clients-updated-db [gemstone :stock] dec)))
