(ns xlr.readline)

(def readline (.-readline (js/require "../src/xlr/node_readline.js")))
