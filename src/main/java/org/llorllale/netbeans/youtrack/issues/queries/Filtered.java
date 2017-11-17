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
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.llorllale.youtrack.api.Issue;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
public class Filtered implements StreamOfIssues {
  private final Predicate<Issue> filter;
  private final StreamOfIssues stream;

  /**
   * 
   * @param filter
   * @param stream 
   * @since 0.1.0
   */
  public Filtered(Predicate<Issue> filter, StreamOfIssues stream) {
    this.filter = filter;
    this.stream = stream;
  }

  @Override
  public Stream<Issue> stream() throws IOException {
    return this.stream.stream().filter(this.filter);
  }
}
