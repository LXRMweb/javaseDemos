# javadoc

## todo

- 解决@link标签不生效的问题
- 

## 概述

- Javadoc是用于提取code中的注释的工具，它是JDK安装的一部分
- Javadoc采用了编译器的某些技术，查找程序中的特殊注释标签。他不仅可以解析这些标签标记的信息，也将毗邻注释的类名或方法名抽取出来，形成docs
- javadoc输出的是html文件。如果你不想要html文件，想生成其他格式的文件，或者你想对Javadoc输出的html文件做一些其他操作，你可以编写你自己的`doclets`javadoc处理器来实现
	+ 点击[doclets](http://MindView.net/Books/BetterJava)查看对于doclets的介绍信息

## 参考资料

1. 处理Javadoc输出的html文件：[`doclets`](http://MindView.net/Books/BetterJava)
2. 关于Javadoc的介绍：
	- [javadoc-index](https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/index.html)
	- [jdk8-docs-tool-javadoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)

## 生成Javadoc文档

1. IDEA中如何生成Javadoc文档
* 方法：
    + 方法一，`菜单栏：Tools->Generate Javadocs`
* 相关IDEA配置参数：

## 基础知识点

1. javadoc默认只会导出public和protected成员的注释到html中
2. 如果你想导出private成员的注释，你可以用`-private`进行标记（建议你不要这么做，因为这对客户端程序员不友好，他们通常只愿意关注他们可以直接使用的部分，不想被内部细节困扰）
3. 语法
	+ `/**` && `*/`
	+ 可以在注释中嵌入html标签
		* 如：`<pre/> <em/> <ol/> <li/>`
		* 注意不要使用标题标签，如`<h1> <hr>`等，因为Javadoc会插入自己的标题，而你的标题可能与他们产生冲突
	+ 可以在注释中使用一些标签（如:@see、@link...）
		* 语法：
			- 独立文档标签：`@标签名`
			    * 独立文档标签必须置于注释行的最前面
			- 行内文档标签：`{@标签名}`
			    * 行内文档标签可以出现在Javadoc注释中的任何地方，它们也是以“@”字符开头，但要括在花括号内
		* 标签：
			`@see @link @docRoot @inheritDoc @version @author @since @param @return @throws @deprecated(javase5之后使用@Deprecated)`
		* 示例：
			- `@see`  -> docs: See Also
				+ 语法：
					* `@see classname/fully-qualified-classname/fully-qualified-classname#method-name  `
				+ javadoc:
					* 上述每种格式都会在生成的文档中加入一个具有超链接的“See Also”条目
					* docs: See Also 【链接到某个类或者method】
					* 但是javadoc不会检查链接的有效性
				+ 
			- 