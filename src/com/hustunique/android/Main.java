package com.hustunique.android;

public class Main {
    /**
     * You can modify testLevel from 1 to 3
     */
    public static void main(String[] args) {

        HashMap<String, Animal> stringAnimalHashMap = new HashMap<>();
        //java.util.HashMap<String, Animal> stringAnimalHashMap = new java.util.HashMap<>();
        int testLevel = 3;
        if (testLevel >= 1) {
            System.out.println("*** TEST1: put,get ***");
            stringAnimalHashMap.put("猫猫", new Animal("喵喵"));
            stringAnimalHashMap.put("狗狗", new Animal("汪汪"));
            stringAnimalHashMap.put("小羊", new Animal("咩咩"));
            stringAnimalHashMap.get("小羊").say();
            stringAnimalHashMap.put("小羊", new Animal("咩咩咩"));
            stringAnimalHashMap.get("小羊").say();
        }
        if (testLevel >= 2) {
            System.out.println("\n*** TEST2: containsKey,remove ***");
            System.out.println(stringAnimalHashMap.containsKey("猫猫"));
            stringAnimalHashMap.remove("猫猫").say();
            System.out.println(stringAnimalHashMap.containsKey("猫猫"));
        }
        if (testLevel >= 3) {
            System.out.println("\n*** TEST3: forEach ***");
            stringAnimalHashMap.forEach((s, animal) -> {
                System.out.print(s + "说：");
                animal.say();
            });
        }
    }
}
