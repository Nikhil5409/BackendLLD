package SOLID;

public abstract class Bird {
    private String name;

    public void eat(){
        System.out.println("Eating : ");
    }

    public abstract void makeSound();
}
