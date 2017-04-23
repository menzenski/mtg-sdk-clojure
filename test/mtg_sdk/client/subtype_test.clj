(ns mtg-sdk.client.subtype_test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.client.subtype :as subtype]
            [mtg-sdk.models :refer [Subtype]]))

(deftest mtg-subtype-test
  (testing "subtype client gets all types"
    (let [subtypes (subtype/get-all)]
      (is (true? (vector? subtypes)))
      (is (true? (every? #(s/validate Subtype %) subtypes))))))
