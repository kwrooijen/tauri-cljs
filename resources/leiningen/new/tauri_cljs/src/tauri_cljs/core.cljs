(ns {{ns-name}}.core
  (:require
   [{{ns-name}}.events :as events]
   [{{ns-name}}.subs]
   [{{ns-name}}.views :as views]
   [re-frame.core :as re-frame]
   [reagent.core :as reagent]))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
    (.getElementById js/document "app")))


(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (mount-root))

(defn suspend! [])

(defn resume [])
