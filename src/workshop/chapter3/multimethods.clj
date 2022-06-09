(ns workshop.chapter3.multimethods)

(defmulti strike (fn [m] (get m :weapon)))

(ns-unmap 'user 'strike)

(defmulti strike
          (fn [{{:keys [health]}:target weapon :weapon}]
            (if (< health 50) :finisher weapon)))

(defmethod strike :finisher
  [_]
  0)
(defmethod strike :sword
  [{{:keys [:health]} :target}]
  (- health 100))

(strike {:weapon :sword :target {:health 200}})

(strike {:weapon :sword :target {:health 30}})

(defmethod strike :cast-iron-saucepan
  [{{:keys [:health]} :target}]
  (- health 100 (rand-int 50)))

(strike {:weapon :sword :target {:health 200}})

(strike {:weapon :cast-iron-saucepan :target {:health 200}})

(defmethod strike :default
  [{{:keys [:health]} :target}]
  health)

(strike {:weapon :spoon :target {:health 200}})
;; Invoice Multimethod

(def sample {:id 42
             :issue-date 2016
             :due-date 2016
             :customer {:name "Foo Bar Industries"
                        :address "123 Main St"
                        :city "New York"
                        :state "CA"
                        :zipcode "10101"}
             :amount-due 5000})

(defmulti calculate-final-invoice-amount (fn [invoice]
                                           (get-in invoice [:customer :state])))


(calculate-final-invoice-amount sample)

(defmethod calculate-final-invoice-amount "NY"
  [invoice]
  (let [amount-due (:amount-due invoice)]
    (+ amount-due (* amount-due 0.05))))



(defmethod calculate-final-invoice-amount "CA"
  [invoice]
  (let [amount-due (:amount-due invoice)]
    (+ amount-due (* amount-due * 0.045))))

(defmethod calculate-final-invoice-amount :default
  [invoice]
  (:amount-due invoice))

;; Shape Multimethod

(defmulti area (fn [shape & _]
                 shape))

(defmethod area :triangle
  [_ base height]
  (/ (* base height)2))

(defmethod area :square
  [_ side]
  (* side side))

(defmethod area :rectangle
  [_ length width]
  (* length width))

(defmethod area :circle
  [_ radius]
  (* radius radius Math/PI))

(area :square 5)
(area :rectangle 3 7)
(area :triangle 4 6)
(area :circle 5)

