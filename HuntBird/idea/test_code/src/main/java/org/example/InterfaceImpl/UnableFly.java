package org.example.InterfaceImpl;

import org.example.Interfaces.FlyBehavior;

public class UnableFly implements FlyBehavior {
    @Override
    public void Fly() {
        System.out.println("飞不起来！");
    }
}
