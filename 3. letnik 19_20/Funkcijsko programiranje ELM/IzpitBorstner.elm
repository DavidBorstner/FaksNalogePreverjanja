module IzpitBorstner exposing (main)

import Html exposing (Html, button, div, text)
import Html.Events exposing (onClick)
import List exposing(..)

------------------ Naloga. 1 ---------------------
{-
   Napišite nekaj enostavnih funkcij nad seznami. Uporabite lahko zgolj funkcije map in foldl iz modula List,
-}
{-
     Napišite nekaj enostavnih funkcij nad seznami.
   Prva funkcija naj sprejme neko celo število (želena dolžina seznama), nek element (element, s katerim napolnite seznam do želene dolžine) in seznam, ki ga želite podaljšati.
   Če je seznam že daljši od podane dolžine ga pustite nespremenjenega.

   Primer:
   padTo 5 0 [1,2,3] = [1,2,3,0,0]

   Druga funkcija iz seznama vrne podseznam, ki se začne na prvem podanem indeksu, konča pa na indeksu za ena manjšem od podanega indeksa.

   Primer:
   slice 1 5 [1,2,2,1,1,2,2] == [2,2,1,1]

   Tretja funkcija je zelo sorodna funkciji foldl. Na nek način je sled izvajanja funkcije foldl.
   Kot prvi argument prejme funkcijo, ki vzame en element seznama in akumulator vrednosti (acc) ter iz njiju zgradi nov akumulator (torej točnoo tako kot dela foldl). Funkcija scan pa naj vrne celoten seznam vrednosti, ki so nastajale med izvajanjem tega folda.

   Primer:
   scan (\x y -> x+y) 0 [1,2,2,1,1,2,2] == [0,1,3,5,6,7,9,11]
-}


-- Appenda narejen seznam znakov na konec seznama
padTo : Int -> a -> List a -> List a
padTo dolzina stevilo sez =
    let 
        dlz = dolzina - (List.length sez)
    in
    sez ++ (naredSeznam stevilo dlz [])
    

-- Naredi seznam, ki vsebuje zeljen znak
naredSeznam : a -> Int -> List a -> List a
naredSeznam st l xs =
    if l > 0 then
        [ st ] ++ (naredSeznam st (l-1) xs)
    else
        xs

slice : Int -> Int -> List a -> List a 
slice start end list = 
    let
        zac = max (start) 0
        kon = max end 0
    in 
        List.drop zac list |> List.take (kon - zac)
        

-- Poskus
scan : (a -> b -> b) -> b -> List a -> List b
scan f acc l =
    case l of 
        [] -> [acc]
      
        h::t -> 
            case t of
                hT :: tT ->
                    (f h hT) ++ (scan f acc t)

------------------ Naloga. 2 ---------------------
{-
   Podano imate podatkovno strukturo, ki predstavlja naravno število v binarni predstavitvi.
   Osnovno število je 0 (konstruktor Zero), potem pa lahko iz nekega števila n sestavimo večje število na dva načina:
      1. Število podvojimo (in prištejemo 0) - konstruktor Dbl0
      2. Število podvojimo in prištejemo 1 - konstruktor Dbl1
      Število 5 predstavimo takole :
       Dbl1 (Dbl0 (Dbl1 Zero))

       Napišite tri funkcije
       1. incr : BinNat -> BinNat
       ki podano število poveča za 1.

       2. decToBinnat : Int -> BinNat,
       ki desetiško število pretvori v BinNat,

       3. sum : BinNat -> BinNat -> BinNat,
       ki sešteje dve števili v tej predstavitvi.

-}


type BinNat
    = Zero
    | Dbl0 BinNat
    | Dbl1 BinNat


incr : BinNat -> BinNat
incr n =
    case n of
        Zero ->
            Dbl1 Zero

        Dbl0 x ->
            Dbl1 x

        Dbl1 (Dbl0 x) ->
            Dbl0 (Dbl1 x)

        Dbl1 (Dbl1 x) ->
            Dbl0 (Dbl0 (incr x))

        Dbl1 Zero ->
            Dbl0 (Dbl1 Zero)


decToBinnat : Int -> BinNat
decToBinnat n =
    case n of
        0 ->
            Zero

        _ ->
            case remainderBy 2 n of
                0 ->
                    Dbl0 (decToBinnat (n // 2))

                1 ->
                    Dbl1 (decToBinnat (n // 2))

                _ ->
                    Zero

{- Pomožne metode, ki jih nisem rabil
-- pomozno nardi seznam
dodajaj n sez =
    case sez of
        [] -> Zero
        
        [a] -> if a == 0 then
                   Dbl0 n 
               else
                   Dbl1 n 
        
        h::t ->
            if h == 0 then
                dodajaj (Dbl0 n) t
            else
                dodajaj (Dbl1 n) t
                
-- pomozno pretvori stevilo v binarno
sezEnk n =
    let 
        stevec m sz =
         if m >= 1 then
            if remainderBy 2 m == 1 then
                [1] ++ stevec (m//2) sz
            else
                [0] ++ stevec (m//2) sz
         else
             sz
    in
        stevec n []
-}   

     
     
decr : BinNat -> BinNat
decr n =
    case n of
        Zero ->
            Zero

        Dbl1 Zero ->
            Zero

        Dbl1 x ->
            Dbl0 x

        Dbl0 (Dbl1 x) ->
            Dbl0 (Dbl0 x)

        Dbl0 Zero ->
            Zero

        Dbl0 (Dbl0 x) ->
            Dbl1 x
            
-- Enemu odšteva da lahko drugemu dodaja

sum : BinNat -> BinNat -> BinNat
sum n1 n2 =
    case n2 of
        Zero ->
            n1
        _ ->
            sum (incr n1) (decr n2)

{- Poskus rešitve summa z pretvorbo iz bin -> integer in nato nazaj v bin

-- Pretvorba iz sezEnk v decimalno število
vrednost: Int -> List Int -> Int -> Int
vrednost stevec sez len =
    case sez of
        [] -> stevec
        
        h::t -> 
            if h == 0 then
               vrednost stevec t (len-1)
            else
               vrednost (dodajBinarno stevec len) t (len-1)
            
-- Vrne dec vrednost stevila
dodajBinarno st l =   
     st + (2^(l-1))

-- Pretvori iz bin v 
binToDec st =
    let
        sez = (sezEnk st)
        dolzina = List.length sez
    in
    vrednost 0 (sezEnk st) dolzina
    
sum2 : BinNat -> BinNat -> BinNat
sum2 n1 n2 =
    let
        v = (binToDec n1) + (binToDec n2) 
    in
    decToBinnant v
-}

main =
    Html.text (Debug.toString())