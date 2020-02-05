import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class HistogramDisplay extends ApplicationFrame {
    private Histogram histogram;

    public HistogramDisplay(Histogram histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    public void execute() {
        setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500, 400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram JFreeChart", "Dominios email", "Numero de emails", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (Object key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key.toString());
        }
        return dataSet;
    }
}
