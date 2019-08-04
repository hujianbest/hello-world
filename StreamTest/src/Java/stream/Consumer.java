package stream;

import annotation.ExecuteTime;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Consumer {


    public  static void run() throws InstantiationException, IllegalAccessException {
        List<ConsumerData> consumerDataList = Utils.generateData(ConsumerData.class, 100);
        initData(consumerDataList);
        List<ConsumerData> processedData = doProcessWithStream(consumerDataList);
        printList(processedData);
    }

    private  static List<ConsumerData> doProcess(List<ConsumerData> consumerDataList) {
        List<ConsumerData> type0 = new ArrayList<>();
        List<ConsumerData> type1 = new ArrayList<>();
        for(ConsumerData data : consumerDataList){
            if ((data.getDataType()==0)){
                type0.add(data);
            }else {
                type1.add(data);
            }
        }
        for(ConsumerData data : type0){
            Utils.type0Process(data);
        }
        for(ConsumerData data : type1){
            Utils.type1Process(data);
        }
        type0.addAll(type1);
        return type0;
    }

    private  static void initData(List<ConsumerData> consumerDataList) {
        for (int i = 0; i < consumerDataList.size(); i++) {
            consumerDataList.get(i).setDataType(i % 2);
            consumerDataList.get(i).setContent("dataContent" + (i + 1));
        }
    }

    private  static void printList(List<ConsumerData> consumerDataList){
        consumerDataList.forEach(consumerData -> System.out.println(consumerData.getDataType()+ "-"+consumerData.getContent()));
    }

    @ExecuteTime
    private  static List<ConsumerData> doProcessWithStream(List<ConsumerData> consumerDataList){
        return consumerDataList.stream().map(Utils::processUnit).collect(Collectors.toList());
    }


}
