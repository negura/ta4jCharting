package de.sjwimmer.ta4jchart.chartbuilder.data;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTableModelTest {

  @Test
  public void testDataModel() {
    final String columnName = "Test";
    final List<Object> columnValues = Arrays.asList("A", "B", "C", "1", "2", "3");
    TacDataTableModel dataTableModel = new TacDataTableModel();
    dataTableModel.addEntries(columnName, columnValues);

    assertEquals(columnName, dataTableModel.getColumnName(2));
    assertEquals(3, dataTableModel.getColumnCount());
    assertEquals(Object.class, dataTableModel.getColumnClass(0));

    for (int i = 0; i < columnValues.size(); i++) {
      assertEquals(columnValues.get(i), dataTableModel.getValueAt(i, 2));
    }
  }
}