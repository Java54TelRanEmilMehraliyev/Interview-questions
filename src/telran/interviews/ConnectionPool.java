package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

//all methods should have O[1] complexity
public class ConnectionPool {
	private final Map<Long, Connection> pool;
	private final int size;

	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		this.size = size;
		this.pool = new LinkedHashMap<Long,Connection>(size, 0.75f, true) {
		protected boolean removeEldestEntry(Map.Entry<Long, Connection> eldest) {	
		 return size() > ConnectionPool.this.size;
		}
	};
	}

	public Connection getConnection(Connection connection) {
		long id = connection.id();
		if (pool.containsKey(id)) {
			pool.remove(id);
			pool.put(id, connection);
			return connection;
		} else {
			pool.put(id, connection);
			return connection;
		}
	}

	public boolean isInPool(long id) {

		return pool.containsKey(id);
	}
}