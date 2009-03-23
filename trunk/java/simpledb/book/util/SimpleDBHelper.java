package simpledb.book.util;

import com.xerox.amazonws.sdb.SimpleDB;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 12:26:12 AM
 */
public class SimpleDBHelper {

    // todo: load these from properties file for easy running
    public static String ACCESS_KEY = "YOUR_AWS_ACCESS_KEY";
    public static String SECRET_KEY = "YOUR_AWS_SECRET_KEY";

    public static SimpleDB getSimpleDB(){
        SimpleDB db = new SimpleDB(ACCESS_KEY, SECRET_KEY);
        return db;
    }
}
