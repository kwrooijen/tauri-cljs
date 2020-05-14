(ns {{ns-name}}.events
  (:require
   [re-frame.core :as re-frame]
   [{{ns-name}}.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
