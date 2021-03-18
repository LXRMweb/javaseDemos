package javase.demo.equals;

import java.util.Objects;

public class TestEquals {
    public static void main(String[] args) {
        Integer i1 = new Integer(22);
        Integer i2 = new Integer(22);
        System.out.println("使用‘==’比较两个内容相同的对象，rst=" + (i1 == i2));
        System.out.println("使用‘equals()’比较两个内容相同的对象，rst=" + i1.equals(i2));
        System.out.println("结论：==比较的是对象的引用，equals()比较的是对象的内容");
        System.out.println("java类库中的对象一般都override了equals(),开发者可以直接调用，比较两个对象的内容是否相等");
        System.out.println("自定义类库如果不override equals(), 就会得到意想不到的结果，因为equals()的默认行为是比较两个class对象的引用");
        System.out.println("没有实现equals()的自定义类对象：new NotOverrideEquals(12,‘小明’).equals(new NotOverrideEquals(12,‘小明’)) = "+new NotOverrideEquals(12,"小明").equals(new NotOverrideEquals(12,"小明")));
        System.out.println("实现equals()的自定义类对象：new OverrideEquals(12,‘小明’).equals(new OverrideEquals(12,‘小明’)) = "+new OverrideEquals(12,"小明").equals(new OverrideEquals(12,"小明")));
    }

    private static class NotOverrideEquals{
        private int age;
        private String name;

        public NotOverrideEquals(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    private static class OverrideEquals{
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
*///:~
