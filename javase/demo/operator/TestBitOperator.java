package javase.demo.operator;

/**
 * Description: 位操作符使用示例（& | ^ ~ << >> >>>）
 *
 * @author created by Meiyu Chen at 2021-3-18 14:54, v1.0
 */
public class TestBitOperator {
    public static void main(String[] args) {
        TestBitOperator demo = new TestBitOperator();
        // 展示位运算符的基本用法： & | ^ ~
        demo.demonstrateBasicUsage();
        // 展示移位操作符的基本用法
        demo.shiftOperator();
    }

    /**
     * Description: 展示移位运算符的基本用法
     * <ul>
     *     <li>移位运算符也是二进制的“位”</li>
     *     <li>移位运算符只可用来处理整数，不可以操作其他数据类型的数值
     *     （如果对char/byte/short类型的数值进行移位处理，那么移位之前他们会被转化为int类型，并且得到的结果也是个int）
     *      (如果对一个long型的数值进行移位操作，得到的结果也是一个long型数值)
     *     </li>
     *     <li>左移操作符“<<”在低位补0</li>
     *     <li>右移操作符分为两种：有符号右移“>>” 和 无符号右移“>>>”</li>
     *         <ul>
     *             <li>无符号右移“>>>”: 高位补0</li>
     *             <li>有符号右移“>>”: 正数高位补0，负数高位补1(复制符号位)</li>
     *         </ul>
     *     <li>可与赋值运算符结合使用： >>= <<= >>>= </li>
     *     <li>使用“>>>=”操作byte/short/char型数值时要注意：可能得到错误的结果
     *         <p>解说：
     *                 按理说无符号右移“>>>=”高位补0，得到的结果应该是正数。
     *                 但是，由于移位运算符会先将char/byte/short型的数值转化为int型，移位操作得到的结果也是个int。
     *                 >>>=, 移位之后又赋值给char/byte/short, 赋值过程中会发生截断</p>
     *     </li>
     * </ul>
     *
     * @author created by Meiyu Chen at 2021-3-18 15:07, v1.0
     */
    private void shiftOperator() {
        System.out.println("-1=" + Integer.toBinaryString(-1));
        System.out.println("10=" + Integer.toBinaryString(10));
        System.out.println("正数的最高位是0，负数的最高位是1");
        int i = 0xffffffff;
        i >>>= 10;
        System.out.println("int -1=" + Integer.toBinaryString(-1) + "(len=" + Integer.toBinaryString(-1).length() + ")");
        System.out.println("int i = -1, i>>>=10, rst: i= " + Integer.toBinaryString(i) + "(len=" + Integer.toBinaryString(i).length() + ")");
        // byte -1 = 1111 1111
        byte b = (byte) 0xff;
        // 期望的结果是0，实际得到的结果却是-1
        b >>>= 10;
        System.out.println("byte b=0xff, b>>>=10, rst: b=" + Integer.toBinaryString(b) + "(len=" + Integer.toBinaryString(b).length() + ")");
        byte b2 = -1;
        System.out.println("byte b=0xff, b>>>10 = " + Integer.toBinaryString(b2 >>> 10)+ "(len=" + Integer.toBinaryString(b2 >>> 10).length() + ")");
        System.out.println("byte b=0xff, b>>>10 = " + Integer.toBinaryString(((byte) 0xff) >>> 10)+ "(len=" + Integer.toBinaryString(((byte) 0xff) >>> 10).length() + ")");
    }

    /**
     * Description: 展示位运算符的基本用法
     *
     * @author created by Meiyu Chen at 2021-3-18 14:58, v1.0
     */
    private void demonstrateBasicUsage() {
        int a = 0xAAAA;
        int b = 0X5555;
        System.out.println("a=" + Integer.toBinaryString(a) + ",\tb=" + Integer.toBinaryString(b));
        System.out.println("按位与：a&b=" + Integer.toBinaryString(a & b));
        System.out.println("按位或：a|b=" + Integer.toBinaryString(a | b));
        System.out.println("按位异或：a^b=" + Integer.toBinaryString(a ^ b));
        System.out.println("按位取反：~a=" + Integer.toBinaryString(~a));
    }
}
