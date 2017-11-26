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

package org.llorllale.netbeans.youtrack.issues;

import java.awt.event.ActionListener;

import javax.swing.JComponent;

import org.netbeans.modules.bugtracking.spi.RepositoryController;

/**
 * Exposes the repository's configuration.
 * 
 * <p>The dialog to configure a YouTrack repository integrates with its controller via this 
 * interface.
 * 
 * <p>Each repository is mapped to one YouTrack project; hence, only issues from a single project
 * will be managed. Therefore, our "repository coordinates" are:
 * 
 * <ul>
 *    <li>The {@link #apiUrl() REST API URL}</li>
 *    <li>The {@link #userToken() user's permanent token}</li>
 *    <li>The {@link #projectId() project's ID}</li>
 * </ul>
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public interface RepoConfig {
  /**
   * The URL for YouTrack's REST API, as entered by the user. 
   * Example: http://youtrack/rest.
   * 
   * @return the URL for YouTrack's REST API
   * @since 0.2.0
   */
  String apiUrl();

  /**
   * The project's ID as entered by the user.
   * 
   * @return the project's ID as entered by the user
   * @since 0.2.0
   */
  String projectId();

  /**
   * The user's permanent token.
   * 
   * @return the user's permanent token
   * @since 0.2.0
   */
  String userToken();

  /**
   * Returns a Swing view of this configuration.
   * 
   * @return a view of this configuration 
   * @see RepositoryController#getComponent() 
   * @since 0.2.0
   */
  JComponent view();

  /**
   * {@code listener} will be notified when the "Test" button is clicked.
   * 
   * @param listener the listener
   * @return this {@link RepoConfig}
   */
  RepoConfig onTestBtn(ActionListener listener);
}
