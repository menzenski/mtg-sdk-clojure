(ns mtg-sdk.models.format-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [Format]]))

(deftest format-test
  (testing "string format is valid"
    (is (s/validate Format "Theros Block"))
    (is (s/validate Format "Zendikar Block"))
    (is (s/validate Format "Commander")))
  (testing "non-string format throws an exception"
    (is (thrown? Exception (s/validate Format (hash-map))))
    (is (thrown? Exception (s/validate Format {:name "not a string"})))))
