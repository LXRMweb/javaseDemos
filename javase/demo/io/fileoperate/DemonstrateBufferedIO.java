package javase.demo.io.fileoperate;

import java.io.*;
import java.util.Arrays;

/** Description: 引入缓冲区，提升文件IO效率
 * 参考资料：
 * 1. [视频-缓冲流的原理](https://www.bilibili.com/video/BV1U4411V7rq?p=41)
 * 2. [视频-为文件输出流引入缓冲区-提升文件output效率](https://www.bilibili.com/video/BV1U4411V7rq?p=42&spm_id_from=pageDriver)
 * 3. [视频-缓冲区效率提升展示](https://www.bilibili.com/video/BV1U4411V7rq?p=44&spm_id_from=pageDriver)
 * @author created by Meiyu Chen at 2021-5-12 19:23, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemonstrateBufferedIO {
    public static void main(String[] args) {
//        // 演示：字节流-引入缓冲区，提高文件output效率
//        demonstrateBufferedFileOutputStream();
//
//        // 演示：字节流-引入缓冲区，提高文件读取效率（文件->内存）
//        demonstrateBufferedFileInputStream();

        // 演示：字符流-引入缓冲区，提高文件output效率
//        demonstrateBufferedFileWriter();

        // 演示：字符流-引入缓冲区，提高文件读取效率（文件->内存）
        demonstrateBufferedFileReader();
    }

    /** Description: 字符流-引入缓冲区，提高文件读取效率（文件->内存）
     * @see DemonstrateBufferedIO#demonstrateBufferedFileInputStream() 唯一的差别在于是字节流还是字符流
     * @author created by Meiyu Chen at 2021-5-12 20:30, v1.0
     * 参考资料：
     * 1.[视频](https://www.bilibili.com/video/BV1U4411V7rq?p=46)
     */
    private static void demonstrateBufferedFileReader() {
        // step1,确定输出文件路径
        String file = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator +  "log.txt";
        // step2,创建缓冲流对象
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file)); // 不指定缓冲区大小，使用默认值：8192字节
//            bfr = new BufferedReader(new FileReader(file),2048); // 指定缓冲区大小2048字节（建议大小设为1024的整数倍）

