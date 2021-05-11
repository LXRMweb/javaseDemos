package javase.demo.io.fileoperate;

import java.io.*;
import java.util.Arrays;

/** Description: 演示文件输入/输出流操作示例
 *      输出：将数据从内存输出到硬盘文件
 *      输入：将数据从硬盘文件读入到内存
 *      输出原理：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
 *      输入原理：java code -> JVM -> OS -> OS调用文件操作方法，将数据从磁盘文件读入到内存中
 * @author created by Meiyu Chen at 2021-5-11 10:06, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemonstrateFileIOByteStream {
    public static void main(String[] args) {
        // 使用二进制流将数据从内从输出到磁盘文件
//        demonstrateFileOutputStream();

        // 使用二进制输入流将数据从磁盘文件读入到内存中
        demonstrateFileInputStream();
    }

    /** Description: 展示文件输入流的用法
     * 参考资料：
     * 1.[视频-二进制文件输入流-FileInputStream](https://www.bilibili.com/video/BV1U4411V7rq?p=24&spm_id_from=pageDriver)
     * @author created by Meiyu Chen at 2021-5-11 15:09, v1.0
     */
    private static void demonstrateFileInputStream() {
        /*step1,指定待读入的文件
        * 注意：请确保相应的文件真实存在，否则会报运行时异常
        *   java.io.FileNotFoundException: D:\testFile\logs\log333.txt (系统找不到指定的文件。)
        * */
        String filePath = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator + "log.txt";
        System.out.println(filePath);
        FileInputStream fis = null;
        try {
            // step2, 创建文件输入流对象
            fis = new FileInputStream(filePath);

            // step3, 将数据从磁盘文件读入到内存
            // 一次读取一个字节：public int read() throws IOException
//            readOnceOneByte(fis);
            // 一次读取多个字节
            readOnceMulByte(fis);



            /*step5, 释放内存、系统资源
             * 文件输入流运行机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从磁盘文件读入到内存中
             * 由此可见，文件输入过程中，会占用内存空间，占用OS资源，所以，文件输入完毕之后，要记得释放相应的资源
             * fis.colse() 关闭此文件输入流，并释放与此有关的所有系统资源*/
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** Description: 文件输入流（字节流），文件->内存
     * 一次读取多个字节
     * 参考资料：
     * 1. [视频-一次读取多个字节](https://www.bilibili.com/video/BV1U4411V7rq?p=26&spm_id_from=pageDriver)
     * @author created by Meiyu Chen at 2021-5-11 15:45, v1.0
     */
    private static void readOnceMulByte(FileInputStream fis) throws IOException {
        /*缓存数组：用于暂存从文件中读取到的内容
        * 备注：数组长度一般设置为1024 或 1024的整数倍
        * */
        byte[] bytes = new byte[3];
        int len = -10;
        /*public int read(byte b[]) throws IOException
        * 返回值：int 每次调用read(bytes)实际读取到的有效字节数
        *       也即：本次读取了多少个字节
        *       一开始每次读取，得到的返回值都 === bytes: byte[]数组的长度
        *       快多大文件末尾时，得到的返回值一般会小于bytes数组长度
        *       如果已经到达文件结束标记位置，再次调用read(bytes)，将不会读到任何内容，返回值为-1
        * 本例：每次读取三个字节的内容，存储到bytes: byte[]数组中
        *       新读到的内容覆盖bytes数组原有内容
        *       快到达文件末尾时，如果读出的内容长度<bytes.length, 则bytes中只有部分数据被覆盖，这时bytes数组后几位的数据是脏数据
        *
        * */
        while ((len = fis.read(bytes)) != -1){
            // 不推荐使用：达到文件末尾时可能会出现脏数据
//            System.out.println(new String(bytes));
            // 推荐使用，只用bytes数组中的有用数据
            System.out.print(new String(bytes,0,len));
        }
    }

    /** Description: 文件输入流（字节流），文件->内存
     * 一次读取一个字节
     * @author created by Meiyu Chen at 2021-5-11 15:45, v1.0
     */
    private static void readOnceOneByte(FileInputStream fis) throws IOException {
        /*step3, 读取文件内容到内存中
        * 1. public int read() throws IOException
        *       读取下一个字节的内容，并将指针移动到下一个字节
        *       如果到达文件末尾，则返回-1
        * 备注： OS会为其中的每一个文件添加文件结束标记，不同OS的文件结束标记不同
        *       但是JVM为了实现良好的可移植性，特针对不同OS做了适配
        *       JVM会自动将不同OS的文件结束标记转化成-1，返回个java code
        * */
        int nextByte = -10;
        while ((nextByte = fis.read()) != -1) {
            // 直接读出来的内容是int型的
//                System.out.print(nextByte);
            /*可以将其强制类型转化，转成字符型，得到的内容就和OS打开文件看到的内容一致了
            * 存在的问题：这种方式对中文不够友好，会将中文读出成乱码*/
            System.out.print((char) nextByte);
        }/* Output: (100% match)
D:\testFile\logs\log.txt
hello world
world
a
abc
accc
*///:~
    }

    /** Description: 展示文件输出流的用法（借助于FileOutputStream，将内存总的数据输出到磁盘文件中）
     *
     * 备注：
     * 1. 文件输出流运行机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
     * 2.
     *
     * 参考资料：
     * 1. [视频-数据从内存写入磁盘文件](https://www.bilibili.com/video/BV1U4411V7rq?p=20&spm_id_from=pageDriver)
     * 2.
     * @author created by Meiyu Chen at 2021-5-11 10:58, v1.0
     */
    private static void demonstrateFileOutputStream() {
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
        try {
            /*构造方法的作用：
            *   1. 创建一个FileOutputStream对象
            *   2. 根据构造方法中传递的文件/文件路径，创建一个空的文件
            *   3. 会把创建好的FileOutputStream对象指向创建好的文件
            * 注意：创建之前请确保相应的路径是真实存在的，否则会报运行时异常
            *   java.io.FileNotFoundException: D:\testFile\logs\log.txt (系统找不到指定的路径。)
            * */
            // ------------  覆盖原有文件（如果相应文件已经存在，那么将覆盖原有文件） start --------
            // public FileOutputStream(String name) throws FileNotFoundException
            fos = new FileOutputStream(file);
            // public FileOutputStream(File file) throws FileNotFoundException
//            fos = new FileOutputStream(new File(file));
            // ------------  覆盖原有文件（如果相应文件已经存在，那么将覆盖原有文件） end --------
            // ------------  不覆盖原有文件，续写（如果相应文件已经存在，那么将在原有文件的结尾追加新的内容） start --------
            // boolean append: true-追加写；false-创建新文件，覆盖原有文件
            // public FileOutputStream(String name, boolean append)
//            fos = new FileOutputStream(file,true);
            // public FileOutputStream(File file, boolean append)
//            fos = new FileOutputStream(new File(file),true);
            // ------------  不覆盖原有文件，续写（如果相应文件已经存在，那么将在原有文件的结尾追加新的内容） end --------


            /*step4，将数据从内存写入到磁盘文件
            * */
            byte[] bytes = "hello world\n".getBytes();
//            System.out.println(Arrays.toString(bytes));
            // public void write(byte b[]) throws IOException
            fos.write(bytes);
            /*public void write(byte b[], int off, int len) throws IOException
            * 从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
            * */
            fos.write(bytes,6,bytes.length-6);
            /*向文件中写入十进制：97 = 1100001
            * 写入过程分析：
            *   由于FileOutputStream是二进制输出流，所以写数据时，JVM 会先把十进制的97转化为二进制数据流1100001
            *   然后JVM通知OS，让OS调用文件操作API来将上述二进制数据流1100001写入到磁盘文件中
            *   磁盘文件中存储的也是二进制数据1100001
            *   当用户打开相应文件的时候，OS会自动查询编码表，把字节转化为字符
            *   对于记事本、notepad++...各种文本编辑器而言，OS遵循如下解码规则：
            *       1. 对于0-127的数值，查询ASCII码表解码，97对应的字符是a
            *       2. 0-127之外的其他任意二进制数值，查询系统默认码表（如：中文OS对应的就是GBK码表）
            *   所以，虽然java程序中写入文件的是97，但是打开文件之后看到的会是'a'
            * 参考资料：
            * 1. [视频-文件输出流&&文件编码方式](https://www.bilibili.com/video/BV1U4411V7rq?p=21&spm_id_from=pageDriver)
            * */
            // public void write(int b) throws IOException
            fos.write(97);
            writeNewLine(fos);
            // 0-127的数，OS会使用ASCII码表，97=a,98=b,99=c
            byte[] bytes1 = {97,98,99}; // 打开文件，看到的会是"abc"
            fos.write(bytes1);
            writeNewLine(fos);
            // 如果写入的字节流数据中有负数，那么该负数会和紧随其后的一个字节共同组成一个中文字符（GBK编码）
            byte[] bytes2 = {97,-98,99,-100,99,99}; // 打开文件，看到的会是"a瀋渃c"
            fos.write(bytes2);


            /*step5, 释放内存、系统资源
            * 文件输出流运行机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
            * 由此可见，文件输出过程中，会占用内存空间，占用OS资源，所以，文件输出完毕之后，要记得释放相应的资源
            * fos.colse() 关闭此文件输出流，并释放与此有关的所有系统资源*/
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Description: 写换行
     *  windows: \r\n
     *  linux:\n
     *  mac:\r
     * @author created by Meiyu Chen at 2021-5-11 14:33, v1.0
     */
    private static void writeNewLine(FileOutputStream fos) throws IOException {
        // 换行
//        String str = "\r\n";
//        byte[] newLine = str.getBytes();
//        System.out.println(Arrays.toString(newLine)); // [13, 10]
        String property = System.getProperty("line.separator");
        byte[] newLine = property.getBytes();
//        System.out.println(Arrays.toString(newLine)); // [13, 10]
        fos.write(newLine);
    }


}
