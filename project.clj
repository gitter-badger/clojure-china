(defproject clojure-china "0.0.1"
  :url "http://clojure-chian.org"
  :description "Source code of clojure-china.org"
  :min-lein-version "2.0.0"
  :repl-options
  {:init-ns clojure-china.repl}
  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [ring-server "0.3.1"]
   [environ "0.5.0"]
   [com.taoensso/timbre "3.1.6"]
   [com.taoensso/tower "2.0.2"]
   [log4j "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [lib-noir "0.8.2"]
   [compojure "1.1.6"]
   [ragtime "0.3.7"]
   [korma "0.3.1"]
   [postgresql/postgresql "9.1-901-1.jdbc4"]
   [enlive "1.1.5"]]
  :ring
  {:handler clojure-china.handler/app,
   :init clojure-china.handler/init,
   :destroy clojure-china.handler/destroy}
  :ragtime
  {:migrations ragtime.sql.files/migrations,
   :database (System/getenv "DATABASE_URI")}
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.2"]],
    :env {:dev true}}}
  :plugins
  [[lein-ring "0.8.10"]
   [lein-environ "0.5.0"]
   [ragtime/ragtime.lein "0.3.7"]])
