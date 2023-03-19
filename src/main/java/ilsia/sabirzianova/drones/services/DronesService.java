package ilsia.sabirzianova.drones.services;

import ilsia.sabirzianova.drones.model.Medication;

public interface DronesService {
    public void register();// registering a drone;

    public void load(Medication medication); //loading a drone with medication items;

    public Medication check();//checking loaded medication items for a given drone;

    public boolean isEmpty(); //checking available drones for loading;

    public Integer checkBattery();// check drone battery level for a given drone;
}
