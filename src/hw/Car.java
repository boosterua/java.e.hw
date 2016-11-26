package hw;

    abstract class Vehicle{
        String carModel;
        public int gasVolume;
        Wheel[] wheels = new Wheel[4];
        Engine engine;
        abstract public Integer changeTire(Integer ww);
        abstract public void drive();
        
        public int getGasVolume(){
            return gasVolume;
        }
        
        public void addGasVolume(int delta){
            gasVolume+=delta;
        }
    }
    
    public class Car extends Vehicle{
        public static int wheelId = 0;
        private int newCarInitialized = 0;
        public String state = "";
        
        Car BuildACar(){
            if(newCarInitialized++==1) return this;
            for (int i=0; i < wheels.length; i++){
                wheels[i] = new Wheel();
            }
            this.engine = new Engine();
            return this;
        }
        
        public Integer changeTire(Integer nr){
            try{ //System.out.println(nr);
                wheels[nr-1].changeTire();
                return (nr);                
            } catch (Exception e){
                System.out.println("Couldn't change the tire. Can't drive further. Please call your service company.");
                //throw e;
            }
            return 0;
        }
        
        public void drive(){
            state = "Driving";
            engine.drive();
        }
        
        public void stop(){
            state = "Stopped";            
            engine.stop();
        }
        public void refuel(int volume){
            addGasVolume(+volume);
            System.out.printf("Thank you for refueling. My tank now holds %d liters of gas.\n", gasVolume);
        }
        
        void setCarModel(String model){
            this.carModel = model;
            System.out.println("Your car model is: " + carModel);
        }
        
        public String getCarModel(){
            return this.carModel;
        }
        

    }
    
    class Wheel extends Car{
        int wheel;
        public Wheel() {
            wheelId++;
            System.out.println("New wheel produced and "+ wheelId +" assembled.");
            this.wheel=wheelId;
        }
        public int changeTire(){
            System.out.println("Tire nr "+ this.wheel + " has been changed! Let's drive on ;)");
            return wheel;
        }
    }
    
    class Engine extends Car{
        public int enigineId = 0;
        Engine(){
            System.out.println("New engine installed.");
            this.enigineId++;
        }
        public void drive(){
            state = "Engine  Started";
        }
        
        public void stop(){
            state = "Engine Stopped";            
        }
    };
    