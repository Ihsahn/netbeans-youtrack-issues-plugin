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

package org.llorllale.netbeans.youtrack.issues.mock;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Mock {@link JFrame} that adds a given {@link JComponent} to its {@link #getContentPane() content
 * pane}. Suitable for tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @param <T> the encapsulated component's type
 * @since 0.2.0
 */
public class MockFrame<T extends JComponent> extends JFrame {
  private static final long serialVersionUID = 7672151565142936049L;

  private final T component;

  /**
   * Ctor.
   * 
   * @param component the component to add to the content pane
   * @since 0.2.0
   */
  public MockFrame(T component) {
    super.getContentPane().add(component);
    this.component = component;
  }

  /**
   * The encapsulated component.
   * 
   * @return the encapsulated component
   * @since 0.2.0
   */
  public T component() {
    return this.component;
  }
}
