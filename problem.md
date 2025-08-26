# Valid Parentheses (LeetCode 20)

## Problem Statement
You are given a string `s` consisting only of the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`.

Return `true` if the input string is **valid**, and `false` otherwise.

A string is valid **iff**:
1. Every open bracket is closed by the same type of close bracket.
2. Open brackets are closed in the correct order (properly nested).
3. Every close bracket has a corresponding prior open bracket of the same type.

**Constraints**
- `1 <= s.length <= 1000`
- `s` contains only the six bracket characters.

---

## Examples

**Example 1**
```
Input: s = "[]"
Output: true
```

**Example 2**
```
Input: s = "([{}])"
Output: true
```

**Example 3**
```
Input: s = "[(])"
Output: false
Explanation: The brackets are not closed in the correct order.
```

Additional edge examples:
```
"("        -> false
")"        -> false
"{}[]()"   -> true
"["        -> false
""         -> (not in constraints; if allowed, true)
```

---

## Intuition (Why a Stack?)
- Brackets must close in the **reverse** order they open → Last-In-First-Out (LIFO).
- A stack naturally tracks the **most recent** unmatched opening bracket.
- When you see an opening bracket, push the **expected matching closer** (e.g., for `'('` push `')'`).
- When you see a closing bracket, it must equal the top of the stack; otherwise the string is invalid.
- At the end, the stack must be empty (all opens properly closed).

This approach avoids repeatedly checking pairs in both directions and keeps the logic concise and safe.

---

## Pseudocode
```
function isValid(s):
    create empty stack
    for each char c in s:
        if c is '(':
            push ')' onto stack
        else if c is '{':
            push '}' onto stack
        else if c is '[':
            push ']' onto stack
        else:
            if stack is empty:
                return false
            top = pop from stack
            if top != c:
                return false
    return stack is empty
```

---

## Time & Space Complexity
- **Time:** `O(n)` — each character is pushed/popped at most once.
- **Space:** `O(n)` — in worst case (all openings), stack holds up to `n` items.


---

## Dry Run
`s = "([{}])"`
- `(` → push `)` → stack: `)`
- `[` → push `]` → stack: `) ]`
- `{` → push `}` → stack: `) ] }`
- `}` → pop `}` matches → stack: `) ]`
- `]` → pop `]` matches → stack: `)`
- `)` → pop `)` matches → stack: empty → **valid**

`s = "[(])"`
- `[` → push `]`
- `(` → push `)` → stack: `] )`
- `]` → pop `)` ≠ `]` → **invalid**

---

## Test Cases
```
true:  "()", "()[]{}", "{[()()]}", "([{}])", "{()}[]"
false: "(]", "([)]", "(", ")", "[(])", "["
```
