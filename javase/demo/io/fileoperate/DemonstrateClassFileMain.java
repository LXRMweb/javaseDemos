package javase.demo.io.fileoperate;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/** Description: demo - java 文件操作
 *     展示java.io.File/FileFilter/FilenameFilter的用法
 * @author created by Meiyu Chen at 2021-5-8 10:15, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemonstrateClassFileMain {

    public static void main(String[] args) {
//        // 展示File类中四个public static field的用法
//        demoFileFields();
//
//        // 展示File类的构造方法
//        demoFileConstructors();

        // 展示File类的成员方法
        demoFileMethods();
    }

    /** Description: 展示File类中public成员变量的用法
     * @author created by Meiyu Chen at 2021-5-8 9:43, v1.0
     */
    private static void demoFileFields() {
        System.out.println("class File的四个public fields:");

        /*File.separator：
         *       文件分隔符
         *       注意，在不同的OS中，File.separator的值是不一样的，在windows中它是‘\’，在linux中它是‘/’*/
        System.out.println("文件分隔符：File.separator = "+File.separator);
        // 推荐用法
        String file1 = "D:" + File.separator + "mydir" + File.separator + "abc.txt"; // (推荐)
        String file2 = "D:" + File.separator + "mydir" + File.separator + "123.txt"; // (推荐)
        // 不推荐下面的写法
        String file11 = "D:\\workspace\\IntellijIDEA\\JavaSEDemo\\src"; // (不推荐)只适配windows，不适配Linux
        String file12 = "D:/workspace/IntellijIDEA"; // (不推荐)只适配Linux，不适配windows

        /*File.pathSeparator：
         *       路径分隔符
         *       注意，在不同的OS中，File.pathSeparator的值是不一样的，在windows中它是‘;’，在linux中它是‘：’*/
        System.out.println("路径分隔符：File.pathSeparator = "+File.pathSeparator);
        // 推荐用法
        String paths = file1 + File.pathSeparator + file2; // (推荐)
        // 不推荐下面的写法
        String paths1 = file1 + ";" + file2; // (不推荐)只适配windows，不适配Linux
        String paths2 = file1 + ":" + file2; // (不推荐)只适配Linux，不适配windows
    }

    /** Description: 展示File类中四个构造函数的用法
     * @author created by Meiyu Chen at 2021-5-8 10:17, v1.0
     */
    private static void demoFileConstructors() {
        /*String path:
        *   路径可以是文件结尾、也可以是目录结尾
        *   路径可以是绝对路径，也可以是相对路径
        *   路径可以是存在的，也可以是不存在的
        *   创建File对象，只是把字符串路径封装成File对象，并不考虑路径的真假情况
        *   你可以把封装出的File对象看作是一个工具类，你可以通过这个工具类来操作真实的文件或路径
        * */
        //  -------------      new File(String path)    ------------------
        // 文件
        String path = "D:" + File.separator + "mydir" + File.separator + "aaa.txt";
        File file = new File(path);
        System.out.println(file.toString()); // D:\mydir\aaa.txt
        // 路径
        String path2 = "D:" + File.separator + "mydir";
        File file1 = new File(path2);
        System.out.println(file1); // D:\mydir
        // 相对路径
        String path3 = "src" + File.separator + "javase";
        File file2 = new File(path3);
        System.out.println(file2); // src\javase

        // -------------    public File(String parent, String child)    -----------
        String parent = "d:" + File.separator + "mydir" + File.separator;
        String child = "aaa.txt";
        String child2 = "subdir" + File.separator + "aaa.txt";
        File file3 = new File(parent, child);
        File file4 = new File(parent, child2);
        System.out.println(file3); // d:\mydir\aaa.txt
        System.out.println(file4); // d:\mydir\subdir\aaa.txt

        // ----------   public File(File parent, String child)  --------
        File parentPath = new File("D:" + File.separator);
        File file5 = new File(parentPath, "subdir" + File.separator + "aaa.txt");
        System.out.println(file5); // D:\subdir\aaa.txt
    }

    /** Description: 展示File类中的成员方法的用法
     * @author created by Meiyu Chen at 2021-5-8 10:50, v1.0
     */
    private static void demoFileMethods() {
//        File file = new File("D:" + File.separator + "aaa.txt");
//        File file1 = new File("aaa.txt");
//        File parent = new File("D:"+File.separator+"parent");
//        File subdir = new File(parent, File.separator + "subdir");
//        File file2 = new File("src" + File.separator + "javase" + File.separator + "demo" + File.separator + "io" + File.separator + "fileoperate" + File.separator + "Main.java");
//
//        // 获取路径信息
//        getPaths(file, file1);
//
//        // 获取文件名或者最后一级目录名
//        getNameDemo(file, file1, parent, subdir);
//
//        // 获取文件大小
//        getFileSize(file, parent);
//
//        // 判断相应的文件 / 文件夹 是否存在，是文件还是文件夹
//        judgement(file, subdir, file2);
//
//        // 创建文件
//        demonstrateCreateNewFile();
//
//        // 创建文件夹
//        demonstrateCreateDir();

//        // 删除文件 、 文件夹
//        demonstrateDelete();

        // 某文件夹下所有文件 && 子文件夹列表
//        demonstrateList();

        // 遍历某目录及其子目录
//        iterXxxDir(new File("D:" + File.separator + "testFile"));

        // 文件过滤器
        demonstrateFileFilter(new File("D:" + File.separator + "testFile"));
    }

    /** Description: 展示文件过滤器的用法
     *      列出文件夹下所有md文件
     * @author created by Meiyu Chen at 2021-5-10 15:05, v1.0
     * @param dir
     */
    private static void demonstrateFileFilter(File dir) {
        // 列出某文件夹下所有md文件（不考虑子文件夹）
//        demonstrateFileFilter1(dir);

        // 列出某文件夹及其子文件夹下所有md文件
//        demonstrateFileFilter2(dir);

        // 展示java.io.FileNameFilter的用法
        demonstrateFileNameFilter(dir);

    }

    /** Description: 展示java.io.FileNameFilter的用法
     * @author created by Meiyu Chen at 2021-5-10 16:36, v1.0
     */
    private static void demonstrateFileNameFilter(File dir) {
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            /*dir:File 待遍历的目录
//             * name:String 待遍历目录中的文件或者子文件夹名称*/
//            public boolean accept(File dir, String name) {
//                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".md");
//            }
//        });

        /*可以使用lambda表达式简化匿名内部类
        * 注意：只有内部只含有一个函数的抽象类/接口，才可以使用lambda表达式
        * 因为FilenameFilter中只有一个抽象方法——accept()，所以这里的匿名内部类可以使用lambda来优化
        * 下面这句代码和上面的代码完全等价
        * */
        File[] files = dir.listFiles((File direc, String name) -> {
            return new File(direc, name).isDirectory() || name.toLowerCase().endsWith(".md");
        });

        for (File file : files) {
            if (file.isDirectory()) {
                // 遍历子目录
                demonstrateFileNameFilter(file);
            }else{
                System.out.println(file);
            }
        }
    }

    /** Description: 列出某文件夹及其子文件夹下所有md文件
     * @author created by Meiyu Chen at 2021-5-10 16:24, v1.0
     */
    private static void demonstrateFileFilter2(File dir) {
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                // 如果是md文件，则添加进列表
//                // 如果是目录，也要添加进列表，因为需要遍历子目录，看看子目录中有没有md文件
////                return dir.isDirectory() || dir.getName().toLowerCase().endsWith(".md");
//                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".md");
//            }
//        });

        /*可以使用lambda表达式简化匿名内部类
         * 注意：只有内部只含有一个函数的抽象类/接口，才可以使用lambda表达式
         * 因为FilenameFilter中只有一个抽象方法——accept()，所以这里的匿名内部类可以使用lambda来优化
         * 下面这句代码和上面的代码完全等价
         * */
        File[] files = dir.listFiles((File pathname)->{
            return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".md");
        });

        for (File file : files) {
            if (file.isDirectory()) {
                // 遍历子目录，看子目录及子目录的子目录中有没有md文件
                demonstrateFileFilter2(file);
            }else {
                System.out.println(file);
            }
        }
    }

    /** Description: 列出某文件夹下所有md文件（不考虑子文件夹）
     * @author created by Meiyu Chen at 2021-5-10 16:22, v1.0
     */
    private static void demonstrateFileFilter1(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".md");
            }
        });

        for (File file : files) {
            System.out.println(file);
        }
    }/* Output: (55% match)
D:\testFile\readme - 副本.md
D:\testFile\readme.md
*///:~


    /** Description: 遍历目录及其子目录
     * @author created by Meiyu Chen at 2021-5-8 17:43, v1.0
     * @param rootDir
     */
    private static void iterXxxDir(File rootDir) {
        File[] files = rootDir.listFiles();
        if (files == null) {
            // 不是目录, 或者目录不存在
            return;
        }
        for (File file : files) {
//            System.out.println("-" + file.getName());
            System.out.println("-" + file);
            if (file.isDirectory()) {
                iterXxxDir(file);
            }
        }

    }

    /** Description: 获取目录下的所有子目录与文件
     * 相关API：
     *      1. public String[] list()
     *      2. public String[] list(FilenameFilter filter)
     *      3. public File[] listFiles()
     *      4. public File[] listFiles(FilenameFilter filter)
     *      5. public File[] listFiles(FileFilter filter)
     * 注意：
     *      1. 只能遍历目录
     *      2. 如果给出的路径不是目录，则返回null
     *      3. 如果给出的路径不存在，则返回null
     *      4. 返回值是：相应目录下所有子文件夹 && 文件 的文件名列表/File对象列表
     * @author created by Meiyu Chen at 2021-5-8 17:00, v1.0
     */
    private static void demonstrateList() {
        File rootDir = new File("D:" + File.separator + "testFile");

        /* list()
            返回D盘根目录下所有文件夹和文件的名称组成的数组
            返回值是String[] */
        String[] list = rootDir.list();
        for (String item : list) { // output:~  aaa.txt	test	我是一个隐藏文件.txt	我是一个隐藏文件夹	新建文件夹
            System.out.print("\t" +item);
        }

        /*listFiles()
            返回D盘根目录下所有文件夹和文件的File对象组成的数组
            返回值是File[]
        * */
        System.out.println();
        File[] files = rootDir.listFiles();
        for (File file : files) { // output:~ D:\testFile\aaa.txt	D:\testFile\test	D:\testFile\我是一个隐藏文件.txt	D:\testFile\我是一个隐藏文件夹	D:\testFile\新建文件夹
            System.out.print("\t"+file);
        }

        // 如果相应目录不存在，则返回null
        File dir2 = new File("D:" + File.separator + "一个不存在的文件夹");
        System.out.println(dir2.list()); // null
        System.out.println(dir2.listFiles()); // null

        // 如果不是一个目录，则返回null
        File dir3 = new File("D:" + File.separator + "testFile" + File.separator + "aaa.txt");
        System.out.println(dir3.list()); // null
        System.out.println(dir3.listFiles()); // null

    }

    /** Description: 演示如何删除文件 文件夹
     *  返回值：
     *      true 成功删除相应的文件/文件夹后，返回true
     *      false 如果相应的文件或文件夹不存在，返回false
     *          如果相应文件夹不为空，其内部有子文件夹或者文件，则不执行删除操作，返回false
     *  注意：
     *      delete() 是直接“永久性删除”相应文件，不走回收站，使用时一定要谨慎
     * @author created by Meiyu Chen at 2021-5-8 16:30, v1.0
     */
    private static void demonstrateDelete() {
        File file = new File("subdir" + File.separator + "新建文件夹");
        // 在项目根目录下创建了多级子目录，D:\workspace\IntellijIDEA\JavaSEDemo\subdir\新建文件夹
//        file.mkdirs();
        // 删除了项目根目录下subdir文件夹下的“新建文件夹”这个子目录，并返回true
//        System.out.println(file.delete());
        File file1 = new File("substr" + File.separator + "AAA");
        // 在项目根目录下创建了 substr/AAA/子文件夹
//        file1.mkdirs();
        File file2 = new File(file1, "123.txt");
//        try {
//            // 在substr/AAA/子文件夹 下创建了123.txt
//            file2.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 由于substr/AAA/子文件夹 不为空，所以无法删除该子文件夹，返回false
//        System.out.println(file1.delete()); // false
        // 删除了substr/AAA/子文件夹下的123.txt,并返回true
        System.out.println(file2.delete()); //true
        // 待删除的文件夹：“新建文件夹”，不存在，无需执行删除操作，直接返回false
        System.out.println(file.delete()); // false
        // 上面已经删除了相应的文件器123.txt, 文件已经不存在了，无需执行删除操作，直接返回false
        System.out.println(file2.delete()); // false
        System.out.println(file1.delete()); // false
        System.out.println(new File("substr").delete()); // true
        System.out.println(new File("subdir").delete()); // true
    }

    /** Description: 演示如何创建文件夹
     *  mkdir()只能创建单级文件夹
     *  mkdirs()可以创建单级以及多级文件夹
     *  返回值：
     *      1. true 待创建的文件夹不存在时，创建相应文件夹，并且返回true
     *      2. false 待创建的文件夹已经存在时，不创建，并返回false
     *  注意：
     *      1. 此方法只能创建文件夹，不能创建文件
     *      2. 如果存在同名的文件（文件类型已知），会创建文件夹并返回true（如相应目录下存在“aaa.txt” 时，会创建名称为aaa的文件夹）
     *      2. 如果存在同名的文件（文件类型未知），不会创建文件夹并返回false（如相应目录下存在“aaa.xx这种类型未知的文件” 时，不会创建名称为aaa的文件夹）
     * @author created by Meiyu Chen at 2021-5-8 15:45, v1.0
     */
    private static void demonstrateCreateDir() {
        File file = new File("D:" + File.separator + "新建文件夹");
        // 会在D盘创建名称为“新建文件夹”的文件夹，并且返回true
        System.out.println(file.mkdir()); // true
        // 因为前面已经创建了相应文件夹，相应文件夹已经存在了，不会再次创建，直接返回false
        System.out.println(file.mkdir()); // false

        // mkdir(): 父目录并非真实存在时，不会创建文件夹，并返回false
        // mkdirs()：父目录并非真实存在时，会创建多级子目录，并返回true
        File file1 = new File("D:" + File.separator + "subdir" + File.separator + "新建文件夹");
        /*mkdir()只能创建单级目录，由于“D:\subdir\”父目录并不存在，mkdir()无法再并不存在的父目录中创建文件夹，
        所以mkdir()不会创建目录，且返回false
        注意：这个过程中不会抛出异常哦*/
        System.out.println(file1.mkdir()); // false
        // 创建多级目录D:\subdir\新建文件夹，并返回true
        System.out.println(file1.mkdirs());
        // mkdirs在并不存在的父路径中创建子目录
        File file2 = new File("subdir" + File.separator + "新建文件夹");
        // 会在项目根目录下创建多级子目录，D:\workspace\IntellijIDEA\JavaSEDemo\subdir\新建文件夹
        System.out.println(file2.mkdirs()); // true

    }

    /** Description: 展示创建文件的方法- use createNewFile()
     * 返回值：
     *      true：文件不存在时，创建文件，返回true
     *      false：文件已经存在时，不会创建文件，返回false
     * 注意：
     *      1. 此方法只能创建文件，不能创建文件夹
     *      2. 路径必须是真实的，否则会抛出异常
     *      3. 如果相应目录下存在同名文件夹，则不会创建相应的文件
     * 参考资料：
     *      1. [视频-java-File#createNewFile()](https://www.bilibili.com/video/BV1U4411V7rq?p=7&spm_id_from=pageDriver)
     * @author created by Meiyu Chen at 2021-5-8 14:23, v1.0
     */
    private static void demonstrateCreateNewFile() {
        try {
//            // 可以使用绝对路径
//            File file = new File("D:" + File.separator + "a.txt");
//            System.out.println(file.createNewFile()); // true 在D盘下创建了a.txt文件并返回true
//            System.out.println(file.createNewFile()); // false 因为前面已经创建了相应的文件，所以文件已经存在，不会再次创建
//
//            // 也可以使用相对路径
//            File file1 = new File("b.txt");
//            // 将会在项目根目录（D:\workspace\IntellijIDEA\JavaSEDemo）下创建b.txt 并返回true
//            System.out.println(file1.createNewFile());

            /*只可以创建文件，不可以创建文件夹
            * */
            File file3 = new File("D:" + File.separator + "新建文件夹");
            // 会在D盘创建一个名称为“新建文件夹”的文件，文件类型未知
            // 注意，创建出的是文件，不是文件夹哦
            System.out.println(file3.createNewFile()); // true

//            // 若路径（待创建文件的父目录）不是真实存在的，则会抛出异常
//            File file2 = new File("D:" + File.separator + "subdir" + File.separator + "c.txt");
//            /*由于D盘下并没有subdir文件夹, 所以在并不存在的文件夹中创建文件是不会成功的
//            * 运行时异常：java.io.IOException: 系统找不到指定的路径。*/
//            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Description: 判断相应的文件 / 文件夹 是否存在，相应路径是文件还是文件夹
     * @author created by Meiyu Chen at 2021-5-8 14:09, v1.0
     */
    private static void judgement(File file, File subdir, File file2) {
        // 文件或目录是否存在（可以是相对路径或绝对路径）
        System.out.println(file.exists());
        System.out.println(subdir.exists());
        System.out.println(file2.exists());

        /*注意：
            在OS中，isDirectory()和isFile()是互斥的，即相应路径不是目录就是文件
            在使用isDirectory()和isFile()判断之前，请先确保路径真实存在
            如果相应文件或文件夹不存在，则isDirectory()和isFile()都返回false
        * */
        System.out.println(file.isDirectory()); // false 因为路径不存在
        System.out.println(file.isFile()); // false 因为路径不存在
        System.out.println(file2.isDirectory()); // false
        System.out.println(file2.isFile()); // true
        // 推荐用法：先保证相应路径是真实存在的，再去判断是目录还是文件，否则得不到正确的结果
        if (file.exists()) {
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
        }
    }

    private static void getFileSize(File file, File parent) {
        /*获取文件大小：length()
        *   只能获取文件大小，文件夹是没有大小的
        *   如果相应的文件不存在，则返回值为0
        *   单位：字节 */
        System.out.println(file.length()); // 0 不存在的文件，返回值是0
        System.out.println(parent.length()); // 0 文件夹没有大小概念，所以返回值是0
    }

    /** Description: 展示getName()的用法
     * @author created by Meiyu Chen at 2021-5-8 13:49, v1.0
     */
    private static void getNameDemo(File file, File file1, File parent, File subdir) {
        /* getName():获取文件名或者最后一级目录名
        *       该方法返回的是构造方法传入的字符串的最后一级（可能是文件，也可能是目录）*/
        System.out.println(file.getName()); // aaa.txt
        System.out.println(file1.getName()); // aaa.txt
        System.out.println(parent.getName()); // parent
        System.out.println(subdir.getName()); // subdir
    }

    /** Description: 使用File成员方法获取路径信息
     * @author created by Meiyu Chen at 2021-5-8 11:25, v1.0
     */
    private static void getPaths(File file, File file1) {
        /*获取 文件/目录 路径*/
        /*getAbsolutePath()
        *   返回绝对路径
        *   无论构造函数传入的是相对路径还是绝对路径，返回的都是绝对路径（以盘符开始的路径）*/
        System.out.println(file.getAbsolutePath()); // D:\aaa.txt
        System.out.println(file1.getAbsolutePath()); // D:\workspace\IntellijIDEA\JavaSEDemo\aaa.txt
        /*getPath()
        *   等价于toString()，File#toString()中调用的就是getPath()
        *   构造函数传入什么值，返回的就是什么值*/
        System.out.println(file.getPath()); // D:\aaa.txt
        System.out.println(file1.getPath()); // aaa.txt
        // getPath() === toString()
        System.out.println(file);
        System.out.println(file1.toString());
    }
}
