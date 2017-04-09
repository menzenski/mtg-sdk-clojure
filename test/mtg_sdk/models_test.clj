(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json])
  (:gen-class))

(load "models_test/booster_test")
(load "models_test/card_test")
(load "models_test/foreigncardname_test")
(load "models_test/format_test")
(load "models_test/legality_test")
(load "models_test/ruling_test")
(load "models_test/set_test")
(load "models_test/subtype_test")
(load "models_test/supertype_test")
(load "models_test/type_test")
