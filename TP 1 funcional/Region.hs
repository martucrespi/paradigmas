module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR, )
   where

import Point
import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel] deriving (Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg c l t) cit | foldr (\city acc -> city /= cit) False c = Reg (cit:c) l t
                       | otherwise = error "la ciudad ya está en la Region"

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg c l t) c1 c2 q | foldr (\link acc -> linksL c1 c2 link) False l = error "ya existe un link entre estas ciudades"
                          | otherwise = Reg (c1:c2:c) (newL c1 c2 q:l) (newT (newL c1 c2 q:l):t)

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
linksInReg links (c:cities) = [l | l <- links, c1 <- c:cities,c2 <- cities, linksL c1 c2 l]
tunelR (Reg c l t) cities | foldr (\tunel acc -> tunel == newT (linksInReg l cities)) False t = Reg c l (newT (linksInReg l cities):t) 
                          | otherwise = error "ya existe esta comunicación"

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg c _ t) c1 c2 | foldr (\city acc -> city /= c1) False c && foldr (\city acc -> city /= c2) False c = foldr (\each acc -> connectsT c1 c2 each) False t
                             | otherwise = error "por lo menos una de las dos ciudades no esta en Region"

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ l _) c1 c2 = foldr (\each acc -> linksL c1 c2 each) False l

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
tunelInR tunels c1 c2 = [t | t<- tunels, connectsT c1 c2 t]
delayR (Reg _ _ t) c1 c2 | tunelInR t c1 c1 /= [] = foldr (\tunel acc -> acc + delayT tunel) 0 (tunelInR t c1 c2)
                         | otherwise = error "no se encontro el tunel"

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
buscarLink l c1 c2 = [link | link <- l, linksL c1 c2 link]
availableCapacityForR (Reg _ links _) c1 c2 | buscarLink links c1 c2 /= [] =  foldr (\link acc -> acc + capacityL link) 0 links
                                            | otherwise = error "No se encontro el la capacidad entre esas ciudades"

-- codigo de testeo
main :: IO ()
main = do
    let c11 = newC "Berlin" (newP 1 2)
        c12 = newC "London" (newP 4 6)
        c21 = newC "Praga" (newP 2 1)
        c22 = newC "Buenos Aires" (newP 6 4)
        c31 = newC "Oregon" (newP 1 3)
        c32 = newC "Valencia" (newP 4 5)
        c41 = newC "Viena" (newP 5 4)
        c42 = newC "Monte Carlo" (newP 9 3)
        c51 = newC "Roma" (newP 7 2)
        c52 = newC "Florencia" (newP 5 1)
        c61 = newC "Paris" (newP 8 8)
        c62 = newC "California" (newP 9 3)
        q1 = newQ "High" 10 10.20
        q2 = newQ "Low" 3 2.54
        q3 = newQ "Low" 2 1.25
        q4 = newQ "High" 9 8.77
        q5 = newQ "High" 7 9.45
        q6 = newQ "Low" 3 3.26
        r1 = newR
        add1 = foundR r1 c11
        add2 = foundR r1 c12
        add3 = foundR r1 c21
        add4 = foundR r1 c22
        add5 = foundR r1 c31
        add6 = foundR r1 c32
        add7 = foundR r1 c41
        add8 = foundR r1 c42
        add9 = foundR r1 c51
        add10 = foundR r1 c52
        add11 = foundR r1 c61
        add12 = foundR r1 c62
        link1 = linkR r1 c11 c12 q1
        link2 = linkR r1 c21 c22 q2
        link3 = linkR r1 c31 c32 q3
        link4 = linkR r1 c41 c42 q4
        link5 = linkR r1 c51 c52 q5
        link6 = linkR r1 c61 c62 q6
        tunel1 = tunelR r1 [c11, c12, c21, c22, c31, c32]
        tunel2 = tunelR r1 [c41, c42, c51, c52, c61, c62]
        connected1 = connectedR r1 c11 c12
        connected2 = connectedR r1 c41 c31
        links1 = linkedR r1 c11 c12
        links2 = linkedR r1 c52 c22
        delay = delayR r1 c42 c52
        capacity = availableCapacityForR r1 c42 c52
    print connected1
    print connected2
    print links1
    print links2
    print delay
    print capacity
