import java.lang.reflect.Field;

/**
 * @author pppppp
 * @date 2022/1/10 16:31
 */

public class Reflect {
  /*  public static void main(String[] args) throws Exception {
        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"
    }*/
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public字段"score":
        Field score = stdClass.getField("score");
        System.out.println(score);
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(String name) {
        super(name);
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}