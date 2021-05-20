package javase.demo.io.object;

import java.io.Serializable;

/** Description: 如果想要该类可以进行序列化、反序列化，请一定要实现Serializable接口
 * @author created by Meiyu Chen at 2021-5-20 10:37, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class Person implements Serializable {
    /* 避免java.io.InvalidClassException
    *   如果不添加该常量，则每次实现了Serializable接口的Person类进行了修改之后，
    *   新编译出的Person.class文件中的serialVersionUID都会改变
    *   序列化时，JVM会将Person.class中的serialVersionUID写入"对象.txt"文件
    *   反序列化时，JVM会将Person.class中的serialVersionUID和"对象.txt"文件对比，若二者的serialVersionUID不同，则会爆出InvalidClassException
    *   为了避免上述异常，所以在Person中添加serialVersionUID常量，这样每次修改Person之后，Person.class中的serialVersionUID都不会改变
    * */
    private static final long serialVersionUID = 100000;
    private String name;
    private int age;

    /* 4. [视频-VO/DO类中被transient修饰的属性不能被序列化](https://www.bilibili.com/video/BV1U4411V7rq?p=57)
     *  被transient修饰的属性不能被序列化：序列化之后存储到文件中，然后再反序列化读取出来的值不会是你持久化的值，而是null和0
     * 推荐用法：
     *      1. 如果不想序列化（并持久化至文件中）某些field，可以使用transient关键字修饰该field
     */
    private transient String transientStr = "被transient修饰的field，初始值"; // 反序列化读取出来的值会是null
    private transient int transientInt = 1000; // 反序列化读取出来的值会是0

    /* 被static修饰的field不可以被序列化
    * static修饰的field是所有对象共享的，所以不能被序列化
    * 反序列化读取出来的值会是内存中最新的值，而不是序列化（持久化存储）时的值
    * */
    private static String staticStr = "被static修饰的field,初始值";
    private static int staticInt = 0;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", transientStr='" + transientStr + '\'' +
                ", staticStr='" + staticStr + '\'' +
                ", staticInt=" + staticInt +
                ", transientInt=" + transientInt +
                '}';
    }

    public static int getStaticInt() {
        return staticInt;
    }

    public static void setStaticInt(int staticInt) {
        Person.staticInt = staticInt;
    }

    public static String getStaticStr() {
        return staticStr;
    }

    public static void setStaticStr(String staticStr) {
        Person.staticStr = staticStr;
    }

    public Person(String name, int age, String transientStr) {
        this.name = name;
        this.age = age;
        this.transientStr = transientStr;
    }

    public Person(String name, int age, String transientStr, String staticStr, int staticInt, int transientInt) {
        this.name = name;
        this.age = age;
        this.transientStr = transientStr;
        Person.staticStr = staticStr;
        Person.staticInt = staticInt;
        this.transientInt = transientInt;
    }

    public String getTransientStr() {
        return transientStr;
    }

    public void setTransientStr(String transientStr) {
        this.transientStr = transientStr;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
