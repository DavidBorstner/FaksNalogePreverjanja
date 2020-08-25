#!/bin/bash

sudo apt-get update
sudo get-apt install ImageMagick

if ! [ -d SavedImages ]; then
	mkdir SavedImages
fi

echo "alias UVslike="\"sh UVslike.sh"\"" >> ~/.bashrc
source ~/.bashrc

chmod +x UVslike.sh
alias UVslike="sh UVslike.sh"

