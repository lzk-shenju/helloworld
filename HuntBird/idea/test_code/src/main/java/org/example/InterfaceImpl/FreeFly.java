package org.example.InterfaceImpl;

import org.example.Interfaces.FlyBehavior;

public class FreeFly implements FlyBehavior {
    @Override
    public void Fly() {
        System.out.println("飞翔蓝天！");
    }
}
