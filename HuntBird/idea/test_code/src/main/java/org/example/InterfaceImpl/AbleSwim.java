package org.example.InterfaceImpl;

import org.example.Interfaces.SwimBehavior;

public class AbleSwim implements SwimBehavior {

    @Override
    public void swim() {
        System.out.println("鱼翔浅底！");
    }
}
