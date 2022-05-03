(ns app.hello
  (:require [reagent.core :as r]
            [reagent-mui.material.button :refer [button]]
            [reagent-mui.material.button-group :refer [button-group]]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.container :refer [container]]))

(defn click-counter [click-count]
  [:div
   "The atom " [:code {:style {:color "red"}} "click-count"] " has value: "
   @click-count ". "
   [:input {:type "button" :value "Click me to Reset!"
            :on-click #(swap! click-count (constantly 0))}]
   [box {:sx {:p 2}}
    [button-group {:size "small" :variant "contained"}
     [button {:on-click #(swap! click-count dec)} "Dec"]
     [button {:on-click #(swap! click-count inc)} "Inc"]]]])

(def click-count (r/atom 0))

(defn hello []
  ;; What is sx? https://mui.com/system/the-sx-prop/
  [container {:max-width "md" :sx {:bgcolor "#cfe8fc" :p 2}}
   [:p "Hello, cljs-test is running!"]
   [:p "Here's an example of using a component with state:"]
   [click-counter click-count]])
