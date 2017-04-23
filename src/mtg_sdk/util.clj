(ns mtg-sdk.util
  (:require [clojure.data.json :as json]))

(defn parse-data [data]
  (json/read-str data :key-fn keyword))
