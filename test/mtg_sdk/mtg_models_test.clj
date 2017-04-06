(ns mtg-sdk.mtg-models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models])
  (:gen-class))

(load "models/format_test")
(load "models/subtype_test")
(load "models/supertype_test")
(load "models/type_test")
