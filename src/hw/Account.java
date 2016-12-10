package hw;

import java.util.*;

/**
 * Created by tonchief on 12/04/2016.
 * 10. Создать класс  Account с внутренним классом,
 * с помощью объектов которого можно хранить информацию
 * обо всех операциях со счетом (снятие, платежи, поступления).
 */

public class Account {
    Long id = 0L;
    String number;
    Set<String> accounts = new HashSet<String>();
    ArrayList<Operation> transactions = new ArrayList();

    Account(){
        this.id++;
        // generate random string of 2600ddd, where ddd is 10 dec.digits
        // add it to accounts Set, to avoid duplicates
        do {
            String rnd = Objects.toString(new Random().nextLong()) +
                    "000000000000000";
            this.number = String.format("2600%d", rnd.substring(1,10));
        } while (accounts.contains(this.number));
        accounts.add(this.number);
    }

    class Operation{
        OperationType opt;
        int amount;
        Date date;

        Operation(OperationType opt, int amount, Date date){
            this.opt = opt;
            this.amount = amount;
            this.date = date;
            Account.this.transactions.add(this);
        }
    }

    public enum OperationType {
        DISBURSEMENT, WITHDRAWAL, INCOME;
    }

}
