package org.example.Entity;

import org.example.InterfaceImpl.FreeFly;
import org.example.Interfaces.FlyBehavior;
import org.example.Interfaces.SwimBehavior;

public class Eagle extends Bird{

    public Eagle(FlyBehavior flyBehavior, SwimBehavior swimBehavior) {
        super(flyBehavior, swimBehavior);
    }

    @Override
    public void fly() {
        flyBehavior.Fly();
    }

    @Override
    public void swim() {
        swimBehavior.swim();
    }


    public void display() {
        System.out.println("我是一只老鹰");
    }
}
