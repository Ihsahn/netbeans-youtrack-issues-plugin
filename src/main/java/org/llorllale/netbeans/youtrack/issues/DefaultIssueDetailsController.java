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

import org.llorllale.netbeans.youtrack.issues.util.IssueToSpec;
import org.llorllale.netbeans.youtrack.issues.util.EqIssueSpec;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import org.llorllale.youtrack.api.Issue;
import org.netbeans.modules.bugtracking.spi.IssueController;
import org.openide.util.HelpCtx;

/**
 * MVC controller for issues.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @see IssueDetails
 * @since 0.2.0
 */
@SuppressWarnings("checkstyle:MethodCount")
public final class DefaultIssueDetailsController implements IssueController {
  private final Issue issue;
  private final IssueDetails view;

  /**
   * Ctor.
   * 
   * @param issue the issue to be displayed
   * @since 0.2.0
   */
  public DefaultIssueDetailsController(Issue issue) {
    this.issue = issue;
    this.view = new DefaultIssueDetails(issue);
  }

  @Override
  public JComponent getComponent() {
    return this.view.asView();
  }

  @Override
  public HelpCtx getHelpCtx() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void opened() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void closed() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public boolean saveChanges() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public boolean discardUnsavedChanges() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public boolean isChanged() {
    return new EqIssueSpec(
        new IssueToSpec().apply(this.issue)
    ).isEqualTo(this.view.asSpec());
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }
}
