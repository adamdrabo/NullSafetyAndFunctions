# NullSafetyAndFunctions

Kotlin practice exercises on functions, null safety and function overloading.

## Concepts covered

- Functions: a block of code written once and reused everywhere.
  - Parameters are declared in the function header. Arguments are the values passed when calling the function.
  - The type after the parentheses is the type of value the function returns.
  - Single-expression functions: `fun square(n: Int) = n * n`.
  - Early return: a function can have several `return`. The first one reached ends the function.
  - Function overloading: several functions can share the same name if their parameters are different (in number or in type). Kotlin picks the right one based on the arguments.
- Null safety:
  - A type without `?` is non-nullable. A type with `?` can hold a value or `null`.
  - `?.` (safe call): calls a method only if the value is not null.
  - `?:` (Elvis): gives a default value when the left side is null.
  - Smart cast: after checking `if (x != null)`, Kotlin treats `x` as non-nullable.
  - `?.let`: runs a block only if the value is not null.
  - `toIntOrNull()`: returns `null` instead of crashing when the text is not a number.

## Exercise 1: Invoice with taxes

Calculate the subtotal from a price and a quantity, then add Quebec taxes (14.975%). The result of the first function becomes the argument of the second.

```kotlin
fun main() {
    println("Enter the price of your article: ")
    val price = readln().toDouble()

    println("Enter the quantity of your article: ")
    val quantity = readln().toInt()

    val subTotal = calculateSubtotal(price, quantity)
    println("Subtotal: $${"%.2f".format(subTotal)}")

    val total = addTaxes(subTotal)
    println("Total: $${"%.2f".format(total)}")
}

fun calculateSubtotal(price: Double, quantity: Int): Double {
    return price * quantity
}

fun addTaxes(amount: Double) = amount * 1.14975
```

## Exercise 2: Age category

Return an age category from a user input. Invalid input (text or negative number) returns "Invalid age".

```kotlin
fun ageCategory(age: Int?): String {
    if (age == null || age < 0) {
        return "Invalid age"
    }

    return when (age) {
        in 0..12 -> "Child"
        in 13..17 -> "Teenager"
        in 18..64 -> "Adult"
        else -> "Senior"
    }
}

print("Enter your age: ")
val age = readln().toIntOrNull()
println("Category: ${ageCategory(age)}")
```

## Exercise 3: Nickname

Greet the user with their nickname, or "Guest" if they don't have one. Display the number of letters only if the nickname exists.

```kotlin
fun greet(nickname: String?) {
    println("Hello, ${nickname ?: "Guest"}")

    nickname?.let {
        println("Your nickname has ${it.length} letters.")
    }
}

print("Enter your nickname (leave empty if you don't have one): ")
val input = readln()
val nickname: String? = if (input.isBlank()) null else input
greet(nickname)
```

## Exercise 4: Area calculation (overloading by number of parameters)

Calculate the area of a square or a rectangle with two functions that share the same name. Kotlin calls the right one based on the number of arguments.

```kotlin
fun area(side: Double) = side * side
fun area(length: Double, width: Double) = length * width

println("Enter your choice (1: Square, 2: Rectangle)")
val choice = readln()

when (choice) {
    "1" -> {
        println("Enter the side of the square: ")
        val side = readln().toDouble()

        println("The area of the square is: ${"%.2f".format(area(side))}")
    }
    "2" -> {
        println("Enter the length: ")
        val length = readln().toDouble()

        println("Enter the width: ")
        val width = readln().toDouble()

        println("The area of the rectangle is: ${"%.2f".format(area(length, width))}")
    }
    else -> {
        println("Invalid choice")
    }
}
```

## Exercise 5: Input analysis (overloading by type)

Describe a user input with two functions that share the same name. Kotlin calls the `Int` version for a number and the `String` version for text.

```kotlin
fun describe(number: Int) {
    println("You entered the number $number. Its double is ${number * 2}.")
}

fun describe(text: String) {
    println("You entered the text $text. It has ${text.length} characters.")
}

print("Enter something: ")
val input = readln()
val number = input.toIntOrNull()

if (number != null) {
    describe(number)
} else {
    describe(input)
}
```

## What I learned

- When I can explain the logic in words, I should translate my sentence directly into code.
- A parameter name is only a label inside the function. The argument can come from anywhere, including another function's result.
- A function that returns a value should not print it. The caller decides what to do with it.
- Without a `return`, the function keeps running after an `if`. An early `return` stops it and enables the smart cast.
- Inside `?.let`, `it` is never null, so checking `it != null` is useless.
- Kotlin chooses an overload based on the number and the type of the arguments. Thanks to the smart cast, an `Int?` checked with `if (number != null)` calls the `Int` version.
- Two functions with the same parameters but a different return type are not a valid overload.
- Always run the code and test edge cases (empty input, text instead of a number) before calling it done.