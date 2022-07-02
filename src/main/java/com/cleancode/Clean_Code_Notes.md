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
    
   
    