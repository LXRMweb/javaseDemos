package javase.demo.random;

import java.util.Random;

/** Description: Random使用示例
 * @author created by Meiyu Chen at 2021-3-17 17:05, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class TestRandom {
    /** Description: 程序入口
     * @author created by Meiyu Chen at 2021-3-17 17:06, v1.0
     */
    public static void main(String[] args) {
        /*Random构造函数参数：long seed
        *   如果new Random()新建实例时没有传递任何参数，那么Java就会将当前时间作为随机数生成器种子，并由此在程序每一次执行时都产生不同的输出。
        *   如果new Random(long)新建实例时提供了种子，就可以在每次执行程序时都生成相同的随机数，因此其输出是可验证的（正如本例中所展示的那样）
        *   种子用于随机数生成器的初始化值，随机数生成器对于特定的种子值总是产生相同的随机数序列
        *   要想生成更多的不同的输出，可以随意移除本例中的种子
        * */
        Random random = new Random(47);
        for(int i=0;i<10;i++){
            /* 传递给nextInt()的参数设置了所产生的随机数的上限，而其下限为0.
                如本例中设置了100，则随机数产生器会产生[0,99]的随机整数*/
            int nextInt = random.nextInt(100);
            float nextFloat = random.nextFloat();
            System.out.println(nextInt+","+nextFloat);
        }
    }
}/* Output: (100% match)
58,0.39982635
93,0.0534122
61,0.57799757
68,0.4170137
22,0.73734957
88,0.9510573
51,0.11435455
9,0.5466897
98,0.20143336
20,0.55373144
*///:~
