(ns cleewalk.core)
(ns cleewalk.core (:use clojure.pprint))

(defrecord Node [left value right])

(defn not-nil? [expr] (not (nil? expr)))

(defn push-left
  [stack]
  (let [top (peek stack)]
    (if (not-nil? top)
      (recur (conj stack (:left top)))
      (pop stack))))

(defn has-next [stack] (not-nil? (peek stack)))

(defn cleewalk_internal
  "Walks the tree"
  [stack]
  (when (not (empty? stack))
    (let [top (peek stack)
          reduced (pop stack)]
      (println (:value top))
      (if (not-nil? (:right top))
        (recur (push-left (conj reduced (:right top))))
        (recur reduced)))))

(defn cleewalk
  "Walks the binary tree given in the first parameter"
  [node]
  (let [stack (list node)] (cleewalk_internal (push-left stack))))
