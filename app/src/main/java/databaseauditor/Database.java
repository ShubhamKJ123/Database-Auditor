package databaseauditor;

import java.util.List;

interface Database {
    public boolean connect();

    public void disconnect();

    public <T> int insertOne(T obj);

    public <T> int updateMany(T obj, List<List<String>> params);

    public <T> int deleteMany(T obj, List<List<String>> params);
}