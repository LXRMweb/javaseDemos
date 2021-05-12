# IO

## 基础知识点

1. 分类
- 字节流：InputStream && OutputStream
    + 一切文件数据（文本、图片、视频...）在存储时，都是以二进制数字的形式保存的，都是一个个的字节，那么传输一样如此。
    + 所以，字节流可以传输任意文件数据
    + 缺点：使用字节流处理中文，容易出现中文乱码问题，所以处理中文时最好使用字符流，而非字节流
        - 为什么使用字节流处理中文容易出现乱码问题？
            * 答：各个字符集中都不是使用一个字节存储汉字，如：GBK中一个中文占用两个字节，UTF-8中一个中文占用三个字节
            使用字节流去读写文件，一次只能读一个字节，直接强制类型转化成char型，实际上是将一个汉字拆分成了三个部分
            解析出来的内容就会是乱码，而非正确的汉字
- 字符流: Reader && Writer
备注：在操作数据流的过程中，我们要时刻明确，无论使用什么样的流对象（字节流/字符流），
       底层传输的始终 是二进制数据。

## 相关API

1. java.io.OutputStream
    * FileOutputStream
    * ...
2. java.io.InputStream
    * FileInputStream
    * ...
3. java.io.Reader
    * BufferedReader
    * FileReader
    * FilterReader
    * InputStreamReader
        + FileReader
        + 
    * CharArrayReader
    * PipedReader
    * StringReader
    * ...
    
4. java.io.Writer

备注：注意，这些方法都是输入输出流最顶层的API，这些class中定义了子类中通用的一些方法。
另外，这些类都是抽象类，不能直接使用，实际编程过程中要是用他们的子类。

## 附录

## 参考资料

1. [视频-java文件IO操作详解](https://www.bilibili.com/video/BV1U4411V7rq?p=41&spm_id_from=pageDriver)