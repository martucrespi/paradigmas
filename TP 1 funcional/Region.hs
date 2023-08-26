

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
foundR (Reg c l t) cit |foldr (\city acc -> city /= cit) False c = Reg (cit:c) l t
                        |otherwise = error "la ciudad ya está en la Region"


linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg c l t) c1 c2 q | foldr (\link acc -> linksL c1 c2 link) False l = error "ya existe un link entre estas ciudades"
                           | otherwise = Reg (c1:c2:c) (newL c1 c2 q:l) (newT (newL c1 c2 q:l):t)


tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región

linksInReg links (c:cities) = [l | l <- links, c1 <- c:cities,c2 <- cities, linksL c1 c2 l]
tunelR (Reg c l t) cities | foldr (\tunel acc -> tunel /= newT (linksInReg l cities)) False t = Reg c l (newT (linksInReg l cities):t) 
                           | otherwise = error "ya existe esta comunicación"


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg c _ t) c1 c2 |foldr (\city acc -> city /= c1) False c && foldr (\city acc -> city /= c2) False c = foldr (\each acc -> connectsT c1 c2 each) False t
                              | otherwise = error "por lo menos una de las dos ciudades no esta en Region"


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ l _) c1 c2 = foldr (\each acc -> linksL c1 c2 each) False l


delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

tunelInR tunels c1 c2 = [t| t<- tunels, connectsT c1 c2 t]
delayR (Reg _ _ t) c1 c2 | tunelInR t c1 c1 /= [] = foldr (\tunel acc -> acc + delayT tunel) 0 (tunelInR t c1 c2)
                         | otherwise = error "no se encontro el tunel"



availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

buscarLink l c1 c2 = [link| link <- l, linksL c1 c2 link]
availableCapacityForR (Reg _ links _) c1 c2 | buscarLink links c1 c2 /= [] =  foldr (\link acc -> acc + capacityL link) 0 links
                                             | otherwise = error "No se encontro el la capacidad entre esas ciudades"

