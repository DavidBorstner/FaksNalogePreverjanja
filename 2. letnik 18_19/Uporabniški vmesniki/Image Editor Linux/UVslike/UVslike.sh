#!/bin/bash

RED='\033[1;31m'
NC='\033[0m'
GREEN='\033[0;32m'
BLUE='\033[1;34m'
YELLOW='\033[1;33m'
GRAY='\033[0;37m'


pretvori(){

	imeSlike="$1"
	Argument1="$2"

	imeSlike="$(ls | sort -n | head -1)"
	var1=${imeSlike%.*}
	drugo="$var1"".""$Argument1"
	convert "$imeSlike" "$drugo" 
	rm "$imeSlike"
	
}

CROP(){
	cd Slike
	imeSlike="$(ls | sort -n | head -1)"
	
	visina=$(identify -format "%h" "$imeSlike")> /dev/null
	sirina=$(identify -format "%w" "$imeSlike")> /dev/null
	echo "${GRAY}Your current image dimensions are: ""$sirina""x""$visina" 
	
	echo -n "${BLUE}Please insert preferred image height: ${NC}"
	read NovaVisina
	
	echo -n "${BLUE}Please insert preferred image width: ${NC}"
	read NovaSirina
	
	echo -n "${BLUE}Please insert at what image width the crop should start: ${NC}"
	read Novx
	
	echo  -n "${BLUE}Please insert at what image height the crop should start: ${NC}"
	read Novy
	
	if [ "$NovaVisina" -eq "$NovaSirina" 2>/dev/null ] || [ "$NovaSirina" -eq "$NovaSirina" 2>/dev/null ] || [ "$Novx" -eq "$Novx" 2>/dev/null ] || [ "$Novy" -eq "$Novy" 2>/dev/null ]; then
		cp "$imeSlike" "zacasna"
		mogrify -crop "$NovaSirina"x"$NovaSirina"+"$Novx"+"$Novy" "$imeSlike"
		
		echo -n "${BLUE}Are you satisfied with the result?[Y/N] : ${NC}"
		display "$imeSlike"
		
		read satis
		
		if [ "$satis" = "y" ] || [ "$satis" = "Y" ] || [ "$satis" = "yes" ] || [ "$satis" = "YES" ] || [ "$satis" = "Yes" ]; then
			echo "${YELLOW}Image has been succesfully cropped."
			rm zacasna
		else
			rm "$imeSlike"
			mv zacasna "$imeSlike"
			echo "$(tput setaf 3)The changes have been canceled."
		fi
	else
		echo "${RED}The entered values are not valid. Please try again with numbers."
	fi
	cd ..
}

RESIZE(){
	cd Slike
	imeSlike="$(ls | sort -n | head -1)"
	
	visina=$(identify -format "%h" "$imeSlike")> /dev/null
	sirina=$(identify -format "%w" "$imeSlike")> /dev/null
	echo "${GRAY}Your current image dimensions are: ""$sirina""x""$visina" 
	echo -n "${BLUE}Please insert preferred image height: ${NC}"
	read NovaVisina
	
	echo -n "${BLUE}Please insert preferred image width: ${NC}"
	read NovaSirina
	
	if [ "$NovaVisina" -eq "$NovaSirina" 2>/dev/null ] || [ "$NovaSirina" -eq "$NovaSirina" 2>/dev/null ]; then
		cp "$imeSlike" "zacasna"
		gm convert -resize "$NovaVisina"x"$NovaVisina" "$imeSlike" "$imeSlike"
		
		echo -n "${BLUE}Are you satisfied with the result?[Y/N] : ${NC}"
		display "$imeSlike"
		
		read satis
		
		if [ "$satis" = "y" ] || [ "$satis" = "Y" ] || [ "$satis" = "yes" ] || [ "$satis" = "YES" ] || [ "$satis" = "Yes" ]; then
			echo "${YELLOW}Image has been succesfully resized to the dimensions: "$NovaVisina"x"$NovaSirina""
			rm zacasna
		else
			rm "$imeSlike"
			mv zacasna "$imeSlike"
			echo "$(tput setaf 3)The changes have been canceled."
		fi
	else
		echo "${RED}The entered values are not valid. Please try again with numbers."
	fi
	cd ..
}

