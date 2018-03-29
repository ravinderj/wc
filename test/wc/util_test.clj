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
  (testing "should get first file argument from all arguments"
    (is (= (get-first-file '("-abc" "abc" "-a" "a" "b" "-b")) "abc"))))

(deftest get-first-file-index-test
  (testing "should get first file argument index from all arguments"
    (is (= (get-first-file-index '("-abc" "abc" "-a" "a" "b" "-b")) 1))))

(deftest get-options-test
  (testing "should get option arguments from all arguments"
    (is (= (get-options '("-abc" "abc" "-a" "a" "b" "-b")) '("-abc")))))

(deftest get-options-test
  (testing "should get all option arguments from all arguments"
    (is (= (get-options '("-abc" "-ab" "-a" "a" "b" "-b")) '("-abc" "-ab" "-a")))))

(deftest get-files-test
  (testing "should get all file arguments from all arguments"
    (is (= (get-files '("-abc" "-ab" "-a" "a" "b" "-b")) '("a" "b" "-b")))))
