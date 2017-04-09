(in-ns 'mtg-sdk.models-test)

(deftest format-test
  (testing "string format is valid"
    (is (s/validate models/Format "Theros Block"))
    (is (s/validate models/Format "Zendikar Block"))
    (is (s/validate models/Format "Commander")))
  (testing "non-string format throws an exception"
    (is (thrown? Exception (s/validate models/Format (hash-map))))
    (is (thrown? Exception (s/validate models/Format {:name "not a string"})))))
