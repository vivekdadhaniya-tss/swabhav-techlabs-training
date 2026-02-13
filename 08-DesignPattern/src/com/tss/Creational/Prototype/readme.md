# Prototype Design Pattern

## Definition

The Prototype Pattern is a **creational design pattern** that creates new objects by cloning an existing instance instead of creating them from scratch.

---

## Problem It Solves

When object creation is:

* Expensive,
* Complex,
* Or repeatedly requires the same configuration,

creating new objects using `new` every time leads to duplicated setup and unnecessary overhead.

---

## How It Solves the Problem

* Create a fully configured object (prototype).
* Provide a `clone()` method.
* Generate new objects by copying the prototype.
* Modify only the required fields.

Cloning avoids re-executing initialization logic and reusing configuration setup.

---

## When / Where to Use

Use Prototype when:

* Object creation is costly (e.g., DB/API initialization).
* Many similar objects are required.
* Objects have large or complex configurations.
* Runtime duplication of objects is needed.

---

## One-Line Summary

The Prototype Pattern improves efficiency and flexibility by creating new objects through copying an existing instance rather than rebuilding them from scratch.
