package javase.demo.operator;
/** Description: 按位运算示例
 * @author created by Meiyu Chen at 2021-3-18 14:54, v1.0
 */
public class TestBitOperator {
    public static void main(String[] args) {
        TestBitOperator demo = new TestBitOperator();
        demonstrateBasicUsage();
    }

    /** Description: 展示位运算符的基本用法
     * @author created by Meiyu Chen at 2021-3-18 14:58, v1.0
     */
    private static void demonstrateBasicUsage() {
        int a = 0xAAAA;
        int b = 0X5555;
        System.out.println("a="+Integer.toBinaryString(a)+",\tb="+Integer.toBinaryString(b));
        System.out.println("按位与：a&b="+Integer.toBinaryString(a&b));
        System.out.println("按位或：a|b="+Integer.toBinaryString(a|b));
        System.out.println("按位异或：a^b="+Integer.toBinaryString(a^b));
        System.out.println("按位取反：~a="+Integer.toBinaryString(~a));
    }
}
