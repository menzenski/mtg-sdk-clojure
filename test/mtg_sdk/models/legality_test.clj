(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json]))

(deftest legality-test
  (let [valid-json-legality (str "{\"format\":\"Kaladesh Block\",\"legality\":\"Legal\"}")
        valid-legality (json/read-str valid-json-legality :key-fn keyword)]
    (testing "valid legality object is valid"
      (is (s/validate models/Legality valid-legality)))
    (testing "invalid legality object is invalid"
      (is (thrown? Exception (s/validate models/Legality (dissoc valid-legality :format))))
      (is (thrown? Exception (s/validate models/Legality (dissoc valid-legality :legality)))))))


