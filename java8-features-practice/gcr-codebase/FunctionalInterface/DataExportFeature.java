public class DataExportFeature {

    interface DataExporter {

        void exportToCSV();
        void exportToPDF();

        default void exportToJSON() {
            System.out.println("Exporting data to JSON (default implementation)");
        }
    }

    static class CSVExporter implements DataExporter {

        public void exportToCSV() {
            System.out.println("Exporting data to CSV format");
        }

        public void exportToPDF() {
            System.out.println("CSVExporter does not support PDF");
        }
    }

    static class PDFExporter implements DataExporter {

        public void exportToCSV() {
            System.out.println("PDFExporter does not support CSV");
        }

        public void exportToPDF() {
            System.out.println("Exporting data to PDF format");
        }
    }

    public static void main(String[] args) {

        DataExporter csvExporter = new CSVExporter();
        DataExporter pdfExporter = new PDFExporter();

        csvExporter.exportToCSV();
        csvExporter.exportToJSON();

        pdfExporter.exportToPDF();
        pdfExporter.exportToJSON();
    }
}
