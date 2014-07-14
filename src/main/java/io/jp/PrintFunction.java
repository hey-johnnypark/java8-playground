package io.jp;

import java.util.function.Consumer;

public class PrintFunction implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println(t);
    }

}
