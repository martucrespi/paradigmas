module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ = Qua

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua s i f) = i

delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua s i f) = f

-- codigo de testeo
main :: IO ()
main = do
    let q1 = newQ "High" 5 10.58
        q2 = newQ "Low" 1 5.12
        delay1 = delayQ q1
        delay2 = delayQ q2
        capacity1 = capacityQ q1
        capacity2 = capacityQ q2
    print delay1
    print delay2
    print capacity1
    print capacity2
