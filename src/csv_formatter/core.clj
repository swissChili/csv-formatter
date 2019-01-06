(ns csv-formatter.core
  (:gen-class)
  (:require [csv-formatter.fmt :as csv-fmt]
  	        [clojure.java.io :as io]
            [clojure-csv.core :as csv]
            [clojure.string :as str]))

(defn -main
  "Read a csv, and rearange it so that it matches the
  needed format."
  [& args]
  (if (and (> (count args) 0) (.exists (io/as-file (first args))))
    (spit (str/join "" [(first args) ".out.csv"])
          (csv/write-csv
            (csv-fmt/format-csv (slurp (first args)))))
    (println "No CSV file provided! Drag one to the jar or provide it
as the first parameter if you're using a CLI.")))
