package javase.demo.io.fileoperate;

import java.io.*;

/** Description: 引入缓冲区，提升文件IO效率
 * 参考资料：
 * 1. [视频-缓冲流的原理](https://www.bilibili.com/video/BV1U4411V7rq?p=41)
 * 2. [视频-为文件输出流引入缓冲区-提升文件output效率](https://www.bilibili.com/video/BV1U4411V7rq?p=42&spm_id_from=pageDriver)
 * @author created by Meiyu Chen at 2021-5-12 19:23, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemonstrateBufferedIO {
    public static void main(String[] args) {
        // 演示：引入缓冲区，提高文件output效率
        demonstrateBufferedFileOutput();
    }

    /** Description: 引入缓冲区，提高文件output效率
     * 文件输出（内存->磁盘文件）机制：java code -> JVM -> OS -> OS调用文件操作方法，将数据从内存写入到文件中
     * 每次调用write(), 上述过程就会执行一遍，这种交互过程十分缓慢
     * 某些情况下，我们可以使用引入缓冲区的方法，来提高工作效率：
     *      1. 引入缓冲区后，code中的数据不直接写入磁盘文件，而是先写入“内存缓冲区”，内存缓冲区满了之后，或者调用flush/close时，内存缓冲区中的数据才写入磁盘
     *      2. write -> 缓冲区 -> write -> 缓冲区 -> ... -> flush()/close() -> OS -> os调用文件操作方法，将数据从内存缓冲区写入到文件中
     * @author created by Meiyu Chen at 2021-5-12 19:27, v1.0
     */
    private static void demonstrateBufferedFileOutput() {
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
//            bfos = new BufferedOutputStream(fos,2048); // 指定缓冲区大小为2048Byte
            for (int i = 0; i < 100; i++) {
                String s = "现在写入第" + i + "行数据\n\r";
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
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
