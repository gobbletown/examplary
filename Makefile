clojure_MODE ?= clj
SOURCES_UTIL = src/xlr/readline.$(clojure_MODE)
SOURCES_BASE = $(SOURCES_UTIL) src/xlr/reader.cljc src/xlr/printer.cljc
SOURCES_LISP = src/xlr/env.cljc src/xlr/core.cljc src/xlr/stepA_xlr.cljc
SRCS = $(SOURCES_BASE) src/xlr/env.cljc src/xlr/core.cljc
SOURCES = $(SOURCES_BASE) $(SOURCES_LISP)

DEPS = $(if $(filter cljs,$(clojure_MODE)),node_modules,deps)

dist: $(if $(filter cljs,$(clojure_MODE)),node_modules,xlr.jar xlr)

deps:
	lein deps

xlr.jar: $(SOURCES)
	lein with-profile stepA uberjar
	cp target/stepA_xlr.jar $@

SHELL := bash
xlr: xlr.jar
	cat <(echo -e '#!/bin/sh\nexec java -jar "$$0" "$$@"') xlr.jar > $@
	chmod +x xlr

src/xlr/%.cljc: $(DEPS)
	@true

#src/xlr/stepA_xlr.cljc: $(DEPS)

target/%.jar: src/xlr/%.cljc $(SRCS)
	lein with-profile $(word 1,$(subst _, ,$*)) uberjar

node_modules:
	npm install

clean:
	rm -rf target/ xlr.jar xlr
