/**Lists are just one type of Scala collections, but it is the most important one. Go through List.sc first
  * Sets and Maps like lists are immutable, 'core' scala collections
  */

/****************************MAPS*****************************/

//Creating a map from key value pairs
//Map is a collection of pairs, i.e Nothing but collection of Tuples
//.Map -> returns a list of key values pairs, lists of Tuples
val stateCodes = Map(
  "California" -> "CA",
  "New York" -> "NY", //Arrow notation
  ("Vermont" , "VT") //Paranthesis notation
)

//Lookup the value for a given key
stateCodes("California") //If given incorrect value it throws noElementFoundException

//.contains -> returns true or false
stateCodes.contains("Califohkjhkh") //returns false


//Applying Higher Order functions to Maps

//foreach,map,reduce will all work with Maps, just they will with 'Lists'
//the key is that, the function we specify must operate on key-value pairs i.e., 2-element tuples
//The input will be a two-element tuple, See the example
stateCodes.foreach(x => println(x._1 + "=" + x._2))
stateCodes.foreach((x:(String,String)) => println(x._1 + "=" + x._2) ) //both the statements are same


//convert Map to a List
//If we have two lists with same number of elements, we can create a Map using "zip" and "toMap"
val states = List("California","New York","Vermont")
val codes = List("CA","NY","VT")

val stateCodes1 = (states zip codes).toMap
stateCodes1 == stateCodes //you can compare two Map like this

//convert Map to List
stateCodes.keySet.toList
stateCodes.values.toList


/************************************SETS*******************************
  * Sets are really similar to lists,
  * except they are unordered and have a uniqueness constraint
  * Except that there is no much of a difference between a list and a set
  */










