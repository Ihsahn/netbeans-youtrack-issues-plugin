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
import java.util.Optional;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.User;
import org.llorllale.youtrack.api.UsersOfIssue;
import org.llorllale.youtrack.api.session.UnauthorizedException;

/**
 * Mock impl of {@link UsersOfIssue} suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class MockUsersOfIssue implements UsersOfIssue {
  private Issue issue;
  private User creator;
  private User updater;
  private User assignee;

  /**
   * Ctor
   * 
   * @param issue the parent issue
   * @since 0.2.0
   */
  public MockUsersOfIssue(Issue issue) {
    this.issue = issue;
  }

  /**
   * Sets this issue's creator.
   * 
   * @param creator the issue's creator
   * @return this object
   * @since 0.2.0
   */
  public MockUsersOfIssue withCreator(User creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Set's this issue's updater.
   * 
   * @param updater the updater
   * @return this object
   * @since 0.2.0
   */
  public MockUsersOfIssue withUpdater(User updater) {
    this.updater = updater;
    return this;
  }

  /**
   * Sets this issue's assignee.
   * 
   * @param assignee the assignee
   * @return this object
   * @since 0.2.0
   */
  public MockUsersOfIssue withAssignee(User assignee) {
    this.assignee = assignee;
    return this;
  }

  @Override
  public User creator() throws IOException, UnauthorizedException {
    return this.creator;
  }

  @Override
  public Optional<User> updater() throws IOException, UnauthorizedException {
    return Optional.ofNullable(this.updater);
  }

  @Override
  public Optional<User> assignee() throws IOException, UnauthorizedException {
    return Optional.ofNullable(this.assignee);
  }

  @Override
  public UsersOfIssue assignTo(User user) throws IOException, UnauthorizedException {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public Issue issue() {
    return this.issue;
  }
}
