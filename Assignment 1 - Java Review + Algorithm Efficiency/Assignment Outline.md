# Assignment Prompt
**This assignment covers Modules 1 and 2.**
Part A reviews core Java fluency and introduces the GitHub workflow you will use for every code submission this semester. Part B introduces Big-O notation and asks you to connect theoretical complexity to what you actually observe when your own code runs.
## Learning Objectives
- Refresh core Java fluency before the semester's data structures content begins
- Demonstrate the GitHub workflow (repository, commits, push)
- Explain and apply Big-O notation to analyze code
- Connect theoretical complexity to observed/empirical behavior
## Part A — Programming (Student-Chosen Topic)
Choose your own small program topic — build anything you'd like (a simple game, a calculator, a simulator, a text-based tool, a tracker, etc.) as long as your program demonstrates every required component listed below.

**What NOT to use:** This is a review of core, pre-collections Java. Do **not** use ArrayList, LinkedList, or any class from java.util that acts as a dynamic collection — use plain arrays only. Do **not** write setter or getter methods; the two user-defined methods required below must each do something more meaningful than simply assigning or returning a field.
### Example Project Idea
To show how the required components can fit together, here's one possible topic (you are not required to use this idea — pick your own):

**Dice-Roll Streak Tracker** — the program simulates rolling a die a set number of times (stored in an int[] array), then reports the longest streak of consecutive rolls above a threshold the user enters. A Roll class could hold a face value and a field noting whether it counted toward a streak, with a constructor that sets the face value. One method could scan the array to compute the longest streak (returns an int); a second could print a formatted summary of the results. A loop fills and scans the array, an if/else decides whether each roll extends or breaks a streak, and Scanner reads the number of rolls and the threshold from the user.

Other quick ideas: a grade calculator, a number-guessing game, a basic inventory/roster tracker, a unit converter, or a simple quiz/trivia program.
### Required Components
Your submission must include all of the following. Use the table below as a self-check before submitting.
1. At least one array. (Must be a plain array.)
2. At least one loop and one conditional.
3. At least two user-defined methods.
4. At least one custom class with a constructor and a field.
5. Basic input handling.
6. GitHub repository with 2-3 incremental commits.
### GitHub Requirements
Every code submission in CPSC 2108 goes through GitHub — if you haven't already, work through the Getting Started with GitHub activity from Module 1 before starting Part A. For this assignment, your repository should show:

- A repository created for this assignment (I recommend making it private for now)
- 2–3 incremental commits with clear messages showing real progress (e.g., "add Item class," "implement processData method," "add input handling") — not a single commit dumping the finished program
- A final push of your completed, working code
## Part B — Written Analysis (Algorithm Efficiency)
**40 points.** Submit as a typed PDF or Word document. Show your reasoning — a bare answer like "O(n)" with no justification earns partial credit at best.
### B.1 Big-O Identification (20 points, 4 points each)
For each code segment below, state the tight Big-O bound for its time complexity in terms of n (and m, where it appears), and justify your answer in 2–3 sentences by describing how the number of operations grows as the input grows.

_Segment 1_
```java
int first = arr[0];
System.out.println("First element: " + first);

```

_Segment 2_
```java
int sum = 0;

for (int i = 0; i &lt; n; i++) {
  sum += arr[i];
}

```

_Segment 3_
```javascript
int i = n;
int steps = 0;

while (i > 1) {
  i = i / 2;
  steps++;
}
```

_Segment 4_
```java
for (int row = 0; row < n; row++) {
  for (int col = 0; col < m; col++) {
    System.out.print(row * col + " ");
  }
  System.out.println();
}
```

_Segment 5_
```java
for (int i = 0; i < n; i++) {
  System.out.println("n-item " + i);
}

for (int j = 0; j < m; j++) {
  System.out.println("m-item " + j);
}
```

### B.2 Empirical vs. Theoretical (20 points)
Use the required method from Part A that takes your array as a parameter and iterates over it — this is the method whose runtime should scale with the array's size. Do the following:

- Predict its Big-O complexity before timing it, and briefly justify your prediction.
- Using System.nanoTime(), time the method at two different input sizes (e.g., run it on a small array and again on a much larger one — resize/regenerate your array as needed).
- Report both timings and describe whether the change in runtime is consistent with your predicted complexity.
- In 3–5 sentences, explain any mismatch between your prediction and your observed timings, or note if a match confirms your reasoning.
## Deliverables
- GitHub repository link with your Part A code and commit history
- Screenshot of your code running
- Written responses for Part B (B.1 and B.2), submitted as a typed PDF or Word document