package javase.demo.operator;

/**
 * Description: 下面这个例子展示了哪些基本类型能进行哪些特定的运算。
 * 基本上这是一个不断重复的程序，只是每次使用了不同的基本数据类型。
 * 使用“//!”注释的代码行，表示编译器遇到这种代码会爆出编译错误。
 *
 * 总结：
 * <ul>
 *     <li>可以用于boolean型数值的操作符非常少：只有逻辑运算符 和 位操作符</li>
 *     <li>boolean型数值不能转化成其他任何类型，其他类型的数值也不能转化成boolean型</li>
 *     <li>运算符操作之前，会将低于int型的数值（包括：byte/char/short）先转化成int型，然后应用操作符去进行计算，最终得到的结果也是int型数值
 *     这种情况下，如果想要将运算结果赋值给低于int的类型，需要手动强制类型转换，否则编译器会报错。
 *     手动强制类型转换之前，请先关注超出相应类型可表示的取值范围，导致数值溢出的情况，编译器不会报错，所以开发者对此要格外谨慎
 *     </li>
 *     <li>位操作符 & | ^ ~ 可以作用于整形数值和boolean型数值，但是不能作用于浮点型数值（包括float和double）</li>
 *     <li>换句话说，位操作符 & | ^ ~ 可以作用于除了float、double之外的任意基本数据类型</li>
 *     <li>使用操作符对基本数据类型进行操作时，要注意取值范围，如 int i = Integer.MAX_VALUE i*4 = -4，得到的值是错的</li>
 *     <li>溢出取值范围时，编译器不会报错，所以编程时要特别注意</li>
 * </ul>
 *
 * @author created by Meiyu Chen at 2021-3-19 9:06, v1.0
 * <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 * <br>    [TODO-修改内容概述]
 */
public class OperatorDemos {
    public static void main(String[] args) {
        OperatorDemos demos = new OperatorDemos();
        demos.booleanWithOperator(true, false);
        char a = 'a', b = 'x';
        demos.charWithOperator(a, b);
//        byte by1 = 10, by2 = 11;
//        demos.byteWithOperator(by1, by2); // 和char基本相同
//        short sh1 = 10, sh2 = 11;
//        demos.shortWithOperator(sh1, sh2); // 和char基本相同
//        int i1 = 10, i2 = 11;
//        demos.intWithOperator(by1, by2); // 和char基本相同，除了强制类型转换（运算符操作结果本身就是int型的）
//          long l1 = 10, l2 = 11;
//        demos.longWithOperator(by1, by2); // 和char基本相同，除了强制类型转换（运算符操作结果本身就是int型的,int向long转换不需要显式指定）
        /* float型数值上可以使用哪些操作符：
                和char基本相同，
                除了不需要强制类型转换 && 无法使用按位操作符
        */
        float f1 = 1.3f, f2 = 2.2f;
        demos.floatWithOperator(f1, f2);
        /* double型数值上可以使用哪些操作符：
               和float基本相同
        */
//        double d1 = 1.3d, d2 = 1.6d;
//        demos.doubleWithOperator(d1,d2);
    }

    /**
     * Description: 测试float型数值上都可以进行哪些操作
     *
     * @author created by Meiyu Chen at 2021-3-19 10:52, v1.0
     */
    private void floatWithOperator(float f1, float f2) {
        float v = f1 + f2;
        float v1 = f1 - f2;
        float v2 = f1 * f2;
        float v3 = f1 / f2;
        float v4 = f1 % f2;
        ++f1;
        --f1;
        float v5 = +f2;
        float v6 = -f2;
        boolean b = f1 > f2;
        boolean b1 = f1 >= f2;
        boolean b3 = f1 < f2;
        boolean b2 = f1 <= f2;
        boolean b4 = f1 == f2;
        boolean b5 = f1 != f2;
        // operator && || ! can't be applied to float
//!        boolean b6 = f1 && f2;
//!        boolean b7 = f1 || f2;
//!        boolean b8 = !f1;
        // 位操作符可以作用于整型（byte/char/short/int/long）数值上,但是不可以作用于浮点型（float/double）数值上
        // operator & | ~ << >> >>> can't be applied to float
//!        float v7 = f1 & f2;
//!        float v8 = f1 | f2;
//!        float v9 = f1 ^ f2;
//!        float v10 = ~f1;
//!        float v11 = f1 << f2;
//!        float v12 = f1 >> f2;
//!        float v13 = f1 >>> f2;
        f1+=f2;
        f1-=f2;
        f1*=f2;
        f1/=f2;
        f1%=f2;
        // Error:(79, 33) java: 不兼容的类型: float无法转换为boolean
//!        boolean f11 = (boolean) f1;
        char f11 = (char) f1;
        byte f12 = (byte) f1;
        short f13 = (short) f1;
        int f14 = (int) f1;
        long f15 = (long) f1;
        double d = f1;
    }

