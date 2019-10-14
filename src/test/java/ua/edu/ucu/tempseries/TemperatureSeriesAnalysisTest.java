package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    TemperatureSeriesAnalysis seriesAnalysis;
    TemperatureSeriesAnalysis emptySeriesAnalysis;

    @Before
    public void setup() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        emptySeriesAnalysis = new TemperatureSeriesAnalysis();
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        emptySeriesAnalysis.average();
    }


    @Test
    public void testAverage() {
        double expResult = 1.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        emptySeriesAnalysis.average();
    }


    @Test
    public void testDeviation() {
        double expResult = 3.7416573867739;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        emptySeriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        emptySeriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        emptySeriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testClosestToZero() {
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        emptySeriesAnalysis.findTempClosestToValue(4.0);
    }

    @Test
    public void testClosestToValue() {
        double expResult = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTemperatureLessThanWithEmptyArray() {
        emptySeriesAnalysis.findTempsLessThan(4.0);
    }

    @Test
    public void testTemperatureLessThan() {
        int expResult = 3;
        double[] actualResult = seriesAnalysis.findTempsLessThan(4.0);
        assertEquals(expResult, actualResult.length, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTemperatureGreaterThanWithEmptyArray() {
        emptySeriesAnalysis.findTempsGreaterThan(4.0);
    }

    @Test
    public void testTemperatureGreaterThan() {
        int expResult = 1;
        double[] actualResult = seriesAnalysis.findTempsGreaterThan(4.0);
        assertEquals(expResult, actualResult.length, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempSummaryStatisticsWithEmptyArray() {
        emptySeriesAnalysis.summaryStatistics();
    }

    @Test
    public void testTempSummaryStatistics() {
        TempSummaryStatistics statistics = seriesAnalysis.summaryStatistics();
        assertEquals(1.0, statistics.avgTemp, 0.00001);
        assertEquals(3.7416573867739, statistics.devTemp, 0.00001);
        assertEquals(-5.0, statistics.minTemp, 0.00001);
        assertEquals(5.0, statistics.maxTemp, 0.00001);
    }

    @Test
    public void testAddTempToEmptyArray() {
        assertEquals(3, emptySeriesAnalysis.addTemps(1.0, 2.0, 3.0));
    }

    @Test
    public void testAddTemp() {
        assertEquals(7, seriesAnalysis.addTemps(1.0, 2.0, 3.0));
    }

    @Test(expected = InputMismatchException.class)
    public void testConstructorFailure() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -274.0};
        TemperatureSeriesAnalysis seriesTest = new TemperatureSeriesAnalysis(temperatureSeries);
    }

}
