(ns workshop.chapter3.advanced-call-signatures)


(defn print-flight
  [[[lat1 lon1] [lat2 lon2]]]
  (println (str "Flying from: Lat " lat1 " Lon "
                lon1 " Flying to: Lat " lat2 " Lon " lon2)))

(print-flight [[48.9615 2.4372] [37.742 -25.6976]])

(defn print-mapjet-flight
  [{{lat1 :lat  lon1 :lon} :from, {lat2 :lat lon2 :lon} :to}]
  (println (str "Flying from: Lat" lat1 " Lon " lon1 " Flying to: Lat " lat2 " Lon " lon2)))

(print-mapjet-flight {:from {:lat 48.9615 :lon 2.4372}, :to {:lat 37.742 :lon -25.6976}})

;; Arity Overloading

(defn no-overloading []
  (println  "Same old, same old..."))

(defn overloading
  "overloading a function based on number of supplied arity"
  ([] "No argument")
  ([a] (str "One argument: " a))
  ([a b] (str "Two arguments: a: " a " b: " b)))

(overloading)
(overloading 2)
(overloading "a" "v")


;; Variadic Functions

(str "Concatenating " "is " "difficult " "to " "spell " "but " "easy " "to "
     "use!")

