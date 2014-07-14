package io.jp.interfaces;

public interface DefaultInterface {

    public default void alreadyImplemented() {
        System.out.printf("I am already implemented and used by %s\n", getClass());
    }

    // Normal interface method which needs to be implemented by concrete class
    public void implementMe();

}
