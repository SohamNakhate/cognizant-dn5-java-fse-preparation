// STEPS FOR SINGLETON
// 1. Create a private static object in the same class
// 2. Create a private constructor 
// 3. Create a public static method that returns the instance of object. 


class Singleton{


    //private static Singleton obj = new Singleton();   - EAGER INITIALIZATION
    //private static volatile Singleton obj;  - DOUBLE CHECKED LOCKING 
    private static Singleton obj;  

    private Singleton(){
    }

    // public static Singleton getInstance(){
    //     return obj; 

    // LAZY INITIALIZATION
    public static Singleton getInstance(){
        if(obj == null)
            obj = new Singleton(); 
        
        return obj; 
    }

    //Thread safe 
    // public static synchronized Singleton getInstance(){
    //     if(obj == null){
    //         obj = new Singleton(); 
    //     }
    //     return obj; 
    // }


    // DOUBLE CHECKED LOCKING
    // public static Singleton getInstance(){ // add volatile to the initialzation
    //     // To make it thread safe 
    //     if(obj == null){
    //         synchronized(Singleton.class){
    //             // check again as multiple threads can reach till this point. 
    //             if(obj == null)
    //                 obj = new Singleton(); 
    //         }
    //     }
    //     return obj; 
    // }
    
}




public class Main{
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance(); 
        Singleton s2 = Singleton.getInstance(); 
    
        System.out.println(s1 == s2);
    }
}