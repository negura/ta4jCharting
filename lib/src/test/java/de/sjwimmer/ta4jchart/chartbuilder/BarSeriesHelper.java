package de.sjwimmer.ta4jchart.chartbuilder;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.ta4j.core.Bar;
import org.ta4j.core.bars.HeikinAshiBarBuilder;
import org.ta4j.core.num.DecimalNum;

public class BarSeriesHelper {

  /**
   * Creates a series of mock bars with given close prices
   *
   * @param closes the expected close prices of the bars
   * @return a series of mock bars with given close prices
   */
  public static List<Bar> createBars(final double... closes) {
    final List<Bar> bars = new ArrayList<>(closes.length);
    for (int i = 0; i < closes.length; i++) {

      Bar bar = new HeikinAshiBarBuilder()
          .timePeriod(Duration.ofDays(1))
          .endTime(ZonedDateTime.now().minusDays((closes.length - i)).toInstant())
          .openPrice(DecimalNum.valueOf(closes[i]))
          .highPrice(DecimalNum.valueOf(closes[i] + (double) i))
          .lowPrice(DecimalNum.valueOf(Math.max(0, closes[i])))
          .closePrice(DecimalNum.valueOf(closes[i]))
          .volume(DecimalNum.valueOf(closes[i] * (double) i))
          .build();

      bars.add(bar);
    }
    return bars;
  }

  /**
   * Creates a series of mock bars
   *
   * @return a series of mock bars with given close prices
   */
  public static List<Bar> createBars() {
    return createBars(32, 26, 28, 20, 21, 23, 24, 23, 26);
  }
}
