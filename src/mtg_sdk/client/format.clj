(ns mtg-sdk.client.format
  (:require [clj-http.client :as client]
            [mtg-sdk.config :refer [base-url]]
            [mtg-sdk.util :refer [parse-data]]))

(def formats-url
  (format "%s/formats" base-url))

(defn get-all []
  (-> formats-url client/get :body parse-data))
