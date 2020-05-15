(defproject tauri-cljs/lein-template "0.0.2"
  :description "A leiningen template for Shadow-cljs + Tauri"
  :url "https://github.com/kwrooijen/tauri-cljs"
  :license {:name "MIT"}
  :eval-in-leiningen true

  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_user
                                    :password :env/clojars_pass
                                    :sign-releases false}]])
