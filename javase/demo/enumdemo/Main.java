package javase.demo.enumdemo;

/**
 * Description: 测试类-测试RmbEnum枚举类
 *
 * @author created by ChenMeiYu at 2021-1-21 9:17, v1.0
 * modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 * [TODO-修改内容概述]
 */
public class Main {

    public static void main(String[] args) {
        // 编译器会自动为enum类添加一些函数
        methodsAutoAddedToEnum();

        // 在switch语句中使用Enum类
        testEnumInSwitch();
    }

    /**
     * Description: 使用示例-编译器自动为枚举类添加了一些函数，本函数中展示了这些函数的使用示例
     *
     * @author created by ChenMeiYu at 2021-1-21 9:32, v1.0
     */
    public static void methodsAutoAddedToEnum() {
        /*编译器会自动为枚举类添加toString/values/ordinal()函数*/
        for (RmbEnum item : RmbEnum.values()) {
            System.out.println(item + ",order=" + item.ordinal());
        }
    }

    /**
     * Description: 使用示例-switch中使用枚举类
     *
     * @author created by ChenMeiYu at 2021-1-21 9:33, v1.0
     */
    public static void testEnumInSwitch() {
        /*枚举类可以在switch中使用*/
        System.out.println("============枚举类可以在switch语句中使用============");
        StringBuilder sb = new StringBuilder();
        for (RmbEnum item : RmbEnum.values()) {
            sb.append(item).append(":");
            switch (item) {
                case ONE:
                    sb.append("一元");
                    break;
                case TWO:
                    sb.append("两元");
                    break;
                case FIVE:
                    sb.append("五元");
                    break;
                case TEN:
                    sb.append("十元");
                    break;
                case TWENTY:
                    sb.append("二十元");
                    break;
                case FIFTY:
                    sb.append("五十元");
                    break;
                case HUNDRED:
                    sb.append("一百元");
                    break;
                default:
                    break;
            }
            sb.append(",").append(item.ordinal()).append(";\n");
        }
        System.out.println(sb);
    }
}
