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

import java.util.function.Predicate;
import org.llorllale.youtrack.api.Issue;
import org.netbeans.modules.bugtracking.spi.QueryController;
import org.netbeans.modules.bugtracking.spi.QueryProvider;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
public class YtQueryProvider implements QueryProvider<Predicate<Issue>, Issue> {

  @Override
  public String getDisplayName(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public String getTooltip(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public QueryController getController(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean canRemove(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void remove(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean canRename(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void rename(Predicate<Issue> query, String newName) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void setIssueContainer(Predicate<Issue> query, IssueContainer<Issue> c) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void refresh(Predicate<Issue> query) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

}
