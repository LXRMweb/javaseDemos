package javase.demo.io.printstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/** Description: 演示PrintStream
 * 参考资料：
 *      1. [视频-PrintStream](https://www.bilibili.com/video/BV1U4411V7rq?p=60&spm_id_from=pageDriver)
 * PrintStream特点：
 *      1. 只负责数据的输出，不负责收据的读取
 *      2. 与其他输出流不同，PrintStream永远不会抛出IOException
 *      3. PrintStream继承自OutputStream, 所以它拥有父类所拥有的所有方法
 *      4. 该class特有的方法
 *          print(任意类型的值)
 *          println(任意类型的值并换行)
 *      5. 如果使用父类中的write()方法将数据输出到文件，那么打开相应的文件时，OS会自动调用字符集，
 *          将0-127范围内的数字自动转化为字符
 *         如果使用PrintStream独有的方法print/println将数据输出到文件，OS就不会执行上述转换，
 *          0-127范围的数字仍然会是数字，而非字符
 * @author created by Meiyu Chen at 2021-5-20 17:14, v1.0
 */
public class DemonstratePrintStream {
    public static void main(String[] args) {
        // demo1, write vs print
        demonstrateWriteVsPrint();

    }

    /** Description: 展示PrintStream所独有的print/println方法和继承自OutputStream的write方法的区别
     * @author created by Meiyu Chen at 2021-5-20 17:28, v1.0
     */
    private static void demonstrateWriteVsPrint() {
        // step1,确定输出文件路径
        String file = "D:" + File.separator + "testFile" + File.separator + "printStream" + File.separator +  "printStreamFile.txt";

        // step2，确保输出文件所在父目录真实存在
        // 经过下述处理，确保创建FileWriter之前，文件所在父目录是真实存在的，防止出现运行时异常
        File file1 = new File(file);
        String parent = file1.getParent();
//        System.out.println(parent); //        D:\testFile\logs
        File parentDir = new File(parent);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // step3, 创建PrintStream对象，指定输出目的地
        PrintStream ps = null;
        try {
            // 方法一，public PrintStream(String fileName) throws FileNotFoundException
            ps = new PrintStream(file);
            // 方法四，public PrintStream(String fileName, String csn)
            //        throws FileNotFoundException, UnsupportedEncodingException
//            ps = new PrintStream(file,"UTF-8");
            // 方法二，public PrintStream(File file) throws FileNotFoundException
//            ps = new PrintStream(new File(file));
            // 方法三，public PrintStream(File file, String csn)
//            ps = new PrintStream(new File(file),"utf-8");
            // 方法五，其他构造函数

            // 使用继承来的write方法向文件中写入数据
            ps.write(97); // a

            // 使用自己独有的方法向文件中写入数据
            ps.println(97);
            ps.println('a');
            ps.println("this is a string");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
        } finally {
            if (ps!=null) {
                ps.close();
            }
        }
    }
}
