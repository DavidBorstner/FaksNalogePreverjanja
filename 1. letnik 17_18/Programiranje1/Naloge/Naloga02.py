from random import *

Ana = 0
Berta = 0

input("Pritisni gumb da se igra zacne")

while 1==1:

    if Ana <= 30:
        A1 = randint(1, 6)
        Ana = Berta + A1
        print("Ana vrže " + str(A1) + " in je na " + str(Ana) + " tockah.")

        if Ana >= 30:
            print("Ana je zmagovalka")
            break;

        if A1 == 6:
            A1 = randint(1, 6)
            Ana = Ana + A1
            print("Ana vrže " + str(A1) + " in je na " + str(Ana) + " tockah.")

        if Ana >= 30:
            print("Ana je zmagovalka")
            break;

    if Berta <= 30:
        B1 = randint(1,6)
        Berta = Berta + B1
        print("Berta vrže "+ str(B1) + " in je na " + str(Berta) +" tockah.")

        if Berta >= 30:
            print("Berta je zmagovalka")
            break;

        if B1 == 6:
            B1 = randint(1, 6)
            Berta = Berta + B1
            print("Berta vrže " + str(B1) + " in je na " + str(Berta) + " tockah.")

        if Berta >= 30:
            print("Berta je zmagovalka")
            break;

input("Pritisni gumb da zapreš")