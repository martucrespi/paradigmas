

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


tunrlR (Reg c l t) cities = foldr ()

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ t) c1 c2 = foldr (\each acc -> connectsT c1 c2 each) False t


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ l _) c1 c2 = foldr (\each acc -> linksL c1 c2 each) False l

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

delayR (Reg _ _ t) c1 c2 = foldr ()


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades



