import random
import math
from math import*
DolzinaStrela = random.randint(10000,50000)
print("Vpiši vrednosti, da boš lahko zadel cilj, ki se nahaja na dolžini: " + str(DolzinaStrela) + "m. Zadenite ± 1000 od cilja.")
cilj = 0
kot_topa =0
hitrost = 0
DolzinaMinus = DolzinaStrela - 1000
DolzinaPlus = DolzinaStrela + 1000


while 1==1:
    if cilj < DolzinaPlus:
        kot_topa = input("Vpiši kot pod katerim boš ustrelil [°]: ")
        hitrost = input("Vpiši s kakšno hitrostjo boš ustrelil [m/s]: ")

    if DolzinaMinus < cilj:
        kot_topa = input("Vpiši kot pod katerim boš ustrelil [°]: ")
        hitrost = input("Vpiši s kakšno hitrostjo boš ustrelil [m/s]: ")

    cilj = ((int(hitrost) ** 2) * 2 * ((sin(math.radians(int(kot_topa)))) * (cos(math.radians(int(kot_topa)))))) / 9.8

    if cilj < DolzinaPlus and DolzinaMinus < cilj:
        print("Zadeli ste tarčo")
        break
    else:
        print("Ustrelili ste: " + str(cilj) + " Zadeti morate " + str(DolzinaStrela))


input("Pritisnite gumb, da zaprete konzolo")