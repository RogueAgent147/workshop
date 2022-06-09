
(def base-mult 2)
(def base-co2 382)
(def base-year 2006)

;; Estimate = 382 + ((Year - 2006) * 2)

(defn co2-estimate
  "takes one integer and retruns the estimated level of CO2
   ppm for that year"
  [year]
  (let [year-diff (- year base-year)
        year-prod (* base-mult year-diff)]
    (+ base-co2 year-prod)))


(co2-estimate 2006)
(co2-estimate 2020)
(co2-estimate 2050)

