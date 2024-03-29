
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
public class CH9TimeCall {

	/**
	 * Main execution body.
	 *
	 * @param args	    command line arguments (none required or processed)
	 */
    public static void main(String [] args) {
		if (args.length != 2) {
			System.err.println("usage: CH9TimeCall <access key> <secret key>");
			System.exit(1);
		}
		try {
			String awsAccessId = args[0];
			String awsSecretKey = args[1];

			if (awsAccessId == null || awsAccessId.trim().length() == 0) {
				System.out.println("Access key not set");
				return;
			}
			if (awsSecretKey == null || awsSecretKey.trim().length() == 0) {
				System.out.println("Secret key not set");
				return;
			}
			int LIMIT = 10;
			int [] times = new int[LIMIT];
			SimpleDB sdb = new SimpleDB(awsAccessId, awsSecretKey);

			for (int i=0; i<LIMIT; i++) {
				try {
					long start = System.currentTimeMillis();
					ListDomainsResult list = sdb.listDomains();
					long end = System.currentTimeMillis();
					times[i] = (int)(end-start);
				} catch (SDBException ex) {
					System.out.println("Error: "+ex.getMessage());
					ex.printStackTrace();
				}
			}
			int sum = 0;
			for (int i=2; i<LIMIT; i++) {
				sum += times[i];
			}
			System.out.println("avg time for request : "+(sum/(LIMIT-2))+" msec");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

    }
}
