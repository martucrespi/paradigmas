
import Link 
import City
module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
primerL = head tunel 
ultimoL = last tunel

primeraC cit (Lin cit1 _ _) | cit == cit1 = True
                  |otherwise = False

ultimaC cit (Lin _ cit2 _) | cit == cit2 = True
                  |otherwise = False

connectsT c1 c2 Tunel | primeraC c1 primerL == True && ultiamC c2 ultimoL == True = True
                     |primeraC c2 primerL == True && ultimaC c1 ultimoL == True = True
                     | otherwise = False

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l t = foldr (\each acc -> l == each || acc) False t

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT t = foldr (\each acc -> acc + delayL each) 0 t

