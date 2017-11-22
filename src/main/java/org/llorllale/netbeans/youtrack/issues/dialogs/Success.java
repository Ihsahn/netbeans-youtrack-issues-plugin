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

package org.llorllale.netbeans.youtrack.issues.dialogs;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 * A dialog window with a "success" message.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class Success implements Dialog {
  private final String msg;

  /**
   * Ctor.
   * 
   * @param msg the message to display
   * @since 0.2.0
   */
  public Success(String msg) {
    this.msg = msg;
  }

  @Override
  public void show() {
    DialogDisplayer.getDefault() 
        .notify(
            new NotifyDescriptor.Message(
                this.msg, 
                NotifyDescriptor.INFORMATION_MESSAGE
            )
        );
  }
}
