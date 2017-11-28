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

import org.llorllale.youtrack.api.Issues.IssueSpec;

/**
 * Tests whether the decorated {@link IssueSpec} is 
 * {@link #isEqualTo(org.llorllale.youtrack.api.Issues.IssueSpec) equal} to another 
 * {@link IssueSpec}.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public final class EqIssueSpec implements Equality<IssueSpec> {
  private final IssueSpec spec;

  /**
   * Ctor.
   * 
   * @param spec the base spec to test against
   * @since 0.2.0
   */
  public EqIssueSpec(IssueSpec spec) {
    this.spec = spec;
  }

  @Override
  public boolean isEqualTo(IssueSpec other) {
    return new EqList<>(this.spec.asNameValuePairs()).isEqualTo(other.asNameValuePairs())
        && this.spec.asFields().equals(other.asFields());
  }
}
