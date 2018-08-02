package javaDemo.Annotation;

import java.lang.reflect.Field;

public class AnnotationDemo {

    @MyAnnotation(age = 20)
    public int age;
    @MyAnnotation(name = "cheng")
    public String name;

    public static void main(String[] args) {
        AnnotationDemo ages = new AnnotationDemo();
        //?????????????
        Field[] fields = ages.getClass().getFields();
        for (Field field : fields) {
            MyAnnotation annotation2 = field.getAnnotation(MyAnnotation.class);
            annotation2.getClass().getCanonicalName();
            System.out.println(annotation2.getClass().getCanonicalName());
            if (field.getName().equals("")) {

            }
				
			
			/*if(annotation2.age()!=0) {
				ages.age = annotation2.age();
			}
			if(annotation2.name()!="")
			{
				ages.name = annotation2.name();
			}*/


        }
        System.out.println(ages.name + "????" + ages.age);
		/*//?????????????????????????????
		Annotation[] an = ages.getClass().getAnnotations();
		
		//????????????????????????????У?
	    Annotation[] an2 = ages.getClass().getDeclaredAnnotations();*/


//		System.out.println(ages.age);
    }


}
