# IO

## 基础知识点

1. 分类
- 字节流：InputStream && OutputStream
    + 一切文件数据（文本、图片、视频...）在存储时，都是以二进制数字的形式保存的，都是一个个的字节，那么传输一样如此。
    + 所以，字节流可以传输任意文件数据
- 字符流: Reader && Writer
备注：在操作数据流的过程中，我们要时刻明确，无论使用什么样的流对象（字节流/字符流），
       底层传输的始终 是二进制数据。

## 相关API

1. java.io.OutputStream
    * FileOutputStream
    * 
2. java.io.InputStream
3. java.io.Reader
4. java.io.Writer

备注：注意，这些方法都是输入输出流最顶层的API，这些class中定义了子类中通用的一些方法。
另外，这些类都是抽象类，不能直接使用，实际编程过程中要是用他们的子类。

## 附录