package edu.hanoi.jazz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hoanghiep on 5/28/17.
 */
public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContextStartedEvent.class);
    @Autowired
    private DataSource dataSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        LOGGER.info("context start application " + dataSource);
        try {
            createTable("HN_GROUP", "create table HN_GROUP(id bigint primary key generated always as identity " +
                    "(start with 1, increment by 1), name varchar(100))");
        } catch (Exception e) {
            LOGGER.info("error: " + e);
        }
    }

    private void createTable(String name, String script) throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, name, null);
        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists!");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script);
    }
}
