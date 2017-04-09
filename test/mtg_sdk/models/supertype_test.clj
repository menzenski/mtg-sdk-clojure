(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json]))

(deftest supertype-test
  (testing "string supertype is valid"
    (is (s/validate models/Supertype "Basic"))
    (is (s/validate models/Supertype "Legendary"))
    (is (s/validate models/Supertype "Snow")))
  (testing "non-string supertype throws an exception"
    (is (thrown? Exception (s/validate models/Supertype (hash-map))))
    (is (thrown? Exception (s/validate models/Supertype {:name "not a string"})))))
