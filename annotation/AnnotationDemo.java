package annotation;

import java.lang.reflect.Field;

public class AnnotationDemo {

    @MyAnnotation(age = 20)
    public int age;
    @MyAnnotation(name = "cheng")
    public String name;

    public static void main(String[] args) {
        AnnotationDemo ages = new AnnotationDemo();
        // 获取属性
        Field[] fields = ages.getClass().getFields();
        for (Field field : fields) {
            MyAnnotation annotation2 = field.getAnnotation(MyAnnotation.class);
            annotation2.getClass().getCanonicalName();
            System.out.println(annotation2.getClass().getCanonicalName());
            if (field.getName().equals("")) {

            }
        }
        System.out.println(ages.name + "cheng" + ages.age);

    }


}
