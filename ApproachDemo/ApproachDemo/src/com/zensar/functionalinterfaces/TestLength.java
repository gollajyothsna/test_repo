package com.zensar.functionalinterfaces;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;



//Write functional interface & lambda expression for functionality
//that returns length of the string.



@FunctionalInterface
interface StringOpr {
public int getLength(String str);
}



public class TestLength {
public static List<String> filterStrings(List<String> listOfStrs,
Predicate<String> predicate) {
List<String> listOfNonEmptyStrings = new ArrayList<String>();
for(String str : listOfStrs) {
if(predicate.test(str)) {
// if(str.isEmpty() == false) { // Not generic only for present situation it is used
listOfNonEmptyStrings.add(str);
}
}
return listOfNonEmptyStrings;
}



public static void main(String[] args) {

List<String> listOfStrs = Arrays.asList("Pavan","","Kumar","Dasari","");

Predicate<String> NonEmptyStringPredicate = (String str) -> !str.isEmpty();
List<String> listOfNonEmptyStrings = filterStrings(listOfStrs,
NonEmptyStringPredicate);
System.out.println("listOfNonEmptyStrings : " +listOfNonEmptyStrings);

Predicate<String> EmptyStringPredicate = (String str) -> str.isEmpty();
List<String> listOfEmptyStrings = filterStrings(listOfStrs,
EmptyStringPredicate);
System.out.println("listOfEmptyStrings : " +listOfEmptyStrings);

// StringLength Length = (String name) -> name.length(); // Using own function interface
// System.out.println("Length of the String is : " +Length.Length("Pavan"));

Function<String, Integer> func = (String str) -> str.length(); // Using predicate
System.out.println("Length of the String is : " +func.apply(("Pavan")));



}



}

