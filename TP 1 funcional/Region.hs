

module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg c l t) cit = cit:c

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg c l t) c1 c2 q = Reg (c1:c2:c) (newL c1 c2 q:l) (newT (newL c1 c2 q:l):t)

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
linksInReg links (c:cities) = [l | l <- links, c1 <- c:cities,c2 <- cities, linksL c1 c2 l]
tunelR (Reg c l t) cities = Reg c l (newT (linksInReg l cities):t)

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ t) c1 c2 = foldr (\each acc -> connectsT c1 c2 each) False t


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ l _) c1 c2 = foldr (\each acc -> linksL c1 c2 each) False l


delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ _ t) c1 c2 | tunelInR t c1 c1 /= [] = foldr (\tunel acc -> acc + delayT tunel) 0 (tunelInR t c1 c2)
                        | otherwise = error "no se encontro el tunel"
tunelInR tunels c1 c2 = [t| t<- tunels, connectsT c1 c2 t]


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg _ links _) c1 c2 | buscarLink links c1 c2 /= [] =  foldr (\link acc -> acc + capacityL link) 0 links
                                             | otherwise = error "No se encontro el la capacidad entre esas ciudades"
buscarLink l c1 c2 = [link| link <- l, linksL c1 c2 link]
