package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.result.ScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 12/5/2016.
 */
public class Journal {

    private List<String> creeksId;
    private List<String> sitesId;

    public Journal() {
        this.creeksId = new ArrayList<String>();
        this.sitesId = new ArrayList<String>();
    }

    public void setTrace(ScanResult result){
        if(result.foundedCreeks()){
            List<String> creeks = result.getCreeks();
            creeksId.addAll(creeks);
        }

        if(result.foundedSites()){
            List<String> sites = result.getSites();
            sitesId.addAll(sites);
        }
    }

    public String buildReport() {
        String report = "";
        for(String site : sitesId){
            report+="EMERGENCY:"+site+"\n";
        }
        if(!creeksId.isEmpty()){
            report+="CREEK:"+creeksId.get(0);
        }
        return report;
    }
}
