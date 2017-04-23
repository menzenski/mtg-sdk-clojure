(ns mtg-sdk.models.legality-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [Legality]]))

(deftest legality-test
  (let [valid-json-legality (str "{\"format\":\"Kaladesh Block\",\"legality\":\"Legal\"}")
        valid-legality (json/read-str valid-json-legality :key-fn keyword)]
    (testing "valid legality object is valid"
      (is (s/validate Legality valid-legality)))
    (testing "invalid legality object is invalid"
      (is (thrown? Exception (s/validate Legality (dissoc valid-legality :format))))
      (is (thrown? Exception (s/validate Legality (dissoc valid-legality :legality)))))))


