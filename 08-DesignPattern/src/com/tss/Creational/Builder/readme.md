# 🏗 Builder Design Pattern

## 📌 Definition

The **Builder Pattern** is a creational design pattern used to construct complex objects step by step.
It separates the object construction process from its representation.

---

## 🎯 What Problem Does It Solve?

When a class has:

* Many fields
* Required and optional parameters
* Too many constructor arguments
* Multiple overloaded constructors

It leads to:

* Confusing constructor calls
* Parameter order mistakes
* Hard-to-read code
* Poor maintainability

Example (not readable):

```java
new User("Aarav", 26, "New York", "1234567890", true, true);
```

This situation is known as the **Telescoping Constructor Problem**.

---

## ✅ How Builder Solves the Problem

1. Required parameters are passed first.
2. Optional parameters are set step by step.
3. `build()` creates the final object.

Example:

```java
User user = new User.Builder("Aarav", 26)
        .city("New York")
        .phone("1234567890")
        .isAdmin(true)
        .isActive(true)
        .build();
```

✔ Clear
✔ Readable
✔ Flexible
✔ No parameter confusion

---

# 🔄 What is Fluent Interface?

A **Fluent Interface** is a design style where methods return the same object so that multiple methods can be chained together in a single statement.

In simple words:

> Methods return `this` so we can keep calling methods one after another.

---

## 🔹 Example from Builder (Fluent Version)

```java
public Builder city(String city) {
    this.city = city;
    return this;
}
```

Here:

* `this.city = city;` → sets the value
* `return this;` → returns the same Builder object

So we can write:

```java
new User.Builder("Aarav", 26)
        .city("New York")
        .phone("1234567890")
        .isAdmin(true)
        .build();
```

Each method returns the same `Builder`, allowing the next method to be called.
This flowing style is called **Fluent Interface**.

---

# 🏗 What Happens If Methods Return `void` Instead of `Builder`?

## 📌 Scenario

Suppose we modify the Builder methods like this:

```java
public void city(String city) {
    this.city = city;
}

public void phone(String phone) {
    this.phone = phone;
}
```

Now the return type is `void` instead of `Builder`.

---

## ❌ What We Lose

Method chaining will **not work**.

This will give a compile-time error:

```java
new User.Builder("Aarav", 26)
        .city("New York")
        .phone("1234567890")   // ❌ ERROR
        .build();
```

### Why?

Because:

* `city()` now returns `void`
* `void` does not return an object
* So `.phone()` cannot be called on it
* The method chain breaks

---

## ✅ How It Must Be Written Now

Without method chaining, we must write:

```java
User.Builder builder = new User.Builder("Aarav", 26);

builder.city("New York");
builder.phone("1234567890");
builder.isAdmin(true);
builder.isActive(true);

User user = builder.build();
```

This works correctly.

---

## 🔎 Difference Between Both Approaches

| With `Builder` Return Type | With `void` Return Type |
| -------------------------- | ----------------------- |
| Supports method chaining   | No method chaining      |
| Fluent and readable        | More verbose            |
| Looks clean                | Looks traditional       |
| Uses Fluent Interface      | No Fluent Interface     |

---

## 🧠 Important Concept

Method chaining works only when each method:

* Returns the same object (`this`)
* So the next method can be called immediately

If a method returns `void`, the chain stops.

---

## 🔒 Why Constructor is Private?

```java
private User(Builder builder)
```

* Prevents direct object creation
* Forces object creation through Builder
* Ensures controlled and valid construction

---

## 📦 Why Builder Class is Static?

```java
public static class Builder
```

* Belongs to `User`
* Does not need outer class instance
* Used only to build `User`

---

## 🧠 Internal Working

1. Builder collects data.
2. `build()` calls the private constructor.
3. Constructor copies values from Builder.
4. Final object is created.
5. Fields are `final`, so object becomes immutable.

---

## 🏢 Where Is It Used?

* User/Profile objects
* Configuration objects
* DTO classes
* Request/Response objects
* Java libraries like `StringBuilder`

---

## ✅ Advantages

* Improves readability
* Avoids constructor overload
* Prevents parameter mistakes
* Supports immutability
* Easy to maintain

---

## 🎯 Final Conclusion

Using `void` does **not break the Builder pattern logic**,
but it removes the **Fluent Interface style**, making the code less readable and less expressive.

---

## 🎤 One-Line Summary

> Builder Pattern constructs complex objects step by step using a fluent interface, improving readability, flexibility, and maintainability while avoiding constructor overload problems.

---