(ns csv-formatter.core
  (:gen-class)
  (:require [csv-formatter.fmt :as csv-fmt]
            [csv-formatter.ui :as ui]
            [clojure.java.io :as io]
            [clojure-csv.core :as csv]
            [clojure.string :as str]))

(defn format-file
  [file]
  (spit (str/join "" [file ".out.csv"])
        (csv/write-csv
          (csv-fmt/format-csv (slurp file)))))

(defn -main
  "Read a csv, and rearange it so that it matches the
  needed format."
  [& args]
  (if (and (> (count args) 0) (.exists (io/as-file (first args))))
    (format-file (first args))
    (format-file (ui/start-ui!))))
