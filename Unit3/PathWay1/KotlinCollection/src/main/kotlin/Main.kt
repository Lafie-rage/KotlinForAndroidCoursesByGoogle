fun main(args: Array<String>) {
    // region SETS
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2) // Define a list
    println("list:   $numbers") // Print the list
    println("sorted: ${numbers.sorted()}") // Print a copy of the list but sorted
    val setOfNumbers = numbers.toSet() // Convert the list to a set
    println("set:    $setOfNumbers") // Print the set : There is no more duplicate

    // Example that order doesn't matter in sets.
    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}")

    // Contains on sets
    println("contains 7: ${setOfNumbers.contains(7)}") // The set doesn't contain the value 7
    // endregion

    // region MAPS
    val peopleAges = mutableMapOf( // Define a map of String key and Int value
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42) // Adding an element using the put method
    peopleAges["Joe"] = 51 // Adding an element using shorthand way*
    peopleAges["Fred"] = 31 // Adding a value to an existing key replace the value mapped to this key
    println(peopleAges)

    // Printing the map using a foreach
    peopleAges.forEach { print("${it.key} is ${it.value}, ") } // There is an extra comma at the end
    println() // Print a line break
    // We can use map to fix this
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") ) // Transform the list of age to a list of strings
    // Those strings are joined and seperated with a coma

    // Retrieve the elements with a key composed of less than 4 letters
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames)
    // endregion

    // region LAMBDAS AND HIGH-ORDER FUNCTIONS
    val triple: (Int) -> Int = { a: Int -> a * 3 } // Define a lambda returning an int multiplied by 3
    println(triple(5))

    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted()) // Sort the list by alphabetic order
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length }) // Sort the list by string length
    // endregion

    // region WORD LIST
    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) } // Retrieve only the words starting with a b (non-case-sensitive)
        .shuffled() // Shuffle the list
        .take(2) // Retrieve the 2 firsts elements
    println(filteredWords)

    val filteredWordsStartingWithC = words.filter { it.startsWith("c", ignoreCase = true) }
        .shuffled()
        .take(1)
    println(filteredWordsStartingWithC)
    // endregion
}