#!/bin/bash 
name="Rudolf Eror"
geslo=""
if [ $# -eq 0 ]; then
	echo "Napaka!"
	exit 42
else
	geslo=$1
	sudo useradd beton -c "Rudolf Eror" -p $(mkpasswd -m sha-512 $1)
	echo "Uporabnik ustvarjen!"  	
fi
for i in $(seq 0 ${#geslo}); do
 	echo ${geslo:$i:1}
	
done
echo "Debeli zajec."

