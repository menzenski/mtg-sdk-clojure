(ns mtg-sdk.client.format_test
  (:use [clojure.test])
  (:require [mtg-sdk.client.format :as mtg-format]))

(deftest mtg-format-test
  (testing "format client gets all formats"
    (let [formats (mtg-format/get-all)]
      (is (true? (contains? formats :formats)))
      (is (true? (vector? (:formats formats)))))))
