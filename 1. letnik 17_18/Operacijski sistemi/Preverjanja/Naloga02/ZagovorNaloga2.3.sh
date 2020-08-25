#!/bin/bash  
poskus=""
counter=0
stevec=2

declare -a seznam



cat $1 | sort -t ";" -k 2,2 -k 3,3 | while read line
do
    koda="$(cut -d';' -f1 <<< $line)"
    ime="$(cut -d';' -f2 <<< $line)"
    priimek="$(cut -d';' -f3 <<< $line)"
    skrajsano=${ime:0:8}
    uporabnik=$skrajsano${priimek:0:1} 
    declare -l uporabnik
    uporabnik=$uporabnik
    
    uporabnik=${uporabnik//Č/C}
    uporabnik=${uporabnik//Ž/z}
    uporabnik=${uporabnik//Š/s}
    uporabnik=${uporabnik//Ć/c}
    uporabnik=${uporabnik//Đ/d}
    uporabnik=${uporabnik//č/c}
    uporabnik=${uporabnik//ž/z}
    uporabnik=${uporabnik//š/s}
    uporabnik=${uporabnik//ć/c}
    uporabnik=${uporabnik//đ/d}
    upoime=$uporabnik    


    while true; do
       if [[ ${seznam[@]} =~ (^|[[:space:]])"$uporabnik"($|[[:space:]]) ]]; 	   then      
            uporabnik=$upoime$stevec
            ((stevec++))
       else
           stevec=2
           break
       fi    
    done

    seznam["$counter"]="$uporabnik"
    ((counter++))

    poskus=$uporabnik  

  	uporabnik= echo uporabnik || tr '[:lower:]' '[:upper:]'
    geslo=$(mkpasswd -m sha-512 $koda -s "12345678")

	
    echo "$koda;$ime $priimek;$uporabnik;$geslo" 

done

