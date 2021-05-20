package javase.demo.io.fileoperate;

import java.io.*;

/** 编码、解码、字符集 && 乱码问题解决
 * 概述：
 * 1. 字节流（FileIn/OutputStream）读写字符文本容易出现乱码问题
 * 2. 字符流 (FileReader/Writer) 读写文本时，是对字节流进行了一定的封装，自动按照IDE默认字符集对字节流进行了编码、解码
 * 但是，字符流只能使用IDE设置的默认字符集，无法自己指定使用其他字符集，
 * 所以，字符流读写文件也有可能出现中文乱码问题
 * 3. 转换流（InputStreamReader/OutputStreamWriter）是字符流(FileReader/Writer) 的父类
 * 转换流除了可以使用IDE默认字符集之外，还可以自主指定使用其他字符集
 * 转换流比字符流拥有更多的自由
 * 所以，我们可以使用转换流彻底解决乱码问题
 * 解决乱码问题的关键：编码 && 解码过程中，使用同样的规则（同样的字符集）

* {@link }
* 参考资料：
* 1. [编码、解码、字符集](https://www.bilibili.com/video/BV1U4411V7rq?p=48)
* 2. [编码解码字符集不一致导致的乱码问题演示](https://www.bilibili.com/video/BV1U4411V7rq?p=49)
* 3. [文件字节字符转换流的原理](https://www.bilibili.com/video/BV1U4411V7rq?p=50)
* 4. [解决文件IO中文乱码问题-写文件](https://www.bilibili.com/video/BV1U4411V7rq?p=51)
* 5. [解决文件IO中文乱码问题-读文件](https://www.bilibili.com/video/BV1U4411V7rq?p=52)
* 6. javase.demo.other.编码-解码-字符集.md*/
public class DemonstrateFileIOCharset {
    public static void main(String[] args) {
        // demo1，编码过程中指定字符集
//        demonstrateOutputStreamWriter();
        
        // demo2, 解码过程中指定字符集
//        demonstrateInputStreamReader();

        // demo3, 示例：改变文件字符集（文件字符集转换）
        demonstrateFileCharsetTransfer();
    }

    /** Description: 文件字符集转换（将文件字符集从GBK格式转换成UTF-8格式）
     * @author created by Meiyu Chen at 2021-5-20 9:29, v1.0
     * 参考资料：
     * 1. [视频-转换文件编码](https://www.bilibili.com/video/BV1U4411V7rq?p=53&spm_id_from=pageDriver)
     */
    private static void demonstrateFileCharsetTransfer() {
        // 源文件：这是一个GBK格式的文件
        String fileGBK = "D:" + File.separator + "testFile" + File.separator + "charset" + File.separator +  "gbk.txt";
        // 目的文件：想要将上述“源文件”转化成utf8格式存储到“目的文件”
        String fileUTF8 = "D:" + File.separator + "testFile" + File.separator + "charset" + File.separator +  "fileUTF8.txt";
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // step1, 创建文件输入流对象（指定字符集为“源文件”的字符集-GBK）
            isr= new InputStreamReader(new BufferedInputStream(new FileInputStream(fileGBK)),"GBK");
            // step2, 创建文件输出流对象（指定字符集为“目的字符集”-UTF-8）
            osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileUTF8)),"utf-8");

            // step3, 读取源文件，将读取到的内容写入到新的文件
            char[] chArr = new char[1024];
            int len = -10;
            while ((len = isr.read(chArr))!=-1){
                osw.write(chArr,0,len);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step4, 释放资源
            if (osw!=null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (isr!=null) {
                        try {
                            isr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    /** Description: 指定解码字符集（文件内容读入到内存，指定二进制流解码成人能看得懂的字符的字符集）
     * @author created by Meiyu Chen at 2021-5-14 16:46, v1.0
     */
    private static void demonstrateInputStreamReader() {
        String file = "D:" + File.separator + "testFile" + File.separator + "charset" + File.separator +  "gbk.txt";
        // step1,创建文件输入流对象（可以指定缓冲区大小，解码字符集）
        InputStreamReader isr = null;
        try {
            // 建议使用和文本相同的字符集，这样解码之后才不会出现乱码问题
            // 不引入缓冲区，且字符集使用默认的
//            isr = new InputStreamReader(new FileInputStream(file));
            // 引入缓冲区且指定缓冲区大小为2047Byte，但字符集使用默认的
//            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(file),2048));
            // 引入缓冲区且指定缓冲区大小为2047Byte, 同时指定字符集为“GBK”
            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(file),2048),"gbk");
//            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(file),2048),"utf-8");

            // step2, 读取文件内容到内存（解码：将二进制流转换成人看得懂的字符串流，使用上面指定的字符集进行解码）
            int nextChar = -10;
            while ((nextChar = isr.read())!=-1){
                System.out.println((char) nextChar);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step3，释放资源
            if (isr!=null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: 指定编码字符集（内存数据输出到磁盘文件，指定字符编码成机器能理解的二进制流的字符集）
     * 参考资料：
     *  1. [解决文件IO中文乱码问题-写文件](https://www.bilibili.com/video/BV1U4411V7rq?p=51)
     * @author created by Meiyu Chen at 2021-5-14 16:07, v1.0
     */
    private static void demonstrateOutputStreamWriter() {
        long startTime = System.currentTimeMillis();
        // step1,确定输出文件路径
//        String file = "D:" + File.separator + "testFile" + File.separator + "charset" + File.separator +  "gbk.txt";
        String file = "D:" + File.separator + "testFile" + File.separator + "charset" + File.separator +  "uft8.txt";

        // step2，确保输出文件所在父目录真实存在
        // 经过下述处理，确保创建FileWriter之前，文件所在父目录是真实存在的，防止出现运行时异常
        File file1 = new File(file);
        String parent = file1.getParent();
//        System.out.println(parent); //        D:\testFile\logs
        File parentDir = new File(parent);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // step3, 创建字符文件输出流（引入缓冲区，并指定编码字符集）
        // OutputStreamWriter:字节流与字符之间的桥梁，使用指定的字符集将字符流编码成二进制流
        OutputStreamWriter osw = null;
        try {
            // 不使用缓冲区
            osw = new OutputStreamWriter(new FileOutputStream(file),"gbk");
            // 指定缓冲区大小，并指定字符集
//            osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file),1024),"GBK");
            // 字符集-不区分大小写
//            osw = new OutputStreamWriter(bos,"GBK");
            // 不指定字符集，使用默认字符集：UTF-8
//            OutputStreamWriter osw = new OutputStreamWriter(bos);

            // step4, 调用write，将字符流转化成字节流存储到缓冲区
            // 往文件中写入两个汉字：如果指定的编码字符集是GBK，那么文件大小会是4Byte；如果是UTF-8，则文件大小是6Byte
            osw.write("你好");

            // step5, 将缓冲区的内容持久化至磁盘文件
            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step6，释放资源
            if (osw!=null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime) + "毫秒");
    }
}
