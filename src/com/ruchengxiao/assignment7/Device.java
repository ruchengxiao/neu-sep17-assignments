package com.ruchengxiao.assignment7;
//Problem 3
class Root {
    public static void main(String[] args) { // score 2

        Device device = new Device();
        Sensor heat = new Sensor(device);
        Sensor pressure = new Sensor(device);

        Controller controller = new Controller(device, heat, pressure);

        controller.start();
        heat.start();
        pressure.start();
    }
}

class Controller extends Thread {
    Device device;
    Sensor heat;
    Sensor pressure;
    public Controller(Device device, Sensor heat, Sensor pressure) {
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    @Override
    public void run() {
        device.startup();
        synchronized (device) {
            while (heat.getValue() <= 70 && pressure.getValue() <= 100) {
                try {
                    device.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("heat -> " + heat.getValue() + " , " + "pressure -> " + pressure.getValue());
            }

        }

        heat.stop();
        pressure.stop();
        device.shutdown();

    }
}
class Device {
    public void startup() {
        System.out.println("Device started");
    }

    public void shutdown() {

        System.out.println("Device shutting down due to maintenance");
    }
}

class Sensor extends Thread {
    private final Device device;
    private double value;

    public Sensor(Device device) {
        this.device = device;
    }
    public double getValue() {
        return value;
    }
    public void updateValue() {
        this.value += 0.01; // you check with other values here and see how it works
    }
    public void run() {
        while (true) {
            synchronized (device) {
                double oldValue = value;
                updateValue();
                if (value != oldValue) {
                    device.notifyAll();
                }
            }
        }
    }
}
