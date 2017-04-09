(ns mtg-sdk.models-test
  (:use [clojure.test])
  (:require [schema.core :as s]
            [mtg-sdk.mtg-models :as models]
            [clojure.data.json :as json]))

(deftest foreign-card-name-test
  (let [valid-json-fcn (str "{\"name\":\"\u4E07\u548C\u7434\",\"imageUrl\":"
                            "\"http:\\/\\/gatherer.wizards.com\\/Handlers\\/Image."
                            "ashx?multiverseid=418063&type=card\",\"language\""
                            ":\"Chinese Simplified\",\"multiverseid\":418063}")
        valid-fcn (json/read-str valid-json-fcn :key-fn keyword)]
    (testing "valid foreign card name is valid"
      (is (s/validate models/ForeignCardName valid-fcn)))
    (testing "invalid foreign card name is invalid"
      (is (thrown?
            Exception
            (s/validate models/ForeignCardName (dissoc valid-fcn :name))))
      (is (thrown?
            Exception
            (s/validate models/ForeignCardName (dissoc valid-fcn :imageUrl))))
      (is (thrown?
            Exception
            (s/validate models/ForeignCardName (dissoc valid-fcn :language))))
      (is (thrown?
            Exception
            (s/validate models/ForeignCardName (dissoc valid-fcn :multiverseid)))))))
