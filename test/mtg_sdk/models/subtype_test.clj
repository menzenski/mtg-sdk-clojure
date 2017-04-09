(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json]))

(deftest subtype-test
  (testing "string subtype is valid"
    (is (s/validate models/Subtype "Basic"))
    (is (s/validate models/Subtype "Legendary"))
    (is (s/validate models/Subtype "Snow")))
  (testing "non-string subtype throws an exception"
    (is (thrown? Exception (s/validate models/Subtype (hash-map))))
    (is (thrown? Exception (s/validate models/Subtype {:name "not a string"})))))
