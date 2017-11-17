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

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import static java.util.stream.Collectors.toList;
import org.llorllale.youtrack.api.Issue;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
public class Issues extends AbstractCollection<Issue> {
  private final Collection<Issue> issues;

  /**
   * 
   * @param stream 
   * @since 0.1.0
   */
  public Issues(StreamOfIssues stream) throws IOException {
    this.issues = stream.stream().collect(toList());
  }

  @Override
  public Iterator<Issue> iterator() {
    return this.issues.iterator();
  }

  @Override
  public int size() {
    return this.issues.size();
  }
}
