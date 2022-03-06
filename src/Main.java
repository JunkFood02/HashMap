
public class Main {
    public static void main(String[] args) {
        HashMap<String, Animal> stringAnimalHashMap = new HashMap<>();
        stringAnimalHashMap.put("猫猫", new Animal("喵喵"));
        stringAnimalHashMap.put("狗狗", new Animal("汪汪"));
        stringAnimalHashMap.put("小羊", new Animal("咩咩"));
        stringAnimalHashMap.get("小羊").say();
        stringAnimalHashMap.forEach((s, animal) -> {
            System.out.print(s + "说：");
            animal.say();
        });
        stringAnimalHashMap.put("小羊", new Animal("咩咩咩"));
        System.out.println(stringAnimalHashMap.containsKey("猫猫"));
        stringAnimalHashMap.remove("猫猫").say();
        stringAnimalHashMap.forEach((s, animal) -> {
            System.out.print(s + "说：");
            animal.say();
        });
        System.out.println(stringAnimalHashMap.containsKey("猫猫"));
    }
}
