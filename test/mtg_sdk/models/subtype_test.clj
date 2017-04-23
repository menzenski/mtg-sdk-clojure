(ns mtg-sdk.models.subtype-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [Subtype]]))

(deftest subtype-test
  (testing "string subtype is valid"
    (is (s/validate Subtype "Basic"))
    (is (s/validate Subtype "Legendary"))
    (is (s/validate Subtype "Snow")))
  (testing "non-string subtype throws an exception"
    (is (thrown? Exception (s/validate Subtype (hash-map))))
    (is (thrown? Exception (s/validate Subtype {:name "not a string"})))))
