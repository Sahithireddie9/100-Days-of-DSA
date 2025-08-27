# LeetCode 150. Evaluate Reverse Polish Notation

## ✅ Problem Statement

You are given an array of strings `tokens` that represents an arithmetic expression in **Reverse Polish Notation (RPN)**.  
Evaluate the expression and return the integer result.

**Notes:**  
- Valid operators: `+`, `-`, `*`, `/`  
- Each operand may be an integer or another expression  
- Division between two integers **truncates toward zero**  
- No division by zero will occur  
- Input is a valid RPN expression  
- All intermediate results fit in a 32-bit signed integer

---

## 🧪 Examples

**Example 1**  
**Input:** `["2","1","+","3","*"]`  
**Output:** `9`  
**Explanation:** `((2 + 1) * 3) = 9`

**Example 2**  
**Input:** `["4","13","5","/","+"]`  
**Output:** `6`  
**Explanation:** `(4 + (13 / 5)) = 6`

**Example 3**  
**Input:** `["10","6","9","3","+","-11","*","/","*","17","+","5","+"]`  
**Output:** `22`  
**Explanation:**  
```
((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= 17 + 5
= 22
```

---

## 🔒 Constraints

- `1 <= tokens.length <= 10^4`
- `tokens[i]` is either an operator: `"+", "-", "*", "/"`, or an integer in the range `[-200, 200]`

---

## 💡 Intuition (Using a Stack)

Reverse Polish Notation is naturally evaluated using a **stack**:

- When we see a **number**, push it onto the stack.  
- When we see an **operator**, we **pop** the top two numbers `b` (right operand) and `a` (left operand) from the stack, compute `a op b`, and push the result back.

This works because in RPN, operands always appear **before** their operator, so the stack holds the most recent operands ready for calculation.

> ⚠️ Order matters for `-` and `/`:  
> If you pop `a` then `b`, compute `b - a` and `b / a` respectively.

Also, in Java, integer division **truncates toward zero** by default, which matches the problem requirement.

---

## 🧰 Algorithm

1. Initialize an empty stack of integers.  
2. For each token in `tokens`:
   - If it's a number → parse and **push** to the stack.
   - If it's an operator:
     - **Pop** the top two numbers: `a = stack.pop()`, `b = stack.pop()`
     - Compute `b op a` depending on the operator.
     - **Push** the result back to the stack.
3. At the end, the stack contains exactly one element — **return** it.

---

## 🧾 Pseudocode

```
stack = empty stack

for token in tokens:
    if token is an operator in {+, -, *, /}:
        a = stack.pop()   // right operand
        b = stack.pop()   // left operand
        if token == "+": stack.push(b + a)
        else if token == "-": stack.push(b - a)
        else if token == "*": stack.push(b * a)
        else if token == "/": stack.push(b / a)  // truncates toward zero
    else:
        stack.push(parseInt(token))

return stack.pop()
```

---

## ⏱️ Time & Space Complexity

- **Time:** `O(n)` — each token is processed once.  
- **Space:** `O(n)` in the worst case (all numbers before any operators).

---

## ✅ Java Solution 

```java
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);  // Java truncates toward zero
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
```

---

## 🧭 Edge Cases to Consider

- Single operand: `["5"] → 5`  
- Negative numbers: `["-2","3","*"] → -6`  
- Mixed operations: `["3","-4","+","2","/"] → (-1)/2 = 0` (truncates toward zero)  
- Long expressions with many tokens

---

## 🧪 Quick Test Inputs

```
["2","1","+","3","*"]               // 9
["4","13","5","/","+"]              // 6
["10","6","9","3","+","-11","*","/","*","17","+","5","+"] // 22
["5"]                               // 5
["-2","3","*"]                      // -6
["3","-4","+","2","/"]              // 0
```

---

## 📝 Notes

- Using `Stack<Integer>` is fine; alternatively, you can use `ArrayDeque<Integer>` for better performance in modern Java.
- Ensure you always pop in the correct order for `-` and `/`.  
