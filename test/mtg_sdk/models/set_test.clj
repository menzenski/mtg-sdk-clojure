(in-ns 'mtg-sdk.mtg-models-test)

(deftest mtg-set-test
  (let [valid-json-set (str "{\"code\":\"ICE\",\"name\":\"Ice Age\",\"type\":"
                            "\"expansion\",\"border\":\"black\",\"mkm_id\":11,"
                            "\"booster\":[\"rare\",\"uncommon\",\"uncommon\","
                            "\"uncommon\",\"common\",\"common\",\"common\","
                            "\"common\",\"common\",\"common\",\"common\","
                            "\"common\",\"common\",\"common\",\"common\"],"
                            "\"mkm_name\":\"Ice Age\",\"releaseDate\":"
                            "\"1995-06-01\",\"gathererCode\":\"IA\","
                            "\"magicCardsInfoCode\":\"ia\",\"block\":"
                            "\"Ice Age\"}")
        valid-set (json/read-str valid-json-set)]
    (testing "valid set is valid"
      (is (s/validate models/Set valid-set)))
    (testing "invalid set throws an exception"
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :name)))))))
