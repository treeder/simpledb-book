package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.ItemAttribute;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import simpledb.book.util.SimpleDBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 10:42:48 PM
 */
public class UpdateBlog {

     public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        Item item = domain.getItem("07129609-8306-4a39-9297-8002572ba77c");
        List<ItemAttribute> attributes = new ArrayList<ItemAttribute>();
        attributes.add(new ItemAttribute("author", "Travis Reeder", true));
        item.putAttributes(attributes);
    }
}
