package chapter2and3;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("log.csv", bankStatementParser);
    }
}
