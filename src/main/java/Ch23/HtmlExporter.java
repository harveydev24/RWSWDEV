package Bank;

public class HtmlExporter implements Exporter{
    @Override
    public String export(SummaryStatistics summaryStatistics) {

        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li>" + summaryStatistics.getSum() +"</li>";
        result += "<li>" + summaryStatistics.getAverage() +"</li>";
        result += "<li>" + summaryStatistics.getMax() +"</li>";
        result += "<li>" + summaryStatistics.getMin() +"</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
