package bookstore.web;

import java.sql.Connection;

public class ConnectionContext {
	public ConnectionContext() {
	}

	private static ConnectionContext instrance = new ConnectionContext();

	public static ConnectionContext getInstance() {
		return instrance;
	}

	private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

	public void bind(Connection connection) {
		connectionThreadLocal.set(connection);
	}

	public Connection get() {
		return connectionThreadLocal.get();
	}

	public void remove() {
		connectionThreadLocal.remove();
	}
}
