import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * TODO
 *
 * @author bestJ
 * @since 1.0.0
 */
public class MongoUtil {

    public static MongoDatabase getConnect(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        return mongoDatabase;
    }




    public static void main(String[] args) {
        MongoCollection<Document> collection = getConnect().getCollection("user");
        Document document = new Document("name","张三")
                .append("sex","男")
                .append("age",18);
        collection.insertOne(document);

        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
}
