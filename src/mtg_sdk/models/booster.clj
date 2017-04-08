(in-ns 'mtg-sdk.mtg-models)

(s/def Booster [(s/cond-pre s/Str [s/Str])])
