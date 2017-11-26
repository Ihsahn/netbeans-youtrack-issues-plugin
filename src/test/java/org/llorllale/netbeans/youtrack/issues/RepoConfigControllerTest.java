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

import java.net.MalformedURLException;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.llorllale.netbeans.youtrack.issues.mock.MockRepoConfig;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.IoError;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockProject;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockProjects;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockYouTrack;
import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockYtFunction;
import org.llorllale.youtrack.api.session.AuthenticationException;
import org.llorllale.youtrack.api.session.UnauthorizedException;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class RepoConfigControllerTest {

  /**
   * {@link RepoConfigController#isValid()} should return false if an invalid URL is provided.
   * 
   * @since 0.2.0
   */
  @Test
  public void isValidIsFalseOnInvalidUrl() {
    final RepoConfigController test = new RepoConfigController(
        new MockRepoConfig("", "", ""), 
        new IoError(new MalformedURLException())
    );
    assertThat(test.isValid()).isFalse();
  }

  /**
   * {@link RepoConfigController#isValid()} should return false if an invalid token is provided.
   * 
   * @since 0.2.0
   */
  @Test
  public void isValidIsFalseOnAuthenticationError() {
    final RepoConfigController test = new RepoConfigController(
        new MockRepoConfig("", "", ""), 
        new IoError(new AuthenticationException("invalid token"))
    );
    assertThat(test.isValid()).isFalse();
  }

  /**
   * {@link RepoConfigController#isValid()} should return false if the token is not authorized
   * to access projects.
   * 
   * @since 0.2.0
   */
  @Test
  public void isValidIsFalseOnAuthorizationError() {
    final RepoConfigController test = new RepoConfigController(
        new MockRepoConfig("", "", ""), 
        new IoError(new UnauthorizedException("invalid token", null))
    );
    assertThat(test.isValid()).isFalse();
  }

  /**
   * {@link RepoConfigController#isValid()} should return false if an invalid project ID is 
   * provided.
   * 
   * @since 0.2.0
   */
  @Test
  public void isValidIsFalseOnProjectNotFound() {
    assertThat(
        new RepoConfigController(
            new MockRepoConfig("", "", ""), 
            new MockYtFunction(new MockYouTrack(new MockProjects()))
        ).isValid()
    ).isFalse();
  }

  /**
   * {@link RepoConfigController#isValid()} should return true when all parameters provided 
   * are correct.
   * 
   * @since 0.2.0
   */
  @Test
  public void isValidisTrueWhenProjectIsFound() {
    assertThat(
        new RepoConfigController(
            new MockRepoConfig("", "", ""), 
            new MockYtFunction(new MockYouTrack(new MockProjects(new MockProject())))
        ).isValid()
    ).isTrue();
  }
}
