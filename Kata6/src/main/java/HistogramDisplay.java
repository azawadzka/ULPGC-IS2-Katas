import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HistogramDisplay extends ApplicationFrame {

    public HistogramDisplay(Person[] data) {
        super("Histogram");
        this.setContentPane(createPanel(createDataSet(data)));
        this.pack();
        this.execute();
    }
    
    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel(DefaultCategoryDataset data) {
        ChartPanel chartpanel = new ChartPanel(createChart(data));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Employees per departament", "Departaments", "Number of employees", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;
    }
    
    public DefaultCategoryDataset createDataSet(Person[] data) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Person p : data) {
            dataSet.addValue(1, "", p.getDepartament());
        }
        return dataSet;
    }
}
