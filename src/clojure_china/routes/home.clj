(ns clojure-china.routes.home
  (:use compojure.core)
  (:require [clojure-china.views.layout :as layout]))

(defn home-page []
  "It works!")

(defroutes home-routes
  (GET "/" [] (home-page)))
