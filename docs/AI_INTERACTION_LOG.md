## Chat GPT will be used for this project

## The AI Code is in the Bag, Container and BagTest Class

## It created a code that meets the requirement.

## I then ask AI to approve specific aspects of iterative refinement using the code. It generated some steps to improve it instead of the code just perfect as is.
✅ Key Refinement Goals:
1.	Encapsulation & Defensive Programming
2.	Error Handling & Input Validation
3.	Code Efficiency & Readability
4.	Iterative Refinement Documentation & Design Clarity

## Below is an iteratively refined version of your code with explicit notes on what each improvement achieves.
## The Bag class is changed and this comment is added: 
/**
* A generic Bag class that allows duplicate elements.
* Uses an ArrayList as the backing data structure.
*
* Iterative Refinement Goals:
* - Improved encapsulation
* - Defensive programming (null safety)
* - Immutable iterator exposure
* - Clear documentation and consistent design
    */
## And the summary of this. 
✅ Summary of Iterative Refinement Improvements
Focus	Improvement	Example
Encapsulation	No external access to items	private final List<E> items
Safety	Iterator returns a copy	new ArrayList<>(items).iterator()
Extensibility	Additional constructor	new Bag<>(List.of("a", "b"))
Usability	Added clear() and toString()	Easier debugging
Maintainability	Added clear documentation	JavaDoc at class level

## Then finally will use the updated code that iteratively refined ask AI explicitly request coverage of empty bags, single items, multiple items, removal scenarios, and iterator behavior.

## A lot more test were completed around 14 tests were passed and the updated coded that is current is in their classes