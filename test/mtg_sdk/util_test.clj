(ns mtg-sdk.util-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [mtg-sdk.util :refer [parse-data]]))

(deftest parse-data-test
  (testing "json response is parsed with keys as keywords"
    (let [raw-str (str "{\"types\":[\"Artifact\",\"Conspiracy\",\"Creature\","
                       "\"Enchantment\",\"Instant\",\"Land\",\"Phenomenon\","
                       "\"Plane\",\"Planeswalker\",\"Scheme\",\"Sorcery\","
                       "\"Tribal\",\"Vanguard\"]}")]
      (is (true? (contains? (parse-data raw-str) :types))))
    (let [raw-str (str "{\"set\":{\"code\":\"KTK\",\"name\":\"Khans of "
                       "Tarkir\",\"type\":\"expansion\",\"border\":\"black\","
                       "\"mkm_id\":1495,\"booster\":[[\"rare\",\"mythic rare\"]"
                       ",\"uncommon\",\"uncommon\",\"uncommon\",\"common\","
                       "\"common\",\"common\",\"common\",\"common\",\"common\","
                       "\"common\",\"common\",\"common\",\"common\",\"land\","
                       "\"marketing\"],\"mkm_name\":\"Khans of Tarkir\","
                       "\"releaseDate\":\"2014-09-26\",\"magicCardsInfoCode\":"
                       "\"ktk\",\"block\":\"Khans of Tarkir\"}}")]
      (is (true? (contains? (parse-data raw-str) :set)))
      (let [parsed (parse-data raw-str)]
        (is (true? (contains? (:set parsed) :code)))
        (is (true? (contains? (:set parsed) :name)))
        (is (true? (contains? (:set parsed) :type)))
        (is (true? (contains? (:set parsed) :border)))))))

