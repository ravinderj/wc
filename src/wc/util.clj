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

(defn get-first-file-index [elements]
  (.indexOf (vec elements) (get-first-file elements)))

(defn get-options
  [arguments]
  (take (get-first-file-index arguments) arguments))

(defn get-files
  [arguments]
  (nthrest arguments (get-first-file-index arguments)))
