(ns clojure-china.routes.posts
  (:use compojure.core)
  (:require [clojure-china.views.posts :as posts]))

(def categories [{:name "编程" :slug "programming"}
                 {:name "新闻" :slug "news"}
                 {:name "灌水" :slug "gossip"}
                 {:name "招聘" :slug "recruit"}])

(defn posts-index [req]
  (let [category (get-in req [:route-params :category])]
    (posts/render-index [] categories category)))

(defroutes posts-routes
  (context "/posts" []
           (GET "/" [] posts-index)
           (GET "/:category" [] posts-index)))