ROTATE(){
	cd Slike
	imeSlike="$(ls | sort -n | head -1)"
	
	echo -n "${BLUE}How many degrees do you want to rotate your image: ${NC}"
	read stopinje

	if [ "$stopinje" -eq "$stopinje" 2>/dev/null ]; then
		cp "$imeSlike" "zacasna"
		
		convert "$imeSlike" -rotate "$stopinje" "$imeSlike" 
		
		echo -n  "${BLUE}Are you satisfied with the result?[Y/N]: ${NC}"
		display "$imeSlike"
		
		read satis
		
		if [ "$satis" = "y" ] || [ "$satis" = "Y" ] || [ "$satis" = "yes" ] || [ "$satis" = "YES" ] || [ "$satis" = "Yes" ]; then
			echo "${YELLOW}Image has been succesfully rotated for $stopinje degrees."
			rm zacasna
		else
			rm "$imeSlike"
			mv zacasna "$imeSlike"
			echo "$(tput setaf 3)The changes have been canceled."
		fi
		
		else
			echo "${RED}The entered values are not valid. Please try again with numbers."
	fi
	cd ..
}

COLOUR(){
	cd Slike
	imeSlike="$(ls | sort -n | head -1)"
	
	echo "Availible colorspaces are: RBG, greyscale and indexed."
	echo -n "${BLUE}What colorspace do you want to chose: "
	read barve
	
	if [ "$barve" = "RGB" ] || [ "$barve" = "Rgb" ] || [ "$barve" = "rgb" ]; then
		convert "$imeSlike" -set colorspace rbg "$imeSlike"
	else
		if [ "$barve" = "greyscale" ] || [ "$barve" = "GREYSCALE" ] || [ "$barve" = "Greyscale" ]; then
			convert "$imeSlike" -set colorspace grey "$imeSlike"
		else
			if [ "$barve" = "indexed" ] || [ "$barve" = "INDEXED" ] || [ "$barve" = "Indexed" ]; then
			echo -n "${BLUE}How many colours do you want: "
			read barve
			cp "$imeSlike" "zacasna"
			
			convert "$imeSlike" +dither -colors "$barve" "$imeSlike"
			
			echo -n  "${BLUE}Are you satisfied with the result?[Y/N]: ${NC}"
			display "$imeSlike"
		
			read satis
		
			if [ "$satis" = "y" ] || [ "$satis" = "Y" ] || [ "$satis" = "yes" ] || [ "$satis" = "YES" ] || [ "$satis" = "Yes" ]; then
				echo "${YELLOW}Image has colorspace has been sucessfully changed."
				rm zacasna
			else
				rm "$imeSlike"
				mv zacasna "$imeSlike"
			echo "$(tput setaf 3)The changes have been canceled."
			fi
			
			
			else
			echo "${RED}The entered colorspace is not valid. Valid colorspaces include: RGB, greyscale and indexed."
			fi
		fi
	fi
	cd ..
}

FORMAT_CHANGE(){
	cd Slike
	
	echo "$Curently supported formats: jpg, jpeg, svg and png."
	echo -n "${BLUE}What format do you want to convert to: ${NC}"
	read Argument1
	
	if [ "$Argument1" = "svg" ] || [ "$Argument1" = "jpg" ] || [ "$Argument1" = "jpeg" ] || [ "$Argument1" = "png" ] || [ "$Argument1" = "JPEG" ] || [ "$Argument1" = "JPG" ] || [ "$Argument1" = "SVG" ] || [ "$Argument1" = "PNG" ]; then
			pretvori "$imeSlike" "$Argument1"
			echo "${YELLOW}Image succesfully converted!"
	else
		echo "${RED}Please insert a valid format! Valid formats include: svg, jpg, jpeg, and png."
	fi
	cd ..
}

LOAD(){
	echo "Current directory images: "
	ls *.jpeg 2>/dev/null
	ls *.jpg 2>/dev/null
	ls *.png 2>/dev/null

	echo ""
	echo -n "${BLUE}Please enter file name or path: ${NC}"
	read Argument1
	
	if [ -z "$Argument1" ];then
			echo "${RED}Please insert an image!"		
	else
			if [ ! -f "$Argument1" ]; then
				echo "${RED}Please insert a valid image path!"			
			else
				if [ -d Slike ]; then
					cp "$Argument1"  Slike
				else
					mkdir Slike
					cp "$Argument1"  Slike
				fi
				
				echo "${YELLOW}Image succesfully loaded!"
			fi
		
	fi
}

