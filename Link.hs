module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where
   
import City 
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL c (Lin c1 c2 _) | c == c1 || c == c2 = True
                           |otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL c1 c2 l | connectsL c1 l == True && connectsL c2 l == True = True
                  | otherwise = False

capacityL :: Link -> Int
capacityL (Lin _ _ q) = capacityQ q

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ q) = delayQ q
