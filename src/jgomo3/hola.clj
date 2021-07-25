(ns jgomo3.hola
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn greet [{:keys [who]}]
  (let [greet-text (-> "hola.txt"
                       io/resource
                       io/file ;; could be skipped, but the code I'm having problems with does this.
                       slurp)]
    (println greet-text (or who "world") "!")))

(defn -main [& args]
  (greet {:who (first args)}))
