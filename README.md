# Bonus Task: Edge Removal from a Minimum Spanning Tree (MST)

This project is an implementation of the Bonus Task for the course assignment.  
The goal is to efficiently remove an edge from an MST and find a replacement edge  
so that the graph remains a Minimum Spanning Tree.

The project is implemented in **Java**, structured as a **Maven** project,  
and organized in a **GitHub repository** so it can be easily cloned and executed.
---

## What This Program Does

The program:

1. Builds a Minimum Spanning Tree (MST) from a given weighted graph using **Kruskal's Algorithm**.
2. Displays all edges of the MST before removing any edge.
3. Removes one edge from the MST.
4. Shows the resulting connected components after the removal.
5. Finds the minimum-weight replacement edge that reconnects the components.
6. Displays the **new MST** after reconnection.

This demonstrates the ability to:
- Implement MST from scratch,
- Correctly break an MST,
- Efficiently reconnect it with the optimal edge.


#  How I Built the Project (Step by Step)

Below is the full explanation of what was done to complete the assignment:

---

## **Created a Maven Project in IntelliJ IDEA**  
- Created the folder structure:
- src/main/java/org/example/
- 
- Added all required `.java` files there.

This ensures the project can be compiled and run easily after cloning.

---

## ** Implemented All Required Classes**

The project contains the following files:

###  `Edge.java`
Represents a weighted graph edge and implements `Comparable` for sorting.

### `Graph.java`
Stores vertices and all graph edges.

### `UnionFind.java`
Implements Disjoint Set Union (DSU) for cycle detection in Kruskal’s algorithm.

### `MST.java`
Contains:
- Kruskal MST builder,
- Logic for finding replacement edges when the MST is split.

### `Main.java`
Coordinates the full process:
- builds MST,  
- removes an edge,  
- finds components,  
- finds replacement edge,  
- prints the final MST.

---

## ** Added All Classes to GitHub Repository**

I created a GitHub repository, then connected IntelliJ to GitHub using: Git → Manage Remotes → origin → GitHub link

Then committed and pushed the entire project.

This satisfies the requirement that the solution must run after cloning.

---

## ** Tested the program and verified output correctness**

The program prints:

- Full MST,
- Removed edge,
- Components after removal,
- Replacement edge,
- Final MST after reconnection.

Everything matches the behavior required in the assignment.

---

#  How to Run the Program

## **Option 1 — Run in IntelliJ IDEA**
1. Clone the repository:
2. Open the project in IntelliJ.
3. Make sure JDK (Java 17+) is selected.
4. Run the file:
5. The output will appear in the console.

---

## **Option 2 — Run Using Maven (Command Line)**

1. Clone the repository:

2. Compile the project:

3. Run the program:

---

#  Program Output Explanation

Example of what the program prints:

MST before removal:
1 -- 2 (1)
1 -- 3 (2)
3 -- 4 (2)
0 -- 2 (3)
4 -- 5 (6)

Removed edge: 3 -- 4 (2)

Components after removal:
Component: [0, 1, 2, 3]
Component: [4, 5]

Replacement edge: 3 -- 4 (2)

New MST:
1 -- 2 (1)
1 -- 3 (2)
0 -- 2 (3)
4 -- 5 (6)
3 -- 4 (2)


This shows:
- The MST was built,
- One edge was removed,
- The tree split into two components,
- The program correctly found the minimum-weight edge reconnecting them.

---

# Algorithms Used

### **Kruskal's MST Algorithm**
- Sort all edges by weight.
- Add edges while avoiding cycles (using Union-Find).
- Produces a minimum spanning tree.

### **Union-Find (Disjoint Set Union)**
Used to:
- Detect cycles,
- Identify connected components after edge removal,
- Check whether an edge reconnects components.

### **Replacement Edge Search**
To reconnect the MST:
- Iterate over all edges,
- Check if they connect two different components,
- Choose the one with minimal weight.



#  Author
Anetbayeva Dilyara. SE-2427





