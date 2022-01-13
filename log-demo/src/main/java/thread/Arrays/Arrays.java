package thread.Arrays;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author pppppp
 * @date 2022/1/12 21:42
 * jdk1.8 演示arrayList的并发问题
 */
public class Arrays {
    public static void main(String[] args){
        // List<String> list = new ArrayList<>();
        /*解决方案1. Vector*/
        // List<String> list = new Vector<>();// add 方法线程安全
        /*解决方案2. 工具类*/
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        /*解决方案3. JUC CopyOnWriteArrayList 类*/
        // List<String> list = new CopyOnWriteArrayList<>();
        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() ->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
