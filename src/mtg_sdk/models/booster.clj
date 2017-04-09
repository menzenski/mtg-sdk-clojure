(ns mtg-sdk.models
  (:require [schema.core :as s]))

(s/def Booster [(s/cond-pre s/Str [s/Str])])
