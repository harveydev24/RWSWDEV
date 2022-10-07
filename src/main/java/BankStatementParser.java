import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFromCSV(final String line);
    List<BankTransaction> parseLinesFromCSV(final List<String> lines);
}
