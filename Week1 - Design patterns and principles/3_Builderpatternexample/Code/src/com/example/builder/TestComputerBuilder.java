// package com.example.builder;

public class TestComputerBuilder {

    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", 8).build();
        System.out.println("Basic Computer: " + basicComputer);

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", 32)
                .storage(1024)
                .graphicsCardEnabled(true)
                .bluetoothEnabled(true)
                .build();
        System.out.println("Gaming Computer: " + gamingComputer);

        Computer officeComputer = new Computer.Builder("Intel i7", 16)
                .storage(512)
                .bluetoothEnabled(true)
                .build();
        System.out.println("Office Computer: " + officeComputer);
    }
}
