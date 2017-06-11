
//This is the core(important) of scala collections
//A List is an immutable, singly linked list

//***********************LISTS CREATION********************
//The end of the linked list is indicated by the special value Nil
//Nil is basically an empty List - it is a singleton object of type List[Nothing]
//A common way to create lists involves the "cons" operator :: and  the special value Nil

//The "cons" operator :: is right associative- it starts from the extreme right and works to the left
val weekDays = "Mon" :: "Tue" :: "Wed" :: "Thu" :: "Fri" :: Nil
//cons takes a list (initially Nil) and tacks on 1 element (initially Fri) to the head of that list
//And the chain continues until the entire list is setup
//This is advisable only if you have less values to form a Linked List

//Another method is to use apply method of a List to create a List
//i.e an equivalent way is to use the List "constructor" (actually called class parameters in scala)
//We need not use "new" key word if you use apply method.

val weekDays1 = List("Mon", "Tue","Wed", "Thu","Fri")
val weekEndDays = List.apply("Sat", "Sun")
//It doesn't really matter if you use apply method or not, it is by default called
//apply method -> it's exactly like passing variables to a function


val days = weekDays ::: weekEndDays
val days1 = weekDays ++ weekEndDays
//both are virtually same in the effect
//What is the difference between ++ & :::
//::: is used only for lists, ++ is used for any traversable object(all collections)
//::: is right associative, btw as is ::


//ZIP method is used to create list of tuples for each corresponding element in two lists

val allDays = List("Mon", "Tue","Wed", "Thu","Fri","Sat", "Sun")
val dayIndices = List(1,2,3,4,5,6,7)

dayIndices.zip(allDays)
//res0: List[(Int, String)] = List((1,Mon), (2,Tue), (3,Wed), (4,Thu), (5,Fri), (6,Sat), (7,Sun))


//Given a lists of lists, to combine into 1 list use flatten
val daysAgain = List(weekDays, weekEndDays)
val allDays1 = daysAgain.flatten //this gives same as allDays


//***************************SIMPLE LIST OPERATIONS**************************
//.head -> returns the first element
//.tail > returns the rest of the list (except first element, it returns every thing)
//.size -> returns the size
//.reverse -> reverses the list
//.contains -> it will test for a specific element in a list

allDays.head //This returns a string
allDays.tail //This returns a List
allDays.size //This returns an Int
allDays.reverse //This returns a new List
allDays.contains("Mon") //This returns a boolean

//for loop in a list works as usual
for(c <- allDays) println(c)

//While loops need to be terminated properly
//While loops are so unpopular and unfashioned in scala
var restOfWeek = allDays //need to be created as rest of the week need to be changed or else our while will create a infinite loop
while (! restOfWeek.isEmpty) //same as while(resOfWeek == Nil)
  {
    println(s"Grr..today is ${restOfWeek.head}," +
      s"${restOfWeek.size} days left for the weekend")
    restOfWeek = restOfWeek.tail //After the last element it returns a Nil value, so that while loop ends
  }

//.distinct -> returns distinct values
//.drop -> returns a new List with fewer elements
//.slice -> returns a new List subset of the old one
//.splitAt -> returns 2 new Lists, split the list after the point where we specify
//.take -> returns a new List, starting from the head to the number of elements we specify
//.sorted -> returns a new list sorted in a natural order
//.sum -> returns a Int, Float etc, This is only for (Int, float, double) etc. Not for String
//.product -> returns a Int, Float etc, This is only for (Int, float, double) etc. Not for String
//.min -> returns minimum of that type
//.max -> returns maximum of that type

allDays.distinct //This returns a List
allDays.drop(2) //First two elements are removed and returns a new List
allDays.slice(2,5) //Returns a list starting from position 2 and ending at position 5
allDays.splitAt(2) //Returns two Lists, first list with first two values and the next with other values
allDays.take(5) //Returns a list starting from Mon to Fri
allDays.sorted //Returns a list with natural sorted order, For string it is Alphabatical order, for Int it is natural order
allDays.min //Returns Fri
allDays.max //Returns Wed


//*********************************HIGHER ORDER FUNCTiONS IN LISTS***********************
//Higher order functions are functions that takes in other functions as arguments, or returns functions
//Higher order functions on collections are very important in functional programming

