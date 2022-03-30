package com.java8.approaches.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitUtils {

	private static Collection<Fruit> fruitList;
	private static Collection<Fruit> newsList;

	public static List<Fruit> getAllFruits() {
		List<Fruit> fruits = new ArrayList<Fruit>();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			String fruitNames[] = { "Peach", "Banana", "Pomegranate", "Apple", "Watermelon" };
			String fruitColors[] = { "Red", "White", "Yellow" };
			fruits.add(new Fruit(fruitNames[random.nextInt(4)], random.nextInt(500), random.nextInt(100),
					fruitColors[random.nextInt(2)]));
		}
		return fruits;

	}

	public static void printFruits(List<Fruit> fruits) {
		List<Fruit> lowCalories = fruits.stream().filter(fruit -> fruit.getCalories() < 100)
				.sorted(Comparator.comparing(Fruit::getCalories).reversed()).collect(Collectors.toList());
		lowCalories.forEach((s) -> System.out.println(s));

	}

	public static void colorWiseFruits(List<Fruit> fruits) {
		List<String> colorwiseList = fruits.stream().filter(p -> p.color.equals("Yellow")).map(p -> p.name).sorted()
				.collect(Collectors.toList());
		List<String> app3 = fruits.stream().filter(p -> p.color.equals("Red")).map(p -> p.name).sorted()
				.collect(Collectors.toList());
		System.out.println(app3);
	}

	public static void redColorFruits(List<Fruit> fruits) {
		List<Fruit> redColorFruits = fruits.stream().filter(fruit -> fruit.getColor() == "Red")
				.sorted(Comparator.comparing(Fruit::getColor)).collect(Collectors.toList());
		redColorFruits.forEach((s) -> System.out.println(s));
	}

	public static void main(String[] args) {
// printFruits(getAllFruits());
		colorWiseFruits(getAllFruits());
// redColorFruits(getAllFruits());
		Stream<Fruit> q1 = fruitList.stream().filter(fruit -> fruit.getCalories() < 100)
				.sorted(Comparator.comparing(Fruit::getCalories).reversed());
		// q1.forEach(f->System.out.println(f.getName()+" "+f.getCalories()));

		Stream<Fruit> q2 = fruitList.stream().sorted(Comparator.comparing(Fruit::getColor).reversed());
		// q2.forEach(fr->System.out.println(fr.getName()+ " " +fr.getColor()));

		Stream<Fruit> q3 = fruitList.stream().filter(fruit -> fruit.getColor().equals("red"))
				.sorted(Comparator.comparing(Fruit::getPrice));
		// q3.forEach(fr->System.out.println(fr.getName()+" "+fr.getColor()+"
		// "+fr.getPrice()));

		long news = newsList.stream().filter(news1 -> news1.getComment().equals("budget")).count();
		// System.out.println("count=" +news);

		Stream<Transaction> transaction = transactionList.stream().filter(tran -> tran.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue));
		// transaction.forEach(t->System.out.println(t.getYear()+" " +t.getValue()+ "
		// "+t.getTrader().getName()));

		Stream<String> trader = traderList.stream().map(t -> t.getCity()).distinct();
		// trader.forEach(t->System.out.println(t));

		Stream<Trader> trader1 = traderList.stream().filter(tra -> tra.getCity().equals("pune"))
				.sorted(Comparator.comparing(Trader::getName));
		// trader1.forEach(t->System.out.println(t.getCity()+" " + t.getName()));

		Stream<Trader> trader2 = traderList.stream().sorted(Comparator.comparing(Trader::getName));
		// trader2.forEach(t->System.out.println(t.getName()));

		Stream<Trader> trader3 = traderList.stream().filter(tra -> tra.getCity().equals("indore"));
		// trader3.forEach(t->System.out.println(t.getCity()+ " "+ t.getName()));

		Stream<Transaction> trans = transactionList.stream().filter(t -> t.getTrader().getCity().equals("delhi"));
		// trans.forEach(t->System.out.println(t.getValue()+" "+
		// t.getTrader().getCity()));

		OptionalInt maxTrans = transactionList.stream().mapToInt(t -> t.getValue()).max();
		// System.out.println(maxTrans.getAsInt());

		OptionalInt maxTrans1 = transactionList.stream().mapToInt(t -> t.getValue()).min();
		System.out.println(maxTrans1.getAsInt());
		
		public static void highCaloriesFruits(List<Fruit> fruits) {
			//1. Print all high calories Fruits(Calorie > 200) using partitioning.
			Predicate<Fruit> predicate = p -> p.getCalories() > 200;
			Map<Boolean, List<Fruit>> partitionedFruits = fruits.stream().collect(Collectors.partitioningBy(predicate));
			System.out.println(partitionedFruits);
		}
	}
}
