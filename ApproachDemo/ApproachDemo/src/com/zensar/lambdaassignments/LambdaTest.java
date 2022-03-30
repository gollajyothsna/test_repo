package com.zensar.lambdaassignments;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;



@FunctionalInterface
interface MathOperation {
public int operation(int x, int y);
}



@FunctionalInterface
interface Order {
public String OrderStatus(int no);
}



@FunctionalInterface
interface StringOpr {
int getLength(String str);
}





public class LambdaTest {



@Override
public String toString() {
return "LambdaTest []";
}



public static void main(String[] args) {
// 1. Write an application to perform basic arithmetic operations like add,
// subtract, multiply & divide. You need to define a functional interface first.

//2. Write an application using lambda expressions to print Orders having
//2 criteria implemented: 1) order price more than 10000 2) order status is ACCEPTED or COMPLETED.

//3. Use the functional interfaces Supplier, Consumer,
// Predicate & Function to invoke built-in methods from Java API.



//4. Remove the words that have odd lengths from the list. HINT:
//Use one of the new methods from JDK 8. Use removeIf() method from Collection interface.


// BiFunction<Integer, Integer, Integer> biFunc= (x, y)->x + y;
// System.out.println("Addition: " + biFunc.apply(5, 10));

MathOperation addition = (int x, int y) -> x + y;
MathOperation subtraction = (int x, int y) -> x - y;
MathOperation multiplication = (int x, int y) -> x * y;
MathOperation division = (int x, int y) -> x / y;

System.out.println("Addtion : " +addition.operation(5, 10));
System.out.println("Substraction : " +subtraction.operation(24, 2));
System.out.println("Multiplication : " +multiplication.operation(55, 10));
System.out.println("Division : " +division.operation(10, 2));

// BiFunction<Integer, String> biFunc = (O,S) -> {return O > 10000;

Order status = (int no)-> (no > 10000)? "ACCEPTED" :"COMPLETED";
System.out.println(status.OrderStatus(15000));

// Predicate<Integer> Order = (no)-> (no > 10000)? "ACCEPTED" :"COMPLETED";




// Order order1 = (int no, String status) ->
// { return; if (no > 10000) System.out.println("ACCEPTED"); else System.out.println("COMPLETED");
// }

Supplier<String> supplier = ()-> "Jyothsna yadav";
System.out.println(supplier.get());

Consumer<String> consumerString = s ->System.out.println(s);
consumerString.accept("Jyo");

Predicate<Integer> predicate = i -> i > 100;
boolean greaterCheck = predicate.test(200);
System.out.println("is 200 greater than 100: "+greaterCheck);

Function<String, Integer> func = (String str)->str.length();
System.out.println("Length of String is: " + func.apply("Dhoni"));

//4.
ArrayList<String> arrayList = new ArrayList<>();
arrayList .add("jyothsna");
arrayList .add("Jo");
arrayList .add("yadav");
arrayList .add("Golla");

Predicate<String> filter = str -> (str.length()%2)!=0;



System.out.println("Original ArrayList : " + arrayList );
boolean value = arrayList .removeIf(filter);
System.out.println("Returned value : " + value);
System.out.println("ArrayList after removeIf() : " + arrayList );
//5.

List<String> Str = new ArrayList<String>();
StringBuilder ListFirstCharacterStr = new StringBuilder();
Str.add("Welcome");
Str.add("To");
Str.add("Java");
Str.add("World");
Consumer<List<String>> CreateNewString = list ->
{
list.forEach(e -> {ListFirstCharacterStr.append(e.charAt(0));});
};
CreateNewString.accept(Str);
System.out.print("First Character of List are : \n " + ListFirstCharacterStr);

//6
List<String> List = new ArrayList<String>();
List.add("Welcome");
List.add("To");
List.add("Java");
List.add("World");
System.out.println("Before Converting :: " + List);
UnaryOperator <List<String>> MakingCaptialLettersOfWords = list ->
{ list.replaceAll(e-> e.toUpperCase());
return list;};
MakingCaptialLettersOfWords.apply(List);
System.out.println("After Converting into Capital Letters :: " + List);

//7
Map<Integer, String> map = new HashMap<>();
map.put(1, "ABC");
map.put(2, "PQR");
map.put(3, "XYZ");
String result = map.entrySet()
.stream()
.map(entry -> entry.getKey() + " - " + entry.getValue())
.collect(Collectors.joining(", "));
System.out.println(result);

}
}