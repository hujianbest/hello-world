import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * TODO
 *
 * @author bestJ
 * @since 1.0.0
 */
public class MongoUtil {

    public static MongoDatabase getConnect() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mqtt");
        return mongoDatabase;
    }
}

class MqttReceiver implements IMqttMessageListener {
    @Autowired
    private RecordDao recordDao;

    public void messageArrived(String topic, MqttMessage message) {
        String content=message.getPayload().toString();
        recordDao.saveRecord(topic, content);
    }
}









    public static void main(String[] args) {
        MongoCollection<Document> collection = getConnect().getCollection("user");
        Document document = new Document("name","张三")
                .append("sex","男")
                .append("age",18);
        collection.insertOne(document);

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
        System.out.println();

        Bson filter = Filters.eq("name","张三");
        Document document1 = new Document("$set",new Document("age",100));
        collection.updateOne(filter, document1);
        cursor = findIterable.iterator();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
        System.out.println();

        collection.deleteOne(filter);
        cursor = findIterable.iterator();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
}
