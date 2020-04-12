[![CircleCI](https://circleci.com/gh/volkodavs/dropwizard-guice-example.svg?style=svg)](https://circleci.com/gh/volkodavs/dropwizard-guice-example)

# Magic 8-Ball. Dropwizard Guice Integration

## Introduction  

The motivation of the project is to show how to integrate Dropwizard application with Guice DI Framework. 
As an example application, I build a [Magic 8-Ball](https://en.wikipedia.org/wiki/Magic_8-Ball) REST API 
The Magic 8-Ball] is a plastic sphere, made to look like an eight-ball, that is used for fortune-telling or seeking advice.

## Why Dependency Injection? 

Dependency injection is a technique whereby one object supplies the dependencies of another object. 
A dependency is an object that can be used (a service).

### Dependency injection types
* **constructor injection:** the dependencies are provided through a class constructor.
* **setter injection:** the client exposes a setter method that the injector uses to inject the dependency
* **interface injection:** the dependency provides an injector method that will inject the dependency into any client passed to it.
Clients must implement an interface that exposes a setter method that accepts the dependency

I personally prefer constructor injection, because you don't have an object which is in an intermediate invalid state which eliminates lots of checking to ensure the object is valid.

## Why Google Guice

Google Guice is a framework to automate dependency injection by providing a container to where we can map abstractions and implementations.
After the mapping, the dependencies will be automatic injected in clients when requested.

## Why Guice-HK2 bridge required?

Any DI framework is built around a container to hold all the services bound to that system. 
For HK2, the container is the ServiceLocator, and for Guice, the container is the Injector. 
Jersey is coupled with HK2. What this means is that because HK2 is tied to the ServiceLocator container,
Jersey is also tied to this ServiceLocator. So when a service is looked up in a Jersey application, it will be looked up via the ServiceLocator.

So in order for us to introduce another DI framework, we need to tap into the ServiceLocator. 
What the bridge does is tie the Guice Injector to the HK2 ServiceLocator so that the services in the Guice Injector
can be discovered through the ServiceLocator. If the CustomerService were a service bound to the Guice Injector, 
then what would happen is that Jersey would look for it in the ServiceLocator,
and the locator would look in the Injector for it. This is wha the bridge does.

## How to build 

```shell script
$ mvn clean package 
```

## How to start 

```shell script
$ java -jar target/dropwizard-guice-example-0.1.0-SNAPSHOT.jar server
``` 

## Conclusion
I hope that with this basic project will help you to understand how to integrate Guice with Dropwizard,
so you can continue your studies about dependency injection and how to develop code with a lower level of coupling and high level of cohesion.

## References
* [Dropwizard](https://www.dropwizard.io/en/latest/) 
* [Google Guice official repository](https://github.com/google/guice)
* [Dropwizard Guicier](https://github.com/HubSpot/dropwizard-guicier)
* [An overview of Guice](https://justin.abrah.ms/misc/an-overview-of-guice-java-dependency-injection.html)

## License

```text
    MIT License

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
```
