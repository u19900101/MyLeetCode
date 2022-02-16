package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author pppppp
 * @date 2021/12/5 12:17
 */
public class FileReader_Writer {
    public static void main(String[] args) throws IOException {
        /*利用Java 7引入的新的try(resource)的语法，只需要编写try语句，让编译器自动为我们关闭资源*/
        try (FileReader file = new FileReader("./fileLearn/hello.txt")) {
            char[] cbuffer = new char[5];
            int len;
            while ((len = file.read(cbuffer)) != -1) {
                // System.out.println(Arrays.copyOfRange(cbuffer,0,len));
                System.out.println(new String(cbuffer, 0, len));
            }
        }


    }

    @Test
    public void T_新建文件() throws IOException {
        System.out.println("kkk");
        File file = new File("hello.txt");
        boolean newFile = file.createNewFile();
        System.out.println(file.getAbsolutePath());
        System.out.println(newFile);

    }

    @Test
    public void T_fileWriter() throws IOException {
        try (    /*追加*/
                // FileWriter fileWriter = new FileWriter("hello-writer.txt", true);) {
                /*覆盖*/
                BufferedWriter bf = new BufferedWriter(new FileWriter("hello-writer.txt",true))) {
            bf.write("memeda");
            bf.newLine();
            bf.write("jing");
        }
    }

    @Test
    public void T_路径() {
        File file = new File(".");
        //D:\MyMind\note\review\. 当前模块的路径 main 中则为 当前项目的路径
        System.out.println(file.getAbsolutePath());
    }
}
