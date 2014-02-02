(ns kocoro.routes.api
  (:require [kocoro.views.room :as room]
            [compojure.core :refer :all]
            [liberator.core :refer [defresource resource request-method-in]]))

(defresource room-image [room]
  :available-media-types ["image/png"]
  :allowed-methods [:get]
  :handle-ok (fn [context] (room/image room)))

(defroutes api-routes
  (GET "/kocoro/room/:room/status" [room] (room-image room)))
