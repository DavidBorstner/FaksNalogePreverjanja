import math
from math import *
hitrost = input("Vpiši hitrost krogle [M/s]")
kot_topa = input ("Vpiši kot pod katerim je postavljena cev [°]")
gravitacija = 9.8
razdalja = ((int(hitrost)**2) *2*((sin(math.radians(int(kot_topa))))*(cos(math.radians(int(kot_topa)))))) / gravitacija
print(razdalja)
input("Pritisni karkoli za nadaljevanje")

