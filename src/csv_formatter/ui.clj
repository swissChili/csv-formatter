(ns csv-formatter.ui
  (:gen-class))
; yes, im using use.
(use 'seesaw.core)
(use 'seesaw.chooser)


(defn start-ui! "start the ui" []
  (do
    (native!)

    ;(def f (frame :title "CSV Formatter"))
    (choose-file :success-fn (fn [fc file] (.getAbsolutePath file)))))
    ;(config! f :content chooser)
    ;(-> f pack! show!)))
