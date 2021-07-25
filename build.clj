(ns build
  (:require [clojure.tools.build.api :as b]))

(def lib 'jgomo3/hola.clj)
(def version "1.1.1")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn build-classes [_]
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir}))

(defn jar [_]
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]})
  (build-classes nil)
  (b/jar {:class-dir class-dir
          :jar-file jar-file
          :main 'jgomo3.hola}))
