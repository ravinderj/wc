(defproject wc "0.1.0-SNAPSHOT"
  :description "WC : unix command line tool "
  :url "http://github.com/veera83372/word_count"
  :license {:name "Eclipse Public License"
            :url "https://github.com/veera83372/word_count/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot wc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
