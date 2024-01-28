# Design Patterns Practice

- Patterns
    - [Creational](#1-creational-design-patterns)
      - [Singleton](#11-singleton)
      - [Builder](#12-builder)
      - [Prototype & Registry](#13-prototype--registry)
      - [Simple Factory](#14-simple-factory)
      - [Factory Method](#15-factory-method)
      - [Abstract Factory](#16-abstract-factory)
    - [Structural](#2-structural-design-patterns)
      - [Adapter](#21-adapter)
      - [Facade](#22-facade)
      - [Decorator](#23-decorator)
      - [Flyweight](#24-flyweight)
    - [Behavioral](#behavioral-design-patterns)


## 1. Creational Design Patterns
Creational design patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.

### 1.1. Singleton
> **Singleton** is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
> 
> E.g. Having a database connection object or a logger object which required in most of the cases just one object and being used by multiple classes. Similar approach for configuration managers as well.
> 
> For example, if we had multiple objects/instances of a logger class, when multiple threads start writing, the logging will get overridden.
> 
> **Note**: In common practice, **<u>singleton objects should be immutable</u>**. As one object is being shared by multiple classes, making it mutable would cause race conditions because some class may want to change that single object.
>
> **Simple**: A simple singleton [class](src/com/practice/designpatterns/creational/singleton/sample/SingleObjectClass.java) and its [usage](src/com/practice/designpatterns/creational/singleton/sample/SingletonPractice.java).
> 
> **Multithreaded**: To make a singleton [class](src/com/practice/designpatterns/creational/singleton/sample/SingletonMultithreaded.java) thread-safe it needs to be synchronized. Here is the [usage](src/com/practice/designpatterns/creational/singleton/sample/SingletonPractice.java).
> 
> To make singleton pattern work in multithreaded way, and to make sure that we shouldn't be ended up with the race conditions and multiple objects creation, *synchronized* block should be used. And also required to have
> **Double Check Locking** or **DCL** in place.
> 
> **Eager Initialization**: Another way to create a singleton [class](src/com/practice/designpatterns/creational/singleton/sample/SingletonObjectEagerInit.java) without synchronization is using eager initialization.
> 
> However, using eager initialization is a memory overhead as the instance would be created at time of initial loading. But, in the contrary to the previous way for the multithreaded solution approach where initial access to the instance is slower (because of the creation), using eager initialization there is no such thing.
>
> **Useful Links**: [Serialize a Singleton](https://www.baeldung.com/java-serialize-singleton)
>
> **Exercise#1**: **File Based Configuration Manager**
>> **Problem Statement**
>>
>> You are tasked with creating a system-wide configuration manager for a complex software suite. The configuration manager is responsible for managing various configuration settings that affect the behavior and appearance of the software. To prevent multiple instances of the configuration manager, which could lead to inconsistencies and potential resource conflicts, you need to implement a design pattern that ensures the configuration manager is a singleton object.
>>
>> **Assignment**
>>
>> You are required to extend an abstract class `FileBasedConfigurationManager` to implement the Singleton design pattern and create a configuration manager class. The abstract class provides a foundation for managing configuration settings using a file-based approach.
>>
>> **Part1: Implementing Singleton and Extending Abstract Class**
>> 
>> 1. Extend the `FileBasedConfigurationManager` abstract class: You already have an abstract class named `FileBasedConfigurationManager`. Your task is to extend this class to create your own configuration manager class.
>> 2. Implement the Singleton design pattern: Within your configuration manager class, implement the Singleton design pattern to ensure that only one instance of your class can exist within the program.
>> 3. Implement the `getInstance()` and `resetInstance()` methods: Implement the `getInstance()` and `resetInstance()` methods in your configuration manager class. The `getInstance()` method should return the singleton instance of your configuration manager class. The `resetInstance()` method should reset the singleton instance of your configuration manager class to null.
>>
>> **Part 2: Configuration Management**
>> 
>> The `FileBasedConfigurationManager` abstract class provides a foundation for managing configuration settings using a file-based approach.
>> 
>> It already has a load method that loads configuration settings from a file and stores it in a Properties object. The Properties object is a collection of key-value pairs, where the key is a string and the value is an object. 
>>
>> Implement the following methods for configuration management in your extended class:
>>
>> * `String getConfiguration(String key)`: Retrieve a configuration value based on a given key.
>> * `<T> T getConfiguration(String key, Class<T> type)`: Retrieve a configuration value and perform type conversion.
>> * `void setConfiguration(String key, String value)`: Set a configuration value.
>> * `<T> void setConfiguration(String key, T value)`: Set a configuration value with type checking.
>> * `void removeConfiguration(String key)`: Remove a configuration value based on a given key.
>> * `void clear()`: Clear all configuration settings.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/singleton/configmanager/impl/FileBasedConfigurationManagerImpl.java)
>
> **Exercise#2**: **Logger**
>> **Problem Statement**
>>
>> You are tasked with developing a logging module for a complex software application. The logging module needs to maintain a single log file throughout the application's execution to avoid file access conflicts and ensure consistency. To prevent multiple instances of the logging module and ensure thread-safe access to the log file, you need to implement the Singleton design pattern along with the logging functionality.
>>
>> **Assignment**
>>
>> Your task is to implement the `Logger` interface that follows the Singleton design pattern to manage logging operations and maintain a single log file. 
>>
>> **Part 1: Implementing Singleton and Logger**
>>
>> 1. **Implement the Singleton design pattern:** Create a class that implements the `Logger` interface. Implement the Singleton design pattern within this class to ensure that only one instance of the logger can exist within the program. 
>> 2. **Implement the `getInstance()` and `resetInstance()` methods:** Implement the `getInstance()` method in the `LoggerSolution` class. This method should return the singleton instance of the logger class. Also, implement the `resetInstance()` method to reset the singleton instance to `null`.
>> 
>> **Part 2: Logging Operations**
>>
>>  The logger module is responsible for recording log messages of different levels in a single log file. Think of it as a central place where various parts of your software can write messages for debugging or monitoring purposes.
>> 
>> You have to implement the following methods:
>>
>> * `void setLogFile(String filePath)`: This method sets the log file path. The logger will write log messages to this file. Look at using the `java.io.PrintWriter` and `java.io.FileWriter` classes to write to the log file. You can initialise them in this method.
>> * `void log(LogLevel level, String message)`: This method is responsible for logging a message with a specified log level. The log message should include a timestamp, log level, and the provided message. Throw an `IllegalStateException` if the logger is not initialised using the `setLogFile()` method.
>> * `String getLogFile()`: This method returns the current log file path.
>> * `void flush()`: This method flushes any buffered log entries to the log file. Find the appropriate method to use from the `java.io.PrintWriter` class.
>> * `void close()`: This method closes the logger and releases any resources. Find the appropriate method to use from the `java.io.PrintWriter` class.
>> 
>> **Solution**: [Click](src/com/practice/designpatterns/creational/singleton/logger/impl/LoggerImpl.java)
>
> **Exercise#3**: **Connection Pool**
>> **Problem Statement**
>>
>> You are tasked with designing a connection pool for a database management module of a complex software application.
>> The connection pool is responsible for managing database connections efficiently to avoid unnecessary overhead and ensure optimal resource usage.
>> To prevent multiple instances of the connection pool manager and ensure thread-safe access to connections, 
>> you need to implement the Singleton design pattern along with the connection pool management functionality.
>>
>> **Assignment**
>>
>> Your task is to implement the ConnectionPool interface that follows the Singleton design pattern to manage a pool of database connections.
>>
>> **Part 1: Implementing Singleton and Connection Pool**
>>
>> 1. **Implement the Singleton design pattern**: Create a class that implements the ConnectionPool interface. Implement the Singleton design pattern within this class to ensure that only one instance of the connection pool manager can exist within the program.
>> 2. **Implement the `getInstance(int maxConnections)` and `resetInstance()` methods**: Implement the getInstance(int maxConnections) method in the ConnectionPoolSolution class. This method should return the singleton instance of the connection pool manager class. Also, implement the resetInstance() method to reset the singleton instance to null.
>>
>> **Part 2: Connection Pool Management**
>> 
>> In connection pooling, the aim is to efficiently handle a group of database connections. This ensures optimal resource usage and effective sharing of connections across different parts of the software. 
>>> Here's an analogy to help you understand the concept of connection pooling. Imagine a library with a large collection of books. The library has a shelf where all the books are kept. When a reader wants to borrow a book, they go to the shelf, pick up the book, and take it to a reading table. When they are done reading, they return the book to the shelf. The library keeps track of which books are available and which ones are currently being used by readers.
>> 
>> You have to implement the following methods:
>>
>> * `void initializePool()`: This method is responsible for initializing the connection pool. It should create a fixed number of connections and add them to the pool. Use the `DummyConnection` class to create dummy connections. Store the connections in a data structure of your choice, but you will have to track which connections are available and which ones are currently in use. 
>> * `Connection getConnection()`: This method is responsible for providing a connection to the caller. It should return a connection from the pool of available connections. Once a connection is returned, it should be marked as "unavailable" so that other parts of the software don't use it.
>> * `void releaseConnection(Connection connection)`: This method is responsible for releasing a connection back to the pool. It should mark the connection as "available" so that other parts of the software can use it.
>> * `int getAvailableConnectionsCount()`: Implement this method to count how many "available" connections remain in the pool.
>> * `int getTotalConnectionsCount()`: This method is about determining the total number of connections, whether they are currently in use or not.
>> 
>> **Solution**: [Click](src/com/practice/designpatterns/creational/singleton/connectionpool/impl/ConnectionPoolImpl.java)

### 1.2. Builder
> **Builder** is a creational design pattern which helps to construct complex objects step by step. The pattern allows to produce different types and representations of an object using the same construction code.
> 
> Imagine a complex object that requires laborious, step-by-step initialization of many fields and nested objects. In those cases, such initialization code is usually buried inside a monstrous constructor with lots of parameters. Or even worse: scattered all over the client code.
> 
> **Telescoping Constructor**: The Telescoping Constructor is an example of an anti-pattern. In this (anti)pattern, a class has numerous constructors each one taking a different number of parameters, so that class can be instantiated with the correct combination of parameters on each situation, but that at the end, if the class has been properly written, all this constructors delegate to a default constructor. 
> Maintaining telescoping of constructors is a difficult job and also the code is often not readable as developers need to remember the parameter sequence meticulously otherwise the code will break. Thus, the builder pattern is used to avoid this telescoping of the constructors.
>
> **Useful Links**: [Telescoping Constructor & Builder Pattern](https://medium.com/@modestofiguereo/design-patterns-2-the-builder-pattern-and-the-telescoping-constructor-anti-pattern-60a33de7522e)
> 
> **Exercise#1**: **Builder Pattern Implementation for a messaging service**
>> **Problem Statement**
>>
>> You are developing a messaging application with support for various message types, including text, images, audio, and video. Each message type can have additional attributes and settings, such as delivery status and timestamps. The current approach of creating message objects using multiple overloaded constructors has become error-prone and challenging to maintain. You should streamline the creation of message objects with different configurations and immutable objects.
>>
>> **Assignment**
>>
>> Your task is to implement the Builder pattern to create instances of message objects with different configurations. The Builder pattern allows for step-by-step construction of complex objects while keeping the creation process separate from the main object.
>>
>> **Implementing the Builder Pattern**
>>
>> 1. **Review the original class**: You have been provided with a class named `Message`. This class represents different message types and their attributes. Your task is to implement the Builder pattern to create instances of a class with the same properties.
>> 2. **Create the builder class**: Create a new class called `MessageBuilder` that will implement the builder patter. A dummy class has been provided for you to start with. Remember to annotate the class with the `@WithBuilder` annotation. The name does not matter as long as it is annotated.
>> 3. **Test your implementation**: Test cases has been provided for you to test your implementation. Run the test case to ensure that your implementation is correct.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/builder/messagingservice/Message.java)
>
> **Exercise#2**: **Builder Pattern Implementation for Building Queries**
>> **Problem Statement**
>>
>> You are tasked with developing a database management system that involves creating and executing SQL queries. Queries can vary in complexity, involving different SELECT clauses, JOIN operations, WHERE conditions, and more. The current approach of constructing queries using concatenated strings has proven to be error-prone, difficult to read, and challenging to modify. You should implement the Builder pattern to create instances of query objects with various configurations, resulting in more maintainable and flexible code.
>>
>> **Assignment**
>>
>> Your task is to implement the Builder pattern to construct query objects with different configurations. The Builder pattern facilitates the step-by-step construction of complex objects while keeping the creation process separate from the main object.
>>
>> **Implementing the Builder Pattern**
>>
>> 1. **Review the original class:** You have been provided with a class named Query. This class represents SQL queries with different components. Your task is to implement the Builder pattern to create instances of a class with the same properties.
>> 2. **Create the builder class:** Develop a new class called `QueryBuilder` that will implement the Builder pattern for creating query instances. A starter class has been given for you to begin with. Don't forget to annotate the class with the `@WithBuilder` annotation. The actual name of the class doesn't matter, as long as it is annotated.
>> 3. **Test your implementation:** Test cases have been provided for you to verify the correctness of your implementation. Execute the test cases to ensure the accuracy of your code.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/builder/buildingqueries/Query.java)
>
> **Exercise#3**: **Builder Pattern Implementation for a database configuration class**
>> **Problem Statement**
>>
>> You are tasked with creating a system-wide database configuration for a complex software suite. The configuration is responsible for managing various configuration settings that affect the data layer. To ensure a flexible and readable way to create configuration instances that are immutable, you decide to implement the Builder pattern.
>>
>> **Assignment**
>>
>> Your task is to implement the Builder pattern to create instances of a configuration manager class. The Builder pattern allows for step-by-step construction of complex objects while keeping the creation process separate from the main object.
>>
>> **Implementing the Builder Pattern**
>>
>> 1. **Review the original class:** You have been provided with a class that represents the database configuration `DatabaseConfiguration`. The class has a number of properties that are used to configure the database connection. Your task is to implement the Builder pattern to create instances of a class with the same properties.
>> 2. **Create the builder class:** Create a new class called `DatabaseConfigurationBuilder` that will implement the builder patter. A dummy class has been provided for you to start with. Remember to annotate the class with the `@WithBuilder` annotation. The name does not matter as long as it is annotated.
>> 3. **Test your implementation:** A test case has been provided for you to test your implementation. Run the test case to ensure that your implementation is correct. This will pick the correct implementation of the builder class based on the `@WithBuilder` annotation.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/builder/databaseconfiguration/DatabaseConfiguration.java)

### 1.3. Prototype & Registry
> **Prototype** is a creational design pattern that lets copy existing objects without making the code dependent on their classes.
> 
> Let’s say we have an object, and we want to create an exact copy of it. First, we have to create a new object of the same class. Then we have to go through all the fields of the original object and copy their values over to the new object.
> 
> The **Prototype** pattern delegates the cloning process to the actual objects that are being cloned. The pattern declares a common interface for all objects that support cloning. This interface lets us clone an object without coupling your code to the class of that object. Usually, such an interface contains just a single clone method.
> 
> **Simple**: A simple usage of Prototype [click](src/com/practice/designpatterns/creational/prototype/sample).
> 
> **Useful Links**: [Prototype Design Pattern Implementation in Java](https://medium.com/@thecodebean/prototype-design-pattern-implementation-in-java-b4b900f1ad9a)
>
> **Exercise#1**: **Prototype Pattern for Configuration Object Cloning**
> 
>> **Problem Statement**
>>
>> You are developing a configuration management system for your application. This system allows users to define and manage various configurations with different attributes. Creating new configurations with specific attributes is a frequent task during testing and development. However, setting up these configurations manually can be time-consuming and error-prone. To streamline this process, you decide to implement the Prototype pattern. This pattern will enable you to create prototype configuration objects and clone them when needed, saving time and reducing the risk of errors.
>>
>> **Assignment**
>>
>> Your task is to implement the Prototype pattern to create prototype objects for configuration management. You should define a `Configurable` interface that contains the clone method, which should be implemented by configuration objects. Additionally, you need to create a `ConfigurationPrototypeRegistry` interface that provides methods for adding and retrieving configuration prototypes and for cloning configuration objects. The goal is to simplify the process of creating configurations with specific attributes.
>>
>> **Implementing the Prototype Pattern**
>>
>> 1. **Define the `Configurable` interface:** Create an interface named Configurable with a single method, `clone()`, that returns a cloned copy of the implementing object.
>> 2. **Implement the configuration object:** Implement the `Configuration` class with attributes such as `configId`, `configName`, `configValue`, `isEnabled`, and `type`. Ensure that the `Configuration` class implements the `Configurable` interface by providing a proper `clone` method that creates a deep copy of the configuration object.
>> 3. **Define the `ConfigurationPrototypeRegistry` interface:** Create an interface named `ConfigurationPrototypeRegistry` that includes methods for adding prototypes, retrieving prototypes by type, and cloning configuration objects.
>> 4. **Create the registry implementation:** Implement a class that adheres to the `ConfigurationPrototypeRegistry` interface. In this class, manage a collection of configuration prototypes and provide methods to add prototypes, retrieve prototypes by type, and clone configuration objects based on their type.
>> 5. **Test your implementation:** Write test cases to ensure that the `Configuration` class correctly implements the `Configurable` interface, and the registry class properly manages prototypes and performs cloning operations. Verify that cloning a configuration object results in a new object with the same attribute values but is not the same object in memory.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/prototype/configobject)
>
> **Exercise#2**: **Prototype Pattern for Efficient Invoice Generation**
> 
>> **Problem Statement**
>>
>> You are tasked with creating an API for invoice generation and testing. While testing, generating invoices from scratch by fetching data from a database is time-consuming, as retrieving a single invoice already takes several seconds. When you need to generate a large number of invoices for testing purposes, this approach becomes impractical. To optimize the testing process, you decide to implement the Prototype pattern. This pattern allows you to create prototype invoice objects and efficiently clone them as needed, significantly reducing the time and resources required for invoice generation during testing.
>>
>> **Assignment**
>>
>> Your assignment is to implement the Prototype pattern to create prototype invoice objects for efficient testing. You should define an `ObjectClonable` interface that contains the clone method, which should be implemented by invoice objects. Additionally, you need to create an `InvoicePrototypeRegistry` interface that provides methods for adding and retrieving invoice prototypes and for cloning invoice objects. The primary objective is to streamline the process of generating invoices for testing, making it faster and more resource-efficient.
>>
>> **Implementing the Prototype Pattern**
>>
>> 1. **Define the `ObjectClonable` interface:** Create an interface named `ObjectClonable` with a single method, `clone()`, that returns a cloned copy of the implementing object.
>> 2. **Implement the invoice object:** Implement the `Invoice` class with attributes like `invoiceId`, `customerName`, `amount`, `dueDate`, and `invoiceType`. Ensure that the `Invoice` class implements the `ObjectClonable` interface by providing a proper `clone` method that creates a deep copy of the invoice object.
>> 3. **Define the `InvoicePrototypeRegistry` interface:** Create an interface named `InvoicePrototypeRegistry` that includes methods for adding prototypes, retrieving prototypes by type, and cloning invoice objects.
>> 4. **Create the registry implementation:** Implement a class that adheres to the `InvoicePrototypeRegistry` interface. In this class, manage a collection of invoice prototypes and provide methods to add prototypes, retrieve prototypes by type, and clone invoice objects based on their type.
>> 5. **Test your implementation:** Write test cases to ensure that the `Invoice` class correctly implements the `ObjectClonable` interface and that the registry class properly manages prototypes and performs cloning operations. Verify that cloning an invoice object results in a new object with the same attribute values but is not the same object in memory.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/prototype/invoicegeneration)
>> 
> **Exercise#3**: **Prototype Pattern for Object Cloning in Testing**
> 
>> **Problem Statement**
>>
>> You are developing a testing framework for a user API of a social media platform. Each test case requires generating multiple mock users with different attributes to simulate various scenarios. However, creating mock users for testing involves complex setups and is time-consuming. To optimize the user creation process during testing, you decide to implement the Prototype pattern. This pattern allows you to create prototype objects and clone them when needed, avoiding the overhead of setting up complex user objects repeatedly.
>>
>> **Assignment**
>>
>> Your task is to implement the Prototype pattern to create prototype objects for mock users in the testing framework. You should define an `ObjectClonable` interface that contains the `clone` method, which should be implemented by user objects. Additionally, you need to create a `UserPrototypeRegistry` interface that provides methods for adding and retrieving user prototypes and for cloning user objects. The goal is to streamline the process of creating mock users for testing.
>>
>> **Implementing the Prototype Pattern**
>>
>> 1. **Define the `ObjectClonable` interface:** Create an interface named `ObjectClonable` with a single method, `clone()`, that returns a cloned copy of the implementing object.
>> 2. **Implement the user object:** Implement the User class with attributes like `userId`, `username`, `email`, `displayName`, and `age`. Ensure that the `User` class implements the `ObjectClonable` interface by providing a proper `clone` method that creates a deep copy of the user object.
>> 3. **Define the UserPrototypeRegistry interface:** Create an interface named `UserPrototypeRegistry` that includes methods for adding prototypes, retrieving prototypes by type, and cloning user objects.
>> 4. **Create the registry implementation:** Implement a class that adheres to the `UserPrototypeRegistry` interface. In this class, manage a collection of user prototypes and provide methods to add prototypes, retrieve prototypes by type, and clone user objects based on their type.
>> 5. **Test your implementation:** Write test cases to ensure that the `User` class correctly implements the `ObjectClonable` interface, and the registry class properly manages prototypes and performs cloning operations. Verify that cloning a user object results in a new object with the same attribute values but is not the same object in memory.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/prototype/objectcloning)

### 1.4. Simple Factory
> A **Simple Factory** is a class or function that creates an object. 
> 
> It often gets confused with simple factories with general factories or with one of the creational design patterns.
> In most cases, a simple factory is an intermediate step of introducing **Factory Method** or **Abstract Factory** patterns.
> 
> For example,
> 
> ```java
> class UserFactory {
>   public static function create(String type) {
>       switch (type) { 
>           case user: return new User(); 
>           case customer: return new Customer(); 
>           case admin: return new Admin(); 
>           default:
>               throw new Exception('Wrong user type passed.'); 
>       }
>   }
> }
> ```
> 
> **Useful Links**: [Factory Method Pattern vs Simple Factory](https://medium.com/@unclexo/factory-method-pattern-vs-simple-factory-7dcf70e6321a)
>
> **Exercise#1**: **Simple Factory Pattern for Notification System**
> 
>> **Problem Statement**
>>
>> You are designing a notification system. Depending on the type of notification (e.g., email, SMS, push notification), different notification routines are required. You need a way to create notifications without explicitly specifying their classes, ensuring the system is open for future notification types.
>>
>> **Assignment**
>>
>> Your task is to implement the Simple Factory pattern to create notifications in the notification system. The Simple Factory pattern provides a way to create objects without exposing the instantiation logic, allowing for easy addition of new notification types.
>>
>> **Task 1 - Creating a Common Parent Class - Product Hierarchy**
>>
>> To streamline the creation of notifications, implement the common parent class named `Notification`. This class should include attributes and methods that are common to all notifications. The method `notificationType` has already been abstracted out for you as an example. You will need to implement the `Notification` class as a common parent class for all notifications.
>>
>> **Task 2 - Implementing the Simple Factory**
>>
>> Implement a `NotificationFactory` class that follows the Simple Factory pattern. This class should have a method to create notifications based on the `NotificationType`. The factory class should be capable of creating different types of notifications based on the `NotificationType`. Also remember that to create a notification, you need to pass the recipient, message and sender as parameters as well.
>>
>> **Instructions**
>>
>> 1. Implement the `Notification` class as a common parent class for all notifications. Include attributes and methods that are common to all notifications.
>> 2. Implement the `NotificationFactory` class that implements the Simple Factory pattern. Add a method to create notifications based on `NotificationType` and other parameters.
>> 3. Run the provided test cases in the `NotificationTest` class to verify the correctness of your implementation. The tests will check if all notifications have a common parent class and if the factory class can correctly create notifications based on the notification type, recipient, and message.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/factory/simplefactory/emailnotification)
> 
> **Exercise#2**: **Simple Factory Pattern for Audio Player**
>
>> **Problem Statement**
>>
>> You are developing an audio player application that supports different audio formats, such as MP3, WAV, and FLAC. Each audio format requires a specific decoder and player implementation. To keep your audio player extensible and maintainable, you decide to implement the Simple Factory pattern to create audio player objects based on the audio format.
>>
>> **Assignment**
>>
>> Your task is to implement the Simple Factory pattern to create audio players for different audio formats in the audio player application. The Simple Factory pattern allows you to encapsulate the creation logic of audio player objects, making it easy to add support for new audio formats in the future.
>>
>> **Task 1 - Creating Audio Player Classes (Product Hierarchy)**
>> 
>> Start by creating individual audio player classes for each supported audio format. Each audio player class should implement the same set of methods for playing, pausing, and stopping audio playback. Additionally, each class should have attributes that store information about the audio file, such as the volume and playback rate.
>>
>> **Task 2 - Implementing the Simple Factory**
>>
>> Next, implement a `AudioPlayerFactory` class that follows the Simple Factory pattern. This class should provide a method to create audio player objects based on the audio format. The factory class should take care of instantiating the appropriate audio player class based on the format provided and the relevant arguments.
>>
>> **Instructions**
>> 1. Implement the `AudioPlayer` class as a common parent class for all audio players. Include attributes and methods that are common to all audio players.
>> 2. Implement the `AudioPlayerFactory` class that implements the Simple Factory pattern. Add a method to create audio player objects based on the audio format and relevant arguments.
>> 3. Run the provided test cases in the `AudioPlayerTest` class to verify the correctness of your implementation. The tests will check if all audio player classes are implemented correctly and if the factory class is able to create audio player objects for different audio formats.
>> 
>> **Solution**: [Click](src/com/practice/designpatterns/creational/factory/simplefactory/audioplayer)
> 
> **Exercise#3**: **Simple Factory Pattern for Document Processing**
>
>> **Problem Statement**
>>
>> You are designing a document processing application. Depending on the type of document (e.g., text, spreadsheet, presentation), different processing routines are required. You need a way to create document processors without explicitly specifying their classes, ensuring the application is open for future document types.
>>
>> **Assignment**
>>
>> Your task is to implement the Simple Factory pattern to create document processors in the document processing application. The Simple Factory pattern provides a way to create objects without exposing the instantiation logic, allowing for easy addition of new document processor types.
>>
>> **Task 1 - Creating a Common Parent Class - Product Hierarchy**
>>
>> To streamline the creation of document processors, implement the common parent class named `DocumentProcessor`. This class should include attributes and methods that are common to all document processors. The method `supportsType` has already been abstracted out for you as an example. You will need to implement the `DocumentProcessor` class as a common parent class for all document processors.
>>
>> **Task 2 - Implementing the Simple Factory**
>>
>> Implement a `DocumentProcessorFactory` class that follows the Simple Factory pattern. This class should have a method to create document processors based on the `DocumentType`. The factory class should be capable of creating different types of document processors based on the `DocumentType`. Also remember that to create a document processor, you need to pass the document name as a parameter as well.
>>
>> **Instructions**
>>
>> 1. Implement the `DocumentProcessor` class as a common parent class for all document processors. Include attributes and methods that are common to all document processors.
>> 2. Implement the `DocumentProcessorFactory` class that implements the Simple Factory pattern. Add a method to create document processors based on `DocumentType` and other parameters.
>> 3. Run the provided test cases in the `DocumentProcessorTest` class to verify the correctness of your implementation. The tests will check if all document processors have a common parent class and if the factory class can correctly create document processors based on the document type and name.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/factory/simplefactory/documentprocessing)

### 1.5. Factory Method
> **Factory Method** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. 
> 
> For example,
> 
> ```java
> abstract class Department {
>   public abstract function createEmployee(String id);
> }
>
> class ITDepartment extends Department {
>   public function createEmployee(String id) {
>       return new Programmer(id);
>   }
> }
>
> class AccountingDepartment extends Department {
>   public function createEmployee(String id) {
>       return new Accountant(id);
>   }
> }
> ```

### 1.6. Abstract Factory
> **Abstract Factory** is a creational design pattern that produces families of related objects without specifying their concrete classes. 
> 
> What are the "families of objects"? For instance, take this set of classes: `Transport` + `Engine` + `Controls`. There might be several variants of these:
> `Car` + `CombustionEngine` + `SteeringWheel`
> `Plane` + `JetEngine` + `Yoke`
> 
> **Note:** If the program doesn’t operate with product families, then an abstract factory is not needed. 
> 
> And again, it often gets confused about the abstract factory patterns with a simple factory class declared as abstract. It doesn’t.
> 
> **Exercise#1**: **Abstract Factory Pattern for Notifications**
>> **Problem Statement**
>>
>> You are working on a notification system for a communication application. The application must support different types of notifications, such as email, SMS, and push notifications. Each notification type has specific content and delivery methods. You want to design a flexible notification system where different types of notifications can be created without specifying their concrete classes, ensuring the system is open for future notification types and supports compatibility within families.
>>
>> **Assignment**
>>
>> Your task is to implement the Abstract Factory pattern to create notifications and related components in the communication application. The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes, allowing for easy addition of new notification types and ensuring compatibility within families.
>>
>> **Task 1 - Defining the Abstract Factory**
>>
>> The abstract factory class has been created for you. You will need to add the factory methods to create the notification, templates, and senders to the abstract factory class. The method `notificationType` has already been abstracted out for you as an example. You will need to implement the `NotificationFactory` class as a common parent class for all the notification factories.
>>
>> **Task 2 - Implementing Concrete Factories**
>>
>> Create concrete implementations of the `NotificationFactory` interface for email and push notifications. Implement the methods to create compatible notifications, notification providers, and notification templates for each notification type. Ensure that the created components are compatible within the same family.
>>
>> **Task 3 - Testing the Implementation**
>>
>> Run the provided test cases in the `NotificationFactoryTest` class to verify the correctness of your implementation. The tests will check if all notifications have a common parent class, and if the factory classes can correctly create notifications, notification providers, and notification templates based on the notification type and content.
>>
>> **Instructions**
>>
>> 1. Implement the `NotificationFactory` interface with methods to create notifications, notification providers, and notification templates.
>> 2. Create concrete implementations of the `NotificationFactory` interface for email, SMS, and push notifications. Implement the methods to create compatible components for each notification type.
>> 3. Run the provided test cases in the `NotificationFactoryTest` class to verify the correctness of your implementation. The tests will ensure that the factory classes can correctly create notification components based on the notification type and content.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/factory/abstractfactory/notificationexercise)
>
> **Exercise#2**: **Abstract Factory Pattern for Audio Players**
>> **Problem Statement**
>> 
>> You are designing an audio player application. The application should support different audio formats such as MP3, WAV, and FLAC. Each format requires specific decoding, processing, and rendering steps. You want to create instances of these processing steps without explicitly specifying their classes and ensure that the steps within the same format family are compatible.
>>
>> **Assignment**
>>
>> Your task is to extend the Abstract Factory pattern to create audio processing components in the audio player application. The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes, allowing for easy addition of new audio format processor types and ensuring compatibility within families.
>>
>> **Task 1 - Adding the factory methods to the abstract factory**
>>
>> The abstract factory class `AudioFactory` has been created for you. You will need to add the factory methods to create audio decoders, processors, and renderers to the abstract factory class. The method `supportsFormat` has already been abstracted out for you as an example. You will need to implement the `AudioFactory` class as a common parent class for all the audio format factories.
>>
>> **Task 2 - Implementing the Abstract Factory**
>>
>> Now that you have the abstract factory class, you will need to implement the abstract factory for different audio formats such as MP3, WAV, and FLAC. Three classes have been created for you: `Mp3AudioFactory`, `WavAudioFactory`, and `FlacAudioFactory`. You will need to implement the methods to create compatible audio decoders, processors, and renderers. Ensure that the created components are compatible within the same format family.
>>
>> **Instructions**
>> 1. Implement the `AudioFactory` interface with methods to create audio decoders, processors, and renderers.
>> 2. Create concrete implementations of the `AudioFactory` interface for MP3, WAV, and FLAC audio formats. Implement the methods to create compatible audio decoders, processors, and renderers.
>> 3. Run the provided test cases in the `AudioFactoryTest` class to verify the correctness of your implementation. The tests will check if all audio components have a common parent class, and if the factory classes can correctly create audio decoders, processors, and renderers based on the audio format.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/factory/abstractfactory/audioplayerexercise)
> 
> **Exercise#3**: **Abstract Factory Pattern for Document Processing**
>> **Problem Statement**
>>
>> You are designing a document processing application. Depending on the type of document (e.g., text, spreadsheet, presentation), different processing routines are required. These routines involve multiple steps, such as parsing, formatting, and exporting, which need to be coordinated to ensure correct document processing. You want to create instances of these processing steps without explicitly specifying their classes and ensure that the steps within the same family are compatible.
>>
>> **Assignment**
>>
>> Your task is to implement the Abstract Factory pattern to create document processors in the document processing application. The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes, allowing for easy addition of new document processor types and ensuring compatibility within families.
>>
>> **Task 1 - Adding the factory methods to the abstract factory**
>>
>> The abstract factory class has been created for you. You will need to add the factory methods to create document processors, parsers, and printers to the abstract factory class. The method `supportsType` has already been abstracted out for you as an example. You will need to implement the `DocumentFactory` class as a common parent class for all the document factories.
>>
>> **Task 2 - Implementing the Abstract Factory**
>>
>> Now that you have the abstract factory class, you will need to implement the abstract factory for text and spreadsheet documents. Two classes have been created for you: `TextDocumentFactory` and `SpreadsheetDocumentFactory`. You will need to implement the methods to create compatible document processors, parsers, and printers. Ensure that the created processors, parsers, and printers are compatible within the same family.
>>
>> **Instructions**
>>
>> 1. Implement the `DocumentFactory` interface with methods to create document processors, parsers, and printers.
>> 2. Create concrete implementations of the `DocumentFactory` interface for text and spreadsheet documents. Implement the methods to create compatible document processors, parsers, and printers.
>> 3. Run the provided test cases in the `DocumentFactoryTest` class to verify the correctness of your implementation. The tests will check if all document processors have a common parent class, and if the factory classes can correctly create document processors, parsers, and printers based on the document type and name.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/creational/factory/abstractfactory/documentprocessing)

## 2. Structural Design Patterns
Structural design patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.

### 2.1. Adapter
> Adapter is a structural design pattern that lets incompatible interfaces work together. 
> It acts as a bridge between two incompatible interfaces by wrapping the interface of a class into another interface that a client expects.
> The Adapter pattern is particularly useful when integrating new features or systems that have different interfaces.
> 
> **Exercise#1**: **Adapter Pattern for Social Media Aggregator**
>> **Problem Statement**
>>
>> You are working on a social media aggregator app that pulls in posts from various social platforms. Each platform provides data in different structures through distinct APIs. Your task is to unify the data format within the app and ensure that integrating new social platforms remains hassle-free. To achieve this, you want to implement the Adapter pattern, allowing you to create adapter classes for different social media platform APIs. These adapters will convert platform-specific APIs into a common format that your application can use.
>>
>> **Assignment**
>>
>> Your goal is to implement the Adapter pattern to create adapter classes for different social media platform APIs. These adapters should conform to a common interface, making it easy to integrate new platforms in the future. Your task is to abstract away the differences in APIs and data formats and provide a unified interface for your application to work with.
>>
>> **Implementing the Adapter Pattern**
>>
>> 1. **Review the existing APIs:** Study the APIs and data formats of the social media platforms you need to integrate. Understand the differences in their APIs and how they interact with their respective systems.
>> 2. **Implement the adapter interface:** You have been provided with a `SocialMediaAdapter` interface. Your task is to implement this interface in different adapter classes, each corresponding to a different social media platform. The adapters should adapt the provider-specific APIs into a format that matches the `SocialMediaAdapter` interface.
>> 3. **Use composition:** Create adapter classes that internally use instances of the actual social media platform APIs. You should not modify the platform APIs directly. Instead, create methods in the adapter classes that map to the platform APIs and perform the necessary transformations.
>> 4. **Test your implementation:** Run the provided test cases in the `SocialMediaAdapterTest` class to ensure that your adapter classes work correctly. These test cases will check if your adapters have the required methods and if they interact with the platform APIs properly.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/structural/adapter/socialmediaaggregator)
>
> **Exercise#2**: **Adapter Pattern for Language Translation Integration**
>> **Problem Statement**
>> 
>> You are developing a language translation tool that needs to integrate with different translation services like Google Translate, Microsoft Translator, and Yandex.Translate. Each service offers its own API and response format, making integration complex. To simplify this process and ensure consistency in the codebase, you decide to implement the Adapter pattern. This pattern allows you to create adapter classes for different translation services, converting their APIs into a common format that your application can work with.
>>
>> **Assignment**
>>
>> Your task is to implement the Adapter pattern to create adapter classes for different translation service APIs. These adapters should adhere to the `TranslationProviderAdapter` interface, which defines common methods for translation and fetching supported languages. The goal is to abstract away the differences in APIs and data formats, providing a unified interface for your language translation tool.
>>
>> **Implementing the Adapter Pattern**
>>
>> 1. **Review the existing translation services:** Study the APIs and response formats of the translation services you need to integrate with. Understand how each service's API works and the data it provides.
>> 2. **Implement the adapter interface:** You have been provided with a `TranslationProviderAdapter` interface. Your task is to create adapter classes for each translation service that implements this interface. These adapters should adapt the specific translation service's API into a format that matches the methods defined in the `TranslationProviderAdapter`.
>> 3. **Use composition:** Create adapter classes that internally use instances of the actual translation service APIs, such as `GoogleTranslateApi` and `MicrosoftTranslateApi`. Avoid modifying the provider APIs directly; instead, create methods in the adapter classes that map to the provider APIs and perform the necessary data transformations.
>> 4. **Additional method:** Apart from the translated method, you should implement another method as required by the assignment.
>> 5. **Test your implementation:** Execute the provided test cases in the `TranslationProviderAdapterTest` class to validate the correctness of your adapter classes. These test cases will ensure that your adapters have the required methods and interact with the provider APIs properly.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/structural/adapter/languagetranslation)
> 
> **Exercise#3**: **Adapter Pattern for Insurance Providers Integration**
>>
>> **Problem Statement**
>>
>> Your company needs to integrate with various insurance providers, each having different APIs and data formats. To simplify the integration and ensure a consistent data format, you decide to implement the Adapter pattern. This pattern will allow you to create adapter classes for different insurance providers, converting their APIs into a common format that your application can use.
>>
>> **Assignment**
>>
>> Your task is to implement the Adapter pattern to create adapter classes for different insurance providers' APIs. These adapters should conform to a common interface, making it easy to integrate new providers in the future. Your goal is to abstract away the differences in APIs and data formats and provide a unified interface for your application to work with.
>>
>> **Implementing the Adapter Pattern**
>> 1. **Review the existing APIs:** Study the APIs and data formats of the insurance providers you need to integrate with. Understand the differences in their APIs and how they interact with their respective systems.
>> 2. **Implement the adapter interface:** You have been provided with an `TravelInsuranceAdapter` interface. Your task is to implement this interface in different adapter classes, each corresponding to a different insurance provider. The adapters should adapt the provider-specific APIs into a format that matches the `TravelInsuranceAdapter` interface.
>> 3. **Use composition:** Create adapter classes that internally use instances of the actual insurance provider APIs. You should not modify the provider APIs directly. Instead, create methods in the adapter classes that map to the provider APIs and perform the necessary transformations.
>> 4. **Test your implementation:** Run the provided test cases in the `TravelInsuranceAdapterTest` class to ensure that your adapter classes work correctly. These test cases will check if your adapters have the required methods and if they interact with the provider APIs properly.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/structural/adapter/insuranceprovider)

### 2.2. Facade
> The Facade Design Pattern is a structural pattern that provides a simplified, higher-level interface to a set of interfaces in a subsystem. It defines a higher-level interface that makes the subsystem easier to use, reducing the complexity and dependencies for client code. Essentially, the Facade pattern hides the complexities of a subsystem behind a simpler interface.
>
> In short, it encapsulates the details and complexities of the subsystems, providing a higher-level, more understandable interface.
> 
> **Exercise#1**: **Facade pattern for image editing application**
>> **Problem Statement**
>> 
>> You are developing an image editing software that offers various features like loading images, applying filters, adjusting brightness, and saving images. The editing module has complex interactions and dependencies. Your goal is to simplify the interface for users by providing a unified way to access and control these editing functionalities.
>>
>> **Assignment**
>>
>> Your task is to implement the Facade pattern to refactor the existing `ImageEditingManager` class. The class currently handles image editing functionalities separately. Your objective is to create a facade class that presents a unified and simplified interface for users to perform image editing tasks while abstracting away the internal complexities.
>>
>> **Implementing the Facade Pattern**
>> 1.  **Review the original class:** Take a closer look at the `ImageEditingManager` class and its methods. Understand how each editing module is handled and the interactions involved.
>> 2. **Create the facade class:** Create a new class named `ImageEditingFacade` that implements the Facade pattern. This class will encapsulate the interactions with the image editing module, providing a simplified way to edit images.
>> 3. **Remember to call the constructor of your facade using the same arguments from the `ImageEditingManager` class:** Ensure that the constructor of your `ImageEditingFacade` class takes the same arguments that the `ImageEditingManager` class constructor does. This will allow you to pass the necessary dependencies to the facade.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/structural/facade/imageediting)
>
> **Exercise#2**: **Facade pattern for Data Analysis Application**
>> **Problem Statement**
>>
>> You are developing a software application for data analysis. The application involves data collection, preprocessing, analysis algorithms, and visualization. The interactions between these components can become complex. Your goal is to provide a simplified interface for data analysts to perform end-to-end analysis tasks without dealing with the inner workings of each component.
>>
>> **Assignment**
>>
>> Your task is to implement the Facade pattern to refactor the existing data analysis workflow. The current workflow involves data collection, preprocessing, applying analysis algorithms, and visualization. Your goal is to create a facade class that provides a unified and simplified interface for data analysts to perform these tasks seamlessly.
>>
>> **Implementing the Facade Pattern**
>> 1. **Review the original workflow:** Take a closer look at the existing data analysis workflow and the interactions between different components.
>> 2. **Create the facade class:** Create a new class called `DataAnalysisFacade` that implements the Facade pattern. This class will encapsulate the complex interactions between data collection, preprocessing, analysis algorithms, and visualization components.
>> 3. **Remember to call the constructor of your facade using the same arguments from the existing components:** The constructor of your `DataAnalysisFacade` class should take the same arguments that the existing components require. This allows you to pass the necessary parameters to the facade.
>> 4. **Test your implementation:** Test cases have been provided for you to verify your implementation. Run the test cases to ensure that your facade class works correctly and provides the expected functionality.
>>
>>  **Solution**: [Click](src/com/practice/designpatterns/structural/facade/dataanalysis)
> 
> **Exercise#3**: **Facade pattern for a travel booking platform**
>> **Problem Statement**
>>
>> You are working on an online booking platform for travel accommodations. The platform needs to handle bookings, payments, and notifications through different external services. The goal is to provide a simplified interface for customers and internal modules to perform booking-related tasks without directly dealing with the intricacies of each external service.
>>
>> **Assignment**
>>
>> Your task is to implement the Facade pattern to refactor the existing `BookingManager` class. The `BookingManager` class has multiple dependencies and methods that handle bookings, payments, and notifications. Your goal is to create a facade class that provides a unified and simplified interface for these complex operations.
>>
>> **Implementing the Facade Pattern**
>> 1. **Review the original class:** Take a closer look at the `BookingManager` class and its methods. Understand the dependencies it uses and the interactions with external services.
>> 2. **Create the facade class:** Create a new class called `BookingFacade` that implements the Facade pattern. This class will encapsulate the complex interactions with the external services and provide a simplified interface for clients.
>> 3. **Remember to call the constructor of your facade using the same arguments from the BookingManager class:** The constructor of your `BookingFacade` class should take the same arguments that the `BookingManager` class constructor does. This allows you to pass the necessary dependencies to the facade.
>> 4. **Test your implementation:** Test cases have been provided for you to test your implementation. Run the test cases to ensure that your facade class works correctly and provides the expected functionality.
>>
>> **Solution**: [Click](src/com/practice/designpatterns/structural/facade/travelbookingplatform)



