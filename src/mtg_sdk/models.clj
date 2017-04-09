(ns mtg-sdk.models
  (:require [schema.core :as s])
  (:gen-class))


;; ---------------------------------------------
;; simple string types

;; e.g., 'Standard', 'Commander', 'Battle for Zendikar Block'
(s/def Format s/Str)


;; e.g., 'Elf', 'Elemental'
(s/def Subtype s/Str)


;; e.g., 'Basic', 'Legendary'
(s/def Supertype s/Str)


;; e.g., 'Artifact', 'Creature'
(s/def Type s/Str)


;; ---------------------------------------------
;; more complex types that don't depend on other mtg types


;; array structure of a booster pack showing cards possible in each position
(s/def Booster [(s/cond-pre s/Str [s/Str])])


;; object containing information on a card in another language
(s/defschema ForeignCardName
  {:name s/Str
   :imageUrl s/Str
   :language s/Str
   :multiverseid s/Num})


;; object containing information on a card's legality in a format
(s/defschema Legality
  {:format s/Str
   :legality s/Str})


;; a ruling from Gatherer and the date it was posted
(s/defschema Ruling
  {:date s/Str
   :text s/Str})


;; ---------------------------------------------
;; more complex types which reference other mtg types

;; metadata about an MTG set
(s/defschema Set
  {:border s/Str
   :code s/Str
   :name s/Str
   :releaseDate s/Str
   :type s/Str
   (s/optional-key :block) s/Str
   (s/optional-key :booster) Booster
   (s/optional-key :gathererCode) s/Str
   (s/optional-key :magicCardsInfoCode) s/Str
   (s/optional-key :mkm_id) s/Num
   (s/optional-key :mkm_name) s/Str
   (s/optional-key :oldCode) s/Str
   (s/optional-key :onlineOnly) s/Bool})


;; the card object
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
