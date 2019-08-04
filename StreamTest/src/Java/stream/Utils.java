package stream;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static <T> List<T> generateData(Class<T> classType, int dataSize) throws IllegalAccessException, InstantiationException {
        List<T> data = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            data.add(classType.newInstance());
        }
        return data;
    }

    public static ConsumerData type0Process(ConsumerData consumerData){
        consumerData.setContent(consumerData.getContent().concat(" processed with Process-0"));
        return consumerData;
    }

    public static ConsumerData type1Process(ConsumerData consumerData){
        consumerData.setContent(consumerData.getContent().concat(" processed with Process-1"));
        return consumerData;
    }

    public   static ConsumerData processUnit(ConsumerData data){
        if (data.getDataType()==0){
            Utils.type0Process(data);
        }else {
            Utils.type1Process(data);
        }
        return data;
    }
}
