(ns wc.util-test
  (:require [clojure.test :refer :all]
            [wc.util :refer :all]))

(deftest a-test
  (testing "should pass when argument is an option"
    (is (isOption "-abc"))))

(deftest a-test
  (testing "should fail when argument is not an option"
    (is (not (isOption "abc")))))