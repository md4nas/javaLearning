package com.practice.java8;


public class exmaple02 {

    public static void main(String[] args) {
        new exmaple02().doSometing();
    }

    int a = 2; // instance variable

    // lambda expression can access instance variables of outer class,
    // local variables of enclosing method,
    // and local variables of lambda expression
    public  void doSometing(){

        int x = 4;
        Employee employee01 = () -> {
            int a =3; // local variable
            System.out.println("instance variable of outer class " + this.a); // refers to instance variable of outer class
            System.out.println("local variable of enclosing method " + x); // refers to local variable of enclosing method
            System.out.println("local variable of lambda expression " + a); // refers to local variable of lambda expression
            return "10";
        };

        System.out.println("Employee 01 salary: " + employee01.getSalary());
        System.out.println("----------------------------------");

        // Anonymous Inner Class
        Employee employee02 = new Employee (){

            int x = 5; // instance variable

            @Override
            public String getSalary() {
                System.out.println("instance varible of employee 02 " + this.x);
                return "100";
            }
        };
        System.out.println("Employee 02 salary: " + employee02.getSalary());
    }

    @FunctionalInterface
    interface Employee {
        String getSalary();
    }
}
