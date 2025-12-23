Sure, Minsu! Here's a **complete list of commonly used `ArrayList` methods in Java** along with their **time complexity** (in **average case**, unless otherwise noted):

---

### ✅ **Basic Methods**

| Method                             | Description                                      | Time Complexity |
|------------------------------------|--------------------------------------------------|------------------|
| `add(E e)`                         | Add element to end                               | O(1) *amortized* |
| `add(int index, E element)`        | Add element at specific index                    | O(n)             |
| `get(int index)`                   | Get element at index                             | O(1)             |
| `set(int index, E element)`        | Replace element at index                         | O(1)             |
| `remove(int index)`                | Remove element at index                          | O(n)             |
| `remove(Object o)`                 | Remove first occurrence of element               | O(n)             |
| `contains(Object o)`               | Check if element exists                          | O(n)             |
| `indexOf(Object o)`                | Get first index of element                       | O(n)             |
| `lastIndexOf(Object o)`            | Get last index of element                        | O(n)             |
| `size()`                           | Return number of elements                        | O(1)             |
| `isEmpty()`                        | Check if list is empty                           | O(1)             |
| `clear()`                          | Remove all elements                              | O(n)             |
| `toArray()`                        | Convert to array                                 | O(n)             |
| `toArray(T[] a)`                   | Convert to typed array                           | O(n)             |

---

### 🔄 **Iteration Methods**

| Method                             | Description                                      | Time Complexity |
|------------------------------------|--------------------------------------------------|------------------|
| `iterator()`                       | Returns iterator                                | O(1)             |
| `listIterator()`                   | Returns list iterator                           | O(1)             |
| `forEach(Consumer action)`         | Performs action on each element                 | O(n)             |

---

### 🔍 **Bulk Operations**

| Method                             | Description                                      | Time Complexity |
|------------------------------------|--------------------------------------------------|------------------|
| `addAll(Collection c)`             | Add all elements from another collection        | O(m)             |
| `removeAll(Collection c)`          | Remove all elements in given collection         | O(n×m)           |
| `retainAll(Collection c)`          | Retain only elements in given collection        | O(n×m)           |
| `containsAll(Collection c)`        | Check if list contains all elements             | O(n×m)           |

> Here `n` is the size of the list, and `m` is the size of the input collection.

---

### ✂️ **Sublist & Range Operations**

| Method                             | Description                                      | Time Complexity |
|------------------------------------|--------------------------------------------------|------------------|
| `subList(int from, int to)`        | Get a view of portion of the list               | O(1)             |

---

### 🧠 Bonus Utility

| Method                             | Description                                      | Time Complexity |
|------------------------------------|--------------------------------------------------|------------------|
| `ensureCapacity(int minCapacity)` | Increase internal capacity                      | O(n)             |
| `trimToSize()`                     | Reduce capacity to current size                 | O(n)             |

---

Let me know if you want a **summary chart**, **Java examples**, or want to learn which of these are most **commonly used in coding interviews** 😊