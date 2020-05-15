(ns {{ns-name}}.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::content
 (fn [db]
   (:app/content db)))

(re-frame/reg-sub
 ::file-name
 (fn [db]
   (:app/file-name db)))
