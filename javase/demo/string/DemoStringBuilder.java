package javase.demo.string;

/** Description: StringBuilder使用示例
 * @author created by Meiyu Chen at 2021-6-10 14:28, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemoStringBuilder {
    public static void main(String[] args) {
        DemoStringBuilder test = new DemoStringBuilder();
//        // 1. 创建StringBuilder对象
//        test.instanceStringBuilder();
//
//        // 2. 演示StringBuilder中常用method
//        test.demonstrateStringBuilderMethods();

//        // 3. 演示StringBuilder#append()
//        test.demonstrateAppend();

        // 4. 演示StringBuilder#insert()
        test.demonstrateInsert();
    }

    /** Description: 4. 演示StringBuilder#insert()
     * @author created by Meiyu Chen at 2021-6-10 11:18, v1.0
     */
    private void demonstrateInsert() {
        StringBuilder str = new StringBuilder("init str");
        int offset = 2;
        int toInsert = 127;
        str.insert(offset,toInsert);
        System.out.println(str); // in127it str

        str.insert(0,false);
        System.out.println(str); // falsein127it str

        System.out.println(str.insert(0,'A')); // Afalsein127it str

        // 其他insert()...

    }

    /** Description: 3. 演示StringBuilder#append()
     * @author created by Meiyu Chen at 2021-6-10 11:13, v1.0
     */
    private void demonstrateAppend() {
        // 创建一个char[],初始容量=str.lenth + 16, 初始值=str
        StringBuilder sb1 = new StringBuilder("初始字符串");

        /*StringBuilder#append()
         *   append() 有多个重载函数
         *   在原有字符串末尾添加
         *   可以添加多种形式的数据：
         *       可以是int/long/float/double/char/boolean型的原始数据
         *       也可以是char[],String,...
         *   append() 函数内部实现了自动扩容机制，如果执行“末尾添加”指令时发现char[]容量不够用了，
         *   就会触发“自动扩容机制”，将char[]的容量扩大以便于存储更多的字符
         * 附录一，StringBuilder#append()的“自动扩容机制”
         *      1. StringBuilder的底层原理是，将字符串中的字符存储在一个char[]中
         *      2. new StringBuilder()的时候，char[]有一个初始容量
         *      3. append的时候，会在char[]中存放待添加的子串
         *      4. append子串的时候，如果待添加的子串长度超出char[]容量，会触发“自动扩容机制”
         *          char[]的新长度 = 原始长度 * 2 + 2，              当（已有字符串 + 子串）.length  < 原始长度 * 2 + 2时
         *                    or  = （已有字符串 + 子串）.length     当 （已有字符串 + 子串）.length > 原始长度 * 2 + 2时
         *                    or  = 抛出OutOfMemoryError            当（已有字符串 + 子串）.length > Integer.MAX_VALUE-8时
         *      5. 将原来的char[]复制到新的数组中
         *      6. 将子串添加到扩容后的char[]的末尾
         * */
        System.out.println(sb1); // 初始字符串
        StringBuilder append = sb1.append(",尾部增加一个子串");
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

    /** Description: 2. 演示StringBuilder中常用method
     * @author created by Meiyu Chen at 2021-6-10 10:32, v1.0
     */
    private void demonstrateStringBuilderMethods() {
        // 创建一个char[],初始容量=str.lenth + 16, 初始值=str
        StringBuilder sb1 = new StringBuilder("初始字符串");

        // 演示StringBuilder的常用method
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
        StringBuilder delete = new StringBuilder("123456789").delete(start, end);
        System.out.println(delete); // 1456789

        StringBuilder sb2 = new StringBuilder("abcde");
        StringBuilder reverse = sb2.reverse();
        System.out.println(sb2); // edcba
        System.out.println(reverse); // edcba

    }

    /** Description: 1. 创建StringBuilder对象
     * 四种构造方法
     * @author created by Meiyu Chen at 2021-6-10 9:50, v1.0
     */
    private void instanceStringBuilder() {
        /*方法一，public StringBuilder()
         *   创建一个初始容量为16的空的char[]
         *   */
        StringBuilder sb = new StringBuilder();

        /*方法二，public StringBuilder(int capacity)
         *   创建一个空的char[]
         *   指定初始容量
         *   */
        StringBuilder sb2 = new StringBuilder(128);

        /*方法三，public StringBuilder(String str)
         *   创建一个char[]
         *   将传入的字符串赋值给char[]
         *   char[]的初始容量 = str.length + 16
         * */
        StringBuilder sb3 = new StringBuilder("一个字符串");

        /*方法四，public StringBuilder(CharSequence seq) */
    }
}
