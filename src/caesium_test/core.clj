(ns caesium-test.core
  (:require [caesium.crypto.secretbox :as sb]))

(def key (sb/new-key!))
(def plaintext "Hello caesium!")
(def nonce (sb/int->nonce 0))
(def ciphertext (sb/encrypt key nonce (.getBytes plaintext)))
(def roundtrip (String. (sb/decrypt key nonce ciphertext)))
(assert (= plaintext roundtrip))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
