(ns kocoro.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [kocoro.routes.home :refer [home-routes]]
            [kocoro.routes.api :refer [api-routes]]))

(defn init []
  (println "kocoro is starting"))

(defn destroy []
  (println "kocoro is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes api-routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)))


