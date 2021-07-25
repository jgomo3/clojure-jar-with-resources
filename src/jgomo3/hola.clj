(ns jgomo3.hola
  (:gen-class))

(defn greet [{:keys [who]}]
  (println "Hello" (or who "world") "!"))

(defn -main [& args]
  (greet {:who (first args)}))
