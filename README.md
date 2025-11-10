# Randomized BST for Large Depositors

## Overview
This project implements a program based on **Randomized Binary Search Trees (BST)** to manage depositors and apply operations to them.  
Additionally, it examines potential illegal income and unexplained savings that are not justified by the depositor's profession.

---

## Classes and Methods

### `LargeDepositor`
The `LargeDepositor` class contains:

- **Getters and setters** for depositor attributes.  
- **`compareTo(target)`**: Compares the suspicion level of two depositors.  
  - If suspicion levels are equal, the depositor with **lower income** is considered more “suspicious.”  
- **Suspicion calculation**: Computes the suspicion score of a depositor.  
- **`toString()`**: Returns a string representation of the depositor.

---

### `RandomizedBST`
The `RandomizedBST` class implements the interface and contains the following methods:

- **`isEmpty`**: Returns whether a tree node is empty.  

- **`insert`**: Calls the recursive function `insertAsRoot`.  
  - `insertAsRoot` calculates the probability of placing the node to the left or right and inserts accordingly.  
  - Updates the tree size.  
  - **Complexity:** `O(log N)` for balanced tree, `O(N)` for degenerate (“straight”) tree.

- **`load`**: Reads depositor data from a `.txt` file sequentially and inserts them into the tree.  
  - Complexity: `O(N)` for sequential insertion; overall `O(N * log N)` with insert.

- **`updateSavings`**: Updates a depositor's savings based on their tax ID (AFM).  
  - Uses `searchByAFM` to locate the depositor.

- **`searchByAFM`**: Calls the recursive helper `recursiveSearch`.  
  - Moves through nodes based on the key.  
  - **Complexity:** `O(log N)` for balanced tree, `O(N)` for degenerate tree.

- **`searchByLastName`**: Returns a list of depositors with the same last name using `nodeAppend`.  
  - `nodeAppend` creates a singly linked list of depositors with the same last name, which is returned by the main method.  
  - **Complexity:** `O(N)` for sequential list insertion.

- **`remove`**: Similar to search, but deletes the depositor with the specified key and updates the tree.  
  - **Complexity:** `O(log N)` for balanced tree, `O(N)` for degenerate tree.

- **`getMeanSavings`**: Uses helper `traverseSavings` to sum all depositor savings and returns the average.  
  - **Complexity:** `O(N)`.

- **`printTopLargeDepositors`**: Uses the comparator in `LargeDepositor` to maintain a list of the top `K` suspicious depositors.  
  - If the list is full, it compares the smallest value with the candidate and swaps positions if needed.  
  - **Complexity:** `O(N log K)`, with `N` nodes and `K` top candidates.

- **`printByAFM`**: Prints all depositors in ascending order of their AFM.  
  - **Complexity:** `O(N)`.

---

## Complexity Overview

| Method                       | Best Case (Balanced) | Worst Case (Degenerate) |
|-------------------------------|-------------------|------------------------|
| `insert` / `insertAsRoot`     | O(log N)          | O(N)                   |
| `searchByAFM`                 | O(log N)          | O(N)                   |
| `searchByLastName`            | O(N)              | O(N)                   |
| `remove`                      | O(log N)          | O(N)                   |
| `getMeanSavings`              | O(N)              | O(N)                   |
| `printTopLargeDepositors`     | O(N log K)        | O(N log K)             |
| `printByAFM`                  | O(N)              | O(N)                   |

---

This project provides a structured way to manage large depositors, detect suspicious activity, and efficiently maintain a dynamic dataset using **Randomized BSTs**.