    /**
     * Description: 测试char型数值上可以进行哪些操作
     *
     * @author created by Meiyu Chen at 2021-3-19 10:17, v1.0
     */
    private void charWithOperator(char a, char b) {
        int i = a * b;
        char ch1 = (char) (a * b);
        char c = (char) (a + b);
        char c1 = (char) (a - b);
        char c2 = (char) (a / b);
        char c3 = (char) (a % b);
        ++a;
        --a;
        char c4 = (char) +b;
        char c5 = (char) -b;
        boolean b1 = a > b;
        boolean b2 = a >= b;
        boolean b3 = a < b;
        boolean b4 = a <= b;
        boolean b5 = a == b;
        boolean b6 = a != b;
        // 编译错误：逻辑运算符不能用于char型数值
        // operator && || ! can't be applied to boolean
//!        boolean b7 = a && b;
//!        boolean b8 = a || b;
//!        boolean b9 = !a;
        // 位操作符可以作用于char型数值
        char c6 = (char) (a & b);
        char c7 = (char) (a | b);
        char c8 = (char) (a ^ b);
        char c9 = (char) ~a;
        char c10 = (char) (a >> b);
        char c11 = (char) (a << b);
        char c12 = (char) (a >>> b);
        a += b;
        a -= b;
        a *= b;
        a /= b;
        a %= b;
        a &= b;
        a |= b;
        a ^= b;
        // 编译错误：非法语句（不是语句）
//！       a~=b;
        a <<= b;
        a >>= b;
        a >>>= b;
        // Error:(68, 33) java: 不兼容的类型: char无法转换为boolean
//!        boolean c13 = (boolean) c;
        byte c13 = (byte) c;
        short c14 = (short) c;
        int c15 = c;
        long c16 = c;
        float f = c;
        double d = c;
    }

    /**
     * Description: 测试boolean型数值上可以进行哪些操作
     * 注意，能够对boolean型数值进行的运算非常有限
     *
     * @author created by Meiyu Chen at 2021-3-19 9:22, v1.0
     */
    private void booleanWithOperator(boolean x, boolean y) {
        // arithmetic operators
        /*Error:(19, 19) java: 二元运算符 '*' 的操作数类型错误
              第一个类型:  boolean
              第二个类型: boolean
          编译错误：operator +、-、*、/、%、++、-- ... can't be applied to boolean
              */
//!        int i = x * y;
//!        int i1 = x / y;
//!        int i2 = x % y;
//!        int i3 = x + y;
//!        int i4 = x - y;
        boolean b = x == y;
        boolean b1 = x != y;
        boolean b3 = x && y;
        boolean b4 = x || y;
        boolean b2 = !y;
        boolean b5 = x & y;
        boolean b6 = x | y;
        boolean b7 = x ^ y;
        // 编译错误：operator ~ can't be applied to boolean
//!        x = ~y;
        x &= y;
        x |= y;
        x ^= y;
        // 编译错误：不是语句
//!        x ~= y;
        // Error:(35, 26) java: 不兼容的类型: boolean无法转换为char
//!        char x1 = (char) x;
//!         byte x1 = (byte) x;
//!         int x2 = (int) x;
    }
}
