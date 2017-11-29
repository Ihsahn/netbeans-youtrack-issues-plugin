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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.llorllale.netbeans.youtrack.issues.mock.MockFrame;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockField;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockIssue;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockUser;
import org.llorllale.netbeans.youtrack.issues.util.EqIssueSpec;
import org.llorllale.youtrack.api.AssignedField;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.Issues.IssueSpec;

/**
 * Unit tests for {@link DefaultIssueDetails}.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class DefaultIssueDetailsTest {
  private FrameFixture window;

  @BeforeClass
  public static void setup() {
    FailOnThreadViolationRepaintManager.install();
  }

  @After
  public void after() {
    this.window.cleanUp();
  }

  /**
   * {@link DefaultIssueDetails#asSpec()} should return a spec describing the issue accurately.
   * 
   * @since 0.2.0
   */
  @Test
  public void asSpec() {
    final Issue issue = this.issue();
    final IssueSpec expected = new IssueSpec(issue.summary(), issue.description().get());
    issue.fields().forEach(f -> expected.with(f, f.value()));
    final IssueSpec result = this.showNewDetails(issue).component().asSpec();

    assertThat(new EqIssueSpec(result).isEqualTo(expected)).isTrue();
  }

  /**
   * The view's ID text box must have the issue's id as text.
   * 
   * @since 0.2.0
   */
  @Test
  public void viewIssueId() {
    final Issue issue = this.issue();
    this.showNewDetails(issue);

    assertThat(this.window.textBox("issueIdTxtBox").text()).isEqualTo(issue.id());
  }

  /**
   * The view's Created On txt box must have the issue's creation date in the format 
   * "YYYY/MM/dd HH:mm:ss".
   * 
   * @since 0.2.0
   */
  @Test
  public void viewCreationDate() {
    final Issue issue = this.issue();
    final String dateStr = DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss")
        .withZone(ZoneId.systemDefault()).format(issue.creationDate());
    this.showNewDetails(issue);

    assertThat(
        this.window.textBox("createdOnTxtBox").text()
    ).isEqualTo(dateStr);
  }

  /**
   * The view's summary text box must have the issue's summary as text.
   * 
   * @since 0.2.0
   */
  @Test
  public void viewSummary() {
    final Issue issue = this.issue();
    this.showNewDetails(issue);

    assertThat(this.window.textBox("summaryTxtBox").text()).isEqualTo(issue.summary());
  }

  /**
   * The view's description text box must have the issue's description as text.
   * 
   * @since 0.2.0
   */
  @Test
  public void viewDescription() {
    final Issue issue = this.issue();
    this.showNewDetails(issue);

    assertThat(
        this.window.textBox("descriptionTxtBox").text()
    ).isEqualTo(issue.description().get());
  }

  /**
   * The view's fields table must reflect the same fields for the issue.
   * 
   * @since 0.2.0
   */
  @Test
  public void viewFields() {
    final Issue issue = this.issue();
    this.showNewDetails(issue);

    this.window.table("fieldsTable").requireContents(this.toFieldsArray(issue));
  }

  private MockFrame<DefaultIssueDetails> showNewDetails(Issue issue) {
    final MockFrame<DefaultIssueDetails> frame = GuiActionRunner.execute(
        () -> new MockFrame<>(new DefaultIssueDetails(issue))
    );
    this.window = new FrameFixture(frame);
    this.window.robot().settings().delayBetweenEvents(0); //speeds up input
    this.window.show();
    return frame;
  }

  private Issue issue() {
    return new MockIssue()
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
  }

  private String[][] toFieldsArray(Issue issue) {
    final String[][] array = new String[issue.fields().size()][2];

    for (int i = 0; i < issue.fields().size(); i++) {
      final AssignedField field = issue.fields().get(i);
      array[i][0] = field.name();
      array[i][1] = field.value().asString();
    }

    return array;
  }
}
