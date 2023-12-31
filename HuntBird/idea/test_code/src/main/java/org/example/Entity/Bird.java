package org.example.Entity;

import org.example.Interfaces.FlyBehavior;
import org.example.Interfaces.SwimBehavior;

public abstract class Bird {
    public FlyBehavior flyBehavior;
    public SwimBehavior swimBehavior;
    /**
     @roseuid 657FBC5B0114
     */
    public Bird(FlyBehavior flyBehavior, SwimBehavior swimBehavior) {
        this.flyBehavior = flyBehavior;
        this.swimBehavior = swimBehavior;
    }

    public abstract void fly();
    public abstract void swim();

    /**
     @return Void
     @roseuid 657FB37A01A2
     */
    public void display()
    {

    }
}
