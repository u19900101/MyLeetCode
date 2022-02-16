package _1_入门;

/**
 * @author pppppp
 * @date 2022/1/8 9:50
 */
public class HelloWorld {
    public static void main(String[] args){
        // System.out.println("Hello World");
        var sb = new StringBuilder();
        sb.append('k');
        // System.out.println(sb);
        int z = '中';
        // System.out.println(z); //20013
        // String s = """
        //            SELECT * FROM
        //              users
        //            WHERE id > 100
        //            ORDER BY name DESC
        //            """;
        // System.out.println(s);
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?
    }
}
