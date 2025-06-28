package com.exercise;

public class MyService {
    private ExternalAPI api;

    public MyService(ExternalAPI api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();  
    }
        public void executeAction() {
        api.performAction();  
    }
    public String[] fetchMultipleTimes(int times) {
        String[] results = new String[times];
        for (int i = 0; i < times; i++) {
            results[i] = api.getData();  
        }
        return results;
    }
    public void process() {
        api.logAccess();       
        api.performAction();   
        api.getData();         
    }
    public void delete() {
        api.deleteData();
    }
}
