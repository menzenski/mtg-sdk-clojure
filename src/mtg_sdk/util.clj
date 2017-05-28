(ns mtg-sdk.util
  (:require [clojure.data.json :as json]
            [clojure.string :refer [join]]))

(defn parse-data [data]
  (json/read-str data :key-fn keyword))

(defmacro build-query-string
  [& values]
  `(join "|" ~(into [] (map (fn [s] `(str ~s)) values))))
