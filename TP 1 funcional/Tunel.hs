module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point 
import City 
import Quality
import Link
import Data.Binary.Get (remaining)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas

primerasL (Tun tunel) = head tunel
segundoL (Tun tunel) = head (tail tunel)
anteultimoL (Tun tunel) = head (take 2 (drop (length tunel -2) tunel))
ultimoL (Tun tunel) = last tunel

connectsT c1 c2 t |(connectsL c1 (primerasL t) && not (connectsL c1 (segundoL t))) && (connectsL c2 (ultimoL t)  && not (connectsL c2 (anteultimoL  t))) = True
                  |(connectsL c2 (primerasL t)  && not (connectsL c2 (segundoL t))) && (connectsL c1 (ultimoL t)  && not(connectsL c1 (anteultimoL t))) = True
                  |otherwise = False


usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l (Tun t) = foldr (\each acc -> l == each || acc) False t

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun t) = foldr (\each acc -> acc + delayL each) 0 t

-- codigo de testeo
main :: IO ()
main = do
    let c11 = newC "Berlin" (newP 1 2)
        c12 = newC "London" (newP 4 6)
        c21 = newC "Praga" (newP 2 1)
        c22 = newC "Lisboa" (newP 6 4)
        c31 = newC "Oregon" (newP 1 3)
        c32 = newC "Valencia" (newP 4 5)
        q1 = newQ "Quality 1" 2 2.65
        q2 = newQ "Quality 2" 5 7.34
        q3 = newQ "Quality 3" 7 6.49
        l1 = newL c11 c12 q1
        l2 = newL c21 c22 q2
        l3 = newL c31 c32 q3
        l4 = newL c11 c22 q1
        t1 = newT [l1, l2, l3]
        conectado1 = connectsT c11 c32 t1
        conectado2 = connectsT c12 c22 t1
        atraviesa1 = usesT l2 t1
        atraviesa2 = usesT l3 t1
        atraviesa3 = usesT l4 t1
        delay = delayT t1
    print t1
    print conectado1 
    print conectado2
    print atraviesa1
    print atraviesa2
    print atraviesa3
    print delay

