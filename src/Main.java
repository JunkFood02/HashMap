
public class Main {
    public static void main(String[] args) {
        HashMap<String, String> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("猫猫", "喵喵");
        stringIntegerMap.put("狗狗", "汪汪");
        stringIntegerMap.put("小羊", "咩咩");
        System.out.println(stringIntegerMap.get("猫猫"));
        System.out.println(stringIntegerMap.get("狗狗"));
        System.out.println(stringIntegerMap.get("小羊"));
        stringIntegerMap.put("小羊", "咩咩咩");
        System.out.println(stringIntegerMap.get("小羊"));
    }
}
