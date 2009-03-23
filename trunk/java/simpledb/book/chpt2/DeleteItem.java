package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import simpledb.book.util.SimpleDBHelper;

/**
 * User: treeder
 * Date: Nov 17, 2008
 * Time: 10:59:10 AM
 */
public class DeleteItem {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        String itemId = "ITEM_ID";
        domain.deleteItem(itemId);
    }
}
