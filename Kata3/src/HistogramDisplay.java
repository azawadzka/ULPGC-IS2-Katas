import java.awt.Dimension;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{

    public static void main(String[] args) {
        new HistogramDisplay().execute();
    }
    
    public HistogramDisplay() {
        super("Histogram");
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public void execute() {
        setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram JFreeChart", "Dominios email", "Numero de emails", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;
    }
    
    public static DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        Random r = new Random();
        int bound = 500;

        dataSet.addValue(r.nextInt(bound), "", "ulpgc.es");
        dataSet.addValue(r.nextInt(bound), "", "gmail.com");
        dataSet.addValue(r.nextInt(bound), "", "dis.ulpgc.es");
        dataSet.addValue(r.nextInt(bound), "", "mail.es");
        dataSet.addValue(r.nextInt(bound), "", "yahoo.es");
        dataSet.addValue(r.nextInt(bound), "", "msn.es");
        return dataSet;
    }
}
