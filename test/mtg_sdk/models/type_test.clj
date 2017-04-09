(ns mtg-sdk.models.type-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [Type]])
  (:gen-class))

(deftest type-test
  (testing "string type is valid"
    (is (s/validate Type "Artifact"))
    (is (s/validate Type "Enchantment"))
    (is (s/validate Type "Tribal")))
  (testing "non-string type throws an exception"
    (is (thrown? Exception (s/validate Type (hash-map))))
    (is (thrown? Exception (s/validate Type {:name "not a string"})))))
