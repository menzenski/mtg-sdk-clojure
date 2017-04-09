(ns mtg-sdk.models
  (:require [schema.core :as s]))

(s/defschema Legality
  {:format s/Str
   :legality s/Str})
