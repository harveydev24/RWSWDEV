package chapter2and3;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0d;
        for (BankTransaction bankTransaction: bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalAmount() {
        return summarizeTransactions((acc, bankTransaction) ->
                acc + bankTransaction.getAmount());
    }

    public double calculateTotalInMonth(Month month) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
    }

    public double calculateTotalForCategory(String category) {
        return summarizeTransactions((acc, bankTransactions) ->
                bankTransactions.getDescription().equals(category) ? acc + bankTransactions.getAmount() : acc);
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        return result;
    }
}
