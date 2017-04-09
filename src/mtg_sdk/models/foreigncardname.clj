(in-ns 'mtg-sdk.models)

(s/defschema ForeignCardName
  {:name s/Str
   :imageUrl s/Str
   :language s/Str
   :multiverseid s/Num})
