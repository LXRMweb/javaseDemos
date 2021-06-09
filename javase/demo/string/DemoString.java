package javase.demo.datatype.objects;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/** Description: java字符串
 * @author created by Meiyu Chen at 2021-6-9 9:32, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemoString {
    public static void main(String[] args) {
        DemoString test = new DemoString();
        test.demonstrateClassString();
    }

    /** Description: 演示java.lang.String的用法
     *
     * 概述：
     *      1. 程序中所有的双引号字符串（如“123abc”）,都是String类的实例对象，即使程序员没有显式调用new
     *          * 即使没有new，他们也是String对象
     *      2. String字符串的特点：
     *          * 字符串的内容永不可变
     *          * 正是因为字符串不可改变，多以字符串是可以共享使用的
     *          * 字符串效果相当于char[]字符数组，底层原理是byte[]字节数组，计算机中的一切归根到底都是字节流
     *      3. 创建字符串的若干种方式
     *          * String#constructors, String类有好多个构造函数，所以创建String对象也有好多种方式
     *          * 通常我们掌握常用的3+1种方式就可以
     * @author created by Meiyu Chen at 2021-6-9 9:33, v1.0
     */
    private void demonstrateClassString() {
//        // 演示如何创建String对象
//        createStringObject();
//
//        // == vs equals(): 字符串常量池
//        demonstrateEquals();
//
//        // 字符串转换成数组
//        transfer();

//        // 子串替换
//        demonstrateReplace();

//        // unicode码表中相应字符的下标
//        demonstrateUnicode();

        // 字符串切割
        demonstrateSplit();
    }

    /** Description: 字符串切割
     * 注意：split()函数参数是一个正则表达式，不是普通字符串
     * @author created by Meiyu Chen at 2021-6-9 16:46, v1.0
     */
    private void demonstrateSplit() {
        String[] split = "127.0.0.0".split(".");
        /*输出：0
        * 分析：显然不对。
        *       这是因为String#split()函数参数实际是一个正则表达式
        *       “.”是正则表达式的一个元字符，匹配除了换行符之外的任意字符
        *       所以这么切分的结果显然不对，不是期望的结果
        * */
        System.out.println(split.length);
        // 如果想要按照“.”切割，你得使用转移字符
        String[] split1 = "127.0.0.0".split("\\.");
        System.out.println(split1.length); // 4
        for (String s : split1) {
            System.out.println(s);
        }
    }

    /** Description: 获取相应字符在Unicode码表中的位置
     *      如：a-97
     *          b-98
     *          A-65
     * @author created by Meiyu Chen at 2021-6-9 14:56, v1.0
     */
    private void demonstrateUnicode() {
        // "abc".charAt(1)-也即'b'-对应的Unicode码表索引值
        System.out.println("abc".codePointAt(1)); // 98
        // "ABC".charAt(0)-也即'A'-对应的Unicode码表索引值
        System.out.println("ABC".codePointAt(0)); // 65
        // "Z".charAt(0)-也即'Z'-对应的Unicode码表索引值
        System.out.println("Z".codePointAt(0)); // 90
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            System.out.println(c+"="+(c+"").codePointAt(0));

        }

        // "abc".charAt(2-1) = charAt(1)-也即'b'-对应的Unicode码表索引值
        System.out.println("abc".codePointBefore(2)); // 98
        System.out.println("ah哈哈哈".codePointBefore(3)); // 21704
    }

    /** Description: 子串替换
     * 话题1， replace vs replaceAll vs replaceFirst
     *      * replace 和 replaceAll都是全局替换，只有replaceFirst是局部替换
     *      * replace没有使用正则表达式，replaceAll 和 replaceFirst使用了正则表达式
     *      * 如果不想在replaceAll和replaceFirst中使用正则表达式，只需要将正则语法中的元字符转义掉就可以
     * @author created by Meiyu Chen at 2021-6-9 14:41, v1.0
     */
    private void demonstrateReplace() {
        System.out.println("------- 字符串替换 -----");
        /*1. String#public String replace(char oldChar, char newChar)
        *       只能替换一个字符
        *       可以使用转义字符
        *       可以使用汉字
        *       是全局替换
         *       普通替换（两个参数都是普通字符）
        * */
        String rst = "hello".replace('l', 's'); // hesso
        System.out.println(rst);
        System.out.println("1.1.1.1".replace('.','/')); // 1/1/1/1
        System.out.println("1*2*3*4".replace('*','-')); // 1-2-3-4
        System.out.println("1*2*3*4".replace('*','\t'));// 1	2	3	4
        System.out.println("1\t2\t3\t4".replace('\t','\n')); //
        System.out.println("124dfgsdghh哈哈哈哈哈".replace('哈','胡')); // 124dfgsdghh胡胡胡胡胡
        // '\u80f6'-胶（Unicode码-utf8）
        System.out.println("uihjlhjlkhkl黄岛胶皮卡片胶皮".replace('\u80f6','猪')); // uihjlhjlkhkl黄岛猪皮卡片猪皮

        /* 2. public String replace(CharSequence target, CharSequence replacement) {
        *       String实现了CharSequence,所以可以使用String作为参数传入
        *       可以使用转义字符
        *       可以使用汉字
        *       是全局替换
        *       普通替换（两个参数都是普通字符串）
        * */
        System.out.println("1.1.2.3".replace(".","[.]")); // 1[.]1[.]2[.]3
        System.out.println("hello*world".replace("*","\t")); // hello	world
        System.out.println("hjoj哈哈哈猪皮猪皮猪皮".replace("猪皮","牛腿")); // hjoj哈哈哈牛腿牛腿牛腿
        // Unicode编码：猪-\u732a 皮-\u76ae
        System.out.println("hjoj哈哈哈猪皮猪皮猪皮".replace("\u732a\u76ae","猪毛哦")); // hjoj哈哈哈猪毛哦猪毛哦猪毛哦


        /*3. public String replaceFirst(String regex, String replacement)
        *       局部替换（只替换第一个匹配的子串）
        *       正则替换（第一个参数是一个正则表达式）
        *       所用的第一个参数若不是基于规则表达式的，则可以将其看做一个普通的字符串；
        *       如果不想在replaceAll和replaceFirst中使用正则表达式，只需要将正则语法中的元字符转义掉就可以
         * */
        String s = "aaa-hhh-jjj".replaceFirst("-", ";");
        System.out.println(s); // aaa;hhh-jjj
        String s2 = "abd1hag2";
        System.out.println(s2.replaceFirst("\\d","数字")); // abd数字hag2

        /*4. public String replaceAll(String regex, String replacement)
         *       是全局替换
         *       正则替换（第一个参数是一个正则表达式）
         *       第一个参数可以是正则表达式，也可以是一个普通字符串
         *       第一个参数若不是基于规则表达式的，则与replace()替换字符串的效果是一样的；
         *       如果不想在replaceAll和replaceFirst中使用正则表达式，只需要将正则语法中的元字符转义掉就可以
         * */
        // 4.1
        System.out.println("aaa-hhh-jjj".replaceAll("-",";")); // aaa;hhh;jjj
        // 4.2 replace() vs repalceAll()
        // 这个好像和预想的效果不一致，因为replaceAll()的第一个参数是“正则表达式”，JVM默认会将其按照正则表达式解析
        // 第一个表达式是正则表达式：“.”是正则表达式的元字符，匹配除换行符以外的任意字符
        System.out.println("1.1.1.1".replaceAll(".","[.]")); // [.][.][.][.][.][.][.]
        // “那我不想用正则表达式去替换肿么办？”其实也很简单，只要将元字符串转义就行了
        System.out.println("1.1.1.1".replaceAll("\\.","[.]")); // 1[.]1[.]1[.]1
        // replace() 中的两个参数都是普通字符串，并不会被JVM看做正则表达式
        System.out.println("1.1.1.1".replace(".","[.]")); // 1[.]1[.]1[.]1
        // 4.3 第一个参数是正则
        String s4 = "abd1hag2hahh23334hhhjkhj";
        System.out.println(s2.replaceAll("\\d","数字")); // abd数字hag数字
        // 去除掉所有数字
        System.out.println(s2.replaceAll("\\d","")); // abdhag
        // 只保留字母
        System.out.println("ahjjhAHKJJK124KJK***&&&".replaceAll("[^A-Za-z]","")); // ahjjhAHKJJKKJK
        String dir = "D:\\workspace\\IntellijIDEA\\JavaSEDemo\\src\\lxrm\\cn\\test";
        System.out.println(dir); // D:\workspace\IntellijIDEA\JavaSEDemo\src\lxrm\cn\test
        System.out.println(dir.replace("\\","/")); // D:/workspace/IntellijIDEA/JavaSEDemo/src/lxrm/cn/test
        System.out.println(dir.replaceAll("\\\\","\\\\\\\\")); // D:\\workspace\\IntellijIDEA\\JavaSEDemo\\src\\lxrm\\cn\\test
        System.out.println(dir.replaceAll("\\\\","//")); // D://workspace//IntellijIDEA//JavaSEDemo//src//lxrm//cn//test




    }

    /** Description: 字符串转换成其他形式
     * @author created by Meiyu Chen at 2021-6-9 14:23, v1.0
     */
    private void transfer() {
        System.out.println("\n-------- string转成char[] ---------");
        // 1.
        String str = "hello";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+","); // h,e,l,l,o,
        }
        // 2. 拷贝子串到目的数组，存放在目的数组的指定位置
        int srcBegin = 1,srcEnd=3;
        char[] chArrDst = {'1','2','3','4','5','6'};
        System.out.println("");
        System.out.println(Arrays.toString(chArrDst)); // [1, 2, 3, 4, 5, 6]
        int dstBegin = 3;
        str.getChars(srcBegin,srcEnd,chArrDst,dstBegin); // hello
        System.out.println(str);
        System.out.println(Arrays.toString(chArrDst)); // [1, 2, 3, e, l, 6]


        System.out.println("\n------- string 转成byte[] ---------");
        // 1.
        String str2 = "abc";
        byte[] bytes = str2.getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte+","); // 97,98,99,
        }
        System.out.println("");
        // 2. 指定字符集
        try {
            byte[] gbks = str2.getBytes("gbk");
            System.out.println(Arrays.toString(gbks)); // [97, 98, 99]
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /** Description: == vs equals(): 字符串常量池
     * 参考资料：
     *      1. [字符串常量池](https://www.bilibili.com/video/BV1jD4y1d71C?p=3&spm_id_from=pageDriver)
     * 概述：
     *      1. 字符串都是对象，不管你使用new还是不使用new
     *      2. 除了八种基本数据类型的数值&&引用是直接存储在栈中，其余的数据值都是存储在堆中
     *          + String对象引用存储在栈中，但是其值存储在堆中
     *          + 数组(如：int[] a)的引用存储在栈中，但是数组存储在堆中
     *          + JVM会为每个对象分配一定的堆内存空间，堆中存储对象的属性的值
     *              * String对象实际是使用char[]属性来存储的字符串的值
     *      3. ==
     *          + 对于基本数据类型是比较数值
     *          + 对于对象是比较引用：如String字符串和数组，都是比较引用
     *      4. 字符串常量池
     *          + 对于String而言，JVM引入了一个特殊的东西
     *          + 这个特殊的东西叫做“字符串常量池”，是专门配套{@code String  str = "abc"}这种不使用new直接创建String对象的语法出现的
     *          + 只有不使用new创建的字符串对象才会被放在“字符串常量池”中，使用new创建的不会放入池中
     *              * String str = "hello"; // 这种方式创建的string对象的引用会被放入“字符串常量池”
     *              * String str2 = new String(); // 使用new创建的String对象的引用不会被放入“字符串常量池”
     *          + “字符串常量池”是存放在堆中的
     *          + “字符串常量池”中存放的是引用，而非数值
     *          + {@code String str = "hello";}的寻址方式：
     *              * 栈引用 -> 堆：字符串常量池中的“引用” -> 堆中的字符串对象存储空间
     *          + {@code String str2 = new String();} 的寻址方式：
     *              * 栈引用 -> 堆中的字符串对象存储空间
     * @author created by Meiyu Chen at 2021-6-9 10:37, v1.0
     */
    private void demonstrateEquals() {
        // 直接创建（不使用new）的字符串会被放入“字符串常量池”
        // 栈引用 -> 堆：字符串常量池中的“引用” -> 堆中的字符串对象存储空间
        String str1 = "abc";
        String str2 = "abc";
        String str4 = "cde";

        // 使用new创建的String对象不会放入“字符串常量池”
        char[] chArr = {'a','b','c'};
        String str3 = new String(chArr);
        System.out.println(str3); // abc

        // 1. 比较“引用”是否相等
        // ==比较的是“引用”是否相等，而不是比较字符串的值
        System.out.println(str1 == str2); // true，解析：由于字符串常量池的存在，二者最终都指向堆内存空间的同一个地址
        System.out.println(str3 == str2); // false，解析：二者最终指向的堆内存空间地址不同，new会使JVM分配新的堆内存空间给新的对象
        System.out.println(str2 == str4); // false，解析：虽然都经过字符串常量池，但是由于最终的数值不同，所以最终指向两个不同的堆内存对象空间

        // 2. 比较字符串内容
        // 2.1 String#equals() 严格区分大小写
        System.out.println("----  使用equals()比较内容 ------");
        System.out.println(str1.equals(str2)); // true
        System.out.println(str2.equals(str3)); // true
        System.out.println(str2.equals("abc")); // true
        System.out.println("abc".equals(str2)); // true
        System.out.println("ABC".equals(str2)); // false.大小写不一样
        /*2.2 tips: 编程小技巧
        *   如果是一个常量和一个变量进行比较，推荐将常量写在前面，即{@code "abc".equals(str)}
        * */
        System.out.println("abc".equals(str1)); // 推荐（将常量写在前面）
        System.out.println(str1.equals("abc")); // 不推荐（将常量写在后面）
        // 为什么不推荐将常量写在后面的写法？
        String str11 = null;
        System.out.println("abc".equals(str11)); // 返回：false
//        System.out.println(str11.equals("abc")); // 爆出“NullPointerException”
        // 2.3 不区分大小写
        String str12 = "java";
        System.out.println("JAVA".equalsIgnoreCase(str12)); // true
        System.out.println("JAVA".equals(str12)); // false

        // 3. 字符串拼接
        System.out.println("----- 字符串拼接 ------");
        String str21 = "hello";
        String str22 = "World";
        String str23 = str21+str22; // 会在堆中分配新的内存空间
        String str24 = str21+str22; // 会在堆中分配新的内存空间
        System.out.println(str23==str24); // false
        System.out.println(str23.equals(str24)); // true
        String str25 = "hello"+"World"; // “helloWorld”的地址会存入“字符串常量池”
        String str26 = "hello"+"World"; // 直接使用“字符串常量池”中“helloWorld”的地址
        System.out.println(str25==str26); // true
        System.out.println(str25 == str23); // false
        System.out.println(str25.equals(str23)); // true

        // 4. 展示字符串常量池
        System.out.println("----------字符串常量池 ------------");
        String a = "haha";
        String b = "haha";
        System.out.println(a==b); // true
        a = "ttt";
        System.out.println(a==b); // false
        a = "haha"; // 堆中不会分配新的内存空间给String对象来存放“haha”,因为常量池中已经有了“haha”的地址，所以将已经存在的“haha”的地址直接赋值给a
        System.out.println(a==b); // true

    }

    /** Description: 创建String对象的若干种方法
     *                  * String#constructors, String类有好多个构造函数，所以创建String对象也有好多种方式
     *                  * 通常我们掌握常用的3+1种方式就可以
     * @author created by Meiyu Chen at 2021-6-9 9:50, v1.0
     */
    private void createStringObject() {
        // 方法一，创建一个空串
        String str = new String();
        System.out.println(str);

        // 方法二，根据char[]创建
        // 2.1
        char[] chArr = {'1','A','f','1','g','9'};
        String str2 = new String(chArr);
        System.out.println(str2); // 1Af1g9
        // 2.1 位移
        int offset = 1,count = 3;
        String str11 = new String(chArr, offset, count);
        System.out.println(str11); // Af1

        // 方法三，根据byte[]创建
        // JVM会自动将字节流解码成字符
        // using the platform's default charset
        // 所以解码得到的字符串长度有可能小于byte[]的长度，具体对应关系要看字符集
        // 3.1
        byte[] byteArr = {97,98,99};
        String str3 = new String(byteArr);
        System.out.println(str3); // abc
        // 3.2, 位移
        int offset2 = 1,count2=1;
        String str31 = new String(byteArr,offset2,count2);
        System.out.println(str31); // b
        try {
            // 3.3, 指定解码字符集
            String str32 = new String(byteArr, "utf-8");
            String str33 = new String(byteArr, "gbk");
            System.out.println(str32+","+str33); // abc,abc
            // 3.4 指定字符集 + 位移
            String str35 = new String(byteArr, offset2, count2, "gbk");
            System.out.println(str35); // b
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // 方法四，不使用new，直接赋值
        // 即便不使用new，JVM也会自动将相应的值封装成一个String对象（且String底层实际上是将相应的字符串转换成了byte[]二进制流供计算机处理）
        String str4 = "";
        String str5 = "hello";
        System.out.println(str4);
        System.out.println(str5); // hello

        // ... String类的其他构造方法，使用到时再研究
    }
}