//            // step3, 读取文件（方法一，使用read()读取）
//            char[] chars = new char[1024];
//            int len = -10;
//            while ((len=bfr.read(chars))!=-1){
//                System.out.print(new String(chars,0,len));
//            }

            /*step3, 读取文件（方法二，使用readLine()读取）
            * 注意：readLine()是BufferedReader所独有的方法
            *   每次读取一行文本（行结束符：\n\r）*/
            String nextLine = "下一行";
            while ((nextLine=bfr.readLine())!=null){
                System.out.println(nextLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step4, 释放资源
            if (bfr!=null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: 演示：字符流-引入缓冲区，提高文件output效率
     * @see DemonstrateBufferedIO#demonstrateBufferedFileOutputStream() 唯一的差别在于是字节流还是字符流
     * @author created by Meiyu Chen at 2021-5-12 20:30, v1.0
     * 参考资料：
     * 1.[视频](https://www.bilibili.com/video/BV1U4411V7rq?p=45&spm_id_from=pageDriver)
     */
    private static void demonstrateBufferedFileWriter() {
        // step1,确定输出文件路径
        String file = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator +  "log.txt";

        // step2,创建文件输入流对象
        FileWriter fw = null;
        // step3, 引入缓冲区
        BufferedWriter bfw = null;
        try {
            fw = new FileWriter(file);
            bfw = new BufferedWriter(fw); // 不指定缓冲区大小，使用默认值：8192字节
//            bfw = new BufferedInputStream(fw,2048); // 指定缓冲区大小2048字节（建议大小设为1024的整数倍）

            for (int i = 0; i < 200; i++) {
                // step5,向缓冲区写入数据
//                bfw.write("line " + i);
                bfw.write("现在写入第" + i + "行数据");
                /*换行
                * 1.这是BufferedWriter中特有的API
                * 2.这个API可以适配不同的OS（不同OS中的换行符不一样，这个API特地做了适配）*/
//                bfw.write( "\n\r"); // 不推荐（只适配win OS)
                bfw.newLine(); // 推荐，适配各种OS
            }

            /* step6,将缓冲区的数据持久化至磁盘文件
                注意：
                    1.在调用flush之前，相应的数据只到达了数据缓冲区，并没有写入磁盘文件
                    2.close()函数中封装了flush，所以如果你调用了close，也可以省略step6*/
            bfw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step7，释放资源
            if (bfw!=null) {
                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /** Description: 引入缓冲区，提高文件读取效率（文件->内存）
     *  文件读取过程：java code -> JVM -> OS -> OS调用文件操作方法，将数据从磁盘文件读入到内存中
     *  每次调用read(),上述过程就会执行一遍，这种交互过程十分缓慢
     *  某些情况下，我们可以使用引入缓冲区的方法，来提高工作效率：
     *      1. 引入缓冲区后，JVM会一次性读取缓冲区大小的文件内容放在缓冲区
     *      2. 这样下次执行read()时，就会直接葱缓冲区中读取后面的内容，而非每次都去磁盘读取
     *      3. 缓冲区内容读完之后，再次从磁盘读取缓冲区大小的文件内容...
     *      4. java code -> read -> jvm -> os -> 读取磁盘文件（一次性读取缓冲区大小的文件内容缓存在内存中）-> 数据返回给jvm -> jvm将数据送给code ->
     *          code 调用read() -> 直接从缓冲区读取后面的文件内容 -> read -> 从缓冲区读取 -> .... -> 缓冲区内容读完了 ->
     *          去磁盘中再次读取缓冲区大小的文件内容
     * @author created by Meiyu Chen at 2021-5-12 20:01, v1.0
     */
    private static void demonstrateBufferedFileInputStream() {
        // step1,确定输出文件路径
        String file = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator +  "log.txt";

        // step2,创建文件输入流对象
        FileInputStream fis = null;
        // step3, 引入缓冲区
        BufferedInputStream bfis = null;
        try {
            fis = new FileInputStream(file);
            bfis = new BufferedInputStream(fis); // 不指定缓冲区大小，使用默认值：8192字节
//            bfis = new BufferedInputStream(fis,2048); // 指定缓冲区大小2048字节（建议大小设为1024的整数倍）

            // step4, 读取文件
            int nextByte = -10;
            while ((nextByte = bfis.read()) != -1){
                System.out.print((char)nextByte); // 中文会乱码
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step5, 释放资源
            if (bfis != null) {
                try {
                    bfis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: 引入缓冲区，提高文件output效率
     * 文件输出（内存->磁盘文件）机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
     * 每次调用write(), 上述过程就会执行一遍，这种交互过程十分缓慢
     * 某些情况下，我们可以使用引入缓冲区的方法，来提高工作效率：
     *      1. 引入缓冲区后，code中的数据不直接写入磁盘文件，而是先写入“内存缓冲区”，
     *         内存缓冲区满了之后，或者调用了flush/close函数，内存缓冲区中的数据才写入磁盘文件
     *      2. java code -> write -> 缓冲区 -> write -> 缓冲区 -> ... -> 缓冲区满/flush()/close() -> OS -> os调用文件操作方法，将数据从内存缓冲区写入到文件中
     * @author created by Meiyu Chen at 2021-5-12 19:27, v1.0
     */
    private static void demonstrateBufferedFileOutputStream() {
        // step1,确定输出文件路径
        String file = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator +  "log.txt";

        // step2，确保输出文件所在父目录真实存在
        // 经过下述处理，确保创建FileOutputStream之前，文件所在父目录是真实存在的，防止出现运行时异常
        File file1 = new File(file);
        String parent = file1.getParent();
//        System.out.println(parent); //        D:\testFile\logs
        File parentDir = new File(parent);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // step3,创建FileOutputStream对象
        FileOutputStream fos = null;
        BufferedOutputStream bfos = null;
        try {
            fos = new FileOutputStream(file);
            // step4, 为文件输出流引入缓冲区
            bfos = new BufferedOutputStream(fos); // 不指定缓冲区大小，使用默认大小8192Byte
//            bfos = new BufferedOutputStream(fos,2048); // 指定缓冲区大小为2048Byte(建议size最好为1024的整数倍)
//            bfos = new BufferedOutputStream(fos,10); // 指定缓冲区大小为10Byte（测试用，不推荐）
            for (int i = 0; i < 200; i++) {
//                String s = "现在写入第" + i + "行数据\n\r";
//                String s = "line" + i +  "\n\r";
                String s = "line" + i +  System.lineSeparator(); // 不同操作系统的换行符不一样
                // step5,向缓冲区写入数据
                bfos.write(s.getBytes());
            }

            /* step6,将缓冲区的数据持久化至磁盘文件
                注意：
                    1.在调用flush之前，相应的数据只到达了数据缓冲区，并没有写入磁盘文件
                    2.close()函数中封装了flush，所以如果你调用了close，也可以省略step6*/
            bfos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step7,释放系统资源
            // 注意，只需要关闭缓冲流即可，不需要手动关闭文件IO流（fos)
            // 因为你调用bfos.close()之后，JVM会自动关闭fos
            if (bfos!=null) {
                try {
                    bfos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
