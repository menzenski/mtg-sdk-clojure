(in-ns 'mtg-sdk.mtg-models-test)

(deftest ruling-test
  (let [valid-json-ruling (str "{\"date\":\"2016-09-20\",\"text\":\"Panharmonicon "
                               "affects an artifact or creature's own enters-the-"
                               "battlefield triggered abilities as well as other "
                               "triggered abilities that would trigger when an "
                               "artifact or creature enters the battlefield. Such "
                               "triggered abilities start with \\\"when\\\" or "
                               "\\\"whenever.\\\"\"}")
        valid-ruling (json/read-str valid-json-ruling :key-fn keyword)]
    (testing "valid ruling object is valid"
      (is (s/validate models/Ruling valid-ruling)))
    (testing "invalid ruling object is invalid"
      (is (thrown? Exception (s/validate models/Ruling (dissoc valid-ruling :date))))
      (is (thrown? Exception (s/validate models/Ruling (dissoc valid-ruling :text)))))))

