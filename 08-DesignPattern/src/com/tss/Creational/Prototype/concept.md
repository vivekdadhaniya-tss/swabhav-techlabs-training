# 🔹 Prototype Pattern – Shallow vs Deep Copy vs Reference Alias

When using the **Prototype pattern**, the way you implement `clone()` decides what kind of copy you get:

1. **Reference Alias** → `return this;`

    * No new object is created
    * The “clone” points to the **same object**
    * Any change to the clone also affects the original

2. **Shallow Copy** → `return new IDCard(this);`

    * Creates a **new object**
    * Copies **references** of all fields
    * Works fine for immutable fields (`String`, `int`, `boolean`)
    * **Mutable fields** (like objects or lists) are shared → changes affect original

3. **Deep Copy** → `return new IDCard(this)` + clone nested mutable objects

    * Creates a **new object**
    * Creates **new copies of all mutable nested objects**
    * Original and clone are **fully independent**
    * Safe for any changes in the clone

---

## 🔹 Summary Table

| Clone Method / Technique                                   | Object Created? | Copy Type                      | Behavior / Notes                                                      |
| ---------------------------------------------------------- | --------------- | ------------------------------ | --------------------------------------------------------------------- |
| `return this;`                                             | ❌ No            | ❌ Not a copy (Reference Alias) | The clone is the same object; changes affect the original             |
| `return new IDCard(this);`                                 | ✅ Yes           | Shallow Copy                   | New object created; immutable fields safe; mutable objects are shared |
| `return new IDCard(this)` + cloning nested mutable objects | ✅ Yes           | ✅ Deep Copy                    | New object + new copies of mutable fields; clone is fully independent |

---

### 🔹 Quick Conceptual Notes

* **Reference Alias** → No copy at all, just another name for the same object.
* **Shallow Copy** → Object copied, but nested mutable objects are shared.
* **Deep Copy** → Object copied, and all nested objects copied → fully independent clone.
* **Immutable fields** (Strings, int, boolean) are safe with shallow copy.

---

💡 **Example Mapping to Your `IDCard` Project:**

* `return this;` → Template and clone are same → changing `emp1` affects template
* `return new IDCard(this);` → Template and clone share mutable objects (if any)
* `return new IDCard(this)` + deep copy of mutable fields → Template and clone independent

---