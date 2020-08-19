(defproject xlr "0.0.1-SNAPSHOT"
  :description "Make-A-Lisp"

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [net.n01se/clojure-jna "1.0.0"]]

  ;; To run a step with correct readline behavior:
  ;;   lein trampoline with-profile stepX run
  ;; To generate a executable uberjar (in target/) for a step:
  ;;   lein with-profile stepX repl
  :profiles {:step0 {:main xlr.step0-repl
                     :uberjar-name "step0_repl.jar"
                     :aot [xlr.step0-repl]}
             :step1 {:main xlr.step1-read-print
                     :uberjar-name "step1_read_print.jar"
                     :aot [xlr.step1-read-print]}
             :step2 {:main xlr.step2-eval
                     :uberjar-name "step2_eval.jar"
                     :aot [xlr.step2-eval]}
             :step3 {:main xlr.step3-env
                     :uberjar-name "step3_env.jar"
                     :aot [xlr.step3-env]}
             :step4 {:main xlr.step4-if-fn-do
                     :uberjar-name "step4_if_fn_do.jar"
                     :aot [xlr.step4-if-fn-do]}
             :step5 {:main xlr.step5-tco
                     :uberjar-name "step5_tco.jar"
                     :aot [xlr.step5-tco]}
             :step6 {:main xlr.step6-file
                     :uberjar-name "step6_file.jar"
                     :aot [xlr.step6-file]}
             :step7 {:main xlr.step7-quote
                     :uberjar-name "step7_quote.jar"
                     :aot [xlr.step7-quote]}
             :step8 {:main xlr.step8-macros
                     :uberjar-name "step8_macros.jar"
                     :aot [xlr.step8-macros]}
             :step9 {:main xlr.step9-try
                     :uberjar-name "step9_try.jar"
                     :aot [xlr.step9-try]}
             :stepA {:main xlr.stepA-xlr
                     :uberjar-name "stepA_xlr.jar"
                     :aot [xlr.stepA-xlr]}})

