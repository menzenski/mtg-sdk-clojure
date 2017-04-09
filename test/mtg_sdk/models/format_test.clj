(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json]))

(deftest format-test
  (testing "string format is valid"
    (is (s/validate models/Format "Theros Block"))
    (is (s/validate models/Format "Zendikar Block"))
    (is (s/validate models/Format "Commander")))
  (testing "non-string format throws an exception"
    (is (thrown? Exception (s/validate models/Format (hash-map))))
    (is (thrown? Exception (s/validate models/Format {:name "not a string"})))))
