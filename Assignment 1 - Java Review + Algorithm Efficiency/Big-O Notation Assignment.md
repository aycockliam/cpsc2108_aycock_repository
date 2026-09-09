---
created: 2026-08-28
tags:
  - cpsc2108
  - computerscience
  - datastructures
---
# Code Segments

## Segment 1
```java
int first = arr[0];
System.out.println("First element: " + first);
```
## Segment 2
```java
int sum = 0;
for (int i = 0; i &lt; n; i++) {
sum += arr[i];
}
```
## Segment 3
```java
int i = n;
int steps = 0;
while (i > 1) {
i = i / 2;
steps++;
}
```
## Segment 4
```java
for (int row = 0; row < n; row++) {
for (int col = 0; col < m; col++) {System.out.print(row * col + " ");}
System.out.println();
}

```
## Segment 5
```java
for (int i = 0; i < n; i++) {
System.out.println("n-item " + i);
}
for (int j = 0; j < m; j++) {
System.out.println("m-item " + j);
}
```
# B.1
## Segment 1
The runtime complexity of this code block is **O(1)**. The reason why is because we are simply retrieving data from an array and outputting it. There is no looping involved. It has no dependency on input size.
## Segment 2
This segment has a complexity of **O(n)**. We are iterating through all the data of an array making our runtime complexity a constant of whatever `n` is when it runs. If we have 3 index positions the code runs 3 times, likewise for 1,000,000.
## Segment 3
This segment has a complexity of **O(log n)**. The reason it has this complexity is because every iteration mathematically cuts `n` in half and therefore the numbers we need to divide by two is cut in half every single iteration.
## Segment 4
This segment has a complexity of *O(n·m)*. There is a nested for loop where the outer loop is run `n` times and the inner one (for each run of the outer) is run `m` times.
## Segment 5
This segment has a complexity of **O(n+m)**. This is because the loops are separated and we iterate through each dependent on the magnitudes of the respective variables.
# B.2
## Response
I have multiple methods but the primary one that involves iterting over an array is my `Dice.addStreak()` method. It takes in an array and a number and adds it. It does this by making a new array, adding all values from the previous array over and adding that last one. My prediction for complexity is **O(n)** because we are simply going over it for as many rolls as we have. Therefore it will be a linear increase in time.
## Test
When we run the program rolling only 10 times we get a nanotime of 1332, with 100 rolls we get 5446. If it were exactly linear then we would get a runtime of the 100 rolls of 13320. However there is probably more going on here like my CPU cycling up and down. To be truly scientific about it we would need more consistent environmental variables.
