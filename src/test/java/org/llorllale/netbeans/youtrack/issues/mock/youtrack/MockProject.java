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

import java.util.Optional;
import org.llorllale.youtrack.api.Fields;
import org.llorllale.youtrack.api.Issues;
import org.llorllale.youtrack.api.Project;
import org.llorllale.youtrack.api.TimeTracking;
import org.llorllale.youtrack.api.UsersOfProject;
import org.llorllale.youtrack.api.YouTrack;

/**
 * Mock impl of {@link Project} suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class MockProject implements Project {

  @Override
  public String id() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public String name() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public Optional<String> description() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public Issues issues() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public YouTrack youtrack() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public Fields fields() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public TimeTracking timetracking() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }

  @Override
  public UsersOfProject users() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO
  }
}
