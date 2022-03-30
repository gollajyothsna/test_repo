package com.zensar.Dateapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Account1 {
	String name;
	double balance;

	public Account1(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return this.name;
	}

	public double getBalance() {
		return this.balance;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.balance;
	}
}

public class StreamTest {

	private static Collection<String> studentList;
	private static Collection<String> temperatues;

	public static void main(String[] args) {
// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("Jyothsna");
		list.add("abc");
		list.add("abcd");

		Predicate<String> predicate = (String name) -> name.length() % 2 != 0;
		List<String> oddNameStudentList = list.stream().filter(predicate).collect(Collectors.toList());
		System.out.println(oddNameStudentList);
		
		//sorted
		//List<String> sortedStudentList = studentList.stream().sorted().collect(Collectors.toList());
      
		//sort accout list by account balance using sorted() method
		List<Integer> accountlists = Arrays.asList(1000,2000,3000,4000);
		List<Integer> accountBalanceLists = accountlists.stream().sorted().collect(Collectors.toList());
		System.out.println(accountBalanceLists);
		//Write account balance comparator lambda
		
		// allMatch
		List<Integer> temperatures = Arrays.asList(32, 34, 40, 37);
	    boolean isHot = temperatues.stream().noneMatch((Integer temperature)->temperature>39);
		
		//Write lambda where you input Account object & it returns the account balance.
		List<Account1> list1 = Arrays.asList(new Account1("Tom", 2000), new Account1("Jerry", 5000));
		Function<Account1, Double> balfunc = (account) -> account.getBalance();
		Function<Account1, String> namefunc = (account) -> account.getName();
		List<Double> accountBalanceList = list1.stream().map(balfunc).collect(Collectors.toList());
		
		//list of accountbalances
		List<String> nameList = list1.stream().map(namefunc).collect(Collectors.toList());
		System.out.println(accountBalanceList + " " + nameList);
	
	//flatMap using  for grouping 
		Stream<List<Integer>>stream = Stream.of(Arrays.asList(1,2,3),Arrays.asList(1,
				12,30),Arrays.asList(11,2,13));
		List<Integer>flatIntList=stream.flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flatIntList);
	}
}