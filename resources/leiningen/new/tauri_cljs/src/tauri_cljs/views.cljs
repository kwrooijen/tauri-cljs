(ns {{ns-name}}.views
  (:require
   [{{ns-name}}.events :as events]
   [{{ns-name}}.subs :as subs]
   [re-frame.core :as re-frame]
   ["tauri/api/dialog" :as dialog]))

(defn read-file []
  (-> (dialog/open)
      (.then #(re-frame/dispatch [::events/read-file %]))))

(defn button [opts content]
  [:div (merge {:style {:padding "4px 8px"
                        :cursor :pointer
                        :background-color "#220066"
                        :display :inline-block
                        :border-radius "4px"
                        :color :white}}
               opts)
   content])

(defn main-panel []
  [:div {:font-family "Arial, Helvetica, sans-serif"}
   [:h2
    {:style {:text-align :center}}
    "{{name}}"]
   [:div {:style {:margin "48px"}}
    [button {:on-click read-file} "Open file..."]
    (when-let [content @(re-frame/subscribe [::subs/content])]
      [:div {:style {:margin-top "24px"}}
       [:h3 @(re-frame/subscribe [::subs/file-name])]
       [:div
        {:style {:padding "8px"
                 :margin-top "24px"
                 :max-width "600px"
                 :border "solid 2px #ddd"
                 :border-radius "4px"}}
        content]])]])
