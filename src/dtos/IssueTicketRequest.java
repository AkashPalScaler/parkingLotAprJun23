package dtos;

import models.VehicleType;

public class IssueTicketRequest {
    String vehicleNumber;
    VehicleType vehicleType;
    String owner;
    Long gateID;

    public IssueTicketRequest(String vehicleNumber, VehicleType vehicleType, String owner, Long gateID) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.owner = owner;
        this.gateID = gateID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getGateID() {
        return gateID;
    }

    public void setGateID(Long gateID) {
        this.gateID = gateID;
    }
}
