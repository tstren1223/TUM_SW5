
# TUM_SW5
1:Searching with the Strategy Pattern
The Strategy Pattern is a behavioral design pattern that allows choosing different strategies based on a policy during runtime.

You are a working student for the startup e-BOOKist. Due to the observed user behavior of often not reading the whole book, but rather only reading the most intriguing chapters, it is important to choose the most suitable search algorithm when searching for the page number of a chapter. It is your responsibility to solve this task. The only constraint you get is that you should use the Strategy pattern to choose between Linear Search and Binary Search.

Your Tasks
Task 1: Searching
First, you need to implement two search algorithms, in this case, LinearSearch and BinarySearch.

 Implement Linear Search 2 of 2 tests passing
Implement the method performSearch(List<Chapter>, String) in the class LinearSearch using Linear Search. Linear search simply means iterating through the list until the object you are looking for is found. If the chapter name is found in the book, the pageNumber should be returned, otherwise, the return value should be -1.

 Implement Binary Search 2 of 2 tests passing
Implement the method performSearch(List<Chapter>, String) in the class BinarySearch using Binary Search. If the chapter name is found in the book, the pageNumber should be returned, otherwise, the return value should be -1. Here you can find an explanation of Binary Search.

Task 2: Strategy Pattern
We want the application to apply different search algorithms for chapter names in our e-book to retrieve the corresponding page numbers. Use the strategy pattern to select the appropriate search algorithm at runtime.

 SearchStrategy Interface 4 of 4 tests passing
Create a SearchStrategy interface and adjust the search algorithms so that they implement this interface.

 Context Class 3 of 3 tests passing
Create and implement a Context class following the class diagram below. Make sure to add getters and setters for all attributes.

 Implement isChaptersSortedByName 1 of 1 tests passing
Implement the helper method that determines if the e-book's chapters are sorted by name or not. Return true if chapters are sorted by name, otherwise false. This method should later be used to determine which search algorithm is used. Do not traverse the chapter list more than once and do not modify it.
 Implement search 2 of 2 tests passing
Implement the search method according to the class diagram below. The method should execute the search in the book based on the searchAlgorithm.
 Context Policy 4 of 4 tests passing
Create and implement a Policy class following the class diagram below with a simple configuration mechanism. Make sure to add a constructor that takes a Context object as a parameter. The following two tasks should be implemented in the configure method.

 Select Linear Search 2 of 2 tests passing
Select LinearSearch when chapters are not sorted by name because BinarySearch requires a sorted list and sorting is additional overhead.
 Select Binary Search 1 of 1 tests passing
Select BinarySearch when chapters are already sorted by name because then BinarySearch is more efficient and applicable.
Complete the Client class which demonstrates switching between two strategies at runtime. This class is not tested.
<img width="891" alt="image" src="https://github.com/tstren1223/TUM_SW5/assets/64294878/2b75efbf-54e1-41f2-9ea8-18381e4a6d1d">
2:
Adapter Pattern
One of your fellow students stepped on the Celsius thermometer at TUM, and it broke. Luckily, you just learned about the adapter pattern and know that the Fahrenheit thermometer is still intact. Therefore, you want to use your newly acquired knowledge to help your colleague out and get the Celsius display working again.

You have the following tasks:

 Create the class ThermoAdapter that implements ThermoInterface 2 of 2 tests passing
Make sure to add ThermoAdapter in the same package

 Add an association to FahrenheitThermo in ThermoAdapter 1 of 1 tests passing
Name the attribute thermo and make sure to instantiate it

 Implement the method in ThermoAdapter 2 of 2 tests passing
Delegate the method call to the FahrenheitThermo attribute thermo and convert the return value using the formula (tempF - 32.0) * 5.0 / 9.0

 Use ThermoAdapter to display the current temperature 1 of 1 tests passing
Replace the implementation of CelsiusThermo in TemperatureCurve with ThermoAdapter.
<img width="668" alt="image" src="https://github.com/tstren1223/TUM_SW5/assets/64294878/335f43e7-3bbc-4286-9762-68a504e42ccf">
3:
Parallelism
In this exercise, we want to explore deadlocks using a swimming pool facility.

Here is an overview of the system: We have a SwimmingPool, which contains exactly one ChangingRoom and one Locker (for the sake of simplicity; a real swimming pool would obviously have more of each). Before entering the SwimmingPool, Swimmers must change their clothes in the changing room and lock their clothes in the locker. The locker should stay locked until the swimmer is done with their swimming session, and the key to the changing room should also be kept until the swimmer leaves the facility (this implies that only one swimmer at a time can swim in our pool). Different swimmers should be able to request entry to the swimming pool (using goToSwimmingPool) from multiple different threads simultaneously.

Part 1: Create the deadlock
 Create the deadlock 4 of 4 tests passing
Your first task is to use the mutexes provided in the ChangingRoom and Locker classes to lock and unlock accordingly. Make sure to also set the new occupants of the changing room and locker. Since we expect acquireKey() to be called before releaseKey() in ChangingRoom, the tests assume you implement them in this order (the same goes for Locker). We will learn later on that this will (purposefully for this exercise) create a deadlock in a specific situation. Do not remove the takeSomeTime() calls from the methods, as they are required to increase the likelihood of deadlocks (significantly).

Note: The tests for part 2 and part 3 expect part 1 to be implemented correctly.

Part 2: Detect the deadlock
 Detect the deadlock 1 of 1 tests passing
We will now explore why a deadlock can occur here: The SwimmingPoolActionOrder specifies the two possible orders for entering the swimming pool facility: A Swimmer can either use the ChangingRoom before the Locker, or the Locker before the ChangingRoom. However, our current system allows the multi-threaded situation where one swimmer on one thread wants to use one of the orders and another swimmer from another thread wants to use the other order. You should complete the detectDeadlock function in Main, that creates this situation. If you implemented task 1 correctly (i.e. you created the environment required for the deadlock to occur), then executing the main function should lead to it "getting stuck"/blocking/not terminating, as this is what deadlocks do.

Hint: You will have to spawn multiple threads and create the exact interleaving that leads to the deadlock.

Hint: An easy way to test that your detectDeadlock function is actually blocking is to add a print statement under the detectDeadlock call in the main function. If said print statement is actually called, you know that detectDeadlock is not actually blocking (even though it might look like it is).

Part 3: Prevent the deadlock
 Prevent the deadlock 1 of 1 tests passing
Finally, we want to remove the deadlock (without simply removing what we added in task 1). We can achieve this by enforcing a global order (consistent across all threads) of acquiring the ChangingRoom and Locker. This means that we will reject any entry request by a swimmer that contains an order different to our prescribed order. You may print a meaningful message to stdout when rejecting such entry requests. Make your changes to handleEntryRequestDeadlockFree, which currently just forwards to handleEntryRequest in SwimmingPool. You may reuse as much code from handleEntryRequest as you see fit.

If you implemented this part correctly, you should be able to run your main function from part 2 and see that executing it actually terminates now. You might have to replace the handleEntryRequest() call with a handleEntryRequestDeadlockFree call in goToSwimmingPool in Swimmer to use our updated deadlock free implementation, depending on your implementation of part 2.

