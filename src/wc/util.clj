(ns wc.util)

(defn is-option
  [arg]
  (.startsWith arg "-"))

(defn filter-not-option
  [elements]
  (filter
    (fn [x] (not (.startsWith x "-")))
    elements))

(defn get-first-file [elements]
  (first
    (filter-not-option elements)))

(defn get-options
  [arguments]
  (take (.indexOf (vec arguments) (get-first-file arguments)) arguments))
