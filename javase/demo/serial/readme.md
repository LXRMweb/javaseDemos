# 序列化

## 参考资料

1. [对象序列化](https://blog.csdn.net/zmflying8177/article/details/101119134)

## 概述

## 需要关注的问题

1. 为什么要序列化
2. 序列化版本号的用处
3. 如何设定版本号&&什么时候改变版本号&&怎么修改版本号
4. 代码实现序列化、反序列化
5. IDEA中如何自动生成版本号：serialVersionUID
6. Transient关键字：限定某些属性不参与序列化
7. 序列化field范围
    + static属性不参与序列化
    + 