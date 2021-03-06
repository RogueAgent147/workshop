(ns workshop.crash-cousre.peg-thing)

(declare successful-move prompt-move game-over query-rows)

(def peg-board-occ
  {1 {:pegged true, :connections {6 3, 4 2}}
   2 {:pegged true, :connections {9 5, 7 4}}
   3 {:pegged true, :connections {10 6, 8 5}}
   4 {:pegged true, :connections {13 8, 11 7, 6 5, 1 2}}
   5 {:pegged true, :connections {14 9, 12 8}}
   6 {:pegged true, :connections {15 10, 13 9, 4 5, 1 3}}
   7 {:pegged true, :connections {9 8, 2 4}}
   8 {:pegged true, :connections {10 9, 3 5}}
   9 {:pegged true, :connections {7 8, 2 5}}
   10 {:pegged true, :connections {8 9, 3 6}}
   11 {:pegged true, :connections {13 12, 4 7}}
   12 {:pegged true, :connections {14 13, 5 8}}
   13 {:pegged true, :connections {15 14, 11 12, 6 9, 4 8}}
   14 {:pegged true, :connections {12 13, 5 9}}
   15 {:pegged true, :connections {13 14, 6 10}}
   :rows 5})

(defn tri*
  "Generates lazy sequence of triangular numbers"
  ([] (tri* 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))
(take 5 tri)

(defn triangular?
  "Is the number triangular? e.g. 1, 3, 6, 10, 15, etc"
  [n]
  (= n (last (take-while #(>= n %) tri))))
(triangular? 5)
(triangular? 6)

(defn row-tri
  "The triangular number at the end of row n"
  [n]
  (last (take n tri)))
(row-tri 1)
(row-tri 2)
(row-tri 3)

(defn row-num
  "Returns row number the position belongs to: pos 1 in row 1,
  positions 2 and 3 in row 2, etc"
  [pos]
  (inc (count (take-while #(> pos %) tri))))
(row-num 1)
(row-num 5)


(defn connect
  "Form a mutual connection between two positions"
  [board max-pos pos neighbor destination]
  (if (<= destination max-pos)
    (reduce (fn [new-board [p1 p2]]
              (assoc-in new-board [p1 :connections p2] neighbor))
            board
            [[pos destination] [destination pos]])
    board))
(connect {} 15 1 2 4)

(assoc-in {} [:cookie :monster :vocals] "Finntroll")


(defn connect-right
  [board max-pos pos]
  (let [neighbor (inc pos)
        destination (inc neighbor)]
    (if-not (or (triangular? neighbor) (triangular? pos))
      (connect board max-pos pos neighbor destination)
      board)))

(defn connect-down-left
  [board max-pos pos]
  (let [row (row-num pos)
        neighbor (+ row pos)
        destination (+ 1 row neighbor)]
    (connect board max-pos pos neighbor destination)))

(defn connect-down-right
  [board max-pos pos]
  (let [row (row-num pos)
        neigbor (+ 1 row pos)
        destination (+ 2 row neigbor)]
    (connect board max-pos pos neigbor destination)))

(connect-down-left {} 15 1)

(connect-down-right {} 15 3)

