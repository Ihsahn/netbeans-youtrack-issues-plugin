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
 */
package org.llorllale.netbeans.youtrack.issues;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.session.UnauthorizedException;
import org.netbeans.modules.bugtracking.spi.IssueController;
import org.netbeans.modules.bugtracking.spi.IssueProvider;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
public class YtIssue implements IssueProvider<Issue> {
  @Override
  public String getDisplayName(Issue i) {
    return i.summary();
  }

  @Override
  public String getTooltip(Issue i) {
    return i.description().orElse("");
  }

  @Override
  public String getID(Issue i) {
    return i.id();
  }

  @Override
  public Collection<String> getSubtasks(Issue i) {
    return Collections.emptyList();
  }

  @Override
  public String getSummary(Issue i) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean isNew(Issue i) {
    //youtrack-api only creates an instance of Issue if the operation is successful at server
    //side
    return false;
  }

  @Override
  public boolean isFinished(Issue i) {
    //TODO
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean refresh(Issue i) {
    //TODO
    boolean result = true;

    try {
      i.refresh();
    } catch(UnauthorizedException e) {
      result = false;
    } catch(IOException e) {
      result = false;
    }

    return result;
  }

  @Override
  public void addComment(Issue i, String comment, boolean close) {
    //TODO
    try {
      i.comments().post(comment);
    } catch(UnauthorizedException e) {

    } catch(IOException e) {

    }
  }

  @Override
  public void attachFile(Issue i, File file, String description, boolean isPatch) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public IssueController getController(Issue i) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void removePropertyChangeListener(Issue i, PropertyChangeListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void addPropertyChangeListener(Issue i, PropertyChangeListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }
}
