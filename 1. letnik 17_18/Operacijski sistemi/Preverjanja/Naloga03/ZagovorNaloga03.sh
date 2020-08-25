#!/bin/bash
pipe="$1"
log="$2"
prenehaj="$3"

ukazi=()
zadnjiukaz=""
pocakaj=()

zakljuci(){
    kill -TERM -$$
}

zapisi(){
    date +%s%3N > $log
    for i in "${ukazi[@]}"
    do
         IFS=':' read -ra i <<< "$i"
         echo ${i[2]} >> $log         
    done
    for i in "${ukazi[@]}"
    do
        IFS=':' read -ra p <<< "$i"
        echo $(pgrep -P ${p[1]}) >> $log
    done
}

zazeni(){
       while true;
       do
           if ! [ -x "$(command -v ${BERI[3]})" ]; then

                if [ -z ${BERI[3]} ]; then
                    break
                else    
                    IFS=' ' read -ra PREBERI <<< "${BERI[3]}"
                    echo "Command not runnable: ${PREBERI[0]}" >&2 
                    break
                fi
           fi
           
           stevilo="$(pgrep -xfc -g "$$" "${BERI[3]}")"  
           if [ $stevilo -lt ${BERI[1]} ]; then
                ${BERI[3]} & 
                sleep ${BERI[2]}
           fi
       done
}

loglast(){
         lastukaz=$1
         for i in "${ukazi[@]}"
         do
            IFS=':' read -ra i <<< "$i"
            if [ ${i[1]} = $lastukaz ]; then
                echo ${i[2]} >> $log  
                echo $(pgrep -P ${p[1]}) >> $log         
            fi
         done
}

if [[ ! -p $pipe ]]; then
    mkfifo $pipe
fi

while true
do
    if read line <$pipe; then            
	
		if [ "$line" != "$prenehaj" ]; then
			pocakaj=("$line")
			continue 
		fi

	
        for i in "${pocakaj[@]}"
			do		
				if [ "$i" = "log" ]; then
            	 zapisi      
        		fi 
        
        		if [ "$i" = "log last" ]; then
             		loglast zadnjiukaz   
       	    	 fi 
				
			 	IFS=':' read -ra BERI <<< "$i"

        	if [ "$BERI" = "run" ]; then
            	 zazeni & 
           		 ID=$!
            	 pot=$(readlink -m "$(type -P ${BERI[3]})")
            	 pot=${pot%/*} 
            	 pot="$pot/${BERI[3]}"
            	 ukazi=("${BERI[3]}:$ID:$pot")           
        	fi   

        	if [ "$BERI" = "stop" ]; then
           		for i in "${ukazi[@]}"
           		do
                	IFS=':' read -ra p <<< "$i"
                	if [ "${p}" = "${BERI[1]}" ]; then
               		    kill ${p[1]}
                	fi
           		done
        	fi

        	if [ "$i" = "exit" ]; then
           		zakljuci
        	fi 
      
        	zadnjiukaz=$ID 
		done    
    fi
done

