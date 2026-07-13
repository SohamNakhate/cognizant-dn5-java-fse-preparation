//package Creational.Factory;


// Product interface
interface Notification{
    public void notify_1(); 
}

// Concrete creator
class EmailNotification implements Notification{
    public void notify_1(){
        System.out.println("Email Notification");
    }
}
class SMSNotification implements Notification{
    public void notify_1(){
        System.out.println("SMS Notification");
    }
}

//Creator - delcares factory method
abstract class NotificationFactory{
    abstract Notification createNotification(); 
}

// Concrete Creator - implements factory method 
class EmailNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new EmailNotification(); 
    }
}

class SMSNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new SMSNotification(); 
    }
}



public class Main {

    public static void main(String[] args) {
        NotificationFactory factory = new SMSNotificationFactory(); 
        Notification n = factory.createNotification(); 
        n.notify_1(); 
    }
    
}
