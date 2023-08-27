module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import Point 
import City 
import Quality
                                              
data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL c (Lin c1 c2 _) | c == c1 || c == c2 = True
                           |otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL c1 c2 l | connectsL c1 l && connectsL c2 l = True
               | otherwise = False

capacityL :: Link -> Int
capacityL (Lin _ _ q) = capacityQ q

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ q) = delayQ q

-- codigo de testeo
main :: IO ()
main = do
    let c1 = newC "Berlin" (newP 1 2)
        c2 = newC "London" (newP 4 6)
        c3 = newC "Buenos Aires" (newP 5 3)
        q1 = newQ "Quality 1" 2 2.65
        l1 = newL c1 c2 q1
        conectado1 = connectsL c1 l1
        conectado2 = connectsL c3 l1
        link1 = linksL c1 c2 l1
        link2 = linksL c2 c3 l1
        capacidad = capacityL l1
        delay = delayL l1 
    print l1
    print conectado1
    print conectado2
    print link1
    print link2
    print capacidad
    print delay
