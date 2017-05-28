(ns mtg-sdk.client.set
  (:require [clj-http.client :as client]
            [schema.core :as s]
            [mtg-sdk [config :refer [base-url]]
                     [models :refer [Set]]
                     [util :refer [parse-data]]]))

(def sets-url
  (format "%s/sets" base-url))

(defn booster-url
  [set-code]
  (format "%s/%s/booster" sets-url set-code))


(def result-property :sets)

(s/defn get-sets :- [[Set]]
  ([]
   (-> sets-url client/get :body parse-data result-property))
  ([& {:keys [name code]}]
   (-> sets-url client/get :body parse-data result-property)))


