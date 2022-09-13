
    • Dummy objects
    • Stubs
    • Spies
    • Mock objects
    • Fake objects
    
A common understanding of unit testing is the testing of the smallest possible part of 
software, such as a single method, a small set of related methods, or a class.

In reality, we do not test methods; we test **a logical unit and its behavior** instead. 
Logical units can extend to a single method, to an entire class, or a collaboration 
of multiple classes.


benefits of test automation:

    Behavior is continually verified。
    The side effects of code changes are detected immediately。
    Saves time; no need for immediate regression testing。
    
A unit test should exhibit the following characteristics:

    • It should be automated.
    • It should have a fast test execution.
    • A test should not depend on the result of another test or rather test execution order.
    • A test should not depend on database access, file access, or any long running task.
    • A test result should be consistent and time-and-location transparent.
    • Tests should be meaningful.
    • Tests are system documentation.
    • Tests should be short and tests should not be treated as second-class citizens.
    
