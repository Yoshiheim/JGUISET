rm -f bin/com/gui/*
javac -d bin com/gui/Main.java
jar --create --file=App.jar --main-class=com.gui.Main -C bin .
java -jar ./App.jar