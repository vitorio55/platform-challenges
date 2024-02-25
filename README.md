# Platform Challenges
This project is where I store my algorithm studies of solving platform challenges. I will also be adding solutions to
challenges for the job positions to which I will be applying.

## Approach
Each solution is presented in the following format:
- Solution class (inside src/main/java path)
- Solution tests (inside src/test/java path)
- Solution test inputs and outputs (inside src/test/resources path)

To run a solution class, do it from its test class. It will trigger all the registered test cases against the referred 
solution. Test cases data (inputs and ouputs) are stored inside test/resources directory.  

New input and output files should be added to that same structure, following the format 'caseX/input.txt' and
'caseX/output.txt'. To do that we must create a new case directory inside the test/resource appropriate challenge dir.
Then we must set the following constant inside the test
class for the new input and output to be automatically consumed by the test. Let's say we just added case4/input.txt and
case4/output.txt, we must adjust the test class to generate a stream of arguments for the new cases:
```java
private static final int INPUTS_AND_OUTPUTS = 5;
```

There is also a way to run only a single test case. See the 'filter' param when calling inputsOutputsSource method.