package TascaS3.Patterns1.N1;


import java.util.ArrayList;
import java.util.List;

public class Undo {

    private final List<String> commandList;
    private static Undo instance;
    private static final int MAX_COMMANDS = 10; // Limite de comandos guardados

    private Undo() {
        commandList = new ArrayList<>();
    }

    public static synchronized Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        if (commandList.size() == MAX_COMMANDS) {
            commandList.remove(0); // Elimina el comando más antiguo si se alcanzo su limite
        }
        commandList.add(command);
        System.out.println("Comanda añadida: " + command);
    }

    public void removeCommand(int index) {
        if (index >= 0 && index < commandList.size()) {
            String removedCommand = commandList.remove(index);
            System.out.println("Comanda eliminada: " + removedCommand);
        } else {
            System.out.println("Index o posicion no valida");
        }
    }

    public void listCommands() {
        if (commandList.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("Lista de comandas:");
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println((i + 1) + ". " + commandList.get(i));
            }
        }
    }

}
