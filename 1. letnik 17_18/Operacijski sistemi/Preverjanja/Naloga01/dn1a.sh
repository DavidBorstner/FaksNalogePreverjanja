#!/bin/bash
mkdir -p shramba/.conf/
if [ ! -f test ]; then
    touch test
    cp test temp
    mv test temp shramba/.conf/
else
    touch test2
    cp test temp
    mv test temp shramba/.conf/
fi


