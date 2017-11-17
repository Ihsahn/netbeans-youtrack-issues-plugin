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

package org.llorllale.netbeans.youtrack.issues.queries;

import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import org.netbeans.modules.bugtracking.spi.QueryController;
import org.openide.util.HelpCtx;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
public class YtQueryConfigController implements QueryController {

  @Override
  public boolean providesMode(QueryMode mode) {
    return true;
  }

  @Override
  public JComponent getComponent(QueryMode mode) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public HelpCtx getHelpCtx() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void opened() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void closed() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean saveChanges(String name) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean discardUnsavedChanges() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean isChanged() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener l) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener l) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

}
