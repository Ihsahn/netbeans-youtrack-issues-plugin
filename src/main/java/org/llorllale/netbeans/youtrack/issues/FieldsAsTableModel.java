/*
 * Copyright 2017 George Aristy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.llorllale.netbeans.youtrack.issues;

import java.util.HashMap;
import java.util.Map;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.llorllale.youtrack.api.AssignedField;
import org.llorllale.youtrack.api.Issue;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class FieldsAsTableModel implements TableModel {
  private static final Map<Integer, String> COLUMNS = new HashMap<>();

  static {
    COLUMNS.put(0, "Name");
    COLUMNS.put(1, "Value");
  }

  private final String[][] fields;

  /**
   * 
   * @param issue 
   * @since 0.2.0
   */
  public FieldsAsTableModel(Issue issue) {
    this.fields = new String[2][issue.fields().size()];
    for (int i = 0; i < issue.fields().size(); i++) {
      final AssignedField field = issue.fields().get(i);
      this.fields[0][i] = field.name();
      this.fields[1][i] = field.value().asString();
    }
  }

  @Override
  public int getRowCount() {
    return this.fields[0].length;
  }

  @Override
  public int getColumnCount() {
    return COLUMNS.size();
  }

  @Override
  public String getColumnName(int columnIndex) {
    return COLUMNS.get(columnIndex);
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return COLUMNS.get(columnIndex).getClass();
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return this.fields[columnIndex][rowIndex];
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void addTableModelListener(TableModelListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void removeTableModelListener(TableModelListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }
}
