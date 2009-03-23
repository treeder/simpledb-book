package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.QueryResult;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import simpledb.book.util.QueryUtils;
import simpledb.book.util.SimpleDBHelper;

import java.util.List;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 10:00:21 PM
 */
public class GetAllBlogs {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        QueryResult queryResult = domain.listItems();
        List<Item> items = queryResult.getItemList();
        QueryUtils.printItems(items);
    }


}
