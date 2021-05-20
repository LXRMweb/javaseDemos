# 对象的序列化和反序列化

## 参考资料

1. [视频-对象的序列化和反序列化-定义](https://www.bilibili.com/video/BV1U4411V7rq?p=54)
2. [视频-对象的序列化流-ObjectOutputStream](https://www.bilibili.com/video/BV1U4411V7rq?p=55)
3. [视频-对象的反序列化流-ObjectInputStream](https://www.bilibili.com/video/BV1U4411V7rq?p=56)
4. [视频-VO/DO类中被static、transient修饰的属性不能被序列化](https://www.bilibili.com/video/BV1U4411V7rq?p=57)
## 概述

1. 定义
    * 对象的序列化：对象转化成二进制流
    * 对象的反序列化：二进制流转化成对象
2. 相关class
    * ObjectOutputStream: 对象序列化（对象转化成二进制流）
    * ObjectInputStream：对象反序列化（二进制流转化成对象-Object对象）
    * Serializable: 想要进行对象序列化和反序列化的VO/DO class必须先实现Serializable接口
        + 这是一个标记接口，里面没有任何函数
        + 只有实现了该标记接口的class才可以被序列化、反序列化
        + 如果对没有实现该标记接口的class执行序列化、反序列化操作，则会爆出NotSerializableException
    * NotSerializableException: 如果没有实现Serializable的class尝试执行序列化/反序列化操作，则会爆出该异常
    * transient关键字：如果不想序列化（并持久化至文件中）某些field，可以使用transient关键字修饰该field
    * ClassNotFoundException：反序列化的时候可能出现该异常
    * java.io.InvalidClassException: javase.demo.io.object.Person; local class incompatible: stream classdesc serialVersionUID = -4923424073566499021, local class serialVersionUID = 4203928619560498472
        + 反序列化的时候可能会出现这个异常
        + 如果你序列化之后，又修改了相应的VO class（如private改为public）, 并且用修改后的VO class去执行反序列化操作，就会抛出该异常
        + 如何解决： `private static final long serialVersionUID = 100000;`
        + 参考：[视频-对象反序列化-InvalidClassException](https://www.bilibili.com/video/BV1U4411V7rq?p=58&spm_id_from=pageDriver)
3. 编程实现
    * step1，让希望执行对象序列化、反序列化的class一定要实现Serializable接口
    * step2, 