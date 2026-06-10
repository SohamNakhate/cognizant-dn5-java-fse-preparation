# Important Notes

__1. Single Responsibility Principle__ 
- states that a class should have only one responsibility and therefore only one reason to change.
- __Benefits:__
    1. Easier maintenance
    2. Easier testing
    3. Lower coupling
    4. Better readability
    5. Better scalability

### Bad Example
    Employee
        ├── Calculate Salary 
        ├── Save to DB
        └── Generate Report
### Good Example
    Employee
    SalaryService
    EmployeeRepository
    ReportService

--------

2. __Open Close Principle__
- Software entities should be open for extension but closed for modification.
- Existing code is already tested.
- Modifying old code can introduce bugs.
- New features can be added safely.

eg. For a notification system if we already define notification that if type.equals(Email) or .equals(SMS) and give its impleemtnations. now if in future if a new type appears, hence we will have to modify the notification class. instead, we make notification interface with the method send(). Now, all the new classes like Whatsapp, Email, SMS will implement this interface and hence will have to give individual implementation of their own notification by overriding the send() method.  

---------------- 

3. __Liskov Substitution Principle__
- Objects of a subclass should be replaceable with objects of the parent class without affecting correctness.
- A derived class should be able to replace its base class without breaking application behavior.

__Benefits__
1. Correct inheritance
2. Better polymorphism
3. More reliable systems
4. Fewer runtime errors

-----


4. __Interface Segregation Principle__
Clients should not be forced to depend upon interfaces they do not use.

__Simple meaning:__
Don't make a class implement methods it doesn't need. Instead of one large interface, create smaller, focused interfaces.

__*INTERVIEW IMPORTANT*__ : SRP vs ISP (read more in the interview setion)


__Signs of ISP Violation__
1. Empty methods
2. UnsupportedOperationException
3. Large "god interfaces"
4. Classes implementing methods they don't need

__Solution__
1. Break large interfaces into smaller interfaces
2. Use composition of interfaces

---

5. Dependency Inversion Principle

- High-level modules should not depend on low-level modules. Both should depend on abstractions.


---------------








