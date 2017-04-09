(ns mtg-sdk.models
  (:require [schema.core :as s]))

(s/defschema ForeignCardName
  {:name s/Str
   :imageUrl s/Str
   :language s/Str
   :multiverseid s/Num})
