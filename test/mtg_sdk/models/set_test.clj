(in-ns 'mtg-sdk.mtg-models-test)

(deftest mtg-set-test
  (let [valid-set {:code "KLD"
                   :name  "Kaladesh"
                   :type "expansion"
                   :border "black"
                   :booster [["rare" "mythic rare"]
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
                             "marketing"]
                   :releaseDate "2016-09-30"
                   :block "Kaladesh"}])
  (testing "string format is valid"
    (is (s/validate models/Format "Theros Block"))
    (is (s/validate models/Format "Zendikar Block"))
    (is (s/validate models/Format "Commander")))
  (testing "non-string format throws an exception"
    (is (thrown? Exception (s/validate models/Format (hash-map))))
    (is (thrown? Exception (s/validate models/Format {:name "not a string"})))))
