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
        BasicDataType basicDataType = new BasicDataType();
        basicDataType.printDefaultValue();
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
