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

import org.llorllale.youtrack.api.YouTrack;
import org.llorllale.youtrack.api.session.AuthenticationException;
import org.llorllale.youtrack.api.session.Login;

/**
 * Transforms a set of "coordinates" into an instance of {@link YouTrack}.
 * 
 * <p>The coordinates themselves can perhaps be later encapsulated behind an interface in 
 * order to accommodate the different authentication strategies.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
@FunctionalInterface
public interface YouTrackFunction {
  /**
   * Transforms a set of "coordinates" into an instance of {@link YouTrack}.
   * 
   * @param url the YouTrack REST API URL
   * @param token the user's permanent token
   * @return an instance of {@link YouTrack} to use to interface with the server
   * @throws MalformedURLException if {@code url} is malformed
   * @throws AuthenticationException if {@code token} is invalid
   * @throws IOException if the server is unreachable
   * @see YouTrack
   * @see Login
   * @since 0.2.0
   */
  YouTrack apply(String url, String token) 
      throws MalformedURLException, AuthenticationException, IOException;
}
