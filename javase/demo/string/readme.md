# java 字符串

## 概述

1. 相关class
    * String
    * StringBuffer
    * StringBuilder
2. 相关话题
    * 话题1，String#replace vs replaceFirst vs replaceAll
        + 是否使用正则表达式
        + 是否全局替换
        + 字符串常量池
    * 话题2，StringBuffer、StringBuilder中append()的“自动扩容机制”
    * 话题3，StringBuffer vs StringBuilder
    * 话题4，String vs StringBuffer vs StringBuilder
    * 话题5，String && StringBuilder && StringBuffer之间的相互转换
    

## 相关话题

### 话题2，StringBuffer、StringBuilder中append()的“自动扩容机制”

1. StringBuilder的底层原理是，将字符串中的字符存储在一个char[]中
2. new StringBuilder()的时候，char[]有一个初始容量
3. append的时候，会在char[]中存放待添加的子串
4. append子串的时候，如果待添加的子串长度超出char[]容量，会触发“自动扩容机制”
    char[]的新长度 = 原始长度 * 2 + 2，              当（已有字符串 + 子串）.length  < 原始长度 * 2 + 2时
              or  = （已有字符串 + 子串）.length     当 （已有字符串 + 子串）.length > 原始长度 * 2 + 2时
              or  = 抛出OutOfMemoryError            当（已有字符串 + 子串）.length > Integer.MAX_VALUE-8时
5. 将原来的char[]复制到新的数组中
6. 将子串添加到扩容后的char[]的末尾

### 话题3：StringBuffer vs StringBuilder
* 相同点：
    + 拥有相同的父类
        - `public final class StringBuffer
               extends AbstractStringBuilder
               implements java.io.Serializable, CharSequence`
        - `public final class StringBuilder
               extends AbstractStringBuilder
               implements java.io.Serializable, CharSequence`
    + 所以二者内部的methods、fields基本相同
* 不同点：
    + 
    
### 话题4，String vs StringBuffer vs StringBuilder

1. String 类中使用的是final char[]存储字符串，内容不可变，容易造成内存极大浪费
    为了避免内存浪费，引入了StringBuilder 和 StringBuffer
    StringBuffer和StringBuilder使用的是char[],允许字符串内容改变，节省内存资源
    + `String
            private final char[] value`
    + `StringBuffer && StringBuilder
            char[] value;`       
2. 三个类的使用场景
    * 操作少量的数据用String
    * 操作大量的数据用StringBuilder or StringBuffer，避免内存浪费
        + 多线程：使用StringBuffer
        + 单线程：使用StringBuilder，速度比StringBuffer快     
        
### 话题5，String && StringBuilder && StringBuffer之间的相互转换

```
    public StringBuffer(String str) // String -> StringBuffer
    public StringBuilder(String str) // String -> StringBuilder
    StringBuffer#public synchronized String toString() // StringBuffer -> String
    StringBuilder#public String toString()  // StringBuilder -> String
```
