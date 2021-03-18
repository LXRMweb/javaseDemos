package javase.demo.staticdemos;

import static javase.demo.io.IOUtils.myPrint;

public class Main {
    public static void main(String[] args) {
        ClassNameWithStaticFileds inst1 = new ClassNameWithStaticFileds();
        ClassNameWithStaticFileds inst2 = new ClassNameWithStaticFileds();
        myPrint("初始化之前：实例1，"+inst1.toString());
        myPrint("初始化之前：实例2，"+inst1.toString());
        myPrint("执行赋值操作：只给实例1赋值");
        inst1.setNotStaticFiled(100);
        inst1.setStaticField(200);
        myPrint("赋值之后：实例1，" + inst1.toString());
        myPrint("赋值之后：实例2，" + inst2.toString());
        myPrint("通过上述实例可以看到：static class field是所有对象之间共享的");
    }
}/* Output: (100% match)
初始化之前：实例1，ClassNameWithStaticFileds{notStaticFiled=0, staticFiled=0}
初始化之前：实例2，ClassNameWithStaticFileds{notStaticFiled=0, staticFiled=0}
执行赋值操作：只给实例1赋值
赋值之后：实例1，ClassNameWithStaticFileds{notStaticFiled=100, staticFiled=200}
赋值之后：实例2，ClassNameWithStaticFileds{notStaticFiled=0, staticFiled=200}
通过上述实例可以看到：static class field是所有对象之间共享的
*///:~
