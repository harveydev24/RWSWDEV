package chapter2and3;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(final String line);
    List<BankTransaction> parseLinesFromCSV(final List<String> lines);
}
