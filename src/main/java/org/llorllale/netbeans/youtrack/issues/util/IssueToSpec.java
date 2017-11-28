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

package org.llorllale.netbeans.youtrack.issues.util;

import java.util.function.Function;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.Issues.IssueSpec;

/**
 * Transforms an {@link Issue} into its {@link IssueSpec spec}.
 * 
 * <p>Note: the issue's ID, is lost during this transformation because it is not part of 
 * {@link IssueSpec} by design.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public final class IssueToSpec implements Function<Issue, IssueSpec> {
  @Override
  public IssueSpec apply(Issue issue) {
    final IssueSpec spec;

    if (issue.description().isPresent()) {
      spec = new IssueSpec(issue.summary(), issue.description().get());
    } else {
      spec = new IssueSpec(issue.summary());
    }

    issue.fields().forEach(field -> spec.with(field, field.value()));
    return spec;
  }
}
