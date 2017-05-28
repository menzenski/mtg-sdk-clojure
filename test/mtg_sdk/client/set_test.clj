(ns mtg-sdk.client.set-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.client.set :as mtg-set]
            [mtg-sdk.models :refer [Set]]))

(deftest set-url-format-test
  (testing "urls for sets are formatted correctly"
    (is (= "https://api.magicthegathering.io/v1/sets/KLD/booster"
           (mtg-set/booster-url "KLD")))))
