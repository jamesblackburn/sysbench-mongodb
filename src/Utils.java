import java.util.Random;

import org.bson.types.Binary;

import com.mongodb.BasicDBObject;


public class Utils {

    public static String sysbenchString(Random rand, String thisMask) {
        String returnString = "";
        for (int i = 0, n = thisMask.length() ; i < n ; i++) { 
            char c = thisMask.charAt(i); 
            if (c == '#') {
                returnString += String.valueOf(rand.nextInt(10));
            } else if (c == '@') {
                returnString += (char) (rand.nextInt(26) + 'a');
            } else {
                returnString += c;
            }
        }
        return returnString;
    }

    public static BasicDBObject buildDocument(Random rand, int startId, int numMaxInserts, String bigPadding) {
        BasicDBObject doc = new BasicDBObject();
        doc.put("_id",startId);
        doc.put("k",rand.nextInt(numMaxInserts)+1);
        String cVal = Utils.sysbenchString(rand, "###########-###########-###########-###########-###########-###########-###########-###########-###########-###########");
        doc.put("c",cVal);
        String padVal = Utils.sysbenchString(rand, "###########-###########-###########-###########-###########");
        doc.put("pad",padVal);
        doc.put("bigPading", bigPadding); 
        return doc;
    }

}