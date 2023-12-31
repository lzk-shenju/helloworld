package org.example;

import org.example.Entity.Eagle;
import org.example.InterfaceImpl.FreeFly;
import org.example.InterfaceImpl.UnableSwim;

public class Client {
    public static void main(String[] args) {
        FreeFly freeFly = new FreeFly();
        UnableSwim unableSwim = new UnableSwim();
        Eagle eagle = new Eagle(freeFly, unableSwim);
        eagle.display();
        eagle.fly();
        eagle.swim();
    }
}