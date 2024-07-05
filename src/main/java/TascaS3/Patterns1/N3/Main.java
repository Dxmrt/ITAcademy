package TascaS3.Patterns1.N3;

import TascaS3.Patterns1.N3.Commands.AccelerateCommand;
import TascaS3.Patterns1.N3.Commands.BrakeCommand;
import TascaS3.Patterns1.N3.Commands.StartCommand;
import TascaS3.Patterns1.N3.Controller.VehicleController;
import TascaS3.Patterns1.N3.Vehicles.*;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        Vehicle airplane = new Airplane();
        Vehicle boat = new Boat();

        VehicleController controller = new VehicleController();

        controller.setStartCommand(new StartCommand(car));
        controller.setAccelerateCommand(new AccelerateCommand(car));
        controller.setBrakeCommand(new BrakeCommand(car));

        System.out.println("Testeando Coche:");
        controller.startVehicle();
        controller.accelerateVehicle();
        controller.brakeVehicle();

        controller.setStartCommand(new StartCommand(bicycle));
        controller.setAccelerateCommand(new AccelerateCommand(bicycle));
        controller.setBrakeCommand(new BrakeCommand(bicycle));

        System.out.println("\nTesteando Bici:");
        controller.startVehicle();
        controller.accelerateVehicle();
        controller.brakeVehicle();

        controller.setStartCommand(new StartCommand(airplane));
        controller.setAccelerateCommand(new AccelerateCommand(airplane));
        controller.setBrakeCommand(new BrakeCommand(airplane));

        System.out.println("\nTesteando Avion:");
        controller.startVehicle();
        controller.accelerateVehicle();
        controller.brakeVehicle();

        controller.setStartCommand(new StartCommand(boat));
        controller.setAccelerateCommand(new AccelerateCommand(boat));
        controller.setBrakeCommand(new BrakeCommand(boat));

        System.out.println("\nTesteando Barco:");
        controller.startVehicle();
        controller.accelerateVehicle();
        controller.brakeVehicle();
    }
}
