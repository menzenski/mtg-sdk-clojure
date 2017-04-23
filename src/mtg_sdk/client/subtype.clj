(ns mtg-sdk.client.subtype
  (:require [clj-http.client :as client]
            [schema.core :as s]
            [mtg-sdk [config :refer [base-url]]
                     [models :refer [Subtype]]
                     [util :refer [parse-data]]]))

(def subtypes-url
  (format "%s/subtypes" base-url))

(def result-property :subtypes)

(s/defn get-all :- [[Subtype]]
  []
  (-> subtypes-url client/get :body parse-data result-property))

