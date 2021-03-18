package javase.demo.principle.LSP.demo01;

import java.math.BigDecimal;

/**
 * README: 测试类
 *
 * @author created by Meiyu Chen at 2021-2-2 14:32, v1.0
 * modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 * [TODO-修改内容概述]
 */
public class Test {
    public static void main(String[] args) {
//        new Picture().generateAPicture();
        testBigDecimal();
    }
    private static void testBigDecimal(){
        // 你期望存入的是1.23，但由于计算机是使用二进制形式存储，而1.23转化为二进制不是有限位数，所以实际存储在计算机中的值只能无限接近1.23，而非正好等于1.23
        BigDecimal bigDecimal1 = new BigDecimal(1.23);
        BigDecimal bigDecimal2 = new BigDecimal(1.239080);
        System.out.println("1.23，"+bigDecimal1.scale());
        System.out.println("1.239080，"+bigDecimal2.scale());

        BigDecimal bigDecimal3 = new BigDecimal("1.23");
        BigDecimal bigDecimal4 = new BigDecimal("1.239080");
        System.out.println("字符串：");
        System.out.println("1.23，"+bigDecimal3.scale());
        System.out.println("1.239080，"+bigDecimal4.scale());
    }
}
