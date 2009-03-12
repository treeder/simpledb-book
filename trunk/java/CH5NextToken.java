
import java.util.List;

import com.xerox.amazonws.simpledb.Domain;
import com.xerox.amazonws.simpledb.DomainMetadataResult;
import com.xerox.amazonws.simpledb.Item;
import com.xerox.amazonws.simpledb.ListDomainsResult;
import com.xerox.amazonws.simpledb.SelectResult;
import com.xerox.amazonws.simpledb.SDBException;
import com.xerox.amazonws.simpledb.SimpleDB;

/**
 * Sample application demonstrating various operations against SimpleDB.  
 */
public class CH5NextToken {

	/**
	 * Main execution body.
	 *
	 * @param args	    command line arguments (none required or processed)
	 */
    public static void main(String [] args) {
		if (args.length != 2) {
			System.err.println("usage: CH5-Nexttoken <access key> <secret key>");
			System.exit(1);
		}
		try {
			String awsAccessId = args[0];
			String awsSecretKey = args[1];
			String query = "select * from blogfeed";

			if (awsAccessId == null || awsAccessId.trim().length() == 0) {
				System.out.println("Access key not set");
				return;
			}
			if (awsSecretKey == null || awsSecretKey.trim().length() == 0) {
				System.out.println("Secret key not set");
				return;
			}
			System.out.println("Going to run query : "+query);
			String domain = query.substring(query.indexOf("from")+5);
			int idx = domain.indexOf(' ');
			if (idx > -1) {
				domain = domain.substring(0, idx);
			}

			SimpleDB sdb = new SimpleDB(awsAccessId, awsSecretKey);
			Domain dom = sdb.getDomain(domain);

			String nextToken = null;
			try {
				do {
					SelectResult sr = dom.selectItems(query, nextToken);
					List<Item> items = sr.getItems();
					for (Item item : items) {
						System.out.println("Item : "+item.getIdentifier());
						for (String key : item.getAttributes().keySet()) {
							String value = item.getAttributes().get(key);
							System.out.println("  "+key+" = "+value);
						}
					}
					nextToken = sr.getNextToken();
					System.out.println(nextToken);
				} while (nextToken != null && !nextToken.trim().equals(""));
			} catch (SDBException ex) {
				System.out.println(query + " Failure: ");
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

    }
}
