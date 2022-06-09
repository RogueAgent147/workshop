(ns workshop.chapter2.activity2-01)


(def memory-db (atom {}))
@memory-db
(defn read-db [] @memory-db)
read-db
(read-db)
(defn write-db [new-db] (reset! memory-db new-db))
@memory-db

{:table-1 {:data [] :indexes {}} :table-2 {:data [] :indexes {}}}

;; Instance of db usage

(write-db {
           :clients {
                     :data [{:id 1 :name "Bob" :age 30} {:id 2 :name "Alice" :age 24}]
                     :indexes {:id {1 0, 2 1}}
                     }
           :fruits {
                    :data [{:name "Lemon" :stock 10} {:name "Coconut" :stock 3}]
                    :indexes {:name {"Lemon" 0, "Coconut" 1}}
                    }
           :purchases {
                       :data [{:id 0 :user-id 1  :item "Coconut"} {:id 1 :user-id 2 :item "Lemon"}]
                       :indexes {:id {0 0 1 1}}
                       }
           }
          )
(read-db)


(defn create-table [table-name]
  (let [db (read-db)]
    (write-db (assoc db table-name {:data []
                                     :indexes {}})))
  @memory-db)

(create-table :table-name)

(defn drop-table [one-time]
  (let [db (read-db)]
    (write-db (dissoc db one-time)))
  @memory-db)

@memory-db

(drop-table :table-name)


(defn insert
  [table record id-key]
  (let [db (read-db)
        new-data (update-in db [table :data] conj record)
        index (- (count (get-in db [table :data])) 1)]
    (write-db
      (update-in new-data [table :indexes id-key] assoc (id-key record) index))))


(insert :fruits {:name "Rob" :stock 3} :name)
(insert :fruits {:name "Zombie" :stock 2} :name)


(defn select-*
  [record]
  (record (read-db)))

(select-* :fruits)

(defn select-**
  [record]
  (get-in (read-db) [record :data]))

(select-** :fruits)

(defn select-*-where
  [table-name field field-value]
  (let [db (read-db)
        index (get-in db [table-name :indexes field field-value])
        data (get-in db [table-name :data])]
    (get data index)))

(select-*-where :fruits :name "Lemon")

(defn insert-*
  [table record id-key]
  (if-let [existing-record (select-*-where table id-key (id-key record))]
    (println (str "Record with " id-key ": " (id-key record)  " already exists."))
    (let [db (read-db)
          new-data (update-in db [table :data] conj record)
          index (- (count (get-in db [table :data])) 1)]
      (write-db
        (update-in new-data [table :indexes id-key] assoc (id-key record) index)))))

(insert-* :fruits {:name "Zombie" :stock 2} :name)

