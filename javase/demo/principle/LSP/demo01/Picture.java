package javase.demo.principle.LSP.demo01;

/**
 * README: 绘制一幅画
 *
 * @author created by Meiyu Chen at 2021-2-2 14:19, v1.0
 * modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 * [TODO-修改内容概述]
 */
public class Picture {
    /** Description: 生成一幅图画
     * @author created by Meiyu Chen at 2021-2-2 14:30, v1.0
     */
    public void generateAPicture(){
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        generate(circle);
        generate(triangle);
    }

    /** Description: 遵循依赖倒置原则（面向接口编程，而非面向具体实现编程；面向抽象编程，而非面向细节编程）
     *
     * @author created by Meiyu Chen at 2021-2-2 14:23, v1.0
     */
    private void generate(Shape shape){
        shape.draw();
        shape.padding();
        shape.erase();
    }
}
