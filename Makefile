COMPILE :=
ifeq ($(OS),Windows_NT)
	COMPILE += javac --module-path ./libraries/WIN_javafx-sdk-19/lib --add-modules javafx.fxml,javafx.controls *.java
else
	UNAME := $(shell uname -s)
	ifeq ($(UNAME),Linux)
		COMPILE += javac --module-path ./libraries/LIN_javafx-sdk-19/lib --add-modules javafx.fxml,javafx.controls *.java
	else
		OS_DETECT += Mac
	endif
endif

EXECUTE :=
ifeq ($(OS),Windows_NT)
	EXECUTE += java --module-path ./libraries/WIN_javafx-sdk-19/lib --add-modules javafx.fxml,javafx.controls -cp "$(CURDIR);./libraries/WIN_javafx-sdk-19/lib/mysql-connector-java-8.0.23.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.graphics.jar;./libraries/WIN_javafx-sdk-19/lib/javafx-swt.jar;./libraries/WIN_javafx-sdk-19/lib/fontawesomefx-commons-9.1.2.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.web.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.fxml.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.media.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.swing.jar;./libraries/WIN_javafx-sdk-19/lib/fontawesomefx-fontawesome-4.7.0-9.1.2.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.controls.jar;./libraries/WIN_javafx-sdk-19/lib/javafx.base.jar" Main
else
	UNAME := $(shell uname -s)
	ifeq ($(UNAME),Linux)
		EXECUTE += java --module-path libraries/LIN_javafx-sdk-19/lib --add-modules javafx.fxml,javafx.controls -cp "$(CURDIR):./libraries/LIN_javafx-sdk-19/lib/javafx.graphics.jar:./libraries/LIN_javafx-sdk-19/lib/javafx.controls.jar:./libraries/LIN_javafx-sdk-19/lib/javafx.web.jar:./libraries/LIN_javafx-sdk-19/lib/fontawesomefx-commons-9.1.2.jar:./libraries/LIN_javafx-sdk-19/lib/mysql-connector-java-8.0.23.jar:./libraries/LIN_javafx-sdk-19/lib/javafx.base.jar:./libraries/LIN_javafx-sdk-19/lib/fontawesomefx-fontawesome-4.7.0-9.1.2.jar:./libraries/LIN_javafx-sdk-19/lib/javafx-swt.jar:./libraries/LIN_javafx-sdk-19/lib/javafx.swing.jar:./libraries/LIN_javafx-sdk-19/lib/javafx.fxml.jar:./libraries/LIN_javafx-sdk-19/lib/javafx.media.jar" Main
	else
		OS_DETECT += Mac
	endif
endif

DELETE :=
ifeq ($(OS),Windows_NT)
	DELETE += del *.class
else
	UNAME := $(shell uname -s)
	ifeq ($(UNAME),Linux)
		DELETE += rm *.class
	else
		OS_DETECT += Mac
	endif
endif

all:
	@$(COMPILE)
	@$(EXECUTE)
	@$(DELETE)

