package javase.demo.lambda;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        
    }

    /** Description: 列出某文件夹及其子文件夹下所有md文件
     * @author created by Meiyu Chen at 2021-5-10 16:24, v1.0
     */
    private static void demonstrateFileFilter2(File dir) {
        // step1，匿名内部类
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                // 如果是md文件，则添加进列表
//                // 如果是目录，也要添加进列表，因为需要遍历子目录，看看子目录中有没有md文件
////                return dir.isDirectory() || dir.getName().toLowerCase().endsWith(".md");
//                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".md");
//            }
//        });

        /*step2，可以使用lambda表达式简化匿名内部类
         * 注意：只有内部只含有一个函数的抽象类/接口，才可以使用lambda表达式
         * 因为FilenameFilter中只有一个抽象方法——accept()，所以这里的匿名内部类可以使用lambda来优化
         * 下面这句代码和上面的代码完全等价
         * */
//        File[] files = dir.listFiles((File pathname)->{
//            return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".md");
//        });

        /*step3，可以进一步简化上述代码
        * 简化1，可以省略掉参数类型
        * 简化2，如果方法体中只有一行代码，可以省略掉花括号和return*/
        File[] files = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".md"));

        for (File file : files) {
            if (file.isDirectory()) {
                // 遍历子目录，看子目录及子目录的子目录中有没有md文件
                demonstrateFileFilter2(file);
            }else {
                System.out.println(file);
            }
        }
    }

    /** Description: 列出某文件夹及其子文件夹下所有md文件
     * @author created by Meiyu Chen at 2021-5-10 16:36, v1.0
     */
    private static void demonstrateFileNameFilter(File dir) {
        // step1，匿名内部类
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            /*dir:File 待遍历的目录
//             * name:String 待遍历目录中的文件或者子文件夹名称*/
//            public boolean accept(File dir, String name) {
//                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".md");
//            }
//        });

        /* step2, 可以使用lambda表达式简化匿名内部类
         * 注意：只有内部只含有一个函数的抽象类/接口，才可以使用lambda表达式
         * 因为FilenameFilter中只有一个抽象方法——accept()，所以这里的匿名内部类可以使用lambda来优化
         * 下面这句代码和上面的代码完全等价
         * */
//        File[] files = dir.listFiles((File direc, String name) -> {
//            return new File(direc, name).isDirectory() || name.toLowerCase().endsWith(".md");
//        });

        /*step3，可以进一步简化上述代码
         * 简化1，可以省略掉参数类型
         * 简化2，如果方法体中只有一行代码，可以省略掉花括号和return*/
        File[] files = dir.listFiles((direc, name) -> new File(direc, name).isDirectory() || name.toLowerCase().endsWith(".md"));

        for (File file : files) {
            if (file.isDirectory()) {
                // 遍历子目录
                demonstrateFileNameFilter(file);
            }else{
                System.out.println(file);
            }
        }
    }
}
