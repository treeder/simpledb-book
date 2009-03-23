package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import simpledb.book.util.SimpleDBHelper;

/**
 * User: treeder
 * Date: Nov 17, 2008
 * Time: 10:56:34 AM
 */
public class DeleteDomain {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        db.deleteDomain("Blog");
    }
}