//These below functions avoid for loops in scala. They take each element in the collection and perform the required operation which we mentions
//They can be broadly classified into two categories.
//Map Funtions -> Take in a List object and returns a new List
//Reduce functions -> Take in a List object and shrinks list into a value

//foreach
//map
//reduce
//filter
//partition
//sortBy
//fold
//scan,scanLeft,scanRight

/**.foreach -> takes a procedure(does not have a return value) and applies it to each element in the list
  * It is a statement because it accepts procedures.
  * That procedure can be a function object or a literal
  * The result of this cannot be chained to another function*/

allDays.foreach(println(_)) //literal example
val printValue = (x:Any) => {println(x)}:Unit
weekDays.foreach(printValue) //function object example

/**.map -> very closely related to foreach is map.
  *map takes a function or functionObject and applies it to each element in the list, this is like a foreach
  * But the difference is the function in map does have a return value
  * So, map takes in a function not a procedure
  * Map returns a List, with the logic in the function applied to every element in the list
  */

allDays.map(_ =="Mon") //This returns a list of Booleans
val IsMonday = (x:String) => {x=="Mon"} : Boolean
allDays.map(IsMonday)


/**.filter -> takes a predicate and returns a list with each element in the list that satisfies the predicate
  * predicate is like a condition
  * it returns all the elements which satisfies that condition
  */

allDays.filter(_ != "Mon") //returns List(Mon)
allDays.filter(IsMonday)

/**.partition -> This also takes a predicate
  * Returns 2 lists -> elements that satisfy and those that don't satisfy, i.e a tuple of lists
  * Tuple(List1, List2) -> List1 -> condition satisfied, List2 -> condition not satisfies
  */
allDays.partition(_ == "Mon")
allDays.partition(IsMonday)

/**.sortBy -> takes a function and sorts the list elements based on it
  *
  */
allDays.sortBy(_(0)) //sort that list based on the first character of every element in that list



/**Scan, Fold & Reduce are conceptually Reduce methods*/

/**.scan, .scanLeft, .scanRight -> Given a List, takes a function and an initial value and scan, scanLeft & scanRight do their thing
  * These functions take two values, .scan(initial Value)(function to be applied on list)
  * If we understand scan well, it is easy to understand fold and reduce
  * Though conceptually reduce methods returns a value, scan is an exeception.
  * Scan returns a list of values
  * scanLeft is Left Associative
  * scanRight is Right Associative
  * scan makes no guarantees about direction, so make use of scanLeft or scanRight in most of the cases
  */

val someNumbers = List(10,20,30,40,50,60)

someNumbers.scanRight(0)(_-_)
someNumbers.scanLeft(0)(_-_)
someNumbers.scan(0)(_-_)


/**.fold, .foldLeft, .foldRight -> They are very closely related to scan, scanLeft & scanRight
  * These functions take two values, .fold(initial Value)(function to be applied on list)
  * This returns the "last" individual result from the operation, not a list like in scan
  * So, Please see how the results are going to be below
  * .foldLeft -> return the most "right" element from the result of .scanLeft
  * .foldRight -> return the most "left" element from the result of .scanLeft
  * .fold -> retuns the opposite end element from the direction in which scan is run
  */

someNumbers.foldRight(0)(_-_)
someNumbers.foldLeft(0)(_-_)
someNumbers.fold(0)(_-_)


/**.reduce, .reduceLeft, .reduceRight -> Conceptually Reduce and Fold are same
  * Main difference between them is, reduce does not take an initial value
  * First two elements (direction considered) of the list are used in the first call of the reduction function
  * subsequent calls to the reduction function happens as in fold
  * This also results the last element
  */

someNumbers.reduceRight(_-_)
someNumbers.reduceLeft(_-_)
someNumbers.reduce(_-_)

/**Other, Simpler Reduce Operations : startsWith, endsWith, forAll
  * reduce, fold, scan are higher order functions, powerful and complicated
  * .endsWith -> Returns Boolean
  * .startsWith -> Returns Boolean
  * .forAll -> Return Booleans (takes a predicate and check with all the elements in the list)
  */

//consider, weekDays, weekEndDays, allDays for this example

allDays.endsWith(weekEndDays) //returns true
allDays endsWith weekEndDays //same as before statemnt

allDays.startsWith(weekDays)

allDays.forall(_ != "Monday") //if true for all returns true, else returns false
allDays.forall(_.isInstanceOf[String]) //true