
module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
import Link
import City
import Data.Binary.Get (remaining)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas

primerasL (Tun tunel) = head tunel

segundoL (Tun tunel) = head (tail tunel)


anteultimoL (Tun tunel) = head (take 2 (drop (length tunel -2) tunel))
ultimoL (Tun tunel) = last tunel

connectsT c1 c2 t |connectsL c1 (primerasL t) && not (connectsL c1 (segundoL t)) = True
                  |connectsL c2 (primerasL t)  && not (connectsL c2 (segundoL t)) = True
                  |connectsL c1 (ultimoL t)  && not(connectsL c1 (anteultimoL t)) = True
                  |connectsL c2 (ultimoL t)  && not (connectsL c2 (anteultimoL  t)) = True
                  |otherwise = False


usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l (Tun t) = foldr (\each acc -> l == each || acc) False t

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun t) = foldr (\each acc -> acc + delayL each) 0 t

