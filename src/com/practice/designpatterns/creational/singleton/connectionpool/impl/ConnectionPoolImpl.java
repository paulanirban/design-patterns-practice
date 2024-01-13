package com.practice.designpatterns.creational.singleton.connectionpool.impl;

import com.practice.designpatterns.creational.singleton.connectionpool.ConnectionPool;
import com.practice.designpatterns.creational.singleton.connectionpool.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPoolImpl implements ConnectionPool {

    private static volatile ConnectionPool instance;
    private static int maxCon;
    private List<DatabaseConnection> connectionPool;
    private ConnectionPoolImpl() { }
    @Override
    public void initializePool() {
        connectionPool = new ArrayList<>();
        for(int i=0; i<maxCon; i++) {
            connectionPool.add(new DatabaseConnection());
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        if(connectionPool != null) {
            for(DatabaseConnection connection: connectionPool) {
                if(connection.isAvailable()) {
                    connection.setAvailable(false);
                    return  connection;
                }
            }
        }

        return null;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        if(connectionPool != null) {
            connection.setAvailable(true);
        }
    }

    @Override
    public int getAvailableConnectionsCount() {
        int count = 0;
        if(connectionPool != null) {
            for(DatabaseConnection connection: connectionPool) {
                if(connection.isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getTotalConnectionsCount() {
        if(connectionPool != null) {
            return connectionPool.size();
        }
        return 0;
    }

    public static ConnectionPool getInstance(int maxConnections) {
        if(instance == null) {
            synchronized (ConnectionPoolImpl.class) {
                if(instance == null) {
                    instance = new ConnectionPoolImpl();
                    maxCon = maxConnections;
                    instance.initializePool();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        if(instance != null) {
            instance = null;
        }
    }
}
