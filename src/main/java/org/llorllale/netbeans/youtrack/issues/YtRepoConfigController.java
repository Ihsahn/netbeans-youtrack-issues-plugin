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
import java.util.Optional;
import java.util.function.Supplier;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.llorllale.youtrack.api.DefaultYouTrack;
import org.llorllale.youtrack.api.Project;
import org.llorllale.youtrack.api.session.AuthenticationException;
import org.llorllale.youtrack.api.session.PermanentTokenLogin;
import org.netbeans.modules.bugtracking.spi.RepositoryController;
import org.openide.util.HelpCtx;
import org.llorllale.netbeans.youtrack.issues.dialogs.Error;
import org.llorllale.netbeans.youtrack.issues.dialogs.Success;

/**
 * MVC controller for the {@link YtRepoConfigView repo config view}.
 * 
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class YtRepoConfigController implements RepositoryController {
  private final YtRepoConfigView view;
  /**
   * Mutable supplier of error messages. Modified by {@link #testCoordinates()}.
   * 
   * @see #getErrorMessage() 
   */
  private Supplier<String> errorMsg;

  /**
   * Ctor.
   * 
   * @since 0.2.0
   */
  public YtRepoConfigController() {
    this.view = new YtRepoConfigView(this);
  }

  /**
   * Tests the connection to YouTrack using the settings in the {@link YtRepoConfigView view}.
   * 
   * @since 0.2.0
   */
  public void testCoordinates() {
    try {
      final Optional<Project> project = new DefaultYouTrack(
          new PermanentTokenLogin(
              new URL(this.view.apiUrl()),
              this.view.userToken()
          ).login()
      ).projects().get(this.view.projectId());

      if (project.isPresent()) {
        this.errorMsg = () -> "";
        new Success("Success!").show();
      } else {
        this.errorMsg = () -> 
            String.format(
                "Project with ID %s does not exist!", 
                this.view.projectId()
            );
        new Error(this.errorMsg).show();
      }
    } catch(MalformedURLException e) {
      this.errorMsg = () -> "The URL you've entered is invalid.";
      new Error(this.errorMsg).show();
    } catch(AuthenticationException e) {
      this.errorMsg = () -> "The token you've entered is invalid.";
      new Error(this.errorMsg).show();
    } catch(IOException e) {
      this.errorMsg = () -> 
          String.format(
              "Unknown error - perhaps the server is unreachable? The error message is: %s",
              e.getMessage()
          );
      new Error(this.errorMsg).show();
    }
  }

  @Override
  public JComponent getComponent() {
    return this.view;
  }

  @Override
  public HelpCtx getHelpCtx() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public boolean isValid() {
    boolean valid;

    try {
      final Optional<Project> project = new DefaultYouTrack(
          new PermanentTokenLogin(
              new URL(this.view.apiUrl()),
              this.view.userToken()
          ).login()
      ).projects().get(this.view.projectId());

      valid = project.isPresent();

      if (valid) {
        this.errorMsg = () -> "";
        new Success("Success!").show();
      } else {
        this.errorMsg = () -> 
            String.format(
                "Project with ID %s does not exist!", 
                this.view.projectId()
            );
        new Error(this.errorMsg).show();
      }
    } catch(MalformedURLException e) {
      this.errorMsg = () -> "The URL you've entered is invalid.";
      new Error(this.errorMsg).show();
      valid = false;
    } catch(AuthenticationException e) {
      this.errorMsg = () -> "The token you've entered is invalid.";
      new Error(this.errorMsg).show();
      valid = false;
    } catch(IOException e) {
      this.errorMsg = () -> 
          String.format(
              "Unknown error - perhaps the server is unreachable? The error message is: %s",
              e.getMessage()
          );
      new Error(this.errorMsg).show();
      valid = false;
    }

    return valid;
  }

  @Override
  public void populate() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public String getErrorMessage() {
    return this.errorMsg.get();
  }

  @Override
  public void applyChanges() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public void cancelChanges() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public void addChangeListener(ChangeListener l) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public void removeChangeListener(ChangeListener l) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }
}
