package SOLID;

public class Eagle extends Bird implements Flyable{
    private FlyingBehaviour fb;
    public Eagle(FlyingBehaviour fb){
        this.fb = fb;
    }
    public void makeSound(){
        System.out.println("Eagle making sound");
    }
    public void fly(){
        fb.executeFly();
    }
}
