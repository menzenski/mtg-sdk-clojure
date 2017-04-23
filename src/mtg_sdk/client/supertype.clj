(ns mtg-sdk.client.supertype
  (:require [clj-http.client :as client]
            [schema.core :as s]
            [mtg-sdk [config :refer [base-url]]
                     [models :refer [Supertype]]
                     [util :refer [parse-data]]]))

(def supertypes-url
  (format "%s/supertypes" base-url))

(def result-property :supertypes)

(s/defn get-all :- [[Supertype]]
  []
  (-> supertypes-url client/get :body parse-data result-property))
