package javase.demo.datatype;

import javase.demo.io.IOUtils;

/** Description: 本class讲述java基本数据类型相关知识点
 * @author created by Meiyu Chen at 2021-3-16 10:35, v1.0
 *      <br>modified by Meiyu Chen at 2021-3-16 10:35, v1.0, 修改内容概述如下:
 *      <br>    添加 打印<b>类属性</b>和<b>局部变量</b>默认值 的方法
 */
public class BasicDataType {
    private boolean boolean1;
    private byte byte1;
    private char char1;
    private short short1;
    private int int1;
    private long long1;
    private float float1;
    private double double1;


    public static void main(String[] args) {
        BasicDataType demo = new BasicDataType();
        // 基本数据类型变量的默认值（作为class field 时有默认值，作为局部变量时无默认值）
        demo.printDefaultValue();
        // 显式/隐式数据类型转换
        demo.dataTypeCast();
        // 超出取值范围
        demo.outOfRange();
    }

    /** Description: 基本数据类型都有有限的取值范围，使用基本数据类型进行运算时，要也别小心运算结果超出取值范围的情况
     *        计算结果超出取值范围时，编译器并不会报错，所以开发者编程时更需谨慎小心，防止程序运行出现意想不到的结果
     * @author created by Meiyu Chen at 2021-3-19 13:35, v1.0
     */
    private void outOfRange() {
        System.out.println("演示计算结果超出取值范围的情况：");
        int i = Integer.MAX_VALUE;
        System.out.println("i="+i);
        int sum = i+1;
        int mul = i*2;
        System.out.println("i+1="+sum);
        System.out.println("i*2="+mul);
        System.out.println("结果分析：期望得到的值分别是2147483648和4294967294，结果却得到了-2147483648和-2，这是因为表达式计算得到的结果已经超出了int的取值范围");
    }

    /** Description: 数据类型转换（显式/隐式）
     * @author created by Meiyu Chen at 2021-3-18 17:52, v1.0
     */
    private void dataTypeCast() {
        // float && double类型的数值转成int型时，不会四舍五入，而是直接丢弃小数部分
        System.out.println("(int) 1.3f = " + ((int) 1.3f));
        System.out.println("(int) 1.6f = " + ((int) 1.6f));
        System.out.println("(int) 3.3d = " + ((int) 3.3d));
        System.out.println("(int) 3.88d = " + ((int) 3.88d));
        // 如果想要四舍五入，请使用Math.round()
        System.out.println("Math.round(1.3f) = " + Math.round(1.3f));
        System.out.println("Math.round(1.6f) = " + Math.round(1.6f));
        System.out.println("Math.round(1.33d) = " + Math.round(1.32d));
        System.out.println("Math.round(1.68d) = " + Math.round(1.68d));
    }

    /** Description: 基本数据类型的<b>“默认值”</b>
     *  <ul>
     *      <li>
     * 		    各个基本数据类型对应的默认值分别是什么
     * 	    </li>
     * 	    <li>
     * 		    编译器只会给<b>类成员属性</b>自动初始化为默认值，而不会给局部变量初始化为默认值
     * 	    </li>
     * 	    <li>
     * 		    所以当你想要使用未经初始化的<b>局部变量</b>时，编译器就会报错“...可能尚未初始化变量XXX”
     * 	    </li>
     *  </ul>
     * @author created by Meiyu Chen at 2021-3-16 9:19, v1.0
     */
    public void printDefaultValue() {
        myPrint("===========start java基本数据类型的默认值：===============");
        myPrint("-----------start java 编译器会自动为class field赋值为默认值：----------");
        myPrint("class field,boolean: defaultValue = " + boolean1);
        myPrint("class field,(int)char: defaultValue = " + (int)char1);
        myPrint("class field,byte: defaultValue = " + byte1);
        myPrint("class field,short: defaultValue = " + short1);
        myPrint("class field,int: defaultValue = " + int1);
        myPrint("class field,long: defaultValue = " + long1);
        myPrint("class field,float: defaultValue = " + float1);
        myPrint("class field,double: defaultValue = " + double1);
        myPrint("上面的变量都是类属性，只有类属性会被编译器自动赋值为默认值，java编译器不会为局部变量赋初始值");
        myPrint("-----------start java 编译器不会自动为局部变量赋值为默认值：并且java编译器会报错“...可能尚未初始化变量XXX”----------");
//        int intLocalVar;
//        boolean booleanLocalVar;
//        byte byteLocalVar;
//        char charLocalVar;
//        short shortLocalVar;
//        long longLocalVar;
//        float floatLocalVar;
//        double doubleLocalVar;
//        myPrint("局部变量,boolean: defaultValue = " + booleanLocalVar);
//        myPrint("局部变量,(int)char: defaultValue = " + (int)charLocalVar);
//        myPrint("局部变量,byte: defaultValue = " + byteLocalVar);
//        myPrint("局部变量,short: defaultValue = " + shortLocalVar);
//        myPrint("局部变量,int: defaultValue = " + intLocalVar);
//        myPrint("局部变量,long: defaultValue = " + longLocalVar);
//        myPrint("局部变量,float: defaultValue = " + floatLocalVar);
//        myPrint("局部变量,double: defaultValue = " + doubleLocalVar);
        myPrint("===========end java基本数据类型的默认值：===============");
    }

    private void myPrint(String s) {
        IOUtils.myPrint(s);
    }

}/* Output: (100% match)
===========start java基本数据类型的默认值：===============
-----------start java 编译器会自动为class field赋值为默认值：----------
class field,boolean: defaultValue = false
class field,(int)char: defaultValue = 0
class field,byte: defaultValue = 0
class field,short: defaultValue = 0
class field,int: defaultValue = 0
class field,long: defaultValue = 0
class field,float: defaultValue = 0.0
class field,double: defaultValue = 0.0
上面的变量都是类属性，只有类属性会被编译器自动赋值为默认值，java编译器不会为局部变量赋初始值
-----------start java 编译器不会自动为局部变量赋值为默认值：并且java编译器会报错“...可能尚未初始化变量XXX”----------
===========end java基本数据类型的默认值：===============
*///:~
