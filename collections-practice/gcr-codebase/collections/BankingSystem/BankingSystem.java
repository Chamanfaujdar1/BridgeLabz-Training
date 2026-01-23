import java.util.*;

class WithdrawalRequest {
    int accNo;
    int amount;

    WithdrawalRequest(int accNo, int amount) {
        this.accNo = accNo;
        this.amount = amount;
    }
}

public class BankingSystem {
    public static void main(String[] args){
        HashMap<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 2000);
        accounts.put(103, 8000);

        Queue<WithdrawalRequest> queue = new LinkedList<>();
        queue.add(new WithdrawalRequest(101, 1000));
        queue.add(new WithdrawalRequest(102, 2500));
        queue.add(new WithdrawalRequest(103, 3000));
        queue.add(new WithdrawalRequest(101, 6000));

        while(!queue.isEmpty()){
            WithdrawalRequest req = queue.remove();

            if (!accounts.containsKey(req.accNo)) {
                System.out.println("Account not found: " + req.accNo);
                continue;
            }

            int bal = accounts.get(req.accNo);

            if (bal >= req.amount) {
                accounts.put(req.accNo, bal - req.amount);
                System.out.println("Withdrawn " + req.amount + " from " + req.accNo + " | New Balance: " + accounts.get(req.accNo));
            } else {
                System.out.println("Insufficient balance for " + req.accNo + " | Balance: " + bal + " | Requested: " + req.amount);
            }
        }

        TreeMap<Integer, List<Integer>> sortedByBalance = new TreeMap<>();

        for (Map.Entry<Integer, Integer> e : accounts.entrySet()) {
            int accNo = e.getKey();
            int bal = e.getValue();

            sortedByBalance.putIfAbsent(bal, new ArrayList<>());
            sortedByBalance.get(bal).add(accNo);
        }

        System.out.println("\nCustomers sorted by balance:");

        for(Map.Entry<Integer, List<Integer>> e : sortedByBalance.entrySet()){
            System.out.println("Balance " + e.getKey() + " -> Accounts " + e.getValue());
        }
    }
}
