(ns mtg-sdk.client.type
  (:require [clj-http.client :as client]
            [schema.core :as s]
            [mtg-sdk.config :refer [base-url]]
            [mtg-sdk.models :refer [Type]]
            [mtg-sdk.util :refer [parse-data]]))

(def types-url
  (format "%s/types" base-url))

(def result-property :types)

(s/defn get-all :- [[Type]]
  []
  (-> types-url client/get :body parse-data result-property))
