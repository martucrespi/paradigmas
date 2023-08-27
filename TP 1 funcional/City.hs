module City ( City, newC, nameC, distanceC )
   where

import Point 

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC = Cit

nameC :: City -> String
nameC (Cit s _) = s

distanceC :: City -> City -> Float
distanceC (Cit s p) (Cit st po) = difP p po

-- codigo de testeo
main :: IO ()
main = do
    let c1 = newC "Berlin" (newP 1 2)
        c2 = newC "London" (newP 4 6)
        distance = distanceC c1 c2
    print distance
    print c1
    print c2
