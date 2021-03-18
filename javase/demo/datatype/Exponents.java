package javase.demo.datatype;

/** Description: 数值的表示形式（前缀、后缀、指数表示法/科学计数法）
 * @author created by Meiyu Chen at 2021-3-18 14:00, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class Exponents {
    public static void main(String[] args) {
        Exponents demo = new Exponents();
        // 数值前缀：0x/0X/0
        demo.prefixToValue();
        // 数值后缀：L/D/d/f/F
        demo.sufixToValue();
        // 指数计数法/科学计数法：E/e
        demo.exponents();
    }

    /** Description: 指数计数法/科学计数法
     *      注意：这里的e/E（代表10）和数学中的e（2.718）并不等价
     *      1e2 = 100
     *      注意，科学计数法表示的只能是float或double型的数值，如果想用科学计数法表示整形数值，请执行强制类型转化
     * @author created by Meiyu Chen at 2021-3-18 14:10, v1.0
     */
    private void exponents() {
        // 等价于：13.9 * 10^-13
        float expFloat = 13.9e-13f;
        // 等价于：33 * 10^26
        double expDouble = 33E26;
        double exp100 = 1e2;
        // output: 1.39E-12,	3.3E27,	    100.0
        System.out.println(expFloat + ",\t" + expDouble + ",\t" + exp100);
    }

    /** Description: 后缀表示数值类型（L-long; D/d-double; F/f-float）
     * @author created by Meiyu Chen at 2021-3-18 14:07, v1.0
     */
    private void sufixToValue() {
        long l = 10L;
        long l2 = 10;
        long l3 = 0x2fL;
        long l4 = 017L;
        float f = 1f;
        float f2 = 1F;
        float f3 = 1;
        double d = 1;
        double d1 = 1.3d;
        double d2 = 1D;
    }

    /** Description: 前缀表示数值的进制（八进制、十进制、十六进制）
     * @author created by Meiyu Chen at 2021-3-18 14:04, v1.0
     */
    private void prefixToValue() {
        // 十进制
        int i = 63;
        // 十六进制
        int i1 = 0x2f;
        int i2 = 0X2f;
        // 八进制
        int i3 = 0127;
        // max char hex value
        char c = 0xffff;
//!        char c2 = 0xffff0; // value超出char可以表示的数值范围，编译器会报错，提示你要么强制类型转换，要么改变变量数据类型
        // max byte hex value
        byte b = 0x7f;
        // max short hex value
        short s = 0x7fff;
    }
}
