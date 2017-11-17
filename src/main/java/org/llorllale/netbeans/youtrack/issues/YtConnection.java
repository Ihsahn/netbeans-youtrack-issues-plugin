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
 */
package org.llorllale.netbeans.youtrack.issues;

import org.netbeans.modules.bugtracking.api.Repository;
import org.netbeans.modules.bugtracking.spi.BugtrackingConnector;
import org.netbeans.modules.bugtracking.spi.RepositoryInfo;
import org.openide.util.NbBundle;

/**
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.1.0
 */
@BugtrackingConnector.Registration(
    id = "",
    displayName = "#LBL_DisplayName",
    tooltip = "#LBL_Tooltip"
)
@NbBundle.Messages({
    "LBL_DisplayName=YouTrack Issues",
    "LBL_Tooltip=YouTrack Issues"
})
public class YtConnection implements BugtrackingConnector {
  @Override
  public Repository createRepository() {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }

  @Override
  public Repository createRepository(RepositoryInfo info) {
    throw new UnsupportedOperationException("Not supported yet."); //TODO implement
  }
}
