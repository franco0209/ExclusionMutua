import java.io.FileWriter;
import java.io.IOException;

public class Account {
    private String name;
    private double balance;

    public Account(String InName, double InBalance) {
        this.name = InName;
        this.balance = InBalance;
    }

    // Método synchronized para escribir en el archivo de registro
    public synchronized void writeToLog(String logMessage) {
        try (FileWriter writer = new FileWriter("my_log_game.log", true)) {
            writer.write(logMessage + "\n");
            System.out.println("Successfully wrote to the log file: " + logMessage);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }

    public void deposit(double amount) {
        this.balance = balance + amount;
        System.out.println("Se hizo un depósito de " + amount + " soles.");
        this.showBalance();
        // Registro de la acción en el archivo de log
        writeToLog("Deposit: " + amount + " soles by " + this.name);
    }

    public void withdrawal(double amount) {
        if (this.balance >= amount) {
            this.balance = balance - amount;
            System.out.println("Se hizo un retiro de " + amount + " soles.");
            this.showBalance();
            // Registro de la acción en el archivo de log
            writeToLog("Withdrawal: " + amount + " soles by " + this.name);
        } else {
            System.out.println("Estimado " + this.name + "\n No se puede efectuar la transacción con el saldo actual.");
        }
    }

    public void showBalance() {
        System.out.println("Estimado " + this.name + "\n Tiene " + this.balance + " soles en su cuenta.");
    }

    public String getName() {
        return this.name;
    }
}
