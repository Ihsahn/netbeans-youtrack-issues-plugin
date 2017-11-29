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

import org.llorllale.youtrack.api.User;

/**
 * Mock impl of {@link User} suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class MockUser implements User {
  private String name;
  private String email;
  private String loginName;

  /**
   * Ctor.
   * 
   * @since 0.2.0
   */
  public MockUser() {

  }

  /**
   * Sets this user's name.
   * 
   * @param name the user's name
   * @return this object
   * @since 0.2.0
   */
  public MockUser withName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Sets this user's email.
   * 
   * @param email this user's email
   * @return this object
   * @since 0.2.0
   */
  public MockUser withEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Sets this user's login.
   * 
   * @param loginName this user's login
   * @return this object
   * @since 0.2.0
   */
  public MockUser withLoginName(String loginName) {
    this.loginName = loginName;
    return this;
  }

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public String email() {
    return this.email;
  }

  @Override
  public String loginName() {
    return this.loginName;
  }
}
