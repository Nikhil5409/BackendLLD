package ParkingLot.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Ticket ticket;
    private Operator operator;
    private Gate exitGate;
    private double amount;
    private Date exitDate;
    private List<Payment> payments;
}
