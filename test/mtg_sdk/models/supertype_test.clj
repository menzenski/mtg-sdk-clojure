(ns mtg-sdk.models.supertype-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [Supertype]]))

(deftest supertype-test
  (testing "string supertype is valid"
    (is (s/validate Supertype "Basic"))
    (is (s/validate Supertype "Legendary"))
    (is (s/validate Supertype "Snow")))
  (testing "non-string supertype throws an exception"
    (is (thrown? Exception (s/validate Supertype (hash-map))))
    (is (thrown? Exception (s/validate Supertype {:name "not a string"})))))
