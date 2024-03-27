package repositories;

import exceptions.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    Map<Long, Gate> gateTable = new HashMap<Long, Gate>();

    public Map<Long, Gate> getGates() {
        return gateTable;
    }

    public void setGates(Map<Long, Gate> gates) {
        this.gateTable = gates;
    }

    public Gate getGateByID(Long id) throws GateNotFoundException {
        if(gateTable.containsKey(id)){
            return gateTable.get(id);
        }
        throw new GateNotFoundException();
    }
}
