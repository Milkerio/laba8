package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число работников N: ");
        int N = scanner.nextInt();
        List<String> listWords = Arrays.asList("cat", "dog", "mouse", "bird", "cat", "bird", "fly");
        String words = listWords.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .stream()
                .collect(Collectors.joining(", ", "самое частое слово: ", ""));
        System.out.println(words);
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob", 35, "male", 1100),
                new Person("Rose", 44, "female", 1300),
                new Person("Vadik", 25, "male", 2300),
                new Person("Benner", 42, "male", 880),
                new Person("Andrew", 55, "male", 1111),
                new Person("Lissa", 19, "female", 1500),
                new Person("Nick", 33, "male", 3000),
                new Person("Alex", 37, "male", 1400)));
        String workers = persons.stream()
                .filter(person -> person.gender == "male")
                .sorted(Collections.reverseOrder(Comparator.comparingInt(o -> o.age)))
                .map((Function<Person, String>) person -> person.name)
                .limit(N)
                .collect(Collectors.joining(", ",  N + " самых старших сотрудников: ", ""));
        System.out.println(workers);

    }
    }
