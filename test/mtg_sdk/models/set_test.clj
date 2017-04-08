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
        valid-set (json/read-str valid-json-set :key-fn keyword)]
    (testing "an older valid set is valid"
      (is (s/validate models/Set valid-set)))
    (testing "optional fields are optional"
      (is (s/validate models/Set (dissoc valid-set :block)))
      (is (s/validate models/Set (dissoc valid-set :booster))))
    (testing "an older invalid set throws an exception"
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :border))))
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :code))))
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :name))))
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :releaseDate))))
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :type))))))
  (let [valid-json-set (str "{\"code\":\"AER\",\"name\":\"Aether Revolt\","
                            "\"type\":\"expansion\",\"border\":\"black\","
                            "\"booster\":[[\"rare\",\"mythic rare\"],"
                            "\"uncommon\",\"uncommon\",\"uncommon\","
                            "\"common\",\"common\",\"common\",\"common\","
                            "\"common\",\"common\",\"common\",\"common\","
                            "\"common\",\"common\",\"land\",\"marketing\"],"
                            "\"releaseDate\":\"2017-01-20\",\"block\":"
                            "\"Kaladesh\"}")
        valid-set (json/read-str valid-json-set :key-fn keyword)]
    (testing "a newer valid set is valid"
      (is (s/validate models/Set valid-set)))
    (testing "a newer invalid set throws an exception"
      (is (thrown? Exception (s/validate models/Set (dissoc valid-set :name)))))))
