// package com.example.builder;

public class Computer {

    private final String CPU;
    private final int RAM;
    private final int storage;
    private final boolean graphicsCardEnabled;
    private final boolean bluetoothEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCardEnabled = builder.graphicsCardEnabled;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    public static class Builder {
        private final String CPU;
        private final int RAM;
        private int storage = 256;
        private boolean graphicsCardEnabled = false;
        private boolean bluetoothEnabled = false;

        public Builder(String CPU, int RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCardEnabled(boolean enabled) {
            this.graphicsCardEnabled = enabled;
            return this;
        }

        public Builder bluetoothEnabled(boolean enabled) {
            this.bluetoothEnabled = enabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB, GraphicsCard="
                + graphicsCardEnabled
                + ", Bluetooth=" + bluetoothEnabled + "]";
    }
}
