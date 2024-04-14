
/* 
public class ATM {

    class Transaction {
        private String type;
        private double amount;
        private String date;

        public Transaction(String type, double amount, String date) {
            this.type = type;
            this.amount = amount;
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public String getDate() {
            return date;
        }
    }

    class TransactionHistory {
        private Transaction[] transactions;
        private int numTransactions;

        public TransactionHistory(int capacity) {
            transactions = new Transaction[capacity];
            numTransactions = 0;
        }

        public void addTransaction(String type, double amount, String date) {
            if (numTransactions < transactions.length) {
                transactions[numTransactions] = new Transaction(type, amount, date);
                numTransactions++;
            } else {
                System.out.println("Transaction history full. Cannot add more transactions.");
            }
        }

        public void displayTransactions() {
            if (numTransactions == 0) {
                System.out.println("No transactions yet.");
            } else {
                System.out.println("Transaction History:");
                for (int i = 0; i < numTransactions; i++) {
                    Transaction transaction = transactions[i];
                    System.out.println("Type: " + transaction.getType() +
                            ", Amount: " + transaction.getAmount() +
                            ", Date: " + transaction.getDate());
                }
            }
        }
    }

    class User {
        private String user_id;
        private String user_pin;

        public User(String user_id, String user_pin) {
            this.user_id = user_id;
            this.user_pin = user_pin;
        }
    }

    class Atm {
        private User user;
        private TransactionHistory transactionHistory;
        private double balance;

        public Atm(User user, TransactionHistory transactionHistory) {
            this.user = user;
            this.transactionHistory = transactionHistory;
            this.balance = 0.0; // Initial balance
        }

        public void withdraw(double amount, String date) {
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                transactionHistory.addTransaction("Withdrawal", amount, date);
                System.out.println("Withdrawal successful.");
            }
        }

        public void deposit(double amount, String date) {
            balance += amount;
            transactionHistory.addTransaction("Deposit", amount, date);
            System.out.println("Deposit successful.");
        }

        public void transfer(double amount, String date) {
            // Assuming transfer functionality involves deducting from the balance
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                transactionHistory.addTransaction("Transfer", amount, date);
                System.out.println("Transfer successful.");
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        // Create a sample user
        User user = new User("sampleUser", "1234");

        // Create transaction history for the user
        TransactionHistory transactionHistory = new TransactionHistory(100);

        // Create ATM instance and start the application
        Atm atm = new Atm(user, transactionHistory);

        // Perform sample transactions
        atm.deposit(1000.0, "2024-04-15");
        atm.withdraw(500.0, "2024-04-16");
        atm.transfer(200.0, "2024-04-17");

        // Display transactions history
        transactionHistory.displayTransactions();

        // Display remaining balance
        System.out.println("Current balance: " + atm.getBalance());
    }
}*/
import java.util.*;

public class ATM {

    static class Transaction {
        // Transaction class implementation...
        private String type;
        private double amount;
        private String date;

        public Transaction(String type, double amount, String date) {
            this.type = type;
            this.amount = amount;
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public String getDate() {
            return date;
        }
    }

    static class TransactionHistory {
        // TransactionHistory class implementation...
        private Transaction[] transactions;
        private int numTransactions;

        public TransactionHistory(int capacity) {
            transactions = new Transaction[capacity];
            numTransactions = 0;
        }

        public void addTransaction(String type, double amount, String date) {
            if (numTransactions < transactions.length) {
                transactions[numTransactions] = new Transaction(type, amount, date);
                numTransactions++;
            } else {
                System.out.println("Transaction history full. Cannot add more transactions.");
            }
        }

        public void displayTransactions() {
            if (numTransactions == 0) {
                System.out.println("No transactions yet.");
            } else {
                System.out.println("Transaction History:");
                for (int i = 0; i < numTransactions; i++) {
                    Transaction transaction = transactions[i];
                    System.out.println("Type: " + transaction.getType() +
                            ", Amount: " + transaction.getAmount() +
                            ", Date: " + transaction.getDate());
                }
            }
        }
    }

    static class User {
        // User class implementation...
        private String user_id;
        private String user_pin;

        public User(String user_id, String user_pin) {
            this.user_id = user_id;
            this.user_pin = user_pin;
        }
    }

    static class Atm {
        // Atm class implementation...
        private User user;
        private TransactionHistory transactionHistory;
        private double balance;

        public Atm(User user, TransactionHistory transactionHistory) {
            this.user = user;
            this.transactionHistory = transactionHistory;
            this.balance = 0.0; // Initial balance
        }

        public void withdraw(double amount, String date) {
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                transactionHistory.addTransaction("Withdrawal", amount, date);
                System.out.println("Withdrawal successful.");
            }
        }

        public void deposit(double amount, String date) {
            balance += amount;
            transactionHistory.addTransaction("Deposit", amount, date);
            System.out.println("Deposit successful.");
        }

        public void transfer(double amount, String date) {
            // Assuming transfer functionality involves deducting from the balance
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                transactionHistory.addTransaction("Transfer", amount, date);
                System.out.println("Transfer successful.");
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create a sample user
        User user = new User("sampleUser", "1234");

        // Create transaction history for the user
        TransactionHistory transactionHistory = new TransactionHistory(100);

        // Create ATM instance and start the application
        Atm atm = new Atm(user, transactionHistory);

        // Perform sample transactions
        boolean continueProgram = true;
        int n;
        do {
            System.out.println("1.Transaction History");
            System.out.println("2.Withraw");
            System.out.println("3.Deposit");
            System.out.println("4.Transfer");
            System.out.println("5.Ouit");
            System.out.println("Which Operation you want perform:");
            n = sc.nextInt();
            switch (n) {
                case 1: {
                    transactionHistory.displayTransactions();
                    break;
                }
                case 2: {
                    atm.withdraw(500.0, "2024-04-16");
                    System.out.println("Current balance: " + atm.getBalance());
                    break;
                }
                case 3: {
                    atm.deposit(1000.0, "2024-04-15");
                    System.out.println("Current balance: " + atm.getBalance());
                    break;
                }
                case 4: {
                    atm.transfer(200.0, "2024-04-17");
                    System.out.println("Current balance: " + atm.getBalance());
                    break;
                }
                case 5: {
                    continueProgram = false;
                    System.out.println("thank you");
                    break;
                }
                default: {
                    System.out.println("Invalid Input.");
                }
            }
        } while (continueProgram);
    }
}
