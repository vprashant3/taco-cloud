# Clean Code Notes

## Meaningful Names
    - Use intention revealing names 
    - Avoid disinformation while naming a variable
    - Make meaningful distinctions between variable names to avoid confusion
    - Use pronouncable names so that they can be easily read and talked about
    - Use searchable names to quickly find places of usage and intent
    - Avoid encoded names to skip on un-nedeed complexity in nameing a variable
    - Avoid mental mappig between already knownn vairable names
    - Class names should be nouns or noun phrase names
    - Method names should be verb or verb phrase names
    - Pick one word per concept, ie, of fetch, retrieve and get use one through the code
    - Don't add unncessary context

## Functions
    - A function should be small with descriptive name
    - Function should do one thing and do it well
    - One level of abstraction per function
    - Keep number of function arguments to a minimum, preferably less than 3
    - A single input function which takes an event and alters its state with no output, is also fine
    - function should have no side effects
    - there should be separate functions for command(write) and query(read)
    - prefer exceptions to returning error codes, as returned error codes need to be handled immediately in the happy path
    - extract try/catch block
    - have separate dedicated functions for error handling
    - don't repeat yourself

### Comments
    - Don't
    - Unless absoloutely necessary
    - TODO's are fine
    - Don't use a comment when you can use a function or variable
    - If a line of code can be commented, it doesn't need to be in the codebase and should be removed.
    

### Objects and Data Structures
    - Hide the data and code to an interface with defined access methods.
    - Data Structures hold data and have no functions. 
    - Objects hide data and have functions
    - Data structures and objects are opposites.
    - The law of demeter says functions should not not know innards of objects it manipulates.

### Error Handling
    - Use exceptions rather than return codes
    - Try to write tests that force exceptions and then handle them
    - Use unchecked exceptions as with checked exceptions all the callers have to be modified and break open/close principle.
    - Provide context with exceptions
    - Define exceptions in terms of caller's needs
    - Don't return nulls or pass nulls, either throw exceptions or pass speical case objects
    
### Boundaries
    - Write test cases to learn about 3rd party APIs and to ensure release dosen't break anything.
    
### Unit Tests
    - Three laws of TDD
        - You may not write production code until you have written a failing unit test.
        - You may not write more of a unit test than is sufficient to fail, and not compiling is failing.
        - You may not write more production code than is sufficient to pass the currently failing test. 
    - Test code is as important as prodution code
    - Follow Build-Operate-Check pattern in test cases.
        - The first part builds up the test data.
        - The second part operates on that test data.
        - The third part checks that the operation yielded the expected results.
    - Tests have different standards that production code, they should be easy to read, but memory and cpu efficiency are not not top priorites.
    - Single concpet per test
    - Clean tests follow the F.I.R.S.T actronym
        - Fast - shouldn't take long to run
        - Independent - one test shouldn't be dependendent on another
        - Repeatable - should be able to run in prod, qa or local env 
        - Self-validating - test should return a pass or fail, and no manual review is needed to understand the result 
        - Timely - tests should be written before production code.
    - If the tests rot, the code will rot too. Keep the tests updated.

### Classes
    - Class Organization
        - public static constants
        - private satic variables
        - private variables
        - public methods
        - private utilites
    - Keep things encapsulated
    - Classes shold be small
    - Classes should have one responsibility and one reason to change

### Systems
    - Separate constructing a system from using it
    - Systems need domain-specific languages
    - Use the simplest thing that can possibly work

