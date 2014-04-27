(ns clojure-china.models.category
  (:use korma.core)
  (:require clojure-china.models.db))

(comment :categories table
  id    bigserial   PRIMARY KEY,
  name  varchar(20) NOT NULL UNIQUE, -- display name
  slug  varchar(20) NOT NULL UNIQUE, -- url slug
  stick boolean     NOT NULL DEFAULT false,  -- whether to stick on index page
  order_num integer NOT NULL -- the order number for sorting
)

(defentity categories)

(defn find-all []
  (select categories))
