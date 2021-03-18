# package comments

## 概述

本包中展示java面向对象编程的几大基本原则的应用实例。

## java 面向对象编程几大基本原则

### 里氏替换原则（Liskov Substitution Principle LSP）

#### 概述



#### demo

### 依赖倒置原则（Dependence Inversion Principle）
           
#### 概述

- 高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象（High level modules shouldnot depend upon low level modules.Both should depend upon abstractions.Abstractions should not depend upon details. Details should depend upon abstractions）。
- 其核心思想是：要面向接口编程，不要面向实现编程。
- 依赖倒置原则是实现开闭原则的重要途径之一，它降低了客户与实现模块之间的耦合。
- 由于在软件设计中，细节具有多变性，而抽象层则相对稳定，因此以抽象为基础搭建起来的架构要比以细节为基础搭建起来的架构要稳定得多。这里的抽象指的是接口或者抽象类，而细节是指具体的实现类。
- 使用接口或者抽象类的目的是制定好规范和契约，而不去涉及任何具体的操作，把展现细节的任务交给它们的实现类去完成。

#### 使用依赖倒置原则的好处

#### 如何实现依赖倒置

#### demo

