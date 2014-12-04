package designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/11/21.
 */
public class ReportManagerFactory {
    Map<String,IreportManager> finaceReportManager=new HashMap<String, IreportManager>();
    Map<String,IreportManager> businessReportManager=new HashMap<String, IreportManager>();
    public IreportManager getFinaceReportManager(String compId){
        IreportManager finaceReport=finaceReportManager.get(compId);
        if(null==finaceReport){
           finaceReport=new FinaceReport(compId);
           finaceReportManager.put(compId,finaceReport);

        }
        return finaceReport;
    }
    public IreportManager getBusinessReportManager(String compId){
        if(businessReportManager.get(compId)==null){
            IreportManager businessReport=new BusinessReport(compId);
            businessReportManager.put(compId,businessReport);
            return businessReport;
        }else {
            return businessReportManager.get(compId);
        }
    }

}
