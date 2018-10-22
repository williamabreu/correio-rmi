if [ -z $1 ] || [ -z $2 ];
then
    echo "Parâmetros: <host> <port>";
else
    cd ./out/production/correio-rmi/
    rmiregistry &
    java -Dfile.encoding=UTF-8 -classpath . lcd.main.Main server $1 $2
fi