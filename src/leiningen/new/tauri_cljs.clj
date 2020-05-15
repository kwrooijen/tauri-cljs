(ns leiningen.new.tauri-cljs
  (:require [leiningen.new.templates :refer [renderer raw-resourcer name-to-path sanitize-ns ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "tauri-cljs"))
(def raw (raw-resourcer "tauri-cljs"))

(defn copy-file [file]
  [file (raw file)])

(defn render-file [file data]
  [file (render file data)])

(defn files-src-tauri [data]
  [(copy-file "src-tauri/Cargo.toml")
   (render-file "src-tauri/Cargo.toml" data)
   (copy-file "src-tauri/rustfmt.toml")
   (copy-file "src-tauri/tauri.conf.json")])

(defn files-src-tauri-src [_data]
  [(copy-file "src-tauri/src/build.rs")
   (copy-file "src-tauri/src/cmd.rs")
   (copy-file "src-tauri/src/main.rs")])

(defn files-src-tauri-icons [_data]
  [(copy-file "src-tauri/icons/128x128.png")
   (copy-file "src-tauri/icons/128x128@2x.png")
   (copy-file "src-tauri/icons/32x32.png")
   (copy-file "src-tauri/icons/Square107x107Logo.png")
   (copy-file "src-tauri/icons/Square142x142Logo.png")
   (copy-file "src-tauri/icons/Square150x150Logo.png")
   (copy-file "src-tauri/icons/Square284x284Logo.png")
   (copy-file "src-tauri/icons/Square30x30Logo.png")
   (copy-file "src-tauri/icons/Square310x310Logo.png")
   (copy-file "src-tauri/icons/Square44x44Logo.png")
   (copy-file "src-tauri/icons/Square71x71Logo.png")
   (copy-file "src-tauri/icons/Square89x89Logo.png")
   (copy-file "src-tauri/icons/StoreLogo.png")
   (copy-file "src-tauri/icons/icon.icns")
   (copy-file "src-tauri/icons/icon.ico")
   (copy-file "src-tauri/icons/icon.png")])

(defn files-resources [data]
  [(render-file "resources/public/index.html" data)
   (copy-file "resources/public/style.css")])

(defn files-src [data]
  [["src/{{sanitized}}/core.cljs" (render "src/tauri_cljs/core.cljs" data)]
   ["src/{{sanitized}}/db.cljs" (render "src/tauri_cljs/db.cljs" data)]
   ["src/{{sanitized}}/events.cljs" (render "src/tauri_cljs/events.cljs" data)]
   ["src/{{sanitized}}/subs.cljs" (render "src/tauri_cljs/subs.cljs" data)]
   ["src/{{sanitized}}/views.cljs" (render "src/tauri_cljs/views.cljs" data)]])

(defn files-root [data]
  [[".gitignore" (raw "gitignore")]
   (copy-file "package.json")
   (render-file "README.md" data)
   (render-file "shadow-cljs.edn" data)])

(defn tauri-cljs
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (main/info "Generating a new tauri-cljs project.")
    (apply ->files data
           (concat
            (files-root data)
            (files-src data)
            (files-resources data)
            (files-src-tauri data)
            (files-src-tauri-src data)
            (files-src-tauri-icons data)))))
