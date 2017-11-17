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
import org.llorllale.youtrack.api.session.UnauthorizedException;
import org.netbeans.modules.bugtracking.spi.RepositoryController;
import org.openide.util.HelpCtx;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
public class YtRepositoryController implements RepositoryController {
  private final YtRepoConfigView view;
  /**
   * Mutable supplier of error messages. 
   * Its value is set by {@link #isValid()}.
   */
  private Supplier<String> errorMsg;  

  /**
   * Ctor.
   * 
   * @since 0.1.0
   */
  public YtRepositoryController() {
    this.view = new YtRepoConfigView(this);
    this.errorMsg = () -> "";
  }

  @Override
  public JComponent getComponent() {
    return this.view;
  }

  @Override
  public HelpCtx getHelpCtx() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public boolean isValid() {
    boolean isValid = true;  //return variable

    try {
      final Optional<Project> project = new DefaultYouTrack(
          new PermanentTokenLogin(
              new URL(this.view.apiUrl()), 
              this.view.permToken()
          ).login()
      ).projects().get(this.view.projectId());

      if (!project.isPresent()) {
        this.errorMsg = () -> String.format("Project ID %s does not exist!", this.view.projectId());
        isValid = false;
      }
    } catch(MalformedURLException e) {
      this.errorMsg = () -> String.format("Invalid URL: %s", this.view.apiUrl());
      isValid = false;
    } catch(AuthenticationException | UnauthorizedException e) {
      this.errorMsg = () -> String.format("Invalid token %s", this.view.permToken());
      isValid = false;
    } catch(IOException e) {
      this.errorMsg = () -> String.format("Server is unreachable: %s", e.getMessage());
      isValid = false;
    }

    return isValid;
  }

  @Override
  public void populate() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public String getErrorMessage() {
    return this.errorMsg.get();
  }

  @Override
  public void applyChanges() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void cancelChanges() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void addChangeListener(ChangeListener l) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public void removeChangeListener(ChangeListener l) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }
}
