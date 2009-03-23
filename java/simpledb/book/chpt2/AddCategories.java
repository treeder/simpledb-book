package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.SimpleDB;
import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.ItemAttribute;
import com.xerox.amazonws.sdb.SDBException;

import java.util.List;
import java.util.ArrayList;

import simpledb.book.util.SimpleDBHelper;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 10:50:58 PM
 */
public class AddCategories {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        Item item = domain.getItem("07129609-8306-4a39-9297-8002572ba77c");
        List<ItemAttribute> attributes = new ArrayList<ItemAttribute>();
        attributes.add(new ItemAttribute("category", "technology", true));
        attributes.add(new ItemAttribute("category", "databases", true));
        item.putAttributes(attributes);
    }
}
