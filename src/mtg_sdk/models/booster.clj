(in-ns 'mtg-sdk.models)

(s/def Booster [(s/cond-pre s/Str [s/Str])])
