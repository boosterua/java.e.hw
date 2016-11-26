package hw;

import old.HW;

public class Task07_2 extends HW  {
    /*
    	Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
           Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
    */
    {
        print_header(7,"Car-wheel-engine");
    }
    public Task07_2() {
        Car myCar = new Car().BuildACar();
        myCar.setCarModel("Audi Q7");
        myCar.refuel(10);
        myCar.drive();
        myCar.refuel(20);
        myCar.changeTire(1);
        myCar.drive();
    }
}


  abstract class Vehicle{
        String carModel;
        static int gasVolume = 0;
        Wheel[] wheels = new Wheel[4];
        Engine engine;
        public void changeTire(int ww){};
        public void drive(){};
  }
    
    class Car extends Vehicle{
        public static int wheelId=0;

        public Car BuildACar(){
            for (int i=0; i < wheels.length; i++){
                wheels[i] = new Wheel();
            }
            engine = new Engine();
            return this;
        }
        
        public void refuel(int volume){
            setGasVolume(+volume);
            System.out.printf("Thank you for refueling. My tank now holds %d liters of gas.\n", gasVolume);
        }
        
        void setCarModel(String model){
            this.carModel = model;
            System.out.println("Your car model is: " + carModel);
        }
        
        public String getCarModel(){
            return this.carModel;
        }
        
        public int getGasVolume(){
            return this.gasVolume;
        }
        
        public void setGasVolume(int delta){
            this.gasVolume+=delta;
        }
        
        public void changeTire(int nr){
            try{ //System.out.println(nr);
                wheels[nr-1].changeTire();
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Couldn't change the tire. Can't drive further. Please call your service company.");
            }
        }        
        public void drive(){
            engine.drive();
        }        
    }
    
    class Wheel extends Car{
        int wheel;
        public Wheel() {
            wheelId++;
            System.out.println("New wheel "+ wheelId +" assembled.");
            this.wheel=wheelId;
        }
        
        public void changeTire(){
            System.out.println("Tire nr "+ this.wheel + " has been changed! Let's drive on ;)");
        }
    }
    
    class Engine extends Car{
        Engine(){
            System.out.println("New engine installed.");
        }
        public void drive(){
            System.out.println("Engine started. Let's go!");
            for (int v = getGasVolume(); v>0; v--){
                System.out.print(v+"->");
                setGasVolume(-1);
            }
            System.out.println("0. No more gas. Please add some fuel.");
        }
    };
    