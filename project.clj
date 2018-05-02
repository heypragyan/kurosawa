(defproject org.purefn/kurosawa "0.2.0-SNAPSHOT"
  :description "Parent for all that is Immutant"
  :plugins [[lein-modules "0.3.11"]]

  :profiles {:provided
             {:dependencies [[org.clojure/clojure _]]}
             {:dev {:dependencies [[org.clojure/tools.namespace _]
                                   [com.stuartsierra/component.repl _]]
                    :jvm-opts ["-Xmx2g"]
                    :source-paths ["dev"]
                    :codeina {:sources ["src"]
                              :exclude [org.purefn.kurosawa.version]
                              :reader :clojure
                              :target "doc/dist/latest/api"
                              :src-uri "http://github.com/PureFnOrg/kurosawa/blob/master/"
                              :src-uri-prefix "#L"}
                    :plugins [[funcool/codeina "0.4.0"
                               :exclusions [org.clojure/clojure]]
                              [lein-ancient "0.6.10"]]}}}

  :aliases {"docs-from-index" ["build-helper" "docs" "generate" "docs/guides"
                               "caching" "core" "messaging" "scheduling" "transactions" "web" "wildfly"]
            "docs" ["do" "modules" "doc-index" "," "docs-from-index"]
            "project-version" ["run" "-m" "org.purefn.kurosawa.version"]}

  :modules  {;;:subprocess nil
             :inherited {:min-lein-version "2.7.1"
                         :aliases      {"all" ^:displace ["do" "clean," "test," "install"]
                                        "-f" ["with-profile" "+fast"]}
                         :scm {:dir ".."}
                         :license {:name "Apache Software License - v 2.0"
                                   :url "http://www.apache.org/licenses/LICENSE-2.0"}}

             :versions {org.clojure/clojure             "1.9.0-alpha16"
                        com.taoensso/timbre             "4.10.0"
                        com.stuartsierra/component      "0.3.2"
                        com.stuartsierra/component.repl "0.2.0"
                        org.clojure/test.check          "0.9.0"
                        com.gfredericks/test.chuck      "0.2.7"
                        org.clojure/tools.namespace     "0.2.11"}})
