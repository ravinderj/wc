(ns wc.util-test
  (:require [clojure.test :refer :all]
            [wc.util :refer :all]))

(deftest is-option-test
  (testing "should pass when argument is an option"
    (is (is-option "-abc"))))

(deftest is-option-test
  (testing "should fail when argument is not an option"
    (is (not (is-option "abc")))))

(deftest filter-not-option-test
  (testing "should return list of arguments which are not option"
    (is (= (filter-not-option '("-abc" "abc" "-a" "a" "b" "-b")) '("abc" "a" "b")))))

(deftest get-first-file-test
  (testing "should get first file argument in all arguments"
    (is (= (get-first-file '("-abc" "abc" "-a" "a" "b" "-b")) "abc"))))