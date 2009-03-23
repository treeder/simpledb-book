package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.QueryWithAttributesResult;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import com.xerox.amazonws.sdb.ItemAttribute;
import simpledb.book.util.QueryUtils;
import simpledb.book.util.SimpleDBHelper;

import java.util.Map;
import java.util.List;

/**
 * User: treeder
 * Date: Nov 17, 2008
 * Time: 8:56:13 AM
 */
public class QueryBlogs {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        String query = "select * from Blog where title = 'SimpleDB Blog'";
        QueryWithAttributesResult queryResult = domain.selectItems(query, null);
        Map<String, List<ItemAttribute>> resultsMap = queryResult.getItems();
        for (String key : resultsMap.keySet()) {
            List<ItemAttribute> attributes = resultsMap.get(key);

        }
        QueryUtils.printItems(items);
    }
}
