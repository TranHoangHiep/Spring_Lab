package edu.hanoi.jazz;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent>{

	private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		LOGGER.info("Context start application " + dataSource);
		try {
//			createTable("HN_GROUP", "create table HN_GROUP")
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
