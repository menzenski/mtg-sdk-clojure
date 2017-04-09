(in-ns 'mtg-sdk.models-test)

(deftest booster-test
  (let [valid-booster [["rare" "mythic rare"]
                             "uncommon"
                             "uncommon"
                             "uncommon"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "common"
                             "land"
                             "marketing"]]
    (testing "valid boosters are valid"
      (is (s/validate models/Booster valid-booster))
      (is (s/validate models/Booster ["string" "string"]))
      (is (s/validate models/Booster ["string" ["array" "of" "strings"]])))))
