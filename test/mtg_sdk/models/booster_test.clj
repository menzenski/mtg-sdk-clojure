(ns mtg-sdk.models.booster-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [Booster]])
  (:gen-class))

(deftest booster-test
  (let [valid-booster [["rare" "mythic rare"]
                             "uncommon"
                             "uncommon"
                             "uncommon"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "land"
                             "marketing"]]
    (testing "valid boosters are valid"
      (is (s/validate Booster valid-booster))
      (is (s/validate Booster ["string" "string"]))
      (is (s/validate Booster ["string" ["array" "of" "strings"]])))))
