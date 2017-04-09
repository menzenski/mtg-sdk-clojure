(ns mtg-sdk.mtg-models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json])
  (:gen-class))

(load "models/booster_test")
(load "models/card_test")
(load "models/foreigncardname_test")
(load "models/format_test")
(load "models/legality_test")
(load "models/ruling_test")
(load "models/set_test")
(load "models/subtype_test")
(load "models/supertype_test")
(load "models/type_test")
