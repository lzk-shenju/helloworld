package org.example.Entity;

import org.example.Interfaces.FlyBehavior;
import org.example.Interfaces.SwimBehavior;

public class Piegeon extends Bird{

    public Piegeon(FlyBehavior flyBehavior, SwimBehavior swimBehavior) {
        super(flyBehavior, swimBehavior);
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }


    public void display() {

    }
}
