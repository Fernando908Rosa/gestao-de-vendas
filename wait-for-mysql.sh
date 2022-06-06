#!/bin/sh

if [ "$#" -ne 1 ]; then
    >&2 echo "Usage: $0 host:port"
    exit -1
fi

ARGUMENT=$1
HOST="$(echo $ARGUMENT | cut -d ':' -f1)"
PORT="$(echo $ARGUMENT | cut -d ':' -f2)"
MAX_RETRY=100

echo "Testing connection to host $HOST and port $PORT."

count=0
while [ $count -lt $MAX_RETRY ]
do
    count=$((count+1))
    nc -z $HOST $PORT
    result=$?
    if [ $result -eq 0 ]; then
         echo "Mysql Connection is available after $count secund(s)."
         exit 0
    fi
     echo "Mysql is available after - sleeping"    
     sleep 1
done

>&2 echo "Timeout ocurred after walting $MAX_RETRY secunds for $HOST:$PORT."
exit -1 