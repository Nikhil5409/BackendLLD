package ParkingLot.repositories;

import ParkingLot.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    private Map<Long, Gate> gates = new HashMap<>();

    public GateRepository() {

        Gate gate = new Gate() {};

        gate.setId(1L);
        gate.setGateNumber("ENTRY-1");
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(GateType.ENTRY);

        Operator operator = new Operator();
        operator.setName("Nikhil");

        gate.setCurrentOperator(operator);

        gates.put(1L, gate);
    }

    public Optional<Gate> findGateByGateId(Long gateId) {
        return Optional.ofNullable(gates.get(gateId));
    }
}