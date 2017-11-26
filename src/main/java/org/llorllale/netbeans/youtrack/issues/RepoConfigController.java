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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.event.ChangeListener;

import org.llorllale.youtrack.api.DefaultYouTrack;
import org.llorllale.youtrack.api.session.AuthenticationException;
import org.llorllale.youtrack.api.session.PermanentTokenLogin;
import org.llorllale.youtrack.api.session.UnauthorizedException;
import org.netbeans.modules.bugtracking.spi.RepositoryController;
import org.openide.util.HelpCtx;

/**
 * MVC controller for the repository configuration.
 * 
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
@SuppressWarnings("checkstyle:methodcount")
public final class RepoConfigController implements RepositoryController {
  private final RepoConfig config;
  private final YouTrackFunction api;

  /**
   * Primary ctor.
   * 
   * @param config repository configuration
   * @param youtrack youtrack function
   * @since 0.2.0
   */
  RepoConfigController(RepoConfig config, YouTrackFunction youtrack) {
    this.config = config;
    this.config.onTestBtn(e -> this.isValid());
    this.api = youtrack;
  }

  /**
   * Ctor.
   * 
   * <p>Uses {@link DefaultRepoConfig} and {@link DefaultYouTrack}.
   * 
   * @since 0.2.0
   */
  public RepoConfigController() {
    this(
        new DefaultRepoConfig(), 
        (url, token) -> new DefaultYouTrack(new PermanentTokenLogin(new URL(url), token).login())
    );
  }

  @Override
  public JComponent getComponent() {
    return this.config.view();
  }

  @Override
  public HelpCtx getHelpCtx() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public boolean isValid() {
    boolean valid = false;

    try {
      valid = this.api.apply(this.config.apiUrl(), this.config.userToken())
          .projects()
          .get(this.config.projectId())
          .isPresent();
    } catch(MalformedURLException e) {
      //@checkstyle todo
    } catch(AuthenticationException e) {
       //@checkstyle todo
    } catch(UnauthorizedException e) {
       //@checkstyle todo
    } catch(IOException e) {
       //@checkstyle todo
    }

    return valid;
  }

  @Override
  public void populate() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public String getErrorMessage() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void applyChanges() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void cancelChanges() {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void addChangeListener(ChangeListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public void removeChangeListener(ChangeListener listener) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }
}
