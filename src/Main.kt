fun main() {
    // Sales
//    println("Enter the price of your article: ")
//    val price = readln().toDouble()
//
//    println("Enter the quantity of your article: ")
//    val quantity = readln().toInt()
//
//    val subTotal = calculateSubtotal(price, quantity)
//    println("Purchase sub-totals: $${"%.2f".format(subTotal)}")
//
//    val total = addTaxes(subTotal)
//    println("Total: $${"%.2f".format(total)}")

//    // Age category
//
//    print("Enter your age: ")
//    val age = readln().toIntOrNull()
//    println("Category: ${ageCategory(age)}.")


//    // Nickname
//
//    print("Enter your nickname (leave empty if you don't have one): ")
//    val input = readln()
//    val nickname: String? = if (input.isBlank()) null else input
//    greet(nickname)


    // Area calculation(overloading by number)

//    println("Enter your choice (1: Square, 2: Rectangle)")
//    val choice = readln()
//
//
//    when (choice) {
//        "1" -> {
//            println("Enter the measurement to calculate the area of the square.")
//            val side = readln().toDouble()
//
//            println("The area of the square calculation is: ${"%.2f".format(area(side))} square centimetre")
//        }
//        "2" -> {
//            println("Enter the measurement to calculate the area of the rectangle.")
//            println("Enter the length: ")
//            val length = readln().toDouble()
//
//            println("Enter the width: ")
//            val width = readln().toDouble()
//
//            println("The area of the rectangle calculation is: ${"%.2f".format(area(length, width))} square centimetre")
//        }
//        else -> {
//            println("Invalid choice")
//        }
//    }


    // Input analysis (type-based overloading)

//    print("Enter something: ")
//    val input = readln()
//    val number = input.toIntOrNull()
//
//    if (number != null) {
//        describe(number)
//    } else {
//        describe(input)
//    }

}

//fun describe(number: Int) {
//    println("You entered the number $number. Its double is ${number * 2}")
//}
//fun describe(text: String) {
//       println("You entered $text. It has ${text.length} characters.")
//}

//fun area(side: Double) = side * side
//fun area(length: Double, width: Double) = length * width

//fun greet(nickname: String?){
//
//    println("Hello, ${nickname ?: "Guest"}")
//
//    nickname?.let {
//        println("Your nickname has ${it.length} letters.")
//    }
//}

//fun ageCategory(age: Int?): String {
//    if (age == null || age < 0) {
//        return "Invalid age"
//    }
//
//    val message: String = when (age) {
//        in 0..12 -> "Child"
//        in 13..17 -> "Teenager"
//        in 18..64 -> "Adult"
//        else -> "Senior"
//    }
//
//    return message
//}

//fun calculateSubtotal(price: Double, quantity: Int): Double {
//    return price * quantity
//}
//
//fun addTaxes(amount: Double) = amount * 1.14975