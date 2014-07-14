package io.jp;

public class Helpers {

    public static void printHeading(String heading) {
        System.out.println(heading);
        for (int i = 0; i < heading.length(); i++) {
            System.out.print("#");
        }
        System.out.println();
    }

}
