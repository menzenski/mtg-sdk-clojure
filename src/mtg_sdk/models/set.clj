(in-ns 'mtg-sdk.mtg-models)

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
