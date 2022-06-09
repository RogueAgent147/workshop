
(defn falsy [x]
  (when x
    (println "okay")
    (println (str x "!"))))
(falsy false)

(if nil "Truthy" "Falsey")
(if false "Truthy" "Falsey")

(if 0 "Truthy" "Falsey")
(if -1 "Truthy" "Falsey")
(if '() "Truthy" "Falsey")
(if [] "Truthy" "Falsey")
(if "false" "Truthy" "Falsey")
(if "" "Truthy" "Falsey")
(if "The truth might not be pure but is simple" "Truthy" "Falsey")

(true? 1)
(if (true? 1)
  "yes" "no")

(true? true)

(false? nil)
(false? false)

(nil? false)
(nil? nil)
(nil? (println "Hello"))

(and "hello") 
(and "Hello" "Then" "Goodbye")
(and false "hello" "Goodbye")
(and (println "hello") (println "Goodbye"))


(or "hello")
(or "hello" "then" "Goodbye")
(or false nil "Goodbye")
(or true (println "Hello"))

