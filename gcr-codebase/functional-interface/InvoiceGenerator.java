import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {

    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class InvoiceGenerator {

    public static void main(String[] args) {
        LocalDate invoiceDate = LocalDate.now();

        String uiFormat = DateUtils.formatDate(invoiceDate, "dd-MM-yyyy");
        String pdfFormat = DateUtils.formatDate(invoiceDate, "dd MMM yyyy");
        String dbFormat = DateUtils.formatDate(invoiceDate, "yyyy-MM-dd");

        System.out.println("UI Date  : " + uiFormat);
        System.out.println("PDF Date : " + pdfFormat);
        System.out.println("DB Date  : " + dbFormat);

    }

}