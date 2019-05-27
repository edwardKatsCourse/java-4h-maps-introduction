package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Set           ->      Map
        //HashSet       ->      HashMap
        //TreeSet       ->      TreeMap
        //LinkedHashSet ->      LinkedHashMap

        //Map<String, String> map = new HashMap<>();
        //map.put("john@site.com", "John Doe"); //.add
        //map.put("peter@site.com", "Peter Dale");

        //System.out.println(map);
        //System.out.println(map.get("peter@site.com"));

        //  email   person
        Map<String, Person> personDatabase = new HashMap<>();
        personDatabase.put("john@site.com", new Person("john@site.com", "John Doe", 44));
        personDatabase.put("peter@site.com", new Person("peter@site.com", "Peter Stone", 27));
        personDatabase.put("marry@site.com", new Person("marry@site.com", "Marry Smith", 72));

        while (true) {
            System.out.println("Enter email: ");
            String email = new Scanner(System.in).nextLine();

            if (personDatabase.containsKey(email)) {
                System.out.println("Person with such email already exists");
                if (createAnotherPersonOption()) {
                    continue;
                } else {
                    break;
                }
            }

            System.out.println("Enter name: ");
            String name = new Scanner(System.in).nextLine();

            System.out.println("Enter age: ");
            Integer age = new Scanner(System.in).nextInt();

            Person newPersonInDatabase = new Person(email, name, age);

            Person oldPersonInDatabase = personDatabase.put(email, newPersonInDatabase);//create or update

//            System.out.println("Add another person? (Y/N)");
//            String answer = new Scanner(System.in).nextLine();
//            if (answer.equalsIgnoreCase("y")) {
//                continue;
//            } else {
//                break;
//            }

//            if (!answer.equalsIgnoreCase("y")) {
//                break;
//            }

            if (!createAnotherPersonOption()) {
                break;
            }
        }

//        System.out.println("Persons added:");
//        System.out.println(personDatabase.toString());

        System.out.println("Search by email:");
        String searchEmail = new Scanner(System.in).nextLine();

        Person personFound = personDatabase.get(searchEmail);
        if (personFound == null) {
            System.out.println("No matches found");
            return;
        }

        System.out.println("------------------");
        System.out.println("Name: " + personFound.getName());
        System.out.println("Email: " + personFound.getEmail());
        System.out.println("Age: " + personFound.getAge());
    }

    private static boolean createAnotherPersonOption() {
        System.out.println("Add another person? (Y/N)");
        String answer = new Scanner(System.in).nextLine();
//            if (answer.equalsIgnoreCase("y")) {
//                continue;
//            } else {
//                break;
//            }

        return answer.equalsIgnoreCase("y");
    }
}

class Person {
    private String email;
    private String name;
    private Integer age;

    public Person(String email, String name, Integer age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Email: %s | Age: %s",
                this.name,
                this.email,
                this.age);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}