(ns mtg-sdk.client.format
  (:require [clj-http.client :as client]
            [schema.core :as s]
            [mtg-sdk [config :refer [base-url]]
                     [models :refer [Format]]
                     [util :refer [parse-data]]]))

(def formats-url
  (format "%s/formats" base-url))

(def result-property :formats)

(s/defn get-all :- [[Format]]
  []
  (-> formats-url client/get :body parse-data result-property))
