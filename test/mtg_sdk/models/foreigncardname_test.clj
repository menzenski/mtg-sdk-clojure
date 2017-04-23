(ns mtg-sdk.models.foreigncardname-test
  (:use [clojure.test])
  (:require [clojure.data.json :as json]
            [schema.core :as s]
            [mtg-sdk.models :refer [ForeignCardName]]))

(deftest foreign-card-name-test
  (let [valid-json-fcn (str "{\"name\":\"\u4E07\u548C\u7434\",\"imageUrl\":"
                            "\"http:\\/\\/gatherer.wizards.com\\/Handlers\\/Image."
                            "ashx?multiverseid=418063&type=card\",\"language\""
                            ":\"Chinese Simplified\",\"multiverseid\":418063}")
        valid-fcn (json/read-str valid-json-fcn :key-fn keyword)]
    (testing "valid foreign card name is valid"
      (is (s/validate ForeignCardName valid-fcn)))
    (testing "invalid foreign card name is invalid"
      (is (thrown?
            Exception
            (s/validate ForeignCardName (dissoc valid-fcn :name))))
      (is (thrown?
            Exception
            (s/validate ForeignCardName (dissoc valid-fcn :imageUrl))))
      (is (thrown?
            Exception
            (s/validate ForeignCardName (dissoc valid-fcn :language))))
      (is (thrown?
            Exception
            (s/validate ForeignCardName (dissoc valid-fcn :multiverseid)))))))
