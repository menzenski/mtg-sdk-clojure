(ns mtg-sdk.models
  (:require [schema.core :as s]))

(s/defschema Card
  {:name s/Str
   :layout s/Str
   :cmc s/Num
   (s/optional-key :colors) [s/Str]
   :colorIdentity [s/Str]
   :type s/Str
   (s/optional-key :supertypes) [Supertype]
   :types [Type]
   :subtypes [Subtype]
   :rarity s/Str
   :set s/Str
   :setName s/Str
   (s/optional-key :text) s/Str
   (s/optional-key :flavor) s/Str
   :artist s/Str
   :number s/Str
   (s/optional-key :power) s/Str
   (s/optional-key :toughness) s/Str
   (s/optional-key :loyalty) s/Num
   :id s/Str
   (s/optional-key :names) [s/Str]
   (s/optional-key :manaCost) s/Str
   (s/optional-key :multiverseid) s/Num
   (s/optional-key :variations) [s/Num]
   (s/optional-key :imageUrl) s/Str
   (s/optional-key :watermark) s/Str
   (s/optional-key :border) s/Str
   (s/optional-key :timeshifted) s/Bool
   (s/optional-key :hand) s/Num
   (s/optional-key :life) s/Num
   (s/optional-key :reserved) s/Bool
   (s/optional-key :releaseDate) s/Str
   (s/optional-key :starter) s/Bool
   (s/optional-key :rulings) [Ruling]
   (s/optional-key :foreignNames) [ForeignCardName]
   (s/optional-key :printings) [s/Str]
   (s/optional-key :originalText) s/Str
   (s/optional-key :originalType) s/Str
   (s/optional-key :legalities) [Legality]
   (s/optional-key :source) s/Str})
