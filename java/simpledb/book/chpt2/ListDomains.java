package simpledb.book.chpt2;

import com.xerox.amazonws.sdb.SimpleDB;
import com.xerox.amazonws.sdb.ListDomainsResult;
import com.xerox.amazonws.sdb.SDBException;
import com.xerox.amazonws.sdb.Domain;
import simpledb.book.util.SimpleDBHelper;

/**
 * User: treeder
 * Date: Nov 9, 2008
 * Time: 12:44:26 AM
 */
public class ListDomains {

    public static void main(String[] args) throws SDBException {
        SimpleDB db = SimpleDBHelper.getSimpleDB();
        ListDomainsResult listDomainsResult = db.listDomains();
        for (Domain domain : listDomainsResult.getDomainList()) {
            System.out.println("Domain: " + domain.getName());
        }
    }
}
