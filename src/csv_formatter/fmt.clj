(ns csv-formatter.fmt
  (:gen-class)
  (:require [clojure-csv.core :as csv]))

(def target
  ;; skip empty fields
  (first (csv/parse-csv "Tracking Number,Carrier,Recipient,Email")))
(def source
  (first (csv/parse-csv "Recipient,Company,Email,Tracking Number,Cost,Status,Error Message,Ship Date,Label Created Date,Estimated Delivery Time,Weight (oz),Zone,Package Length,Package Width,Package Height,Tracking Status,Tracking Info,Tracking Date,Address Line 1,Address Line 2,City,State,Zipcode,Country,Carrier,Service,Order ID,Rubber Stamp 1,Rubber Stamp 2,Rubber Stamp 3,shipto_person_phone")))


(defn simplify
  [input target progress]
  (if (= (count target) 0)
    progress
    (let [i (.indexOf source (first target))]
      (simplify 
        input 
        (rest target)
        (into progress [(nth input i)])))))


(defn simplify-all
  [from progress]
  (if (= (count from) 0)
    ;; return!
    progress
    (let [src (first from)]
      (simplify-all (rest from) (into progress [(simplify src target [])])))))

(defn format-csv
  [raw]
  ;; First row is label, skip it
  (let [parsed (rest (csv/parse-csv raw))]
    (simplify-all parsed [])))
