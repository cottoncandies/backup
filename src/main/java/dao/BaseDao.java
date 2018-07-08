package dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> queryAll();

    void sava(List<T> list);
}
