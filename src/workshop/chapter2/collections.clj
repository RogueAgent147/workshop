(ns workshop.chapter2.collections)

;; Maps

{:artist "David Bowtie" :song "The Man Who Mapped the World"
 :year 1970}

{"David Bowtie" {"The Man Who Mapped the World" {:year 1970 :duration "4:01"}
                 "Comma Oddity" {:year 1969 :duration "5:19"}}
 "Crosby Stills Hash" {"Helplessly Mapping" {:year 1969 :duration "2.38"}
                       "Almost Cut My Hair" {:year 1970 :duration "4:29" 
                                             :featuring ["Neil Young", "Rich Hickey"]}}}


(hash-map :a 1 :b 2 :c 3)

