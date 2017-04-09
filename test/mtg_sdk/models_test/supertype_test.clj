(in-ns 'mtg-sdk.models-test)

(deftest supertype-test
  (testing "string supertype is valid"
    (is (s/validate models/Supertype "Basic"))
    (is (s/validate models/Supertype "Legendary"))
    (is (s/validate models/Supertype "Snow")))
  (testing "non-string supertype throws an exception"
    (is (thrown? Exception (s/validate models/Supertype (hash-map))))
    (is (thrown? Exception (s/validate models/Supertype {:name "not a string"})))))
