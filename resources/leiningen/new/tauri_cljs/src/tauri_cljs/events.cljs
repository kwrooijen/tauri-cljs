(ns {{ns-name}}.events
  (:require
   [re-frame.core :as re-frame]
   [{{ns-name}}.db :as db]
   ["tauri/api/fs" :as fs]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::add-file
 (fn [db [_ file-name content]]
   (assoc db
          :app/content content
          :app/file-name file-name)))

(re-frame/reg-event-fx
 ::read-file
 (fn [_ [_ file-name]]
   (-> (fs/readTextFile file-name)
       (.then #(re-frame/dispatch [::add-file file-name %])))))
