cd ./out/production/correio-rmi/
rmiregistry &
java -Dfile.encoding=UTF-8 -classpath . lcd.main.Main server $1 $2