package Ch23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    public static final String RESOURCES = "src/main/resources/";

    public void analyze(String fileName, BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankStatementParser.parseLinesFromCSV(lines));

        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println(bankStatementProcessor.calculateTotalAmount());
        System.out.println(bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println(bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println(bankStatementProcessor.findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY &&
                bankTransaction.getAmount() >= 1_000));
    }
}
