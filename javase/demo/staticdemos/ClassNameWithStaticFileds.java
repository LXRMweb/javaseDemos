package javase.demo.staticdemos;

/** Description: 测试static关键字
 * @author created by Meiyu Chen at 2021-3-16 10:43, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class ClassNameWithStaticFileds{

    private static int staticField;
    private int notStaticFiled;

    @Override
    public String toString() {
        return "ClassNameWithStaticFileds{" +
                "notStaticFiled=" + notStaticFiled + ", staticFiled=" + staticField +
                '}';
    }

    public static int getStaticField() {
        return staticField;
    }

    public static void setStaticField(int staticField) {
        ClassNameWithStaticFileds.staticField = staticField;
    }

    public int getNotStaticFiled() {
        return notStaticFiled;
    }

    public void setNotStaticFiled(int notStaticFiled) {
        this.notStaticFiled = notStaticFiled;
    }

}
