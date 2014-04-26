(ns clojure-china.routes.home
  (:use compojure.core)
  (:require [noir.response :refer [redirect]]))

(defn home-page []
  (redirect "/posts"))

(defroutes home-routes
  (GET "/" [] (home-page)))
