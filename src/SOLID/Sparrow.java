package SOLID;

public class Sparrow extends Bird implements Flyable{
    private FlyingBehaviour fb;
    public Sparrow(FlyingBehaviour fb){
        this.fb = fb;
    }
    public void makeSound(){
        System.out.println("Sparrow making sound");
    }
    public void fly(){
        fb.executeFly();
    }
}

