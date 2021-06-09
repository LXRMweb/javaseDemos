package javase.demo.datatype.map;


import java.io.*;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Set;

/** Description: Properties集合
 *
 * @author created by Meiyu Chen at 2021-5-12 18:35, v1.0
 */
public class DemonstrateProperties {
    public static void main(String[] args) {
//        // 演示Properties基本用法
//        demonstrateBasicUsage();
//
//        // 集合中的数据持久化至磁盘文件：演示Properties + 文件IO流 + 磁盘文件
//        demonstrateFileIOStore();

        // 读取磁盘文件数据到Properties集合（文件都是存的key-value）
        demonstrateFileIOLoad();
    }

    /** Description: 读取磁盘文件数据到Properties集合
     *  注意: 文件内容必须全是键值对（键值对分隔符可以是‘=’、空格、...）
     *      文件中可以包含注释（‘#’开头的行算作注释）
     *  备注：可以使用两种文件IO流来实现文件读入操作
     *      1. InputStream, 字节流，不能读取中文
     *      2. Reader, 字符流，可以读取中文
     *   参考资料：
     *      1. [视频](https://www.bilibili.com/video/BV1U4411V7rq?p=40&spm_id_from=pageDriver)
     * @author created by Meiyu Chen at 2021-5-12 18:29, v1.0
     */
    private static void demonstrateFileIOLoad() {
        Properties properties = new Properties();

        // 使用相对路径（相对于项目根目录的路径）
        String path = "src"+ File.separator+"javase"+File.separator+"demo"+File.separator+"datatype"+File.separator+"map"+File.separator+"prop.txt";
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            properties.load(fr);
            // 因为这是个Set,Set会对其中的集合元素自动去重，所以文件中包含多个相同的key时，Set中只保留一个
            Set<String> keySet = properties.stringPropertyNames();
            for (String key : keySet) {
                String value = properties.getProperty(key);
                System.out.println(key+":"+value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: Properties集合可以直接操作磁盘文件
     * @author created by Meiyu Chen at 2021-5-12 17:44, v1.0
     */
    private static void demonstrateFileIOStore() {
        // step1,创建Properties集合并且往该集合中添加数据
        Properties properties = new Properties();
        for (int i = 0; i < 5; i++) {
            properties.setProperty("key"+i,"value"+i);
        }
        properties.setProperty("keyCH","中文");

        // step2, 创建文件IO流对象
        // 使用相对路径（相对于项目根目录的路径）
        String path = "src"+ File.separator+"javase"+File.separator+"demo"+File.separator+"datatype"+File.separator+"map"+File.separator+"prop.txt";
//        FileOutputStream fos = null; // 方法一，使用字节流（中文会展示成乱码）
        FileWriter fw = null; // 方法二，使用字符流（中文不会变成乱码）
        try {
            // 字节流-覆盖原有文件
//            fos = new FileOutputStream(path);
            // 字节流-不替换原有文件，在原有文件末尾追加新内容
//            fos = new FileOutputStream(path,true);
            // 字符流-覆盖原有文件
//            fw = new FileWriter(path);
            // 字符流-不替换原有文件，在原有文件末尾追加新内容
            fw = new FileWriter(path,true);
            // step3, 将集合中的数据持久化至磁盘文件
            /*方法一，public void store(OutputStream out, String comments) throws IOException
            * 使用字节流，不能写入中文，中文会出现乱码
            * */
            // 注释，不能使用中文，容易出现中文乱码
//            String comments = "持久化数据到磁盘文件"; // 不推荐中文，容易乱码
            String comments = "project properties, append";
//            String comments = "";
//            properties.store(fos, comments);
            /*方法二，
            * 使用字符流，可以写入中文*/
            properties.store(fw,comments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            // step4, 释放内存 && 系统资源
//            if (fos!=null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            if (fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: 展示java.util.Properties的基本用法
     * Properties extends Hashtable<Object,Object>
     * Hashtable<K,V>extends Dictionary<K,V> implements Map<K,V>, Cloneable, java.io.Serializable
     * Properties是一个集合，专门存储key-value键值对（且key和value都必须是String类型的）
     * Properties的特性在于：他是唯一一个可以和IO流结合的集合，也就是说
     *      1. 你可以使用Properties集合中的store()，把集合中的临时数据，持久化到硬盘文件中
     *      2. 你可以使用Properties#load()，将硬盘中的文件（文件内容是键值对集合），读取到集合中使用
     *
     * @author created by Meiyu Chen at 2021-5-12 17:02, v1.0
     */
    private static void demonstrateBasicUsage() {
        // step1, 创建集合
        Properties properties = new Properties();

        // step2，往集合中放置键值对
        properties.setProperty("key1","value1");
        properties.setProperty("key2","value2");
        properties.setProperty("key3","value3");

        // step3, 获取集合的所有key
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            // step4, 获取key对应的value
            String value = properties.getProperty(key);
            System.out.println(key+":"+value);
        }
    }
}
