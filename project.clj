(defproject mtg-sdk "0.0.1-alpha"
  :description "API for Magic: the Gathering card information"
  :url "https://github.com/menzenski/mtg-sdk-clojure"
  :author "Matt Menzenski"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [metosin/compojure-api "1.1.10"]]
  :ring {:handler mtg-sdk.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[lein-ring "0.10.0"]]}}
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"
            :distribution :manual})
