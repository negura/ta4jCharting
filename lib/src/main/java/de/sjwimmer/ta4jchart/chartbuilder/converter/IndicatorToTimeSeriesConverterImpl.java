package de.sjwimmer.ta4jchart.chartbuilder.converter;

import java.util.Date;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;

public class IndicatorToTimeSeriesConverterImpl implements IndicatorToTimeSeriesConverter {

  @Override
  public TimeSeriesCollection convert(Indicator<?> indicator, String name) {
    final TimeSeriesCollection collection = new TimeSeriesCollection();
    final TimeSeries timeSeries = new TimeSeries(name);
    final BarSeries barSeries = indicator.getBarSeries();
    for (int i = barSeries.getBeginIndex(); i <= barSeries.getEndIndex(); i++) {
      final Bar bar = barSeries.getBar(i);
      final double value = extractDoubleValue(indicator, i);
      final Second time = new Second(new Date(bar.getEndTime().toEpochMilli()));
      timeSeries.add(time, value);
    }
    collection.addSeries(timeSeries);
    return collection;
  }
}
