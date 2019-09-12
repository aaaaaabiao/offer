package company.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Rank {

    public static int minValue(Property[] propertys) {

        Arrays.sort(propertys, new Comparator<Property>() {
            @Override
            public int compare(Property o1, Property o2) {
                if (o1.a == o2.a) {
                    return o1.b - o2.b;
                }else {
                    return o2.a - o1.a;
                }

            }
        });
        int len = propertys.length;
        int min = 0;
        for (int i = 0; i < len; i++) {
            Property p = propertys[i];
            min += (p.a * (i) + p.b * (len - 1 - i));
        }
        return min;
    }

    public static class Property{
        public int a;
        public int b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Property[] property = new Property[n];
        for (int i = 0; i < n; i++) {
            property[i] = new Property();
            property[i].a = scanner.nextInt();
            property[i].b = scanner.nextInt();
        }

        int min = minValue(property);
        System.out.println(min);

    }
}
