# 📘 PROXY DESIGN PATTERN

---

# 1️⃣ Definition

> Proxy Pattern provides a surrogate (substitute) object that controls access to another real object.

Instead of directly interacting with the real object, the client interacts with a proxy.

```
Client → Proxy → Real Object
```

The client does not know whether it is talking to proxy or real object.

---

# 2️⃣ Why Do We Need Proxy?

Sometimes:

* Object creation is expensive
* Object is located remotely
* Access must be restricted
* Extra functionality (logging, caching, security) is needed
* We do not want to modify the real class

Proxy solves these problems **without changing the original class**.

---

# 3️⃣ Core Structure

### 🔹 Participants

1. **Subject (Interface)**
   Common interface for RealObject and Proxy.

2. **RealSubject (Real Object)**
   The actual object that performs real work.

3. **Proxy**
   Controls access to RealSubject.

---

### 🔹 UML Structure

```
           +------------------+
           |     Subject      |
           +------------------+
              ▲           ▲
              |           |
     +----------------+  +----------------+
     |   RealSubject  |  |     Proxy      |
     +----------------+  +----------------+
                                 |
                                 v
                           RealSubject
```

---

# 4️⃣ Types of Proxy Pattern

There are mainly **3 important types**:

---

# 🔵 1. Virtual Proxy (Lazy Loading)

## 🎯 Purpose

Delay creation of expensive object until needed.

## 📌 When to Use

* Large file loading
* Image loading
* Database connection
* Heavy object initialization

---

## Example

### Interface

```java
interface Image {
    void display();
}
```

### Real Object (Heavy)

```java
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk...");
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
```

### Virtual Proxy

```java
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
```

### Key Idea

Object created only when `display()` is called.

---

# 🔵 2. Protection Proxy (Access Control)

## 🎯 Purpose

Control access to sensitive operations.

## 📌 When to Use

* Role-based access
* Authentication systems
* Authorization checks

---

## Example

### Interface

```java
interface BankAccount {
    void withdraw(double amount);
}
```

### Real Object

```java
class RealBankAccount implements BankAccount {
    public void withdraw(double amount) {
        System.out.println("Withdrawing " + amount);
    }
}
```

### Protection Proxy

```java
class BankAccountProxy implements BankAccount {

    private RealBankAccount realAccount;
    private String userRole;

    public BankAccountProxy(String role) {
        this.userRole = role;
        this.realAccount = new RealBankAccount();
    }

    public void withdraw(double amount) {

        if ("ADMIN".equals(userRole)) {
            realAccount.withdraw(amount);
        } else {
            System.out.println("Access Denied!");
        }
    }
}
```

### Key Idea

Proxy checks permission before allowing operation.

---

# 🔵 3. Remote Proxy

## 🎯 Purpose

Represent object located on another server.

## 📌 When to Use

* Web services
* Microservices
* RMI
* Distributed systems

---

## Example

### Interface

```java
interface WeatherService {
    String getWeather(String city);
}
```

### Real Service (Server Side)

```java
class RealWeatherService implements WeatherService {

    public String getWeather(String city) {
        return "Weather in " + city + " is Sunny";
    }
}
```

### Remote Proxy (Client Side)

```java
class WeatherServiceProxy implements WeatherService {

    private RealWeatherService realService;

    public WeatherServiceProxy() {
        this.realService = new RealWeatherService();
    }

    public String getWeather(String city) {

        System.out.println("Connecting to remote server...");
        return realService.getWeather(city);
    }
}
```

### Key Idea

Client doesn’t know networking details.

---

# 5️⃣ Real-World Examples

* Spring Framework AOP uses proxies internally
* Hibernate uses proxy for lazy loading
* API Gateway acts as proxy
* Firewall acts as protection proxy

---

# 6️⃣ Advantages

✅ Controls access
✅ Improves performance (lazy loading)
✅ Adds security
✅ Follows Open/Closed Principle
✅ Hides complexity

---

# 7️⃣ Disadvantages

❌ Adds extra layer
❌ Can increase complexity
❌ Slight performance overhead

---

# 8️⃣ Proxy vs Decorator (Important)

| Proxy                       | Decorator                        |
| --------------------------- | -------------------------------- |
| Controls access             | Adds behavior                    |
| Focus on protection/control | Focus on functionality extension |
| Usually manages lifecycle   | Usually enhances functionality   |

---

# 9️⃣ When Should You Use Proxy?

Use Proxy when:

✔ Object is expensive
✔ Access must be controlled
✔ Remote communication involved
✔ Logging/caching required
✔ You cannot modify original class

---

# 🔟 Interview One-Line Definition

> Proxy Pattern provides a substitute object that controls access to the real object while maintaining the same interface.

---

# 🔥 Final Understanding

All proxy types follow this rule:

* Same interface as real object
* Holds reference to real object
* Controls access
* Client is unaware

---