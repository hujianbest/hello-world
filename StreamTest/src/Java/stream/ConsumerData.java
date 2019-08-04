package stream;

public class ConsumerData {
    private int dataType;
    private String content;

    ConsumerData(){}

    ConsumerData(int dataType, String content ){
        this.dataType = dataType;
        this.content = content;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static ConsumerData newInstance() {
        ConsumerData fragment = new ConsumerData();
        return fragment;
    }
}
