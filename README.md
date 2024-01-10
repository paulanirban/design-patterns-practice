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
> **Exercise#1**: File based configuration manager
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
>> The FileBasedConfigurationManager abstract class provides a foundation for managing configuration settings using a file-based approach.
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
> 
> 
> **Solution**: [Click](src/com/practice/designpatterns/creational/singleton/configmanager)
> 
> **Links**: https://www.baeldung.com/java-serialize-singleton