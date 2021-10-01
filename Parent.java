public class Parent {    
    public Parent() {
        System.out.println("Parent Constructor");
    }    
    static {
        System.out.println("Parent static block");    
    }    
    {
        System.out.println("Parent initialisation  block");
    }
}
