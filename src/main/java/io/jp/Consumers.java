package io.jp;

import java.util.function.Consumer;

public class Consumers {

    /**
     * Is equal to:
     * public class PrintFunction implements Consumer<String> {
     * 
     * @Override
     *           public void accept(String t) {
     *           System.out.println(t);
     *           }
     * 
     *           }
     **/
    public static final Consumer<String> PRINT_FUNCTION_LAMBDA = input -> System.out.println(input);

}
