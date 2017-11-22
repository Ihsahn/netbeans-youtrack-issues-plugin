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

import java.util.function.Supplier;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 * An error message dialog window.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class Error implements Dialog {
  private final String msg;

  /**
   * Primary ctor.
   * 
   * @param msg the msg to display
   * @since 0.2.0
   */
  public Error(String msg) {
    this.msg = msg;
  }

  /**
   * Ctor.
   * 
   * <p>Eagerly fetches a message from {@code msg} in order to {@link #show() show} later.
   * 
   * @param msg supplies msg to display
   * @since 0.2.0
   */
  public Error(Supplier<String> msg) {
    this(msg.get());
  }

  @Override
  public void show() {
    DialogDisplayer.getDefault() 
        .notify(
            new NotifyDescriptor.Message(
                this.msg, 
                NotifyDescriptor.ERROR_MESSAGE
            )
        );
  }
}
