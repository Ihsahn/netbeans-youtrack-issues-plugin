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

package org.llorllale.netbeans.youtrack.issues.mock;

import java.awt.event.ActionListener;
import javax.swing.JComponent;
import org.llorllale.netbeans.youtrack.issues.RepoConfig;

/**
 * Mock {@link RepoConfig} suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class MockRepoConfig implements RepoConfig {
  private final String apiUrl;
  private final String projectId;
  private final String userToken;

  /**
   * Ctor.
   * 
   * @param apiUrl the server's api url
   * @param projectId the project's id
   * @param userToken the user's token
   * @since 0.2.0
   */
  public MockRepoConfig(String apiUrl, String projectId, String userToken) {
    this.apiUrl = apiUrl;
    this.projectId = projectId;
    this.userToken = userToken;
  }

  @Override
  public String apiUrl() {
    return this.apiUrl;
  }

  @Override
  public String projectId() {
    return this.projectId;
  }

  @Override
  public String userToken() {
    return this.userToken;
  }

  @Override
  public JComponent view() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public RepoConfig onTestBtn(ActionListener listener) {
    return this;
  }
}
