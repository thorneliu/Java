# Interfaces cannot be instantiated 
they can only be implemented by classes or extended by other Interfaces 

# Interfaces as API
costumer do not know the detail of how the API is implemented. Just use it.
The API provider can modify the implemention and costumer need not to care about

# Defining an Interfaces 

An interface declaration consists of modifiers, the keyword interface, the interface name, a comma-separated list of parent interfaces (if any), and the interface body. For example:

public interface GroupedInterface extends Interface1, Interface2, Interface3 
{

// constant declarations

// base of natural logarithms
double E = 2.718282;

// method signatures
void doSomething (int i, double x);
int doSomethingElse(String s);

}

The public access specifier indicates that the interface can be used by any class in any package.

The interface body can contain abstract methods, default methods, and static methods


#Staic method

like class variables, static method in interfaces 
A static method is a method is a method that is associated with the class in which it is defined rather than with any object.

Every instance of the class shares its static methods.
