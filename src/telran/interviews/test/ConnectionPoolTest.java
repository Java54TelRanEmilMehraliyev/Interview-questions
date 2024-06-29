package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.Connection;
import telran.interviews.ConnectionPool;

class ConnectionPoolTest {
private static final long ID1 = 121;
private static final long ID4 = 124;
private static final long ID2 = 122;
private static final long ID3 = 123;
ConnectionPool pool;

@BeforeEach
void setUp() {
	pool = new ConnectionPool(3);
	pool.getConnection(new Connection(ID1));
	pool.getConnection(new Connection(ID2));
	pool.getConnection(new Connection(ID3));
}
	@Test
	void addingNewRemovingFirstCreated() {
		//adding ID4 connection
		//removing ID1 connection
		pool.getConnection(new Connection(ID4));
		assertFalse(pool.isInPool(ID1));
		assertTrue(pool.isInPool(ID4));

	}
    @Test
    void accessOrderUpdatingTest() {
       
        assertEquals(new Connection(ID1), pool.getConnection(new Connection(ID1)));
        pool.getConnection(new Connection(ID4));
        assertTrue(pool.isInPool(ID4));
        assertTrue(pool.isInPool(ID1));
        assertFalse(pool.isInPool(ID2));
    }
}