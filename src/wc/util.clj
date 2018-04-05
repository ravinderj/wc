(ns wc.util)
(use 'clojure.set)

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

(defn read-file
  [file-path]
  (try
    (with-open [rdr (clojure.java.io/reader file-path)]
    (clojure.string/join "\n" (reduce conj [] (line-seq rdr)))
    )
    (catch Exception e (.getMessage e))))

(defn get-number-of-lines
  "gives number of lines in a string"
  [string]
  (count (clojure.string/split string #"\n")))

(defn get-number-of-words
  "gives count of words in a string"
  [string]
  (count (clojure.string/split string #" ")))

(defn get-number-of-characters
  "gives count of characters in a string"
  [string]
  (count (clojure.string/split string #"")))

(defn split-options
  "gives split options as a set"
  [options]
  (set (mapcat (fn [x] (clojure.string/split (subs x 1) #"")) options)))

(defn validate-options
  "returns true if options are valid else throw exception"
  [options]
  (if (clojure.set/subset? options #{"l" "c" "m" "w"})
    true
    (throw (Exception. "Invalid options"))))
