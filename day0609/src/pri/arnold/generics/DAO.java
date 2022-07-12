package pri.arnold.generics;

import java.util.*;

/**
 * @Author: Arnold
 * @Date: 2022/6/9 18:28
 */
public class DAO<T> {

    private Map<String, T> map = new HashMap<>();

    public DAO() {
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        Collection<T> values = map.values();
        ArrayList<T> ts = new ArrayList<>();
        for (T t : values) {
            ts.add(t);
        }
        return ts;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
