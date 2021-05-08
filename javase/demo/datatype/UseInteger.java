package javase.demo.datatype;

/**
 * Description: 展示基本数据类型int的包装器类Integer的用法
 *
 * @author created by Meiyu Chen at 2021-3-18 10:27, v1.0
 * <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 * <br>    [TODO-修改内容概述]
 */
public class UseInteger {
    public static void main(String[] args) {
        UseInteger demo = new UseInteger();
        demo.baseConversion();
        demo.testByteToBinaryString();
    }

    /**
     * Description: 数值在二进制、八进制、十进制、十六进制之间来回转化
     *      只有Integer和Long中封装了进制转化方法（toOctalString、toHexString、toBinaryString）
     *      可以将char/short/int/byte类型的数值传递给Integer的进制转化接口，如果将比较小的类型传递给这些方法，将会发生自动类型转化，相应类型会自动转化为int
     *      不能将long型的数值传递给Integer的进制转化接口，因为超出int的取值范围，会出现精度问题
     * @author created by Meiyu Chen at 2021-3-18 10:28, v1.0
     * @see javase.demo.operator.BitOperatorDemos#byteToBinaryString(byte) 
     */
    private void baseConversion() {
        // 十进制
        int i = 63;
//        int i1 = 0x2f; // 十六进制
//        int i2 = 0X2f; // 十六进制
//        int i3 = 0127; // 八进制
        System.out.println(
                "int型数值的进制转化(int i=63)\n" +
                        "\t十进制：" + i
                        + ",八进制：0" + Integer.toOctalString(i)
                        + ",十六进制：0x/0X" + Integer.toHexString(i)
                        + ",二进制：" + Integer.toBinaryString(i));
        // max char hex value
        char c = 0xffff;
//!        char c2 = 0xffff0; // value超出char可以表示的数值范围，编译器会报错，提示你要么强制类型转换，要么改变变量数据类型
        System.out.println(
                "char型数值的进制转化(char c = 0xffff)\n" +
                        "\t十进制：" + (int) c
                        + ",八进制：0" + Integer.toOctalString(c)
                        + ",十六进制：0x/0X" + Integer.toHexString(c)
                        + ",二进制：" + Integer.toBinaryString(c));

        // max byte hex value
        byte b = 0x7f;
        System.out.println(
                "byte型数值的进制转化(byte b = 0x7f)\n" +
                        "\t十进制：" + b
                        + ",八进制：0" + Integer.toOctalString(b)
                        + ",十六进制：0x/0X" + Integer.toHexString(b)
                        + ",二进制：" + Integer.toBinaryString(b));
        // max short hex value
        short s = 0x7fff;
        System.out.println(
                "short型数值的进制转化(short s = 0x7fff)\n" +
                        "\t十进制：" + s
                        + ",八进制：0" + Integer.toOctalString(s)
                        + ",十六进制：0x/0X" + Integer.toHexString(s)
                        + ",二进制：" + Integer.toBinaryString(s));
        // ------------- 可以使用Integer处理byte/short/char/int基本数据类型的数值，注意，如果比较小的数值类型传递给Integer的toBinaryString等方法，会自动转型为int ------------


        // ------------- 但是，不要使用Integer处理long/float/double基本数据类型的数值,否则会出现丢失精度的问题（超出取值范围 or 丢失小数部分） ------------
        long l = 10L;
        long l2 = 10;
        long l3 = 0x2fL;
        long l4 = 017L;
        System.out.println(
                "long型数值的进制转化(long l3 = 0x2fL)\n" +
                        "\t十进制：" + l3
                        + ",八进制：0" + Long.toOctalString(l3)
                        + ",十六进制：0x/0X" + Long.toHexString(l3)
                        + ",二进制：" + Long.toBinaryString(l3));
        System.out.println(
                "long型数值的进制转化(long l = 10L)\n" +
                        "\t十进制：" + l
                        + ",八进制：0" + Long.toOctalString(l)
                        + ",十六进制：0x/0X" + Long.toHexString(l)
                        + ",二进制：" + Long.toBinaryString(l));
//                        + ",二进制：" + Integer.toBinaryString(l)); // 编译器会报错，不能将long型数值传递给Integer.toBinary/Octal/HexString(),否则可能造成数据精度丢失，超出int可以表示的数值范围
        float f = 1f;
        float f2 = 1F;
        float f3 = 1;
        double d = 1;
        double d1 = 1.3d;
        double d2 = 1D;
        System.out.println(
                "double型数值的进制转化(double d1 = 1.3d)\n" +
                        "\t十进制：" + d1
                        + ",八进制：(基本类型的封装器中没有提供double型数值转化成八进制的API)"
                        + ",十六进制：0x/0X" + Double.toHexString(d1)
                        + ",二进制：(基本类型的封装器中没有提供double型数值转化成二进制的API)"
        );
    }

    /** Description: 测试byteToBinaryString()。看看byte转成二进制的函数是否正确
     * @author created by Meiyu Chen at 2021-3-18 17:39, v1.0
     */
    private void testByteToBinaryString(){
        System.out.println("将byte型数值转成二进制形式：");
        // 对应的二进制应为：1010
        for (byte b=Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            System.out.println(b + "=" + byteToBinaryString(b));
        }
        System.out.println("将byte型数值转成二进制形式：----------end ----------");
    }
    /**
     * Description: 基本数据类型对应的封装器中没有提供将byte型数值转化成二进制字符串的API
     * 本函数尝试使用位操作符来实现这一目的
     *
     * @return
     * @author created by Meiyu Chen at 2021-3-18 16:48, v1.0
     */
    public String byteToBinaryString(byte b) {
        if (b > 0) {
            return Integer.toBinaryString(b);
        }
        if (b == 0) {
            return "0";
        }
        return Integer.toBinaryString(b).substring(24);
    }
}
