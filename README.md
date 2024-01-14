# Design Patterns Practice

- Patterns
    - [Creational](#creational-design-patterns)
    - [Structural](#structural-design-patterns)
    - [Behavioral](#behavioral-design-patterns)


## Creational Design Patterns
Creational design patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.

### 1. Singleton
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
> **Exercise#2**: **Connection Pool**
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
> 
> **Links**: https://www.baeldung.com/java-serialize-singleton

> ### 2. Builder
> **Builder** is a creational design pattern which helps to construct complex objects step by step. The pattern allows to produce different types and representations of an object using the same construction code.
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
>> 2. **Create the builder class**: Create a new class called `MessageBuilder` that will implement the builder patter. A dummy class has been provided for you to start with. Remember to annotate the class with the @WithBuilder annotation. The name does not matter as long as it is annotated.
>> 3. **Test your implementation**: Test cases has been provided for you to test your implementation. Run the test case to ensure that your implementation is correct.