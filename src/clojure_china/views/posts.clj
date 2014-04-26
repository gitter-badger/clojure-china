(ns clojure-china.views.posts
  (:require [net.cgrand.enlive-html :as html :refer [deftemplate defsnippet do->]]
            [clojure-china.views.layout :as layout]))

(defsnippet menus "templates/posts.html" [:#menu]
  [categories selected-slug]
  [:ul [:li html/first-of-type]] (html/remove-class (if selected-slug "pure-menu-selected"))
  [:ul [:li html/first-of-type] :a] (html/set-attr :href "/posts")
  [:ul [:li (html/nth-of-type 1 3)]] (html/substitute nil)
  [:ul [:li (html/nth-of-type 2)]] (html/clone-for
                                    [{:keys [slug name]} categories]
                                    [:li] (html/add-class (if (= selected-slug slug) "pure-menu-selected"))
                                    [:a] (html/set-attr :href (str "/posts/" slug))
                                    [:a] (html/content name)))

(defsnippet index "templates/posts.html" [:#layout]
  [posts categories selected-slug]
  [:#menu] (html/substitute (menus categories selected-slug)))

(defn render-index [& args]
  (layout/render {:layout-content (apply index args)}))
