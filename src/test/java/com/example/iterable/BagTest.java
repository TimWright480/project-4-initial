package com.example.iterable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//

/**
 * Comprehensive unit tests for the Bag class.
 *
 * Coverage goals:
 *  - Empty bag behavior
 *  - Single item behavior
 *  - Multiple items behavior
 *  - Removal scenarios
 *  - Iterator correctness and independence
 */
public class BagTest {

    private Bag<String> bag;

    @BeforeEach
    void setUp() {
        bag = new Bag<>();
    }

    // --- 1. EMPTY BAG TESTS ---

    @Test
    void testEmptyBagInitially() {
        assertTrue(bag.isEmpty(), "New bag should be empty");
        assertEquals(0, bag.size(), "Empty bag should have size 0");
        assertFalse(bag.contains("apple"), "Empty bag should not contain any element");
    }

    @Test
    void testRemoveFromEmptyBagReturnsFalse() {
        assertFalse(bag.remove("apple"), "Removing from empty bag should return false");
    }

    // --- 2. SINGLE ITEM TESTS ---

    @Test
    void testAddSingleItem() {
        bag.add("apple");
        assertFalse(bag.isEmpty(), "Bag should not be empty after adding an item");
        assertEquals(1, bag.size(), "Bag should have size 1 after single add");
        assertTrue(bag.contains("apple"), "Bag should contain the added item");
    }

    @Test
    void testRemoveSingleExistingItem() {
        bag.add("apple");
        assertTrue(bag.remove("apple"), "Removing existing item should return true");
        assertTrue(bag.isEmpty(), "Bag should be empty after removing its only item");
    }

    @Test
    void testRemoveSingleNonExistingItem() {
        bag.add("apple");
        assertFalse(bag.remove("banana"), "Removing non-existing item should return false");
        assertEquals(1, bag.size(), "Size should remain unchanged after failed removal");
    }

    // --- 3. MULTIPLE ITEMS TESTS ---

    @Test
    void testAddMultipleItems() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");
        assertEquals(3, bag.size());
        assertTrue(bag.contains("banana"));
    }

    @Test
    void testRemoveOneOfMultipleItems() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");

        assertTrue(bag.remove("banana"), "Should remove one occurrence of item");
        assertEquals(2, bag.size());
        assertFalse(bag.contains("banana"));
        assertTrue(bag.contains("apple"));
    }

    @Test
    void testAddDuplicateItemsAllowed() {
        bag.add("apple");
        bag.add("apple");
        assertEquals(2, bag.size(), "Duplicates should be allowed");
        assertTrue(bag.contains("apple"));
        assertTrue(bag.remove("apple"), "Removing one duplicate should succeed");
        assertTrue(bag.contains("apple"), "Second duplicate should remain");
        assertEquals(1, bag.size());
    }

    // --- 4. ITERATOR TESTS ---

    @Test
    void testIteratorOverEmptyBag() {
        Iterator<String> iterator = bag.iterator();
        assertFalse(iterator.hasNext(), "Empty bag iterator should have no elements");
    }

    @Test
    void testIteratorTraversesAllItems() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");

        Iterator<String> iterator = bag.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("apple", iterator.next());
        assertEquals("banana", iterator.next());
        assertEquals("cherry", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorIndependenceFromOriginal() {
        bag.add("apple");
        Iterator<String> iterator = bag.iterator();
        bag.add("banana"); // Modify after iterator creation

        assertTrue(iterator.hasNext());
        assertEquals("apple", iterator.next());
        assertFalse(iterator.hasNext(), "Iterator should not reflect later modifications");
    }

    // --- 5. INITIALIZATION AND UTILITY TESTS ---

    @Test
    void testConstructorWithInitialList() {
        Bag<String> initializedBag = new Bag<>(List.of("apple", "banana"));
        assertEquals(2, initializedBag.size());
        assertTrue(initializedBag.contains("apple"));
    }

    @Test
    void testClearEmptiesBag() {
        bag.add("apple");
        bag.add("banana");
        bag.clear();
        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());
    }

    @Test
    void testToStringIncludesItems() {
        bag.add("apple");
        bag.add("banana");
        String result = bag.toString();
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("banana"));
    }
}
