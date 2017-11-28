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

package org.llorllale.netbeans.youtrack.issues.mock.youtrack;

import java.io.IOException;
import java.util.stream.Stream;
import org.llorllale.youtrack.api.AssignedField;
import org.llorllale.youtrack.api.Field;
import org.llorllale.youtrack.api.FieldValue;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.Project;
import org.llorllale.youtrack.api.SelectableFieldValue;
import org.llorllale.youtrack.api.session.UnauthorizedException;

/**
 * Mock impl of {@link AssignedField} suitable for unit tests.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @see MockFieldValue
 * @since 0.2.0
 */
public class MockField implements AssignedField {
  private final String name;
  private final String value;

  /**
   * Ctor.
   * 
   * @param name the field's name
   * @param value the field's value
   * @since 0.2.0
   */
  public MockField(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public Project project() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public boolean equals(Object object) {
    final boolean equals;

    if (!(object instanceof Field)) {
      equals = false;
    } else {
      final Field other = (Field) object;
      equals = this.name().equals(other.name());
    }

    return equals;
  }

  @Override
  public Issue issue() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public FieldValue value() {
    return new MockFieldValue(this, this.value);
  }

  @Override
  public Stream<SelectableFieldValue> change() throws IOException, UnauthorizedException {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
