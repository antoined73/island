package fr.unice.polytech.si3.qgl.iabe.result;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;

import java.util.List;

/**
 * Created by Antoine on 12/5/2016.
 */
public class ScanResult extends Result{

    private List<String> biomes;
    private List<String> creeks;
    private List<String> sites;

    public ScanResult(ResultParser parser) {
        super(parser);
        this.biomes = parser.getBiomes();
        this.creeks = parser.getCreeks();
        this.sites = parser.getSites();
    }

    public boolean foundedSites() {
        return !this.sites.isEmpty();
    }

    public boolean foundedCreeks() {
        return !this.creeks.isEmpty();
    }

    public List<String> getCreeks() {
        return creeks;
    }

    public List<String> getSites() {
        return sites;
    }
}
