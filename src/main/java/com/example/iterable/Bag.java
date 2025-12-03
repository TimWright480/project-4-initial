package com.example.iterable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//

/**
 * A generic Bag class that allows duplicate elements.
 * Uses an ArrayList as the backing data structure.
 *
 * Iterative Refinement Goals:
 * - Improved encapsulation
 * - Defensive programming (null safety)
 * - Immutable iterator exposure
 * - Clear documentation and consistent design
 */
public class Bag<E> implements Container<E> {

    // Step 1: Encapsulation refinement — make list final and private
    private final List<E> items;

    // Step 2: Initialization refinement — allow dependency injection (optional for testing)
    public Bag() {
        this.items = new ArrayList<>();
    }

    public Bag(List<E> initialItems) {
        this.items = new ArrayList<>(initialItems == null ? Collections.emptyList() : initialItems);
    }

    // Step 3: Defensive programming — check nulls
    @Override
    public void add(E item) {
        items.add(item); // Accepts nulls intentionally for flexibility
    }

    @Override
    public boolean remove(E item) {
        if (items.isEmpty()) {
            return false; // Avoids unnecessary search
        }
        return items.remove(item);
    }

    @Override
    public boolean contains(E item) {
        if (items.isEmpty()) return false;
        return items.contains(item);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        // Step 4: Defensive iterator exposure — return a copy iterator
        return new ArrayList<>(items).iterator();
    }

    // Step 5: Utility refinement — additional usability method (optional)
    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        return "Bag" + items.toString();
    }
}