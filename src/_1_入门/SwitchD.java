package _1_入门;

/**
 * @author pppppp
 * @date 2022/1/8 15:43
 * 从Java 12开始 不需要再写break，确保只有一个可以到达
 */
public class SwitchD {
    public static void main(String[] args) {
        String fruit = "apple";
        int result = switch (fruit) {
            case "apple" -> {
                System.out.println("Selected apple");
                yield 1;
            }
            case "pear" -> {
                System.out.println("Selected pear");
                yield 2;
            }
            case "mango" -> {
                System.out.println("Selected mango");
                System.out.println("Good choice!");
                yield 0;
            }
            default -> {
                System.out.println("No fruit selected");
                yield 3;
            }
        };
        // System.out.println(result);
        for (int i = 0; i < 5; i++) {
            System.out.println("i is " + i);
            /*break 只跳出一层*/
            for (int j = 0; j < 5; j++) {
                System.out.println("j is " + j);
                if(j == 3){
                    break;
                }
            }
        }
    }
}
