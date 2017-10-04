(ns cleewalk.core-test
  (:require [clojure.test :refer :all]
            [cleewalk.core :refer :all]))

(ns cleewalk.core-test (:use clojure.pprint))

(deftest testNotNil
  (testing "Testing not-nil? true"
    (let [
      node (->Node nil 1 nil)
      ](is (not-nil? node)))))

(deftest testNil
  (testing "Testing not-nil? false"
    (let [
      node (->Node nil 1 nil)
      ](is (not (not-nil? (:left node)))))))

(deftest testPeekStack
  (testing "Testing peek"
    (let [
      stack '(1 2 3)
      ](is (= 1 (peek stack)))
      (is (= '(1 2 3) stack)))))

(deftest testPopStack
  (testing "Testing pop"
    (let [
      stack '(1 2 3)
      ](is (= '(2 3) (pop stack))))))


(defn recurring
  "Recurring func"
  [alist]
  (let [l (peek alist)]
    (pprint alist)
    (when (not-nil? l)
      (let [blist (pop alist)]
        (recur (conj blist l))))))

;(deftest testRecur
;  (testing "Testing pop"
;    (recurring '(1 2 3))))

(deftest testClassicExample
  (testing "Tests the classic interview example."
    (let [
      node4 (->Node nil 4 nil)
      node2 (->Node node4 2 nil)
      node6 (->Node nil 6 nil)
      node5 (->Node nil 5 nil)
      node3 (->Node node5 3 node6)
      node1 (->Node node2 1 node3)
      ](cleewalk node1))))
