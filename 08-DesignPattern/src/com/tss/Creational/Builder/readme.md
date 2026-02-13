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

This is called the **Telescoping Constructor Problem**.

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

## 🔹 Example from Builder

```java
public Builder city(String city) {
    this.city = city;
    return this;
}
```

Here:

* `this.city = city;` → sets value
* `return this;` → returns same Builder object

So we can write:

```java
new User.Builder("Aarav", 26)
        .city("New York")
        .phone("1234567890")
        .isAdmin(true)
        .build();
```

Each method returns the same `Builder`, allowing the next method to be called.

This flowing style of writing code is called **Fluent Interface**.

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
2. `build()` calls private constructor.
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

## 🎤 One-Line Summary

> Builder Pattern constructs complex objects step by step using a fluent interface, improving readability and flexibility while avoiding constructor overload problems.

---