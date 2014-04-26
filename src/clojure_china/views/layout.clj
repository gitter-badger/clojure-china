(ns clojure-china.views.layout
  (:require [net.cgrand.enlive-html :as html :refer [deftemplate defsnippet]]
            [clojure.string :as str]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]))

(deftemplate base "templates/base.html"
  [{:keys [title layout-content]}]
  [:head :title] (html/content (if title
                                 (str title " | Clojure China")
                                 "Clojure China"))
  [:#layout] (html/substitute layout-content))

(defn render [& args]
  (apply str (apply base args)))
