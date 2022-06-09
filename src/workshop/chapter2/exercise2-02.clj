(ns workshop.chapter2.exercise2-02)

(def favorite-fruit {:name "Kiwi" :color "Green" :kcal_per_100g 61
                     :distinguish_mark "Hairy"})

(get favorite-fruit :name)

(get favorite-fruit :color)

(get favorite-fruit :kcal_per_100g)

(favorite-fruit :color)
(:color favorite-fruit)


(:shape favorite-fruit "egg-like")

(def updeat (assoc favorite-fruit :shape "egg-like"))

updeat

(assoc favorite-fruit :color "Brown")

(assoc favorite-fruit :yearly_production_in_tonnes {:chaina 2025000 :italy 541000 
                                                    :new_zealand 412000 :iran 311000 
                                                    :chille 225000})

(assoc favorite-fruit :kcal_per_100g (-(:kcal_per_100g favorite-fruit) 1))

(update favorite-fruit :kcal_per_100g dec )

(update favorite-fruit :kcal_per_100g - 10)


(dissoc favorite-fruit :name)

(dissoc favorite-fruit :kcal_per_100g :color)