(ns wc.util)

(defn isOption
  [arg]
  (.startsWith arg "-"))
