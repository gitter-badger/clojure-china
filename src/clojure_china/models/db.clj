(ns clojure-china.models.db
  (:use korma.core [korma.db :only (defdb)])
  (:require [clojure-china.models.schema :as schema]))

(defdb db schema/db-spec)

(defentity users)

(defn create-user [user]
  (insert users
          (values user)))

(defn update-user [id first-name last-name email]
  (update users
  (set-fields {:first_name first-name
               :last_name last-name
               :email email})
  (where {:id id})))

(defn get-user [id]
  (first (select users
                 (where {:id id})
                 (limit 1))))

(comment :users table
  id         bigserial   PRIMARY KEY,
  username   varchar(30) NOT NULL UNIQUE,
  email      varchar(30) NOT NULL,
  locked     boolean     NOT NULL DEFAULT false,
  provider   varchar(20) NOT NULL, -- oauth provider, e.g. github
  uid        varchar(20) NOT NULL, -- the uid from oauth provider
  created_at timestamptz NOT NULL DEFAULT now(),
  UNIQUE(provider,uid)
)
