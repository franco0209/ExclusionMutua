public class MainApp {
    public static void main(String[] args) {
        // Crear una cuenta
        Account myAccount = new Account("Usuario1", 1000.0);

        // Realizar operaciones en la cuenta y registrar en el archivo de log
        Thread depositThread = new Thread(() -> myAccount.deposit(200.0));
        Thread withdrawalThread = new Thread(() -> myAccount.withdrawal(150.0));

        // Iniciar los hilos
        depositThread.start();
        withdrawalThread.start();

        try {
            // Esperar a que los hilos terminen
            depositThread.join();
            withdrawalThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        // Mostrar el saldo final
        myAccount.showBalance();
    }
}
