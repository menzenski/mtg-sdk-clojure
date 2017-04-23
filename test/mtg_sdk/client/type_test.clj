(ns mtg-sdk.client.type_test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.client.type :as mtg-type]
            [mtg-sdk.models :refer [Type]]))

(deftest mtg-type-test
  (testing "type client gets all types"
    (let [types (mtg-type/get-all)]
      (is (true? (vector? types)))
      (is (true? (every? #(s/validate Type %) types))))))
