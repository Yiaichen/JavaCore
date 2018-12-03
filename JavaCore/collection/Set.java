package JavaCore.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Set
 */
public class Set {

    public static void main(String[] args) {
        java.util.Set<String> set = new HashSet<String>();
        set.add(null); //���Բ����ֵ
        set.add("");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        System.out.println(set.contains(null));

        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            if (iterator.hasNext()) {
                String next = iterator.next();
                System.out.println(next);
            }
        }
    }
}
