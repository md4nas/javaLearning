package com.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class predicateExample {
    public static void main(String[] args) {

        // Predicate to check if salary is greater than 10,000
        Predicate<Integer> salaryGreaterThan = salary -> salary > 10000;

        System.out.println("Is salary greater than 10000? " + salaryGreaterThan.test(1200));

        int empSalary = 120000;
        System.out.println("Is employee salary greater than 10000? " + salaryGreaterThan.test(empSalary));


        // Example 2: Using Predicate with Streams to filter even numbers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Modern (Java 8) way using Predicate + Streams
        int sum = numbers.stream().filter(isEven).mapToInt(n -> n).sum();
        System.out.println("Sum of even numbers (Streams) = " + sum);

        // Traditional (pre-Java 8) way using for-each loop
        int sum2 = 0;
        for(int number : numbers){
            if(number % 2 == 0){
                sum2 += number;
            }
        }
        System.out.println("Sum of even numbers (Loop) = " + sum2);


        // Example 3: Combining Predicates with Strings
        Predicate<String> startWithA = str -> str.toLowerCase().charAt(0) == 'a';
        Predicate<String> endWithE = str -> str.toLowerCase().charAt(str.length() - 1) == 'e';

        // Logical combinations of predicates
        Predicate<String> and =  startWithA.and(endWithE);     // starts with A AND ends with E
        Predicate<String> or =  startWithA.or(endWithE);       // starts with A OR ends with E
        Predicate<String> negate = startWithA.negate();        // does NOT start with A

        System.out.println("Does string start with 'A'? " + startWithA.test("Apple"));
        System.out.println("Does string end with 'E'? " + endWithE.test("Apple"));
        System.out.println("Starts with A AND ends with E? " + and.test("Apple"));
        System.out.println("Starts with A OR ends with E? " + or.test("Appl"));
        System.out.println("Does NOT start with A? " + negate.test("Apple"));


        // Example 4: Predicate with custom Student class
        Student st1 = new Student(1, "Anas");
        Student st2 = new Student(2, "Kabir");

        Predicate<Student> studentIdCheck = stdId -> stdId.getId() > 1;
        System.out.println("Is student ID greater than 1? " + studentIdCheck.test(st2));


        // Example 5: Using Predicate.isEqual() for equality checks
        Predicate<Object> checkName = Predicate.isEqual("Anas");
        // Predicate<Object> check = obj -> "Anas".equals(obj);
        Predicate<Object> checkId = Predicate.isEqual(1);

        System.out.println("Is student name 'Anas'? " + checkName.test(st1.getName())); // true
        System.out.println("Is student name 'Anas'? " + checkName.test("kabir"));       // false
        System.out.println("Is student ID = 1? " + checkId.test(1));
    }


    // Simple Student class for testing predicates
    private static class Student {
        private String name;
        private int id;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
