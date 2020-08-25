#!/bin/bash -x
name="Rudolf Eror"
if [ $# -eq 0 ]; then
	echo "Napaka!"
	exit
else
	sudo useradd beton -c "Rudolf Eror" -p $(mkpasswd -m sha-512 $1)
	echo "Uporabnik ustvarjen!"  	
fi

