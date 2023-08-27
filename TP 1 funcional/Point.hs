module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP = Poi

difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi x y) (Poi z w) = sqrt ( fromIntegral (z - x)^2 + fromIntegral (w - y)^2)

-- codigo de testeo
main :: IO ()
main = do
    let p1 = newP 1 2
        p2 = newP 4 6
        distance = difP p1 p2
    print distance
    print p1
    print p2
