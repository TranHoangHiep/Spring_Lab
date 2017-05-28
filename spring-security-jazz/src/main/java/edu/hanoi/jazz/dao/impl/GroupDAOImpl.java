package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.GroupDAO;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by hoanghiep on 5/28/17.
 */
@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(GroupDAOImpl.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try{
            session.save(group);
            session.flush();
            LOGGER.info("Save group " + group.getName() + " done");
        } finally {
            session.close();
        }

    }
}
