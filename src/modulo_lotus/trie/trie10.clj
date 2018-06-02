(ns modulo-lotus.trie.trie10
  (:require [clojure.string :refer (split triml)])
  (:import (modulo.lotus.trie Trie)))

(defn process-op [trie op contact]
  (let [cs (char-array contact)]
    (if (= "add" op)
      (.add trie cs)
      (println (.countFor trie cs)))))

(defn run
  []
  (let [n (Integer/parseInt (read-line))
        trie (Trie.)]
    (loop [i 0]
      (when (< i n)
        (let [[op contact] (split (read-line) #"\s+")]
          (process-op trie op contact)
          (recur (inc i))))))
  (flush))
