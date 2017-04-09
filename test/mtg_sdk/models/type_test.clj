(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json]))

(deftest type-test
  (testing "string type is valid"
    (is (s/validate models/Type "Artifact"))
    (is (s/validate models/Type "Enchantment"))
    (is (s/validate models/Type "Tribal")))
  (testing "non-string type throws an exception"
    (is (thrown? Exception (s/validate models/Type (hash-map))))
    (is (thrown? Exception (s/validate models/Type {:name "not a string"})))))
