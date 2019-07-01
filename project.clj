(defproject csv-formatter "0.2.0"
  :description "A CSV formatter"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [clojure-csv/clojure-csv "2.0.1"]
                 [seesaw "1.5.0"]]
  :main ^:skip-aot csv-formatter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
