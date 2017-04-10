(ns mtg-sdk.client.format
  (:require [clj-http.client :as client]
            [schema.core :as s]
            [mtg-sdk.config :refer [base-url]]
            [mtg-sdk.models :refer [Format]]
            [mtg-sdk.util :refer [parse-data]]))

(def formats-url
  (format "%s/formats" base-url))

(s/defn get-all :- [[Format]]
  []
  (-> formats-url client/get :body parse-data :formats))
