
(clojure.string/replace "Hello World" #"\w" "!")

(clojure.string/replace "Hello World" #"\w" (fn [letter]
                                              (do
                                                (println letter)
                                                "!")))

(int \e)

(first (char-array "a"))

(int (first (char-array "a")))

(Math/pow (int (first (char-array "a"))) 2)


(defn encode-letter [s x]
  (let [code (Math/pow (+ x (int (first (char-array s)))) 2)]
    (str  "#" (int code))))

(encode-letter "h" 2)

(defn encode [s]
  (let
   [number-of-words (count (clojure.string/split s  #""))]
    (clojure.string/replace s #"\w"
                            (fn [s] (encode-letter s number-of-words)))))

(encode "Super secret")


(count (clojure.string/split "happy" #""))


(defn decode-letter
  [x y]
  (let [number (Integer/parseInt (subs x 1))
        letter (char (- (Math/sqrt number) y))]
    (str letter)))


(defn decode [s]
  (let [number-of-words (count (clojure.string/split s #" "))] 
    (clojure.string/replace s #"\#\d+" (fn [s] (decode-letter s number-of-words)))))


(def echo (encode "If you want to keep a secret, you must also hide it from yourself."))

echo

(def receive (decode echo))

receive

