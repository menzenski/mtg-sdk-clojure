(defproject mtg-sdk "0.0.3-SNAPSHOT"
  :description "API for Magic: the Gathering card information"
  :url "https://github.com/menzenski/mtg-sdk-clojure"
  :author "Matt Menzenski"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [prismatic/schema "1.1.5"]
                 [clj-http "3.4.1"]]
  :deploy-repositories [["releases" :clojars]]
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"
            :distribution :manual})
