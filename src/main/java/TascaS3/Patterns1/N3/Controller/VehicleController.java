package TascaS3.Patterns1.N3.Controller;

import TascaS3.Patterns1.N3.Commands.Command;

public class VehicleController {
    private Command startCommand;
    private Command accelerateCommand;
    private Command brakeCommand;

    public void setStartCommand(Command startCommand) {
        this.startCommand = startCommand;
    }

    public void setAccelerateCommand(Command accelerateCommand) {
        this.accelerateCommand = accelerateCommand;
    }

    public void setBrakeCommand(Command brakeCommand) {
        this.brakeCommand = brakeCommand;
    }

    public void startVehicle() {
        startCommand.execute();
    }

    public void accelerateVehicle() {
        accelerateCommand.execute();
    }

    public void brakeVehicle() {
        brakeCommand.execute();
    }
}
