(ns workshop.chapter3.activity3-01)

;; Wing-it
;; the itinerary and cost
;; calculations between two locations
;; :distance :cost :duration :distance(km) :cost(dollars) and :duration(hours)

;; itinerary functions :from :to :transport :vehicle
;; :from :to contain a Hashmap :lat :lon
;; transport can be either :walking or :driving
;; :vehicle is only useful when transport is driving
;; :vehicle -> :sporche :sleta :tayato

;; :sporche 0.12 litres per kilometer $1.5 per liter
;; :tayato 0.07 litres per kilometer $1.5 per liter
;; :sleta  0.2 kilowatt hour (kwh) of electricity per kilometer $0.1 per kwh
;; walking 0
;; The cost of each vehicle should be a function of the distance

;; To compute the duration we consider an average driving speed of 70km per hour and an average
;; walking speed of 5 km per hour

(itenary {:from paris :to bordeaux :transport :walking})

(itenary  {:from paris :to bordeaux :transport :driving :vehicle :tayato})

(def average-waliking-speed 5)
(def average-driving-speed 70)

(def paris {:lat 48.856483 :lon 2.352413})

(def bordeaux {:lat 44.834999 :lon -0.575490})

(defn dist-func
  "takes two parameter representing to location
  which it uses to calculate the distance between them"
  [location1 location2]
  (let [{lon1 :lon lat1 :lat} location1
        {lon2 :lon lat2 :lat} location2]
    (let [step1 (- lat2 lat1)
          step5 (* step1 step1)
          step2 (* (- lon2 lon1) (Math/cos lat1))
          step3 (*  step2 step2)
          step4 (+ step5 step3)]
      (* 110.25 (Math/sqrt step4)))))

(dist-func paris bordeaux)


(defmulti itenary (fn [entry] (get entry :transport)))

(defmethod itenary :walking
  [{:keys [:from :to]}]
  (let [walking-distance (dist-func from to)
        duration (/ (dist-func from to) average-waliking-speed)]
    {:cost 0 :distance walking-distance :duration duration}))

(def vehicle-cost-fns {:sporche (partial * 0.12 1.3)
                       :tayato (partial * 0.07 1.3)
                       :sleta (partial * 0.2 0.1)})

(defmethod itenary :driving
  [{:keys [:from :to :vehicle]}]
    (let [driving-distance (dist-func from to)
          cost ((vehicle vehicle-cost-fns) driving-distance)
          duration (/ driving-distance average-driving-speed)]
        {:cost cost :distance driving-distance :duration duration}))

(def manchester {:lat 53.480759, :lon -2.242631})

(def london {:lat 51.507351, :lon -0.127758})

(itenary {:from london :to manchester :transport :walking})

(itenary {:from manchester :to london :transport :driving :vehicle :sleta})