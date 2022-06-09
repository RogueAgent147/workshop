(= 1 1 1)
(= 1 1)
(= 1 1 1 -1)

(= nil nil)
(= false nil)
(= "hello" "hello" (clojure.string/reverse "olleh"))
(= [1 2 3] [1 2 3])

(= '(1 2 3) [1 2 3])

(= 1)
(= "I will not reason and compare: my business is to create.")

(< 1 2)
(< 1 10 100 1000)
(< 1 10 10 100)
(< 3 2 3)
(< -1 0 1)

(<= 1 10 10 100)
(<= 1 1 1)
(<= 1 2 3)

(> 3 2 1)
(> 3 2 2)
(>= 3 2 2)

(not true)
(not nil)
(not (< 1 2))
(not (= 1 1))

(let [x 50]
  (if (or (<= 1 x 100) (= 0 (mod x 100))) 
    (println "valid")
    (println "invalid")))


