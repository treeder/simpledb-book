package simpledb.book.chpt3;

import com.xerox.amazonws.sdb.DataUtils;
import com.xerox.amazonws.sdb.Domain;
import com.xerox.amazonws.sdb.Item;
import com.xerox.amazonws.sdb.ItemAttribute;
import com.xerox.amazonws.sdb.QueryResult;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.SimpleDB;
import simpledb.book.util.QueryUtils;
import simpledb.book.util.SimpleDBHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: treeder
 * Date: Dec 28, 2008
 * Time: 8:55:24 PM
 */
public class Aggregate {

    public static void main(String[] args) throws SDBException, ParseException {
        // We'll use a map to store our aggregate data
        Map<Integer, Integer> counters = new HashMap<Integer, Integer>();
        // Query for our data
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        Domain domain = db.getDomain("PostViews");
        String query = "[‘viewDate’ > ‘2008-11-11’] intersection [‘post_id’ = ‘123’]";
        QueryResult queryResult = domain.listItems(query);
        List<Item> items = queryResult.getItemList();
        for (Item item : items) {
            List<ItemAttribute> attributes = item.getAttributes();
            String viewDateAsString = QueryUtils.getAttribute(attributes, "viewDate");
            Date viewDate = DataUtils.decodeDate(viewDateAsString); // DataUtils is a Typica class
            // Increment our counter for the month
            int month = viewDate.getMonth();
            Integer count = counters.get(month);
            if(count == null) count = 1;
            else count++;
            counters.put(month, count);
        }
        // Sort the keys by month
        List<Integer> months = new ArrayList<Integer>(counters.keySet());
        Collections.sort(months);

        // Print the results
        for (Integer month : months) {
            System.out.println("Month: " + month + " = " + counters.get(month));
        }
    }
}
