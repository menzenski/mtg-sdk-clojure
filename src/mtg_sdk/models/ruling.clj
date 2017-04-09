(ns mtg-sdk.models
  (:require [schema.core :as s]))

(s/defschema Ruling
  {:date s/Str
   :text s/Str})
