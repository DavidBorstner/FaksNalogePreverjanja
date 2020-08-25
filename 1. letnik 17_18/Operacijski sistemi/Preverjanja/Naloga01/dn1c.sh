#!/bin/bash
if [ $# -eq 2 ]; then
	vrstice=$((RANDOM%$1+1))
	stolpci=$((RANDOM%$2+1))
	echo "Pred tablo gre prisilni prostovoljec, ki sedi v vrsti $vrstice in stolpcu $stolpci."
else
	echo "Potrebno je vnesti veljavne vrstice in stolpce!"
fi
exit
