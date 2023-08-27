import Control.Exception
import System.IO.Unsafe
import Point
import Quality
import City
import Link
import Tunel
import Region

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

-- Points
point1 = newP 5 8
point2 = newP 6 9
point3 = newP 7 13
point4 = newP 6 9
point5 = newP 4 15

-- Qualities
highQuality = newQ "High" 10 10.2
lowQuality = newQ "Low" 5 2.6

-- City
city1 = newC "Buenos Aires" point2
city2 = newC "Vienna" point3
city3 = newC "Rome" point4
city4 = newC "Paris" point1

-- Link 
link1 = newL city1 city2 highQuality
link2 = newL city3 city4 lowQuality
link3 = newL city1 city2 highQuality

--Tunel
tunel1 = newT [link1, link2]
tunel2 = newT [link3, link2]

--Region
region = newR
add1 = foundR region city1
add2 = foundR region city2
add3 = foundR region city3
add4 = foundR region city4
linkr1 = linkR region city1 city2 highQuality
linkr2 = linkR region city3 city4 lowQuality
tunelr = tunelR region [city1, city2, city3, city4]
connected1 = connectedR region city1 city2
links1 = linkedR region city1 city2
delay = delayR region city1 city2
capacity = availableCapacityForR region city1 city2

testing :: [Bool]
testing = [
    -- Point
    newP 5 8 == point1,
    newP 6 9 == point2,
    newP 7 13 == point3,
    newP 6 9 == point4,

    difP point1 point2 == 1.41421356237,
    difP point2 point4 == 0.0,

    -- Quality
    newQ "High" 10 10.2 == highQuality,
    newQ "Low" 5 2.6 == lowQuality,

    -- City
    newC "Buenos Aires" (newP 6 9) == city1,
    newC "Vienna" (newP 7 13) == city2,

    -- Link
    newL city1 city2 highQuality == link1,
    newL city3 city4 lowQuality == link2,

    --Tunel
    newT [link1, link2] == tunel1,

    --Region
    connectedR region city1 city2 == connected1,
    linkedR region city1 city2 == links1,
    delayR region city1 city2 == delay,
    availableCapacityForR region city1 city2 == capacity
    
    ]
