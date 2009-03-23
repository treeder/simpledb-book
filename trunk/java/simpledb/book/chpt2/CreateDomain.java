package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.SimpleDB;
import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.SDBException;
import simpledb.book.util.SimpleDBHelper;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 12:38:31 AM
 */
public class CreateDomain {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.createDomain("Blog");
        System.out.println("Domain created: " + domain.getName());
    }
}
