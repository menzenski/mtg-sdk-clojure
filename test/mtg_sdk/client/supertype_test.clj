(ns mtg-sdk.client.supertype_test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.client.supertype :as supertype]
            [mtg-sdk.models :refer [Supertype]]))

(deftest mtg-supertype-test
  (testing "supertype client gets all types"
    (let [supertypes (supertype/get-all)]
      (is (true? (vector? supertypes)))
      (is (true? (every? #(s/validate Supertype %) supertypes))))))
