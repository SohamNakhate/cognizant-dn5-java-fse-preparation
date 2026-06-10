# SOLID Principles - Day 1 Notes

## Overview

SOLID is a set of five object-oriented design principles introduced by Robert C. Martin (Uncle Bob). These principles help developers write maintainable, scalable, flexible, and testable software.

The five principles are:

1. SRP – Single Responsibility Principle
2. OCP – Open Closed Principle
3. LSP – Liskov Substitution Principle
4. ISP – Interface Segregation Principle
5. DIP – Dependency Inversion Principle

---

# 1. Single Responsibility Principle (SRP)

## Definition

A class should have only one reason to change.

A class should have only one responsibility or job.

---

## Bad Example

```java
class Employee {

    public void calculateSalary() {
        System.out.println("Calculating salary");
    }

    public void saveToDatabase() {
        System.out.println("Saving employee");
    }

    public void generateReport() {
        System.out.println("Generating report");
    }
}
```

### Problem

Employee is responsible for:

* Salary calculation
* Database operations
* Report generation

Any change in these functionalities requires modification of the Employee class.

---

## SOLID Version

```java
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

```java
class SalaryService {
    public void calculateSalary(Employee emp) {
        System.out.println("Calculating salary");
    }
}
```

```java
class EmployeeRepository {
    public void save(Employee emp) {
        System.out.println("Saving employee");
    }
}
```

```java
class ReportService {
    public void generate(Employee emp) {
        System.out.println("Generating report");
    }
}
```

---

## Real World Example

A teacher should teach students.

A teacher should not:

* Manage attendance software
* Process salaries
* Clean classrooms

Each responsibility belongs to a different role.

---

## Benefits

* Easier maintenance
* Better readability
* Better testing
* Reduced coupling

---

## Interview Answer

SRP states that a class should have only one responsibility and therefore only one reason to change.

---

# 2. Open Closed Principle (OCP)

## Definition

Software entities should be open for extension but closed for modification.

We should be able to add new functionality without changing existing code.

---

## Bad Example

```java
class NotificationService {

    public void send(String type) {

        if(type.equals("EMAIL")) {
            System.out.println("Sending Email");
        }
        else if(type.equals("SMS")) {
            System.out.println("Sending SMS");
        }
    }
}
```

### Problem

Every time a new notification type is added, this class must be modified.

Examples:

* Email
* SMS
* Push
* WhatsApp

---

## SOLID Version

### Abstraction

```java
interface Notification {
    void send();
}
```

### Implementations

```java
class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Email");
    }
}
```

```java
class SMSNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending SMS");
    }
}
```

### Service

```java
class NotificationService {

    public void sendNotification(Notification notification) {
        notification.send();
    }
}
```

---

## Adding New Feature

```java
class PushNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}
```

No existing code changes.

---

## Benefits

* Extensible
* Safe modifications
* Reduced bug risk
* Better maintainability

---

## Interview Answer

OCP states that software components should be open for extension but closed for modification.

---

# 3. Liskov Substitution Principle (LSP)

## Definition

Objects of a derived class should be replaceable with objects of the base class without affecting correctness.

---

## Bad Example

```java
class Bird {

    public void fly() {
        System.out.println("Flying");
    }
}
```

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new RuntimeException("Penguins cannot fly");
    }
}
```

### Problem

```java
Bird bird = new Penguin();
bird.fly();
```

Runtime failure occurs.

A Penguin cannot correctly substitute a Bird.

---

## SOLID Version

```java
class Bird {
}
```

```java
interface Flyable {
    void fly();
}
```

```java
class Sparrow extends Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Flying");
    }
}
```

```java
class Penguin extends Bird {
}
```

Now only birds that can fly implement Flyable.

---

## Benefits

* Correct inheritance hierarchy
* Reliable polymorphism
* Reduced runtime errors

---

## Interview Answer

LSP states that a child class should be able to replace its parent class without breaking application behavior.

---

# 4. Interface Segregation Principle (ISP)

## Definition

Clients should not be forced to depend upon interfaces they do not use.

