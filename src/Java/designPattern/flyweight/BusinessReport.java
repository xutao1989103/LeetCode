package designPattern.flyweight;

/**
 * Created by Administrator on 2014/11/21.
 */
public class BusinessReport implements IreportManager {
    private String compId;
    @Override
    public String getReport(){
        return "this is business report :"+ compId;
    }
    public BusinessReport(String compId){
        this.compId=compId;
    }
}
