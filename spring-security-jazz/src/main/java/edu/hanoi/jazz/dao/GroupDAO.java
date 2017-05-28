package edu.hanoi.jazz.dao.model;

import java.util.List;

/**
 * Created by hoanghiep on 5/28/17.
 */
public interface GroupDAO {

    public void insert(Group group);

    public List<Group> list(String pattern);

    public void delete(int id);

    public void update(Group group);

    public Group get(int id);
}
