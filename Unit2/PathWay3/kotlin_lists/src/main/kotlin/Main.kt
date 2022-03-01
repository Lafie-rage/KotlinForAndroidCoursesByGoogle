fun main() {
//    discoveringLists()
//    discoveringListImmutability()
//    discoveringMutableLists()
//    discoveringLoops()
    puttingItAllTogether()
}

/**
 * Tests to discover [List] in Kotlin
 */
fun discoveringLists() {
    val numbers = listOf( // Type inferred from declaration statement
        1,
        2,
        3,
        4,
        5,
        6,
    )
    println("List : $numbers")
    println("Size : ${numbers.size}")
    println("First element : ${numbers[0]}")
    println("Second element : ${numbers[1]}")
    println("First element using first() : ${numbers.first()}")
    println("Last element using last() : ${numbers.last()}")
    println("List contains 4 : ${numbers.contains(4)}")
    println("List contains 7 : ${numbers.contains(7)}")
}

/**
 * Tests to discover [List] immutability in Kotlin
 */
fun discoveringListImmutability() {
    val colors = listOf("green", "orange", "blue")
    // colors.add("purple") // Won't work because list are immutable
    // colors[0] = "yellow" // Same as above

    println("Colors : $colors")
    println("Reversed colors : ${colors.reversed()}") // Works because List.reversed() returns the reversed list instead of mutate it. reverse() does mutate the list, that's why List.reverse() doesn't exist.
    println("Sorted colors : ${colors.sorted()}") // Same as above for List.sorted() and sort().

    val oddNumbers = listOf(5, 3, 7, 1)
    println("List: $oddNumbers")
    println("Sorted list: ${oddNumbers.sorted()}")
}

/**
 * Tests to discover [MutableList] in Kotlin
 */
fun discoveringMutableLists() {
    val entrees = mutableListOf<String>() // Cannot infer type of the List, we must specify it. We could also use val entrees: MutableList<String> = mutableListOf()
    println("Entrees : $entrees") // The list is empty
    println("Add noodles: ${entrees.add("noodles")}") // MutableList.add() returns if the item has been added. It's always true.
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")

    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")
//    entrees.add(10) // We cannot add another type of value in this List because it is a List<String>. Yet we could have used a List<Any> for example in order to add Int to the List
    println("Remove spaghetti: ${entrees.remove("spaghetti")}") // remove returns true if the element has been removed, meaning that this element was in the List.
    println("Entrees: $entrees")
    println("Remove first element: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")
    entrees.clear()
    println("Entrees: $entrees")
    println("Empty? ${entrees.isEmpty()}")
}

/**
 * Tests to discover while and for loops
 */
fun discoveringLoops() {
    // region While loops
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0
    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("Total Guest Count: $totalGuests")
    // endregion

    // region For loops
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        println(name) // Prints name
    }
    for (name in names) {
        println("$name - Number of characters: ${name.length}") // Prints name length and name
    }
    //endloop
}


fun puttingItAllTogether() {
    // If we want a list of items we should use List or MutableList
    // We can also use varargs
    val noodles = Noodles()
    val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
    val vegetables2 = Vegetables()
    println(noodles)
    println(vegetables)
    println(vegetables2)

    val orders = mutableListOf<Order>()
    val order1 = Order(1)
    order1.addItem(Noodles())
    orders.add(order1)
    println()

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    orders.add(order2)

    println()

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    orders.add(order3)

    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
    orders.add(order4)

    for (order in orders) {
        order.print()
        println()
    }
}

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}

class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return if(toppings.isEmpty()) "$name Chef's choice"
        else "$name ${toppings.joinToString()}"
    }
}

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()

    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }

    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }

    fun print() {
        println("Order #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }
}