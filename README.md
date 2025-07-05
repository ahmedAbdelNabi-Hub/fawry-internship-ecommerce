# 🧾 Fawry Quantum Internship (Onion Architecture Simulation)

This Java-based console application was developed as a solution to the **Full Stack Development Internship Challenge (Fawry Quantum Internship)**.

## 🎯 Challenge Summary

Design an e-commerce system with the following features:
- Define products with name, price and quantity.
- Handle expirable and non-expirable products.
- Handle shippable products with weight.
- Add products to cart (with stock check).
- Checkout:
  - Calculate subtotal
  - Add shipping fee
  - Display total paid and remaining balance
  - Throw errors for empty cart, expired product, or insufficient balance
- Send shippable items to `ShippingService` via an interface (`getName()`, `getWeight()`)

---

## ✅ Output Example

```text
** Shipment notice **
2x Cheese 400g
1x Biscuits 400g
1x TV 5000g
1x Milk 1000g
Total package weight: 6.8kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Scratch Card 50
1x TV 300
1x Milk 60
2x Pen 20
--------------------------
Subtotal 780
Shipping 20
Amount 800
Balance left 200
```

---

## 📁 Folder Structure

```bash
src/
├── domain/
│   ├── Abstract/                    # Base abstract Product class
│   ├── Entities/                    # Business entities like Cart, Product, etc.
│   ├── Exceptions/                  # Domain-specific exceptions
│   ├── interfaces/services/         # Domain service interfaces (e.g., ICheckoutService)
│
├── Infrastructure/                 # Infrastructure layer implementation (ShippingService)
│
├── Service/                        # Application service layer (CheckoutService)
│
├── Presentation/                   # App entry point (main method)
```

- `lib/`: the folder to maintain dependencies  
- `bin/`: the compiled output files will be generated here by default

> You can customize the folder structure in `.vscode/settings.json` if needed.

---

## ✅ Project Highlights

- 💡 **Onion Architecture Simulation**  
  I tried to simulate Onion Architecture structure. Although the project is small, the folder structure follows the separation between:
  - **Domain Layer** (Entities, Exceptions, Interfaces)
  - **Service Layer** (Business logic like CheckoutService)
  - **Infrastructure Layer** (ShippingService implementation)
  - **Presentation Layer** (Main app entry)

- 🧩 **Dependency Injection**  
  Used **constructor-based Dependency Injection** to inject infrastructure services (ShippingService) into the service layer (CheckoutService), promoting loose coupling and testability.

- **Repository Pattern Ready**  
  I didn’t want to overcomplicate things or add unnecessary complexity — and since there's no actual database used here, I kept it simple.  
  However, adding a repository or persistence layer in the future is very easy and the architecture is already prepared for it.

---

## 🚀 How to Run

1. Make sure you have **JDK** installed.
2. Open the project in **Visual Studio Code**.
3. Navigate to `src/Presentation/App.java`.
4. Run the file using the Run button or `F5`.

---

## 📚 Dependency Management

Dependencies are managed under the `lib/` folder if needed.

The **Java Projects View** in VS Code can help manage dependencies.  
More details here: [VS Code Java Dependency Docs](https://github.com/microsoft/vscode-java-dependency#manage-dependencies)

---

## 🔗 Resources

- [VS Code Java Documentation](https://code.visualstudio.com/docs/languages/java)
- [Onion Architecture - Jeffrey Palermo](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)

