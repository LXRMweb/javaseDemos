package javase.demo.io.fileoperate;

import java.io.*;

/** Description: 演示文件输入/输出流操作示例（字符流）
 *      输出：将数据从内存输出到硬盘文件
 *      输入：将数据从硬盘文件读入到内存
 *      输出原理：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
 *      输入原理：java code -> JVM -> OS -> OS调用文件操作方法，将数据从磁盘文件读入到内存中
 * 备注：使用字符流读写文件不会出现中文乱码问题，因为字符流读写文件时：
 *     一次读取一个完整的字符（一个汉字/一个字母/一个特殊字符）
 *     不会像字节流那样将一个汉字拆分成多个字节，所以也就不会出现乱码问题
 *   todo 实际上出现了乱码问题
 * @author created by Meiyu Chen at 2021-5-11 10:06, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemonstrateFileIOCharStream {
    public static void main(String[] args) {
        // 使用二进制流将数据从内存输出到磁盘文件
        demonstrateFileWriter();

        // 使用二进制输入流将数据从磁盘文件读入到内存中
        demonstrateFileReader();
    }

    /** Description: 展示文件输入流的用法
     * 参考资料：
     * 1.[视频-文件输入流(字符流)-FileReader](https://www.bilibili.com/video/BV1U4411V7rq?p=30&spm_id_from=pageDriver)
     * @author created by Meiyu Chen at 2021-5-11 15:09, v1.0
     */
    private static void demonstrateFileReader() {
        /*step1,指定待读入的文件
        * 注意：请确保相应的文件真实存在，否则会报运行时异常
        *   java.io.FileNotFoundException: D:\testFile\logs\log333.txt (系统找不到指定的文件。)
        * */
        String filePath = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator + "log.txt";
        System.out.println(filePath);
        FileReader fileReader = null;
        try {
            // step2, 创建文件输入流对象(多种构造方法)
//            fileReader = new FileReader(filePath);
            fileReader = new FileReader(new File(filePath));

            // step3, 将数据从磁盘文件读入到内存
            // 一次读取一个字节：public int read() throws IOException
//            readOnceOneCharacter(fileReader);
            // 一次读取多个字节
            readOnceMulChars(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*step5, 释放内存、系统资源
             * 文件输入流运行机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从磁盘文件读入到内存中
             * 由此可见，文件输入过程中，会占用内存空间，占用OS资源，所以，文件输入完毕之后，要记得释放相应的资源
             * fileReader.colse() 关闭此文件输入流，并释放与此有关的所有系统资源
             * 注意：
             * 1. 一定要将close()放在finally中调用，这样可以防止try代码块抛出异常时执行不到close()
             * 2. close()也可能抛出异常，所以close函数也要用try..catch包裹起来
             * */
            if (fileReader!=null) {
                // 如果相应的文件路径不是真实存在的，那么创建fileReader时就会抛出异常，这里拿到的fileReader就会是null
                // null.close()会抛出NullPointerException
                // 所以为了避免执行close时抛出空指针异常，最好在调用close之前先进行一下非空判断
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /** Description: 文件输入流（字符流），文件->内存
     * 一次读取多个字符
     * 参考资料：
     * 1. [视频-一次读取多个字符](https://www.bilibili.com/video/BV1U4411V7rq?p=30&spm_id_from=pageDriver)
     * @author created by Meiyu Chen at 2021-5-11 15:45, v1.0
     */
    private static void readOnceMulChars(FileReader fis) throws IOException {
        /*缓存数组：用于暂存从文件中读取到的内容
        * 备注：数组长度一般设置为1024 或 1024的整数倍
        * */
        // 暂存读取到的文件内容
        char[] chArr = new char[3]; // 不推荐
//        char[] chArr = new char[1024]; // 推荐（推荐数组长度设为1024的倍数）
        // 本次读取到的有效字符数
        int len = -10;
        /*public int read(char cbuf[]) throws IOException {
        * 返回值：int 每次调用read(chArr)实际读取到的有效字节数
        *       也即：本次读取了多少个字符
        *       一开始每次读取，得到的返回值都 === chArr: char[]数组的长度
        *       快到达文件末尾时，得到的返回值一般会小于chArr数组长度
        *       如果已经到达文件结束标记位置，再次调用read(chArr)，将不会读到任何内容，返回值为-1
        * 本例：每次读取三个字节的内容，存储到chArr: char[]数组中
        *       新读到的内容覆盖chArr数组原有内容
        *       快到达文件末尾时，如果读出的内容长度 < chArr.length, 则chArr中只有部分数据被覆盖，这时bytes数组后几位的数据是脏数据
        *
        * */
        while ((len = fis.read(chArr)) != -1){
            // 不推荐使用：达到文件末尾时可能会出现脏数据
//            System.out.println(new String(chArr));
            // 推荐使用，只用bytes数组中的有用数据
            System.out.print(new String(chArr,0,len));
        }
    }

    /** Description: 文件输入流（字符流），文件->内存
     * 一次读取一个字符（一个汉字/一个字母/一个特殊字符）
     * @author created by Meiyu Chen at 2021-5-11 15:45, v1.0
     */
    private static void readOnceOneCharacter(FileReader fileReader) throws IOException {
        /*step3, 读取文件内容到内存中
        * 1. public int read() throws IOException
        *       读取下一个字符的内容，并将指针移动到下一个字节
        *       如果到达文件末尾，则返回-1
        * 备注： OS会为其中的每一个文件添加文件结束标记，不同OS的文件结束标记不同
        *       但是JVM为了实现良好的可移植性，特针对不同OS做了适配
        *       JVM会自动将不同OS的文件结束标记转化成-1，返回个java code
        * */
        int nextChar = -10;
        while ((nextChar = fileReader.read()) != -1) {
            // 直接读出来的内容是int型的
//                System.out.print(nextChar);
            /*可以将其强制类型转化，转成字符型，得到的内容就和OS打开文件看到的内容一致了
            * 中文也能正常展示，不会乱码
            * todo-中文乱码*/
            System.out.print((char) nextChar);
        }/* Output: (100% match)
D:\testFile\logs\log.txt
hello world
world
a
abc
accc
*///:~
    }

    /** Description: 展示文件输出流的用法（借助于FileWriter，将内存总的数据输出到磁盘文件中）
     *
     * 备注：
     * 1. 文件输出流运行机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
     * 2.
     *
     * 参考资料：
     * 1. [视频-数据从内存写入磁盘文件](https://www.bilibili.com/video/BV1U4411V7rq?p=31&spm_id_from=pageDriver)
     * 2.
     * @author created by Meiyu Chen at 2021-5-11 10:58, v1.0
     */
    private static void demonstrateFileWriter() {
        // step1,确定输出文件路径
        String file = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator +  "log.txt";

        // step2，确保输出文件所在父目录真实存在
        // 经过下述处理，确保创建FileWriter之前，文件所在父目录是真实存在的，防止出现运行时异常
        File file1 = new File(file);
        String parent = file1.getParent();
//        System.out.println(parent); //        D:\testFile\logs
        File parentDir = new File(parent);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // step3,创建FileWriter对象
        FileWriter fw = null;
        try {
            /*构造方法的作用：
            *   1. 创建一个FileWriter对象
            *   2. 根据构造方法中传递的文件/文件路径，创建一个空的文件
            *   3. 会把创建好的FileWriter对象指向创建好的文件
            * 注意：创建之前请确保相应的路径是真实存在的，否则会报运行时异常
            *   java.io.FileNotFoundException: D:\testFile\logs\log.txt (系统找不到指定的路径。)
            * */
            // ------------  覆盖原有文件（如果相应文件已经存在，那么将覆盖原有文件） start --------
            // public FileWriter(String name) throws FileNotFoundException
//            fw = new FileWriter(file);
            // public FileWriter(File file) throws FileNotFoundException
//            fw = new FileWriter(new File(file));
            // ------------  覆盖原有文件（如果相应文件已经存在，那么将覆盖原有文件） end --------
            // ------------  不覆盖原有文件，续写（如果相应文件已经存在，那么将在原有文件的结尾追加新的内容） start --------
            // boolean append: true-追加写；false-创建新文件，覆盖原有文件
            // public FileWriter(String name, boolean append)
            fw = new FileWriter(file,true);
            // public FileWriter(File file, boolean append)
//            fw = new FileWriter(new File(file),true);
            // ------------  不覆盖原有文件，续写（如果相应文件已经存在，那么将在原有文件的结尾追加新的内容） end --------


            /*step4，将数据写入到内存缓冲区
            * 注意：FileWriter#write() 并不是直接将数据写入到文件中哦，它只能将数据写入到缓冲区
            * 如果想要数据写入到文件中，必须手动调用flush()或者close()
            * write()函数执行完成之后，相应字符/字符数组/字符串会被JVM转化成二进制流放入缓存
            * 之后调用flush(), JVM会通知OS将相应的二进制流写入文件
            * 或者调用close(), JVM会通知OS，OS会将缓存中的二进制流写入文件，然后释放相应的内存、系统资源
            * */
            // 一次写一个字符：public void write(int b) throws IOException
            fw.write(97);
            writeNewLine(fw);
            /*向文件中写入十进制：97 = 1100001
             * 写入过程分析：
             *   虽然FileWriter是字符输出流，但是jvm会自动将字符流转化成二进制流，OS拿到二进制流，并以二进制流的形式存储文件，
             *   所以写数据时，JVM 会先把十进制的97转化为二进制数据流1100001
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
//            char[] chArr = "hello world\n".toCharArray();
            char[] chArr = {'h','e','l','l','o',' ','w','o','r','l','d'};
//            System.out.println(Arrays.toString(chArr));
            // public void write(char cbuf[]) throws IOException
            fw.write(chArr);
            writeNewLine(fw);
//            /*abstract public void write(char cbuf[], int off, int len) throws IOException
//            * 从指定的字符数组写入len个字符，从偏移量off开始输出到此输出流
//            * */
            fw.write(chArr,6,chArr.length-6);
            writeNewLine(fw);
            // 0-127的数，OS会使用ASCII码表，97=a,98=b,99=c
            char[] bytes1 = {97,98,99}; // 打开文件，看到的会是"abc"
            fw.write(bytes1);
            writeNewLine(fw);
            // public void write(String str) throws IOException
            fw.write("FileReader可以直接写字符串");
            writeNewLine(fw);
            String str = "FileReader可以直接写字符串的一部分";
            int idx = str.indexOf('r') + 1;
            // public void write(String str, int off, int len) throws IOException
            fw.write(str, idx,str.length()-idx);
            writeNewLine(fw);

            /*step5, 将缓存中的数据流持久化至文件
            * 相关话题：flush和close的区别
            *  答：二者都可以刷新缓存，将缓存中的二进制流持久化至磁盘文件
            *       但是flush()执行后，文件输出流还可以使用，而close()执行之后，文件输出流就不可以再用了
            * 参考资料：
            * 1. [视频-close vs flush](https://www.bilibili.com/video/BV1U4411V7rq?p=33&spm_id_from=pageDriver)
            * */
            fw.flush();
            fw.write(97); // 写入“a”

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*step6, 释放内存、系统资源
             * 文件输出流运行机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
             * 由此可见，文件输出过程中，会占用内存空间，占用OS资源，所以，文件输出完毕之后，要记得释放相应的资源
             * fw.colse() 关闭此文件输出流，并释放与此有关的所有系统资源
             * 注意：
             * 1. 一定要将close()放在finally中调用，这样可以防止try代码块抛出异常时执行不到close()
             * 2. close()也可能抛出异常，所以close函数也要用try..catch包裹起来
             * */
            if (fw !=null) {
                    // 如果相应的文件路径不是真实存在的，那么创建fileReader时就会抛出异常，这里拿到的fileReader就会是null
                    // null.close()会抛出NullPointerException
                    // 所以为了避免执行close时抛出空指针异常，最好在调用close之前先进行一下非空判断
                    try {
                        fw.close();
                        /*不推荐：
                         *   会报运行时异常：java.io.IOException: Stream closed
                         *   执行完close之后，fw就已经被关闭了，不可以再使用了*/
//            fw.write("97"); // 不推荐（不要用）
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    /** Description: 写换行
     *  windows: \r\n
     *  linux:\n
     *  mac:\r
     * @author created by Meiyu Chen at 2021-5-11 14:33, v1.0
     */
    private static void writeNewLine(FileWriter fw) throws IOException {
        // 换行
//        String str = "\r\n";
//        char[] newLine = str.toCharArray()();
//        System.out.println(Arrays.toString(newLine)); // [13, 10]
        String property = System.getProperty("line.separator");
        char[] newLine = property.toCharArray();
//        System.out.println(Arrays.toString(newLine)); // [13, 10]
        fw.write(newLine);
    }


}
