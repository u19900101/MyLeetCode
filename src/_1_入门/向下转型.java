package _1_入门;

import java.util.Arrays;
import java.util.StringJoiner;
/**
 * @author pppppp
 * @date 2022/1/8 16:45
 */
public class 向下转型 {
    public static void main(String[] args) {

    }
    /*public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }*/

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(table);
        StringJoiner f = new StringJoiner(", ","(",")");
        StringJoiner v = new StringJoiner(", ","(",")");
        for (String field : fields) {
            f.add(field);
            v.add("?");
        }
        System.out.println(f);
        System.out.println(v);
        return String.join(" ",stringBuilder,f.toString(),"VALUES", v.toString());
    }
    static String buildInsertSql2(String table, String[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(table);
        StringBuilder f = new StringBuilder();
        StringBuilder v = new StringBuilder();
        f.append("(");
        v.append("(");
        for (String field : fields) {
            f.append(field).append(", ");
            v.append("?, ");
        }
        f.setLength(f.length()-2);
        v.setLength(v.length()-2);
        f.append(")");
        v.append(")");
        System.out.println(f);
        System.out.println(v);
        return String.join(" ",stringBuilder,f,"VALUES",v);
    }
}


class Score {
    private int[] scores;
    public Score(int[] scores) {
        this.scores = Arrays.copyOf(scores,scores.length);
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}