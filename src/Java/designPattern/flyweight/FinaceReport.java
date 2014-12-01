package designPattern.flyweight;

/**
 * Created by Administrator on 2014/11/21.
 */
public class FinaceReport implements IreportManager {
    String compId;
    @Override
    public String getReport(){
        return "this is finace report :"+ compId;
    }
    public FinaceReport(String compId){
        this.compId=compId;
    }
}