Prefer multiple small interfaces over one large interface.

---

## Bad Example

```java
interface Worker {

    void work();

    void eat();

    void sleep();
}
```

```java
class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Robot Working");
    }

    @Override
    public void eat() {
    }

    @Override
    public void sleep() {
    }
}
```

### Problem

Robot is forced to implement methods it does not need.

---

## SOLID Version

```java
interface Workable {
    void work();
}
```

```java
interface Eatable {
    void eat();
}
```

```java
interface Sleepable {
    void sleep();
}
```

### Human

```java
class Human implements Workable, Eatable, Sleepable {

    @Override
    public void work() {
    }

    @Override
    public void eat() {
    }

    @Override
    public void sleep() {
    }
}
```

### Robot

```java
class Robot implements Workable {

    @Override
    public void work() {
    }
}
```

---

## Another Example

Bad Interface

```java
interface Machine {

    void print();

    void scan();

    void fax();
}
```

A basic printer does not need scan and fax functionality.

---

## Benefits

* Cleaner interfaces
* Reduced coupling
* Better flexibility
* Easier maintenance

---

## Interview Answer

ISP states that no client should be forced to depend on methods it does not use.

---

# 5. Dependency Inversion Principle (DIP)

## Definition

High-level modules should not depend on low-level modules.

Both should depend on abstractions.

---

## Bad Example

```java
class EmailService {

    public void sendEmail() {
        System.out.println("Email Sent");
    }
}
```

```java
class NotificationManager {

    private EmailService emailService =
            new EmailService();

    public void notifyUser() {
        emailService.sendEmail();
    }
}
```

### Problem

NotificationManager is tightly coupled to EmailService.

Switching to SMS requires modifying NotificationManager.

---

## SOLID Version

### Abstraction

```java
interface MessageService {

    void sendMessage();
}
```

### Implementations

```java
class EmailService implements MessageService {

    @Override
    public void sendMessage() {
        System.out.println("Email Sent");
    }
}
```

```java
class SMSService implements MessageService {

    @Override
    public void sendMessage() {
        System.out.println("SMS Sent");
    }
}
```

### High Level Module

```java
class NotificationManager {

    private MessageService service;

    public NotificationManager(MessageService service) {
        this.service = service;
    }

    public void notifyUser() {
        service.sendMessage();
    }
}
```

---

## Benefits

* Loose coupling
* Easy testing
* Easy replacement of implementations
* Foundation of Spring Dependency Injection

---

## Spring Connection

```java
@Autowired
private MessageService service;
```

Spring injects the implementation automatically.

This is DIP in action.

---

# SOLID Summary Table

| Principle | Full Form                       | Core Idea                                   |
| --------- | ------------------------------- | ------------------------------------------- |
| SRP       | Single Responsibility Principle | One class, one responsibility               |
| OCP       | Open Closed Principle           | Extend without modifying                    |
| LSP       | Liskov Substitution Principle   | Child should replace parent safely          |
| ISP       | Interface Segregation Principle | Small focused interfaces                    |
| DIP       | Dependency Inversion Principle  | Depend on abstractions, not implementations |

---

# Common Interview Questions

### What is SOLID?

SOLID is a set of five object-oriented design principles that improve maintainability, scalability, flexibility, and testability of software systems.

### Which SOLID principle is most used in Spring?

Dependency Inversion Principle (DIP).

### Which design pattern is closely related to OCP?

Strategy Pattern and Factory Pattern.

### Difference between SRP and ISP?

SRP focuses on class responsibilities.

ISP focuses on interface design.

### What happens if LSP is violated?

Inheritance becomes incorrect and runtime failures may occur.

---

# Day 1 Revision Notes

* SRP → One class, one responsibility.
* OCP → Extend behavior without modifying existing code.
* LSP → Child should safely replace parent.
* ISP → Don't force classes to implement unnecessary methods.
* DIP → Depend on interfaces, not concrete classes.

Remember:

"Clean code is not about writing less code. It is about writing code that is easier to change."
