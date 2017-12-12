import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;

public class Chart {

    public static long fibonacci2(long n)  {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fibonacci2(n - 1) + fibonacci2(n - 2);
        }
    }


    public static int fibonacci3(int n){
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i=2; i <= n; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    public static void showChart(JFreeChart chart) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
            }
        });
    }

    public static void drawDiagram(double[][] data) {
        // Diagram elkeszitese
        DefaultXYDataset ds = new DefaultXYDataset();
        ds.addSeries("Fibonacci search", data);
        JFreeChart chart = ChartFactory.createXYLineChart("Fibonacci search", "Fibonacci values", "Runtime", ds,
                PlotOrientation.VERTICAL, true, true, false);

        NumberAxis xAxis = new NumberAxis("Fibonacci values");

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);

        // Diagram megjelenitese
        showChart(chart);
    }

    public static double[][] fillDiagram(int n) {

        double[][] diagramMatrix = new double[2][n + 1];

        for (int i = 0; i <= n; i++) {
            long averageLong = 0;
            for (int j = 0; j <= 10; j++){
                long startTime = System.currentTimeMillis();
                fibonacci2(i);
                long stopTime = System.currentTimeMillis();
                averageLong += stopTime-startTime;
            }
            diagramMatrix[0][i] = fibonacci2(i);
            diagramMatrix[1][i] = averageLong/10;
        }
        return diagramMatrix;
    }

    public static void main(String[] args) {
        drawDiagram(fillDiagram(45));

    }
}
