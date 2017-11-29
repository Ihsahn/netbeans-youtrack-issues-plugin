/*
 * Copyright 2017 George Aristy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.llorllale.netbeans.youtrack.issues.mock.youtrack;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.llorllale.youtrack.api.AssignedField;
import org.llorllale.youtrack.api.Comments;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.IssueTimeTracking;
import org.llorllale.youtrack.api.Project;
import org.llorllale.youtrack.api.UpdateIssue;
import org.llorllale.youtrack.api.User;
import org.llorllale.youtrack.api.UsersOfIssue;
import org.llorllale.youtrack.api.session.UnauthorizedException;

/**
 * Mock impl of {@link Issue} suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class MockIssue implements Issue {
  private String id;
  private Instant creationDate;
  private String summary;
  private String description;
  private final List<AssignedField> fields;
  private final MockUsersOfIssue users;

  /**
   * Ctor.
   * 
   * @since 0.2.0
   */
  public MockIssue() {
    this.fields = new ArrayList<>();
    this.users = new MockUsersOfIssue(this);
  }

  /**
   * Sets this issue's id.
   * 
   * @param id the id
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withId(String id) {
    this.id = id;
    return this;
  }

  /**
   * Sets this issue's creation date.
   * 
   * @param creationDate the creation date
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withCreationDate(Instant creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Sets this issue's summary.
   * 
   * @param summary the summary
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Sets this issue's description.
   * 
   * @param description the description
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * Sets this issue's creator.
   * 
   * @param creator the creator
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withCreator(User creator) {
    this.users.withCreator(creator);
    return this;
  }

  /**
   * Sets this issue's updater.
   * 
   * @param updater the updater
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withUpdater(User updater) {
    this.users.withUpdater(updater);
    return this;
  }

  /**
   * Sets this issue's assignee.
   * 
   * @param assignee the assignee
   * @return this object
   * @since 0.2.0
   */
  public MockIssue withAssignee(User assignee) {
    this.users.withAssignee(assignee);
    return this;
  }

  /**
   * Adds {@code field} to this issue's {@link #fields() assigned fields}.
   * 
   * @param field
   * @return this object
   * @see MockField
   * @since 0.2.0
   */
  public MockIssue with(AssignedField field) {
    this.fields.add(field);
    return this;
  }

  @Override
  public Project project() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String id() {
    return this.id;
  }

  @Override
  public Instant creationDate() {
    return this.creationDate;
  }

  @Override
  public String summary() {
    return this.summary;
  }

  @Override
  public Optional<String> description() {
    return Optional.ofNullable(this.description);
  }

  @Override
  public UsersOfIssue users() {
    return this.users;
  }

  @Override
  public Comments comments() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public IssueTimeTracking timetracking() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public Issue refresh() throws IOException, UnauthorizedException {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public UpdateIssue update() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public List<AssignedField> fields() {
    return Collections.unmodifiableList(this.fields);
  }
}