SLIDESHOW(){
	echo "${GRAY}Current loaded images are: ${NC}"
	cd Slike
	ls
	cd ..
	while true
	do
	
	echo -n "${BLUE}Do you want to load more images? [Y/N]: ${NC}"
	read pogoj
	
		if [ "$pogoj" = "yes" ] || [ "$pogoj" = "YES" ] || [ "$pogoj" = "Yes" ] || [ "$pogoj" = "y" ] || [ "$pogoj" = "Y" ]; then
			LOAD
		else
			break;
		fi
	done
	
	echo -n "${BLUE}Please select the slideshow width: ${NC}"
	read sirina
	
	echo -n "${BLUE}Please select the slideshow height: ${NC}"
	read visina
	
	echo -n "${BLUE}Please select the delay between images in miliseconds: ${NC}"
	read dolzina
	
	echo -n "${BLUE}Please select a name for the slideshow: ${NC}"
	read ime
	
	cd Slike
	
	mogrify -format jpg *.*
	convert '*.jpg["$sirina"x"$visina"]' -set filename:base "%[base]" "%[filename:base].jpg" 2>/dev/null
	convert -delay "$dolzina" -loop 1 *.jpg "$ime"".gif"
	
	echo -n  "${BLUE}Are you satisfied with the result?[Y/N]: ${NC}"
	display "$ime"".gif"
		
	read satis
		
			if [ "$satis" = "y" ] || [ "$satis" = "Y" ] || [ "$satis" = "yes" ] || [ "$satis" = "YES" ] || [ "$satis" = "Yes" ]; then
				echo "${YELLOW}The slideshow has been sucessfully saved."
				cp "$ime"".gif" ../SavedImages
				cd ..
				rm -rf Slike
			else
				rm "$ime"".gif"
				echo "$(tput setaf 3)The slideshow has been deleted."
				cd ..
			fi
}

UNLOAD(){
	echo "${GRAY}Current loaded images are: ${NC}"
	cd Slike
	ls
	
	echo -n "${BLUE}Which file do you want to unload?: ${NC}"
	read datoteka
	
	if [ -e "$datoteka"  ]; then
		rm "$datoteka"
		echo "${YELLOW}The image has been sucessfully unloaded."
	else
		echo "${RED}The image you selected is not loaded!"	
	fi

	cd ..
}

SAVE(){
	echo "${GRAY}Current loaded images are: ${NC}"
	cd Slike
	ls
	
	echo -n "${BLUE}Which file do you want to save?: ${NC}"
	read datoteka

	if [ -e "$datoteka"  ]; then
		cd ..
		cp Slike/"$datoteka" SavedImages
		rm -rf Slike
		echo "${YELLOW}Image succesfully saved!"	
	else
		echo "${RED}The image you selected is not loaded!"	
	fi


}

ukaz="$1";
Argument1="$2";
Argument2="$3";


if [ "$ukaz" = "help" ] || [ "$ukaz" = "HELP" ] || [ "$ukaz" = "Help" ]; then
								echo ""
								echo "UVslike help:"
								echo ""
								echo "To use a command type: UVslike <command>"
								echo ""
								echo "If the command requires additional input the program will lead you further."
								echo ""
								echo " -Help (Description and help with commands)"
								echo " -Load (Command for loading up images)"
								echo " -Resize (Command used for resizing images by selecting height and width)"
								echo " -Rotate (Command used for rotating images by providing the number of degrees)"
								echo " -Colour (Command for changing the images colorspace)"
								echo " -Crop (Command for cropping out parts of the image by providing height, width and x/y distance)"
								echo " -Slideshow (Command for creating a slideshow out of loaded images)"
								echo " -Save (Command that permanently saves an image to SavedImages)"
								echo " -Unload (Command that unloads and deletes a loaded image)"	
								echo ""
fi


if [ -z "$ukaz" ]; then
	echo ""
	echo "${RED}Please enter a valid command!"
	echo ""
