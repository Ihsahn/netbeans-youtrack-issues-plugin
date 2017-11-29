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

import java.time.Instant;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockField;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockIssue;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockUser;
import org.llorllale.netbeans.youtrack.issues.util.EqIssueSpec;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.Issues.IssueSpec;

/**
 * Unit tests for {@link DefaultIssueDetails}.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class DefaultIssueDetailsTest {
  /**
   * {@link DefaultIssueDetails#asSpec()} should return a spec describing the issue accurately.
   * 
   * @since 0.2.0
   */
  @Test
  public void asSpec() {
    final Issue issue = new MockIssue()
        .withId("TP-123")
        .withCreationDate(Instant.now())
        .withSummary("Summary")
        .withDescription("Description")
        .with(new MockField("State", "Open"))
        .with(new MockField("Assignee", "joe"))
        .withCreator(
            new MockUser()
                .withEmail("creator@test.com")
                .withLoginName("creatorLogin")
                .withName("Creator")
        );
    final IssueSpec expected = new IssueSpec(issue.summary(), issue.description().get());
    issue.fields().forEach(f -> expected.with(f, f.value()));
    final IssueSpec result = new DefaultIssueDetails(issue).asSpec();

    assertThat(new EqIssueSpec(result).isEqualTo(expected)).isTrue();
  }

  /**
   * 
   * @since 0.2.0
   */
  @Test
  public void testAsView() {
  }
}
