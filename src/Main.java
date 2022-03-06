

public class Main {
    public static void main(String[] args) {
        HashMap<String, Animal> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("猫猫", new Animal("喵喵"));
        stringIntegerMap.put("狗狗", new Animal("汪汪"));
        stringIntegerMap.put("小羊", new Animal("咩咩"));
        stringIntegerMap.get("小羊").say();
        stringIntegerMap.put("小羊", new Animal("咩咩咩"));
        stringIntegerMap.get("小羊").say();
        stringIntegerMap.forEach((s, animal) -> {
            System.out.print(s+"说：");
            animal.say();
        });
    }
}
