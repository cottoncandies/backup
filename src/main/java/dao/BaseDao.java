package dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> queryAll();

    void save(List<T> list);
}
