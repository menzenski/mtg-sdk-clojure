(ns mtg-sdk.models.format_test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.models.format :as f]))

(deftest format-test
  (testing "string format is valid"
    (is (s/validate f/Format "Theros Block"))
    (is (s/validate f/Format "Zendikar Block"))
    (is (s/validate f/Format "Commander")))
  (testing "non-string format throws an exception"
    (is (thrown? Exception (s/validate f/Format (hash-map))))
    (is (thrown? Exception (s/validate f/Format {:name "not a string"})))))