else
	if [ "$ukaz" = "load" ] || [ "$ukaz" = "LOAD" ] || [ "$ukaz" = "Load" ]; then
		echo ""
		LOAD
		echo ""
	else
			if ! [ -d Slike ] ; then
				if [ "$ukaz" != "load" ] && [ "$ukaz" != "LOAD" ] && [ "$ukaz" != "Load" ] && [ "$ukaz" != "help" ] && [ "$ukaz" != "Help" ] && [ "$ukaz" != "HELP" ] && [ "$ukaz" != "RESIZE" ] && [ "$ukaz" != "Resize" ] && [ "$ukaz" != "resize" ] && [ "$ukaz" != "ROTATE" ] && [ "$ukaz" != "Rotate" ] && [ "$ukaz" != "rotate" ] && [ "$ukaz" != "COLOUR" ] && [ "$ukaz" != "Colour" ] && [ "$ukaz" != "colour" ] && [ "$ukaz" != "COLOR" ] && [ "$ukaz" != "Color" ] && [ "$ukaz" != "color" ] && [ "$ukaz" != "Crop" ] && [ "$ukaz" != "CROP" ] && [ "$ukaz" != "crop" ] && [ "$ukaz" != "slideshow" ] && [ "$ukaz" != "Slideshow" ] && [ "$ukaz" != "SLIDESHOW" ] && [ "$ukaz" != "save" ] && [ "$ukaz" != "Save" ] && [ "$ukaz" != "SAVE" ] && [ "$ukaz" != "Unload" ] && [ "$ukaz" != "UNLOAD" ] && [ "$ukaz" != "unload" ]; then
							echo ""
							echo "${RED}You have entered an invalid command! ${NC}"
							echo "Valid commands include:"
							echo " -Help"
							echo " -Load"
							echo " -Resize"
							echo " -Rotate"
							echo " -Colour"
							echo " -Crop"
							echo " -Slideshow"
							echo " -Save"
							echo " -Unload"		
							echo ""
				else
					echo ""
					echo "${RED}Please load an image to continue."
					echo ""
				fi
			else
				if [ "$ukaz" = "convert" ] || [ "$ukaz" = "Convert" ] || [ "$ukaz" = "CONVERT" ]; then
					echo ""
					FORMAT_CHANGE
					echo ""
			else 			
					if [ "$ukaz" = "save" ] || [ "$ukaz" = "SAVE" ] || [ "$ukaz" = "Save" ]; then
							echo ""
							SAVE
							echo ""
					else
						if [ "$ukaz" = "resize" ] || [ "$ukaz" = "Resize" ] || [ "$ukaz" = "RESIZE" ]; then
							echo ""
							RESIZE
							echo ""
						else
							if [ "$ukaz" = "pomoc" ]; then
								echo "${RED}What brought you here?${NC}"
							else
								if [ "$ukaz" = "rotate" ] || [ "$ukaz" = "ROTATE" ] || [ "$ukaz" = "Rotate" ]; then
									echo ""
									ROTATE
									echo ""
								else
									if [ "$ukaz" = "Colour" ] || [ "$ukaz" = "colour" ] || [ "$ukaz" = "COLOUR" ] || [ "$ukaz" = "COLOR" ] || [ "$ukaz" = "Color" ] || [ "$ukaz" = "color" ]; then
										echo ""
										COLOUR
										echo ""
									else
										if [ "$ukaz" = "Crop" ] || [ "$ukaz" = "CROP" ] || [ "$ukaz" = "crop" ]; then
											echo ""
											CROP
											echo ""
										else
											if [ "$ukaz" = "Slideshow" ] || [ "$ukaz" = "SLIDESHOW" ] || [ "$ukaz" = "slideshow" ]; then
												echo ""
												SLIDESHOW
												echo ""
											else
												if [ "$ukaz" = "unload" ] || [ "$ukaz" = "Unload" ] || [ "$ukaz" = "UNLOAD" ]; then
													echo ""
													UNLOAD
													echo ""
													if [ -z "$(ls -A Slike)" ]; then 
														rm -rf Slike
													fi								
												fi
											fi
										fi
									fi
								fi
							fi
						fi
					fi
			fi
			fi
	fi

fi
