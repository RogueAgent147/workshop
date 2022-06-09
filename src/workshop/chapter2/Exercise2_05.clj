(ns workshop.chapter2.Exercise2-05)


(def my-todo (list "Feed the cat" "Clean the bathroom"
                   "Save the world"))
(conj my-todo "Go to work")

(conj my-todo  "Go to work" "Wash my socks")

(first my-todo)
(rest my-todo)

(nth my-todo 2)