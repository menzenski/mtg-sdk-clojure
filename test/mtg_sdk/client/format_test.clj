(ns mtg-sdk.client.format_test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.client.format :as mtg-format]
            [mtg-sdk.models :refer [Format]]))

(deftest mtg-format-test
  (testing "format client gets all formats"
    (let [formats (mtg-format/get-all)]
      (is (true? (vector? formats)))
      (is (true? (every? #(s/validate Format %) formats))))))
