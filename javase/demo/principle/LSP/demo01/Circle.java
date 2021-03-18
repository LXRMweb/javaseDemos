package javase.demo.principle.LSP.demo01;

import sun.rmi.runtime.Log;

/**
 * README: 圆形
 *
 * @author created by Meiyu Chen at 2021-2-2 14:14, v1.0
 * modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 * [TODO-修改内容概述]
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制出了一个圆形");
    }

    @Override
    public void padding() {
        System.out.println("圆形内部填充了波浪线");
    }

    @Override
    public void erase() {
        System.out.println("擦除圆形");
    }
}
