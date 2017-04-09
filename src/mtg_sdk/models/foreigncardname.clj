(in-ns 'mtg-sdk.mtg-models)

(s/defschema ForeignCardName
  {:name s/Str
   :imageUrl s/Str
   :language s/Str
   :multiverseid s/Num})
