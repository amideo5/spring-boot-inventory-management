package com.practice.practice.Outbound_Data;

import java.util.HashMap;
import java.util.Map;

public class DispatchItenary {
    private Map<String ,String>dispatchMap = new HashMap<String ,String>();

    public DispatchItenary() {
    }
    public DispatchItenary(Map<String, String> dispatchMap) {
        this.dispatchMap = dispatchMap;
    }

    public Map<String, String> getDispatchMap() {
        return dispatchMap;
    }

    public void setDispatchMap(Map<String, String> dispatchMap) {
        this.dispatchMap = dispatchMap;
    }

}
