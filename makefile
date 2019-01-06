install_path = target/uberjar/csv-formatter-0.1.0-standalone.jar

$(install_path): src/csv_formatter/*.clj
	lein uberjar

install: $(install_path)
	sudo cp $^ /etc/csv-formatter.jar
	sudo cp runner.sh /usr/bin/csv-formatter
