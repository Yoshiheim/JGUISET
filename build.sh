if [[ -z "$1" && "$1" =~ ^[0-9]+$ ]]; then
    echo "Error: Argument is null or not an integer."
    exit 1
fi

rm -rf bin/com/gui/*
javac --release $1 -d bin com/gui/Main.java
jar --create --file=App.jar --main-class=com.gui.Main -C bin .
java -jar ./App.jar