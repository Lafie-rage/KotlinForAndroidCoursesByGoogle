/**
 * Program that implements classes for different kinds of dwellings.
 * Shows how to:
 * Create class hierarchy, variables and functions with inheritance,
 * abstract class, overriding, and private vs. public variables.
 */

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    // 	val dwelling = Dwelling() // Cannot create instance from an abstract class
    with(SquareCabin(6, 50.0)) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    with(RoundHut(3, 10.0)) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    with(RoundTower(4, 15.5)) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}

/**
 * Defines properties common to all dwellings.
 * All dwellings have floorspace,
 * but its calculation is specific to the subclass.
 * Checking and getting a room are implemented here
 * because they are the same for all Dwelling subclasses.
 *
 * @param residents Current number of residents
 */
abstract class Dwelling(private var residents: Int) {
    // Properties must be abstract because it's not initialized
    abstract val buildingMaterial: String
    abstract val capacity: Int

    /**
     * Calculates the floor area of the dwelling.
     * Implemented by subclasses where shape is determined.
     *
     * @return floor area
     */
    abstract fun floorArea(): Double // Should be implemented in subclasses

    /**
     * Checks whether there is room for another resident.
     *
     * @return true if room available, false otherwise
     */
    fun hasRoom() = residents < capacity

    /**
     * Compares the capacity to the number of residents and
     * if capacity is larger than number of residents,
     * add resident by increasing the number of residents.
     * Print the result.
     */
    fun getRoom() {
        if (hasRoom()) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no romms left.")
        }
    }


}

/**
 * A square cabin dwelling.
 *
 *  @param residents Current number of residents
 *  @param length Length
 */
class SquareCabin(
    residents: Int, // Defined as an argument but not a property
    val length: Double
) : Dwelling(residents) { // Do not forget to implements Dwelling's methods
    override val buildingMaterial = "Wood"
    override val capacity = 6

    /**
     * Calculates floor area for a square dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return length * length
    }
}

/**
 * Dwelling with a circular floorspace
 *
 * @param residents Current number of residents
 * @param radius Radius
 */
open class RoundHut(
    val residents: Int,
    val radius: Double,
) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    /**
     * Calculates floor area for a round dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    /**
     *  Calculates the max length for a square carpet
     *  that fits the circular floor.
     *
     * @return length of carpet
     */
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
 * Round tower with multiple stories.
 *
 * @param residents Current number of residents
 * @param radius Radius
 * @param floors Number of stories
 */
class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2, // Default value of the property.
    // It also defines another constructor that only requires residents value
) : RoundHut(residents, radius) { // RoundHut must be open because it is defaulty final
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors // Capacity depends on the number of floors.

    /**
     * Calculates the total floor area for a tower dwelling
     * with multiple stories.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        // We don't need to override floorArea() because it's already done in RoundHut
        // But we can do it anyway. Moreover, we can use the RoundHut.floorArea() inside our overriden floorArea()
        return super.floorArea() * floors
    }
}