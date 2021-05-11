package javase.demo.io.fileoperate;

import java.io.*;

/** Description: 文件复制Demo
 * @author created by Meiyu Chen at 2021-5-11 16:41, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class FileCopy {
    public static void main(String[] args) {
        copyFile();
    }

    /** Description: 将D:\testFile\logs\log.txt复制到D:\copies文件夹下
     * 备注：计算机中存储任何类型的文件都是以二进制形式存储的，包括：txt/html/mp3/jpg/avi/mp4...
     * 所以使用字节流（FileIn/OutputStream）可以操作任何类型的文件
     * @author created by Meiyu Chen at 2021-5-11 16:42, v1.0
     */
    private static void copyFile() {
        long startTime = System.currentTimeMillis();
        // step1, 获取文件路径
//        String srcFileStr = "D:" + File.separator + "testFile" + File.separator + "logs" + File.separator + "log.txt";
//        String srcFileStr = "D:" + File.separator + "testFile" + File.separator + "微信截图_20210511181120.png";
        String srcFileStr = "D:" + File.separator + "testFile" + File.separator +"test"+ File.separator+ "main.html";
        String destinationFileStr  = "D:" + File.separator + "testFile" + File.separator + "copies";
        File srcFile = new File(srcFileStr);
        File desDir = new File(destinationFileStr);
        // step2,如果目的文件夹不存在，创建相应文件夹
        if (!desDir.exists()) {
            desDir.mkdirs();
        }
        /*step3,如果目的文件已经存在，删除该文件，防止文件复制操作得到我们不想要的结果（在原有备份文件的末尾追加源文件的内容）
        * 备注：貌似只有txt文件会这样？？
        * */
        File desFile = new File(desDir, srcFile.getName());
        if (desFile.exists()) {
            desFile.delete();
        }

        try {
            // step4, 创建文件IO流对象
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile,true);

            // step5, 读取源文件，写入目的文件
//            byte[] bytes = new byte[1024];
            byte[] bytes = new byte[2];
            int len = -10;
            while ((len = fis.read(bytes))!=-1) {
                fos.write(bytes,0,len);
            }

            /*step6, 释放相应的内存、系统资源
            * 注意：先关文件输出字节流，再关文件读取字节流
            *   因为写完了代表肯定读完了，反之则不一定成立
            * */
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("复制文件，总耗时 = " + (endTime - startTime) + "毫秒");
    }
}
