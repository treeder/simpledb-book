package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.DataUtils;
import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.ItemAttribute;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import simpledb.book.util.SimpleDBHelper;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 12:50:21 AM
 */
public class CreateNewBlog {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("Blog");
        UUID uuid = UUID.randomUUID();
        Item item = domain.getItem(uuid.toString());
        List<ItemAttribute> attributes = new ArrayList<ItemAttribute>();
        attributes.add(new ItemAttribute("uri", "http://blog.simpledbbook.com", true));
        attributes.add(new ItemAttribute("title", "SimpleDB Blog", true));
        attributes.add(new ItemAttribute("updated", DataUtils.encodeDate(new Date()), true));
        attributes.add(new ItemAttribute("author", "Travis Reeder", true));
        item.putAttributes(attributes);
    }
    
}
