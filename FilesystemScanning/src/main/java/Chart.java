import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.Series;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.util.*;

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

    public static double[][] fillDiagram(int n) {

        double[][] diagramMatrix = new double[5][n + 1];

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

    public static void fillSeries(XYSeries targetSeries, double[][] data, int seriesNumber){

        for (int i = 0; i < data[0].length; i++){
            targetSeries.add(data[0][i], data[seriesNumber][i]);
        }

    }

    public static void fillSeriesCollection(XYSeriesCollection targetCollection, double[][] data){

        XYSeries arraySeries1 = new XYSeries("array");
        XYSeries linkedSeries2 = new XYSeries("linked");
        XYSeries treeSeries3 = new XYSeries("tree");
        XYSeries hashSeries4 = new XYSeries("hash");

        fillSeries(arraySeries1,data,1);
        fillSeries(linkedSeries2,data,2);
        fillSeries(treeSeries3,data,3);
        fillSeries(hashSeries4,data,4);

        targetCollection.addSeries(arraySeries1);
        targetCollection.addSeries(linkedSeries2);
        targetCollection.addSeries(treeSeries3);
        targetCollection.addSeries(hashSeries4);

    }


    public static void drawDiagram(double[][] data) {
        // Diagram elkeszitese
        XYSeriesCollection ds = new XYSeriesCollection();
        //DefaultIntervalXYDataset linkedPlot = new DefaultIntervalXYDataset();

        fillSeriesCollection(ds, data);

        JFreeChart chart = ChartFactory.createXYLineChart("Fill Runtimes", "Fill values", "Runtime", ds,
                PlotOrientation.VERTICAL, true, true, false);
        LogarithmicAxis xAxis = new LogarithmicAxis("Fill values");

        JFreeChart chartContainsTest = ChartFactory.createXYLineChart("ContainsTest Runtimes", "Fill values", "Contains Runtime", ds,
                PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);

        // Diagram megjelenitese
        showChart(chartContainsTest);
    }


    public static double[][] matrixGenerator(int n){
        double[][] diagramMatrix = new double[6][n + 1];

        List<Integer> sampleArrayList = new ArrayList<>();
        List<Integer> sampleLinkedList = new LinkedList<>();
        HashSet<Integer> sampleHashSet = new HashSet<>();
        TreeSet<Integer> sampleTreeSet = new TreeSet<>();

        /*fillCollection(n, 1, sampleArrayList, diagramMatrix);
        fillCollection(n, 2, sampleLinkedList, diagramMatrix);
        fillCollection(n, 3, sampleHashSet, diagramMatrix);
        fillCollection(n, 4, sampleTreeSet, diagramMatrix);
*/

        fillCollectionForContainsTest(n, 1, sampleArrayList, diagramMatrix);
        fillCollectionForContainsTest(n, 2, sampleLinkedList, diagramMatrix);
        fillCollectionForContainsTest(n, 3, sampleHashSet, diagramMatrix);
        fillCollectionForContainsTest(n, 4, sampleTreeSet, diagramMatrix);

        return diagramMatrix;
    }

    public static double[][] fillCollection(int n, int listNumber, Collection<Integer> targetCollection, double[][] targetMatrix) {

        int k = 10;
        for (int i = 0; i <= n; i++) {
            long startTime = System.currentTimeMillis();
            for (int j = 0; j <= k; j++){
                targetCollection.add(j);
            }
            long stopTime = System.currentTimeMillis();

            targetMatrix[0][i] = targetCollection.size();
            targetMatrix[listNumber][i] = stopTime-startTime;
            k = k*10;
        }
        return targetMatrix;
    }

    public static void fillCollectionForContainsTest(int n, int listNumber, Collection<Integer> targetCollection, double[][] targetMatrix) {

        int k = 10;
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= k; j++){
                targetCollection.add(j);
            }
            long startTime = System.currentTimeMillis();
            targetCollection.contains(Integer.MAX_VALUE);
            long stopTime = System.currentTimeMillis();

            targetMatrix[0][i] = targetCollection.size();
            targetMatrix[listNumber][i] = stopTime-startTime;
            k = k*10;
        }
    }

    public static void main(String[] args) {

        //drawDiagram(fillDiagram(45));
        drawDiagram(matrixGenerator(4));



    }
}
