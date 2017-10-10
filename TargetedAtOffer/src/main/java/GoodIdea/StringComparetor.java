package GoodIdea;

import java.util.Comparator;

/**
 * Created by ss14 on 2017/5/16.
 */
public class StringComparetor implements Comparator<String> {

    public int compare(String o1, String o2) {
        return (o1+o2).compareTo(o2+o1);
       // return o1.compareTo(o2);
    }
}
