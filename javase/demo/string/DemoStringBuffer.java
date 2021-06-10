package javase.demo.string;

/** Description: StringBuffer使用示例
 *
 * @author created by Meiyu Chen at 2021-6-9 17:43, v1.0
 */
public class DemoStringBuffer {
    public static void main(String[] args) {
        DemoStringBuffer test = new DemoStringBuffer();
        // 1. 创建StringBuffer对象
        test.instanceStringBuffer();

        // 2. 演示StringBuffer中常用method
        test.demonstrateStringBufferMethods();

        // 3. 演示StringBuffer#append()
        test.demonstrateAppend();

        // 4. 演示StringBuffer#insert()
        test.demonstrateInsert();
    }

    /** Description: 4. 演示StringBuffer#insert()
     * @author created by Meiyu Chen at 2021-6-10 11:18, v1.0
     */
    private void demonstrateInsert() {
        StringBuffer str = new StringBuffer("init str");
        int offset = 2;
        int toInsert = 127;
        str.insert(offset,toInsert);
        System.out.println(str); // in127it str

        str.insert(0,false);
        System.out.println(str); // falsein127it str

        System.out.println(str.insert(0,'A')); // Afalsein127it str

        // 其他insert()...

    }

    /** Description: 3. 演示StringBuffer#append()
     * @author created by Meiyu Chen at 2021-6-10 11:13, v1.0
     */
    private void demonstrateAppend() {
        // 创建一个char[],初始容量=str.lenth + 16, 初始值=str
        StringBuffer sb1 = new StringBuffer("初始字符串");

        /*StringBuffer#append()
         *   append() 有多个重载函数
         *   在原有字符串末尾添加
         *   可以添加多种形式的数据：
         *       可以是int/long/float/double/char/boolean型的原始数据
         *       也可以是char[],String,...
         *   append() 函数内部实现了自动扩容机制，如果执行“末尾添加”指令时发现char[]容量不够用了，
         *   就会触发“自动扩容机制”，将char[]的容量扩大以便于存储更多的字符
         * 附录一，StringBuffer#append()的“自动扩容机制”
         *      1. StringBuffer的底层原理是，将字符串中的字符存储在一个char[]中
         *      2. new StringBuffer()的时候，char[]有一个初始容量
         *      3. append的时候，会在char[]中存放待添加的子串
         *      4. append子串的时候，如果待添加的子串长度超出char[]容量，会触发“自动扩容机制”
         *          char[]的新长度 = 原始长度 * 2 + 2，              当（已有字符串 + 子串）.length  < 原始长度 * 2 + 2时
         *                    or  = （已有字符串 + 子串）.length     当 （已有字符串 + 子串）.length > 原始长度 * 2 + 2时
         *                    or  = 抛出OutOfMemoryError            当（已有字符串 + 子串）.length > Integer.MAX_VALUE-8时
         *      5. 将原来的char[]复制到新的数组中
         *      6. 将子串添加到扩容后的char[]的末尾
         *
         * */
        System.out.println(sb1); // 初始字符串
        StringBuffer append = sb1.append(",尾部增加一个子串");
        System.out.println(sb1); // 初始字符串,尾部增加一个子串
        System.out.println(append); // 初始字符串,尾部增加一个子串
        int aInt = 2;
        boolean aBoolean = true;
        char aChar = 'A';
        float aFloat = 1.3f;
        double aDouble = 2.30d;
        long aLong = 1L;
        // 初始字符串,尾部增加一个子串2trueA1.32.31
        System.out.println(sb1.append(aInt).append(aBoolean).append(aChar).append(aFloat).append(aDouble).append(aLong));

        // 其他append() ...
    }

    /** Description: 2. 演示StringBuffer中常用method
     * @author created by Meiyu Chen at 2021-6-10 10:32, v1.0
     */
    private void demonstrateStringBufferMethods() {
        // 创建一个char[],初始容量=str.lenth + 16, 初始值=str
        StringBuffer sb1 = new StringBuffer("初始字符串");

        // 演示StringBuffer的常用method
        // char[]中已经存放的字符个数
        System.out.println(sb1.length()); // 5
        // char[]的容量
        System.out.println(sb1.capacity()); // 21

        System.out.println(sb1.charAt(1)); // 始
        sb1.setCharAt(1,'花');
        System.out.println(sb1); // 初花字符串
        sb1.deleteCharAt(1);
        System.out.println(sb1); // 初字符串
        int start = 1,end=3;
        StringBuffer delete = new StringBuffer("123456789").delete(start, end);
        System.out.println(delete); // 1456789

        StringBuffer sb2 = new StringBuffer("abcde");
        StringBuffer reverse = sb2.reverse();
        System.out.println(sb2); // edcba
        System.out.println(reverse); // edcba

    }

    /** Description: 1. 创建StringBuffer对象
     * 四种构造方法
     * @author created by Meiyu Chen at 2021-6-10 9:50, v1.0
     */
    private void instanceStringBuffer() {
        /*方法一，public StringBuffer()
        *   创建一个初始容量为16的空的char[]
        *   */
        StringBuffer sb = new StringBuffer();

        /*方法二，public StringBuffer(int capacity)
        *   创建一个空的char[]
        *   指定初始容量
        *   */
        StringBuffer sb2 = new StringBuffer(128);

        /*方法三，public StringBuffer(String str)
        *   创建一个char[]
        *   将传入的字符串赋值给char[]
        *   char[]的初始容量 = str.length + 16
        * */
        StringBuffer sb3 = new StringBuffer("一个字符串");

        /*方法四，public StringBuffer(CharSequence seq) */
    }
}
