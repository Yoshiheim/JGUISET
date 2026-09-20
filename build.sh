rm -f bin/com/tui/*
javac -d bin com/tui/Main.java
jar --create --file=App.jar --main-class=com.tui.Main -C bin .
java -jar ./App.jar