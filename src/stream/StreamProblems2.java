package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamProblems2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 7, 8, 9, 5, 2, 36, 4, 78, 222, 24, 9);

		// Sum all Numbers
		list.stream().reduce((a, b) -> a + b).ifPresent(s -> System.out.println("Total " + s));

		// Given a list of numbers, return the average of all numbers.
		OptionalDouble average = list.stream().mapToInt(number -> number).average();
		if (average.isPresent()) {
			System.out.println("Average " + average.getAsDouble());
		}

		// Given a list of numbers, square them and filter the numbers which
		// are greater 100 and then find the average of them
		double average2 = list.stream().map(number -> number * number).filter(number -> number > 100)
				.mapToInt(num -> num).average().orElse(0);
		System.out.println("Average2 " + average2);

		// Given a list of numbers, return the even and odd numbers separately.
		Map<Boolean, List<Integer>> evnOdd = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
		evnOdd.forEach((k, v) -> System.out.println("key :" + k + " value:" + v.toString()));

		// Given a list of numbers, find out all the numbers starting with 2
		List<Integer> numberStartsWith2 = list.stream().map(number -> String.valueOf(number))
				.filter(num -> num.startsWith("2")).map(num -> Integer.valueOf(num)).collect(Collectors.toList());
		System.out.println(numberStartsWith2.toString());

		// Given a list of numbers, print the duplicate numbers. (Approach -1)
		List<Integer> duplicates = list.stream().filter(num -> Collections.frequency(list, num) > 1).distinct()
				.collect(Collectors.toList());
		System.out.println("Duplicate " + duplicates.toString());

		// Given a list of numbers, print the duplicate numbers. (Approach -2)
		Set<Integer> set = new HashSet();
		List<Integer> dups = list.stream().filter(num -> !set.add(num)).distinct().collect(Collectors.toList());
		System.out.println("Duplicate " + dups.toString());

		// Given a list of numbers, print the maximum and minimum values.
		Optional<Integer> max = list.stream().max((a, b) -> a - b);
		System.out.println("Max" + max.get());

		Optional<Integer> min = list.stream().min((a, b) -> a - b);
		System.out.println("Min" + min.get());
		
		Optional<Integer> max2 = list.stream().max(Comparator.comparing(num -> num));
		System.out.println("Max" + max2.get());

		Optional<Integer> min2 = list.stream().min(Comparator.comparing(num -> num));
		System.out.println("Min" + min2.get());
		

		// Given a list of numbers, sort them in ASC order and print.
		List<Integer> asc = list.stream().sorted().collect(Collectors.toList());
		System.out.println("asc order" + asc.toString());

		// Given a list of numbers, sort them in DESC order and print.
		List<Integer> dsc = list.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
		System.out.println("dsc order" + dsc.toString());
		
		List<Integer> dsc2 = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("dsc order" + dsc2.toString());

		// Given a list of numbers, return the first 5 elements and their sum.
		Optional<Integer> sum = list.stream().limit(5).reduce((a, b) -> a + b);
		if (sum.isPresent()) {
			System.out.println("SUM " + sum);
		}
		
		//Given a list of numbers, skip first 5 numbers and return the sum of remaining numbers.
		
		Optional<Integer> sum2 = list.stream().skip(5).reduce((a, b) -> a + b);
		if (sum.isPresent()) {
			System.out.println("SUM " + sum2);
		}
		
		//Given a list of numbers, return the cube of each number.
		List<Integer> cubes = list.stream().map(x-> x*x*x).collect(Collectors.toList());
		System.out.println("Cubes" + cubes);
	}

}
