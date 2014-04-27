(ns clojure-china.models.schema
  (:require [clojure.string :as str]
            [korma.db :refer [postgres]]
            [environ.core :refer [env]]))

;

(defn db-spec-from-uri
  "Parse database uri to map.
   Example uri: jdbc:postgresql://localhost:5432/clojure_china?user=dbuser&password=dbpasswd
   Note: the port can not be omitted, user and password are optional"
  [uri]
  (->> uri
       (#(str/split % #"://|:|/|\?|&|="))
       (drop 2)
       (zipmap [:host :port :db :_ :user :_ :password])
       (#(dissoc % :_))
       postgres))

(def db-spec
  (db-spec-from-uri (env :database-uri)))
