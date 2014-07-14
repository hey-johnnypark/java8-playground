package io.jp.main;

import io.jp.Helpers;
import io.jp.interfaces.ClassA;
import io.jp.interfaces.ClassB;

public class DefaultInterfaces {

    public static void main(String[] args) {

        Helpers.printHeading("Demonstrates use of classes implementing interfaces with default methods");
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        classA.alreadyImplemented();
        classA.implementMe();

        classB.alreadyImplemented();
        classB.implementMe();

    }
}
