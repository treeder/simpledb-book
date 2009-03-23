package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.ItemAttribute;
import com.xerox.amazonws.sdb.QueryResult;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import simpledb.book.util.SimpleDBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 10:12:05 PM
 */
public class DeleteAttribute {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        QueryResult queryResult = domain.listItems();
        List<Item> items = queryResult.getItemList();
        if(items.size() > 0){
            Item item = items.get(0);
            System.out.println("deleting author attribute from item: " + item.getIdentifier());
            List<ItemAttribute> toDelete = new ArrayList<ItemAttribute>();
            toDelete.add(new ItemAttribute("author", null, true));
            item.deleteAttributes(toDelete);
        }
    }
}
