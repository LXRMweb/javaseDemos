package javase.demo.operator;

/** Description: 移位操作符-应用案例
 * @author created by Meiyu Chen at 2021-3-18 16:22, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class ShiftOperatorDemos {
    public static void main(String[] args) {
        ShiftOperatorDemos shiftOperatorDemos = new ShiftOperatorDemos();
        shiftOperatorDemos.signedRightShift();
        shiftOperatorDemos.unsignedRightShift();

    }

    /** Description: 以一个所有位都是1的二进制数字开始，先左移它，然后用无符号右移操作符对其进行右移，
     * 直至所有的二进制位都被移出为止,每移动一位都要使用Integer.toBinaryString()打印出来
     * @author created by Meiyu Chen at 2021-3-18 16:37, v1.0
     */
    private void unsignedRightShift() {
        System.out.println("以一个所有位都是1的二进制数字开始，先左移它，然后用无符号右移操作符对其进行右移，直至所有的二进制位都被移出为止");
        int i = 0xffffffff;
        printBinary(i);
        i<<=18;
        System.out.println("左移18位:");
        printBinary(i);
        System.out.println("开始无符号右移：");
        while(i!=0){
            i>>>=1;
            printBinary(i);
        }
    }

    /** Description: 以一个最高有效位为1的二进制数字开始（提示：使用十六进制常量），
     *      * 用有符号右移操作符对其进行右移，直至所有的二进制位都被移出为止，
     * 每移动一位都要使用Integer.toBinaryString()打印出来
     * @author created by Meiyu Chen at 2021-3-18 16:22, v1.0
     */
    private void signedRightShift(){
        System.out.println("以一个最高有效位为1的二进制数字开始（提示：使用十六进制常量）,用有符号右移操作符对其进行右移，直至所有的二进制位都被移出为止，");
        int i = 0xfa13ad13;
        printBinary(i);
        while(i!=0xffffffff){
            i>>=1;
            printBinary(i);
        }
    }

    private void printBinary(int i) {
        System.out.println(Integer.toBinaryString(i));
    }
}
