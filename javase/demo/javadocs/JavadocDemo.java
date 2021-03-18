//: javase.demo.javadocs/JavadocDemo.java
// 关于上述注释的解释：“第一行采用我自己独特的方法，用一个‘：’作为特殊记号说明这是一个包含源文件名的注释行。该行包含文件的路径信息”——《Java编程思想》
package javase.demo.javadocs;

import javase.demo.enumdemo.Main;

import java.util.Date;

/** Description: Javadoc注释示例
 * 该文件展示了Javadoc注释相关语法，你可以在Javadoc注释中使用html元素或者标签
 * <br>例一，你可以在Javadoc注释中使用html标签：
 * <pre>
 *     System.out.println(new Date());
 * </pre>
 * You can <em>even</em> insert a list:
 * <ol>
 *     <li>Item One</li>
 *     <li>Item Two</li>
 * </ol>
 * @author another author，email：123@163.com，巴拉巴拉
 * @author created by Meiyu Chen at 2021-3-11 16:19, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 * @version 1.2
 * @since 1.0
 * @see AnotherClass
 * @see javase.demo.javadocs.AnotherClass
 * @see AnotherClass#func1()
 * @see Main#testEnumInSwitch()
 * <br>上面展示了使用<code>@see</code>标签添加链接到其他类的Javadoc文档的案例，但是<code>@see</code>标签只能放在一行的行首位置。
 * <br>不合法的使用方式@see AnotherClass, 这样写根本不会生成链接
 * 如果你想在行内使用链接，你必须得使用用花括号括住的<code>@link pakcage.class#member label</code>,如：{@link javase.demo.javadocs.AnotherClass#func1},
 * 再如： {@link #function2}
 * 获取文档到根目录的相对路径：{@docRoot}
 * 从当前类的最直接的基类中继承相关文档到当前的文档注释中：{@inheritDoc}
 */
public class JavadocDemo {
    /** Description: [TODO-功能描述]
     * @author created by Meiyu Chen at 2021-3-11 15:12, v1.0
     *      modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
     *          [TODO-修改内容概述]
     * @param args:String[] 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's:");
        System.out.println(new Date());
    }

    /** Description: [TODO-功能描述]
     * @author created by Meiyu Chen at 2021-3-11 15:39, v1.0
     *      modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
     *          [TODO-修改内容概述]
     * @return void 么有返回值，return只表示已执行完，想要退出函数
     * @throws java.lang.Exception no exceptions thrown
     * @deprecated 废弃原因，建议用户不要使用这些旧特性，因为在不久的将来他们可能会被删除
     */
    public int function2() throws Exception {
        throw new Exception("haha");
    }
    /* 关于下面的注释的解释：
    *       “最后一行也是一行注释，这个‘///:~’标志源代码清单的结束”。——《Java编程思想》
    *       “‘/*Output’标签，表示输出的开始部分将由这个文件生成。通过这种形式，它会被自动地测试以验证其准确性。
    *         在本例中，（55% match）在向测试系统说明程序的每一次运行和下一次运行的输出存在着很大差异，因此它们
    *         与这里列出的输出预期只有55%的相关性”。——《Java编程思想》
    * */
} /* Output: (55% match)
Hello, it's
Thu Mar 11 15:18:06 CST 2021
*///:~
