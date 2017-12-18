import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.*;

public class MemTestChart {

    static long memoryBefore;
    static long memoryAfter;
    static Runtime runtime = Runtime.getRuntime();
    static void memTic() {
        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
    }

    static long memToc() {
        // System.gc();
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        return memoryAfter - memoryBefore;
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

        JFreeChart chartFillMemoryTest = ChartFactory.createXYLineChart("Memory Used", "Fill values", "Memory used", ds,
                PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1,true);

        // Diagram megjelenitese
        showChart(chartFillMemoryTest);
    }


    public static double[][] matrixGenerator(int n){
        double[][] diagramMatrix = new double[6][n + 1];

        List<Integer> sampleArrayList = new ArrayList<>();
        List<Integer> sampleLinkedList = new LinkedList<>();
        HashSet<Integer> sampleHashSet = new HashSet<>();
        TreeSet<Integer> sampleTreeSet = new TreeSet<>();

        fillCollectionForMemTest(n, 1, sampleArrayList, diagramMatrix);
        fillCollectionForMemTest(n, 2, sampleLinkedList, diagramMatrix);
        fillCollectionForMemTest(n, 3, sampleHashSet, diagramMatrix);
        fillCollectionForMemTest(n, 4, sampleTreeSet, diagramMatrix);

        return diagramMatrix;
    }

    public static void fillCollectionForMemTest(int n, int listNumber, Collection<Integer> targetCollection, double[][] targetMatrix) {

        int k = 10;
        for (int i = 0; i <= n; i++) {
            //long startTime = System.currentTimeMillis();
            memTic();
            for (int j = 0; j <= k; j++){
                targetCollection.add(j);
            }
            //long stopTime = System.currentTimeMillis();
            targetMatrix[0][i] = targetCollection.size();
            targetMatrix[listNumber][i] = memToc();
            k = k*10;
        }
    }

    public static void main(String[] args) {

        drawDiagram(matrixGenerator(4));


    }
}
