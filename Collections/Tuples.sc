//they are not collections at all, do not reside in the namespaces where all the collections exists under
//conceptually they are very similar to collections
//creating, accessing each individual elements,iterating, passing tuple to functions

//************CREATING TUPLES*******************
val personalInfo = ("Ashok", "M", 28,"Hadoop Developer")
val genderPair = "Ashok" -> "M"

personalInfo._1
personalInfo._2
personalInfo._3

//tuples are accessed from index 1.
//This makes the different from Lists, Arrays, Collections and Map etc.

//To access an element of a tuple using variables
val (firstName, gender, age, occupation) = personalInfo

firstName

//If you care about some tuple elements but not others, use placeholder
val (firstName1, lastName1, _, gender1) = personalInfo
//age is ignored in the above information
gender1


//****************ITERATING THROUGH TUPLES*************
//productIterator.foreach

personalInfo.productIterator.foreach{x => println("Value "+x)}

//To find number of elements in a tuple use "productArity"
personalInfo.productArity


//*****************PASSING TUPLES TO FUNCTION***********
//Call .tupled() method on the function object
val genderInfo = "Ashok" -> "M"

def printPersonGender(name:String, gender:String) = {
  println(s"Name: $name M/F: $gender")
}

(printPersonGender _).tupled(genderInfo) //pass tuple to a function


//Collections in Scala(and java) all derive from the interface Iterable
//Tuples, on the other hand adhere to traits Tuple1, Tuple2...
//Tuples are not really collections
//Tuples are immutable










