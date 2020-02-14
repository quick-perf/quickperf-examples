/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2020-2020 the original author or authors.
 */

package org.quickperf.quarkus.quarkustest.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

import net.ttddyy.dsproxy.ConnectionInfo;
import net.ttddyy.dsproxy.proxy.JdbcProxyFactory;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.quickperf.sql.config.QuickPerfSqlDataSourceBuilder;

public class QuickperfDriver implements Driver {
    private Driver delegate;

    static {
        try {
            DriverManager.registerDriver(new QuickperfDriver());
        } catch (SQLException e) {
            throw new IllegalStateException("Could not register QuickperfDriver with DriverManager", e);
        }
    }

    @Override
    public boolean acceptsURL(final String url) {
        return url != null && url.startsWith("jdbc:qp:");
    }

    @Override
    public Connection connect(String url, Properties properties) throws SQLException {
        // if there is no url, we have problems
        if (url == null) {
            throw new SQLException("url is required");
        }

        if( !acceptsURL(url) ) {
            return null;
        }

        // find the real driver for the URL
        String extractedUrl = acceptsURL(url) ? url.replace("qp:", "") : url;
        delegate = findDelegate(extractedUrl);

        final Connection conn = delegate.connect(extractedUrl, properties);

        // create a proxy connection
        ConnectionInfo connectionInfo = new ConnectionInfo();
        ProxyDataSource proxyDataSource = QuickPerfSqlDataSourceBuilder.aDataSourceBuilder().buildProxy(null);
        return JdbcProxyFactory.DEFAULT.createConnection(conn, connectionInfo, proxyDataSource.getProxyConfig());
    }

    private Driver findDelegate(String url) throws SQLException {
        // type 4 drivers should be automatically registered
        for (Enumeration<Driver> driverEnumeration = DriverManager.getDrivers(); driverEnumeration.hasMoreElements(); ) {
            Driver driver = driverEnumeration.nextElement();
            try {
                if (driver.acceptsURL(url)) {
                    return driver;
                }
            } catch (SQLException e) {
            }
        }

        throw new SQLException("Unable to find a driver that accepts " + url);
    }

    // we just call the delegate driver for the following methods

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return delegate.getPropertyInfo(url, info);
    }

    @Override
    public int getMajorVersion() {
        return delegate.getMajorVersion();
    }

    @Override
    public int getMinorVersion() {
        return delegate.getMinorVersion();
    }

    @Override
    public boolean jdbcCompliant() {
        return delegate.jdbcCompliant();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return delegate.getParentLogger();
    }

}