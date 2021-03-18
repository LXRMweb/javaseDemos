package javase.demo.principle.LSP.demo01;

/** Description: 形状-接口
 * @author created by Meiyu Chen at 2021-2-2 14:12, v1.0
 */
public interface Shape {
    /** Description: 绘制图案
     *<br> 功能描述:绘制图形
     *<br> 注意事项:[TODO-对子类的实现要求]
     *<br> 调用说明:[TODO-调用注意事项]
     * @author created by Meiyu Chen at 2021-2-2 14:13, v1.0
     *      modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
     *          [TODO-修改内容概述]
     * @param
     * @return void
     * @throws
     */
    void draw();
    /** Description: 填充
     *<br> 功能描述:内部填充颜色
     *<br> 注意事项:[TODO-对子类的实现要求]
     *<br> 调用说明:[TODO-调用注意事项]
     * @author created by Meiyu Chen at 2021-2-2 14:28, v1.0
     *      modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
     *          [TODO-修改内容概述]
     * @param
     * @return void
     * @throws
     */
    void padding();
    /** Description: 擦除
     *<br> 功能描述:擦除
     *<br> 注意事项:[TODO-对子类的实现要求]
     *<br> 调用说明:[TODO-调用注意事项]
     * @author created by Meiyu Chen at 2021-2-2 14:14, v1.0
     *      modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
     *          [TODO-修改内容概述]
     * @param
     * @return void
     * @throws
     */
    void erase();
}
