package TascaS3.Patterns1.N3.Commands;

import TascaS3.Patterns1.N3.Vehicles.Vehicle;

public class BrakeCommand implements Command {
    private final Vehicle vehicle;

    public BrakeCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.brake();
    }
}
