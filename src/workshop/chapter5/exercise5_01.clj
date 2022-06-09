(ns workshop.chapter5.exercise5-01)

;; The basics of reduce

(reduce (fn [sum-so-far item] (+ sum-so-far item)) [8 4000 10 300])

(reduce + [8 4000 10 300])

(apply + [8 4000 10 300])

(def weather-days
  [{:max 31
      :min 27
      :description :sunny
      :date "2019-09-24"}
      {:max 28
         :min 25
         :description :cloudy
         :date "2019-09-25"}
     {:max 22
         :min 18
         :description :rainy
         :date "2019-09-26"}
      {:max 23
         :min 16
         :description :stormy
         :date "2019-09-27"}
     {:max 35
         :min 19
         :description :sunny
         :date "2019-09-28"}])

(apply max (map :max weather-days))

(reduce (fn [min-max-day-so-far this-day]
          (if (> (:max this-day) (:max min-max-day-so-far))
            this-day
            min-max-day-so-far)) weather-days)

(reduce (fn [min-max-day-so-far this-day]
          (if (< (:min this-day) (:min min-max-day-so-far))
            this-day
           min-max-day-so-far))
        weather-days)

(reduce (fn [min-max-day-so-far this-day]
          (if (< (:max this-day) (:max min-max-day-so-far))
            this-day
            min-max-day-so-far)) weather-days)

;; initialization

(reduce (fn [{:keys [minimum maximum]} new-number]
          {:minimum (if (and minimum (> new-number minimum))
                      minimum
                      new-number)
           :maximum (if (and maximum (< new-number maximum))
                      maximum
                      new-number)})
        {}
        [5 25 5004 845 22])


(reduce (fn [ {:keys [minimum]} new-number]
          {:minimum (if (and minimum (> new-number minimum))
                      minimum
                      new-number)})
          [5 25 50004 845 22])

