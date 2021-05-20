package javase.demo.io.object;

import javafx.scene.Parent;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/** Description: 对象反序列化（二进制流转化成对象）
 * class： DataInputStream
 * 概述： 展示对象反序列化基本用法
 * @author created by Meiyu Chen at 2021-5-20 10:15, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class Main {
    private static List<Person> list = new ArrayList<Person>();
    public static void main(String[] args) {
        // demo1, 单个对象序列化，并输出到文件
//        demonstrateObjectOutputStream();

        // demo2, 单个对象反序列化（从文件中读取出来，二进制转化成对象）
        demonstrateObjectInputStream();

        // demo3, 序列化多个对象
        demonstrateMultiObjOut();

        // demo4, 反序列化，得到多个对象
        demonstrateMultiObjIn();
    }

    /** Description: 反序列化集合，读取出多个对象
     * @author created by Meiyu Chen at 2021-5-20 14:55, v1.0
     */
    private static void demonstrateMultiObjIn() {
        String file = "D:" + File.separator + "testFile" + File.separator + "objs" + File.separator + "multiObjs.txt";

        // step1, 创建ois
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            // step2, 对象反序列化
            list.clear();
            list = (ArrayList) ois.readObject();
            for (Person person : list) {
                System.out.println(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Description: 如果想要同时序列化多个对象，该怎么做呢？
     * 思路：借助于集合，先将多个Object存储到集合中，再将集合序列化
     * @author created by Meiyu Chen at 2021-5-20 14:54, v1.0
     */
    private static void demonstrateMultiObjOut() {
        String file = "D:" + File.separator + "testFile" + File.separator + "objs" + File.separator + "multiObjs.txt";
        // 确保上述文件所在的父目录真实存在
        String parent = new File(file).getParent();
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // step1, 准备数据（将对象存储到集合中）
        for (int i = 0; i < 100; i++) {
            list.add(new Person("name"+i,20+i%6));
        }

        // step2, 创建oos
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            // step3, 将集合序列化并写入文件
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step4, 释放资源
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: 对象反序列化（从文件中读取出来，二进制转化成对象）
     * @author created by Meiyu Chen at 2021-5-20 13:18, v1.0
     */
    private static void demonstrateObjectInputStream() {
        // 用于 存储对象序列化结果（对象二进制流）的文件
        String file = "D:" + File.separator + "testFile" + File.separator + "objs" + File.separator + "存储对象序列化结果";
        // 对象反序列化对象
        ObjectInputStream ois = null;
        try {
            // step1, 创建对象反序列化对象，引入了缓冲区（缓冲区大小采用默认值）
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            // step2, 读取文件，将二进制流转化成对象
            Person per = (Person) ois.readObject();
            // step3, 使用对象
            System.out.println("\n反序列化后读取到的对象：\n"+per);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // step4, 释放资源
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Description: 对象序列化（对象转成二进制流输出到文件）
     * @author created by Meiyu Chen at 2021-5-20 10:46, v1.0
     */
    private static void demonstrateObjectOutputStream() {
        // 用于存储对象序列化结果（对象二进制流）的文件
        String file = "D:" + File.separator + "testFile" + File.separator + "objs" + File.separator + "存储对象序列化结果";
        // 确保上述文件所在的父目录真实存在
        String parent = new File(file).getParent();
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 对象序列化对象
        ObjectOutputStream oos = null;
        try {
            // step1, 创建对象序列化对象（引入缓冲区-使用默认大小）
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            // step2, 将对象序列化成二进制流并写入文件
            oos.writeObject(new Person("name",18));
            // 演示transient关键字（被transient、static关键字修饰的field不能被序列化）
            demonstrateTransient(oos);

//            // step2, 准备数据
//            for (int i = 0; i < 100; i++) {
//                oos.writeObject(new Person("name"+i,20+i%6));
//                oos.writeUTF("\n\r");
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // step3, 释放资源
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }/* Output: (100% match)
目标目录下生成了一个文件：D:\testFile\objs\存储对象序列化结果.txt
该文件中存储了程序中创建的100个Person对象的序列化结果（二进制流）
*///:~

    /** Description: 演示transient关键字（被transient、static关键字修饰的field不能被序列化）
     * 推荐用法：如果不想序列化（并持久化至文件中）某些field，可以使用transient关键字修饰该field
     * @author created by Meiyu Chen at 2021-5-20 14:14, v1.0
     */
    private static void demonstrateTransient(ObjectOutputStream oos) throws IOException {
        Person per = new Person("name", 18, "被transient修饰的field，new value", "被static修饰的field,new value=序列化时的值", 100,100);
        System.out.println("即将将下面这个对象序列化至文件中：\n"+per);
        Person.setStaticStr("被static修饰的field，new value = 对象序列化之后又修改了其值");
        Person.setStaticInt(10000);
        System.out.println("\n目前这个对象="+per);
        oos.writeObject(per);
    }
}
