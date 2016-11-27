package hw;

    abstract class Vehicle{
        String carModel;
        public int gasVolume;
        Wheel[] wheels = new Wheel[4];
        abstract public Integer changeTire(Integer ww);
        abstract public void drive();
        
        public int getGasVolume(){
            return gasVolume;
        }
        
        public void addGasVolume(int delta){
            gasVolume+=delta;
        }
    }
    


    class Car extends Vehicle{
        
        public static int wheelId = 0;
        public String state = "";
        Engine engine;
        
        public Car(){
            System.out.println("newWheel="+0);
            engine = new Engine();
            for (int i=0; i < wheels.length; i++){
                wheels[i] = new Wheel(i);
            }
        }
        


        
        public Integer changeTire(Integer nr){
            try{ //System.out.println(nr);
                return  wheels[nr-1].changeTire()+1;
            } catch (Exception e){
                System.out.println("Couldn't change the tire. Can't drive further. Please call your service company.");
//                throw e;
            }
            return 0;
        }
        
        public void drive(){
            state = "Driving";
            gasVolume = engine.drive(gasVolume);
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
    
    class Wheel {
        private int wheelId;
        public Wheel(int id) {
            wheelId = id;
            System.out.println("New wheel "+ id +" produced and assembled.");
        }
        public int changeTire(){
            System.out.println("Tire for wheel id "+ this.wheelId + " has been changed! Let's drive on ;)");
            return this.wheelId;
        }
    }
    
    class Engine {
        public int enigineId = 0;
        public String state = "";
        Engine(){
            System.out.println("New engine installed.");
            this.enigineId++;
        }
        public int drive(int gasVolume){
            state = "Engine  Started. Gas: " + gasVolume;
            for (int v = gasVolume; v>0; v--){
                System.out.print(v+"->");
                gasVolume--;
            }
            return gasVolume;
        }
        public void stop(){
            state = "Engine Stopped";            
        }
    };
    