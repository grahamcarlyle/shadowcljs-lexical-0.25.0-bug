(ns com.grahamcarlyle.lexical-bug.app
  (:require
    [reagent.dom :as rdom]
    ["@lexical/react/LexicalComposer" :refer (LexicalComposer)]
    ["@lexical/react/LexicalContentEditable" :refer (ContentEditable)]
    ["@lexical/react/LexicalPlainTextPlugin" :refer (PlainTextPlugin)]
    [reagent.core :as r]))

(defn lexical-editor []
  [:> LexicalComposer
   {"initialConfig" {}}
   [:> PlainTextPlugin
    {"placeholder"     (r/as-element [:div.editor-placeholder "Enter some text..."])
     "contentEditable" (r/create-element ContentEditable
                                         #js{:className "editor-input"})}]])
(defn render-ui []
  (rdom/render (lexical-editor)
               (js/document.getElementById "root")))

(defn init []
  (println "Hello World")
  (render-ui))
