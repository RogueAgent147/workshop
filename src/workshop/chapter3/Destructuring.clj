(ns workshop.chapter3.Destructuring)

(def sample [48.9615 2.4372])

(defn print-coords
  [coords]
  (let [lat (first coords)
        lon (last coords)]
    (println (str "Latitude: " lat " - " "Longitude: " lon))))

(print-coords sample)

(defn print-coords-*
  [coords]
  (let [[lat lon] coords]
    (println (str "Latitude: " lat " - " "Longitude: " lon ))))

(print-coords-* sample)

(let [[a b c] '(1 2 3)]
  (println a b c))

(def new-data {:lat 48.9615, :lon 2.4372, :code 'LFPB', :name "Paris Le Bourget Airport"})

(defn print-coords-** 
  [airport] 
  (let [lat (:lat airport) 
        lon (:lon airport) 
        name (:name airport)]
    (println (str name " is located at Latitude: " lat " - " "Longitude: " lon))))

(print-coords-** new-data)

(defn print-coords-***
  [airport]
  (let [{lat :lat lon :lon name :name} airport]
    (println (str name " is located at Latitude: " lat " - " "Longitude: "
                  lon))))

(print-coords-*** new-data)

(defn print-coords-****
  [airport]
  (let [{:keys [lat lon name]} airport]
    (println (str name " is located at Latitude: " lat " - " "Longitude: "
                  lon))))

(print-coords-**** new-data)