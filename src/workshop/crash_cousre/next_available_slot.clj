(ns workshop.crash-cousre.next-available-slot)

(def cashiers (ref [1 2 3 4 5]))

(defn next-available []
  (some identity @cashiers))
