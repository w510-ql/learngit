package DB.dao.dao;

import java.sql.Connection;

public interface Dao<T> {
    public int add(T t);
    public int delete(T t);
    public int update(Connection con, T t, String sql);
    public T select(String key);
        
}
