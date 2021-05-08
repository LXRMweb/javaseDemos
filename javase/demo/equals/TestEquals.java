package javase.demo.equals;

import java.util.Objects;

/** Description: 展示 == 和 equals的不同
 *      一般情况下，==比较的是两个对象的引用，而非两个对象的内容
 *      equals()的默认行为也是比较两个对象的引用，自定义类中重写equals()可以实现比较对象内容的需求
 *      javaSE 类库中的类一般都override了equals(), 开发者可以直接使用它来比较相应对象的内容是否相同
 * @author created by Meiyu Chen at 2021-3-19 9:43, v1.0
 */
public class TestEquals {
    public static void main(String[] args) {
        Integer i1 = new Integer(22);
        Integer i2 = new Integer(22);
        System.out.println("使用‘==’比较两个内容相同的对象，rst=" + (i1 == i2));
        System.out.println("使用‘equals()’比较两个内容相同的对象，rst=" + i1.equals(i2));
        System.out.println("结论：==比较的是对象的引用，equals()比较的是对象的内容");
        System.out.println("java类库中的对象一般都override了equals(),开发者可以直接调用，比较两个对象的内容是否相等");
        System.out.println("自定义类库如果不override equals(), 就会得到意想不到的结果，因为equals()的默认行为是比较两个class对象的引用");
        System.out.println("没有实现equals()的自定义类对象：new NotOverrideEquals(12,‘小明’).equals(new NotOverrideEquals(12,‘小明’)) = " + new NotOverrideEquals(12, "小明").equals(new NotOverrideEquals(12, "小明")));
        System.out.println("实现equals()的自定义类对象：new OverrideEquals(12,‘小明’).equals(new OverrideEquals(12,‘小明’)) = " + new OverrideEquals(12, "小明").equals(new OverrideEquals(12, "小明")));
        stringEqualsDemo();
    }

    /**
     * Description: 测试两个字符串是否相等
     *
     * @author created by Meiyu Chen at 2021-3-19 9:36, v1.0
     */
    private static void stringEqualsDemo() {
        String s1 = "123";
        String s2 = "123";
        System.out.println("判断两个字符串是否相等：String s1 = \"123\" String s2 = \"123\" s1==s2，\t" + (s1 == s2));
        System.out.println("判断两个字符串是否相等：String s1 = \"123\" String s2 = \"123\" s1!=s2，\t" + (s1 != s2));
        System.out.println("判断两个字符串是否相等：String s1 = \"123\" String s2 = \"123\" s1.equals(s2)，\t" + s1.equals(s2));
        String s3 = new String("123");
        String s4 = new String("123");
        System.out.println("判断两个字符串是否相等：String s1 = \"123\" String s2 = \"123\" s1==s2，\t" + (s3 == s4));
        System.out.println("判断两个字符串是否相等：String s1 = \"123\" String s2 = \"123\" s1!=s2，\t" + (s3 != s4));
        System.out.println("判断两个字符串是否相等：String s1 = \"123\" String s2 = \"123\" s1.equals(s2)，\t" + s3.equals(s4));
    }

    private static class NotOverrideEquals {
        private int age;
        private String name;

        public NotOverrideEquals(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    private static class OverrideEquals {
        private int age;
        private String name;

        public OverrideEquals(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OverrideEquals that = (OverrideEquals) o;
            return age == that.age &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}/* Output: (100% match)
使用‘==’比较两个内容相同的对象，rst=false
使用‘equals()’比较两个内容相同的对象，rst=true
结论：==比较的是对象的引用，equals()比较的是对象的内容
java类库中的对象一般都override了equals(),开发者可以直接调用，比较两个对象的内容是否相等
自定义类库如果不override equals(), 就会得到意想不到的结果，因为equals()的默认行为是比较两个class对象的引用
没有实现equals()的自定义类对象：new NotOverrideEquals(12,‘小明’).equals(new NotOverrideEquals(12,‘小明’)) = false
实现equals()的自定义类对象：new OverrideEquals(12,‘小明’).equals(new OverrideEquals(12,‘小明’)) = true
false
s1.equals(s2)，	true
*///:~
