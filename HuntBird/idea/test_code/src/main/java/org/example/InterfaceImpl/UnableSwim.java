package org.example.InterfaceImpl;

import org.example.Interfaces.SwimBehavior;

public class UnableSwim implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("扑腾几下就淹死了！");
    }
}
