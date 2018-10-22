if [ -z $1 ] || [ -z $2 ];
then
    echo "Parâmetros: <host> <port>"
else
    cd ./out/production/correio-rmi/
    java -Dfile.encoding=UTF-8 -classpath . lcd.main.Main client $1 $2
fi