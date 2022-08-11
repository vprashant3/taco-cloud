# Clean Code Notes

## Meaningful Names
    - Use intention revealing names 
    - Avoid disinformation while naming a vriable
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
    
    