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
import java.net.MalformedURLException;
import org.llorllale.netbeans.youtrack.issues.YouTrackFunction;
import org.llorllale.youtrack.api.YouTrack;
import org.llorllale.youtrack.api.session.AuthenticationException;

/**
 * Mock impl of {@link YouTrackFunction} suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class MockYtFunction implements YouTrackFunction {
  private final YouTrack youtrack;

  /**
   * Ctor.
   * 
   * @param youtrack the implementation of {@link YouTrack} to be returned by 
   *     {@link #apply(java.lang.String, java.lang.String)}
   * @since 0.2.0
   */
  public MockYtFunction(YouTrack youtrack) {
    this.youtrack = youtrack;
  }

  @Override
  public YouTrack apply(String url, String token) throws MalformedURLException, AuthenticationException, IOException {
    return this.youtrack;
  }
}
