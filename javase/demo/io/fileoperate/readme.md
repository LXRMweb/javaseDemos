# java - 文件操作

## 基础知识点



## 相关API

1. java.io.File

- 既可以操作文件，又可以操作目录
- File适配所有的OS
- 需要关注的问题：
    + 静态成员变量
    + 构造方法
    + 成员方法

2. java.io.FileFilter && java.io.FileNameFilter

- 这两个类都是用于文件过滤的
- 这两个类都是抽象方法，且javase没有提供这两个抽象类的实现类，所以开发者需要自己手动实现这两个抽象类。
override类中的accept(),在accept()中定义文件过滤规则
- 

## 附录

### 绝对路径 vs 相对路径

1. 绝对路径是以盘符(D: c: ...)开头的
    如： d:/workspace/mypro/src/java/ttt.java
2. 相对路径是相对于project根目录的路径
    如： src/java/tt.java
    