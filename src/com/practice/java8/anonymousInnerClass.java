package com.practice.java8;


public class anonymousInnerClass {

    public static void main(String[] args) {

     // Anonymous Inner Class
        Employee employee = new Employee() {

            @Override
            public String getSalary(){
                return "10";
            }

       @Override
            public String getDesignation(){
                return "Software Engineer";
            }

        };

        System.out.println("Employee Salary: " + employee.getSalary());
        System.out.println("Employee Designation: " + employee.getDesignation());
/*
        // lambda expression
        // Employee has two abstract methods, so it’s not a functional interface.

        Employee emoployee = () -> {
         return "10"
        };
        System.out.println(emoployee.getSalary());
    }

    // Functional Interface
     @FunctionalInterface
     interface Eomployee {
     public String getSalary();
     }


 */

    }
}
