package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.MyArray;

class MyArrayTest {
    private MyArray<Integer> intArray;
    private MyArray<String> stringArray;

    @BeforeEach
    void setUp() {
        intArray = new MyArray<>(5);
        stringArray = new MyArray<>(3);
    }

    @Test
    void testSetAll() {
        intArray.setAll(42);
        assertEquals(42, intArray.get(0));
        assertEquals(42, intArray.get(4));

        stringArray.setAll("Hello");
        assertEquals("Hello", stringArray.get(0));
        assertEquals("Hello", stringArray.get(2));
    }

    @Test
    void testSetAndGet() {
        intArray.set(2, 99);
        assertEquals(99, intArray.get(2));

        stringArray.set(1, "World");
        assertEquals("World", stringArray.get(1));
    }

    @Test
    void testOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> intArray.set(10, 123));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringArray.get(-1));
    }
}