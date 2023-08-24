import Point  (Point, newP, difP)


module City ( City, newC, nameC, distanceC )
   where

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC = Cit
nameC :: City -> String
nameC (Cit s _) = s
distanceC :: City -> City -> Float
distanceC (Cit s p) (Cit st po) = difP p po
