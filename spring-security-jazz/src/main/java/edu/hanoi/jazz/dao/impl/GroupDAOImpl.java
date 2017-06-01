package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.GroupDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        try {
            session.save(group);
            session.flush();
            LOGGER.info("Save group " + group.getName() + " done");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Group> list(String pattern) {
        Session session = sessionFactory.getObject().openSession();
        if(pattern == null || pattern.length() < 1){
            Query query = session.createQuery("from Group");
            try {
                return (List<Group>) query.list();
            } finally {
                session.close();
            }
        }
        Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.like("name", "%" + pattern + "%", MatchMode.ANYWHERE));
        return new ArrayList<Group>(criteria.list());
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getObject().openSession();
        Group group = session.get(Group.class, id);
        if (group == null) return;
        try {
            session.delete(group);
            session.flush();
            LOGGER.info("Delete group " + group.getName() + " successful!");
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try{
            Object group1 = session.merge(group);
            session.save(group1);
            session.flush();
            LOGGER.info("Update group " + group.getName() + " successful!");
        } finally {
            session.close();
        }
    }

    @Override
    public Group get(int id) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(Group.class, id);
    }
}
