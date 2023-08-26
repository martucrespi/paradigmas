module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP = Poi
difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi x y) (Poi z w) = sqrt ( fromIntegral (z - x)^2 + fromIntegral (w - y)^2)