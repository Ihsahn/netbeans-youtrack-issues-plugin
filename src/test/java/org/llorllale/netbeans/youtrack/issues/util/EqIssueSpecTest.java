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

package org.llorllale.netbeans.youtrack.issues.util;

import org.llorllale.netbeans.youtrack.issues.mock.youtrack.MockField;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.llorllale.youtrack.api.AssignedField;
import org.llorllale.youtrack.api.Issues.IssueSpec;

/**
 * Unit tests for {@link EqIssueSpec}.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class EqIssueSpecTest {
  /**
   * {@link EqIssueSpec#isEqualTo(org.llorllale.youtrack.api.Issues.IssueSpec)} must be TRUE
   * if the two specs are the same.
   * 
   * @since 0.2.0
   */
  @Test
  public void isEqualTo() {
    final AssignedField field1 = new MockField("field1", "value1");
    final AssignedField field2 = new MockField("field2", "value2");
    final AssignedField field3 = new MockField("field3", "value3");

    final IssueSpec first = new IssueSpec("summary", "description")
        .with(field1, field1.value())
        .with(field1, field2.value())
        .with(field3, field3.value());
    final IssueSpec second = new IssueSpec("summary", "description")
        .with(field1, field1.value())
        .with(field1, field2.value())
        .with(field3, field3.value());

    assertThat(new EqIssueSpec(first).isEqualTo(second)).isTrue();
  }

  /**
   * {@link EqIssueSpec#isEqualTo(org.llorllale.youtrack.api.Issues.IssueSpec)} must be FALSE
   * if the two specs are NOT the same.
   * 
   * @since 0.2.0
   */
  @Test
  public void isNotEqualTo() {
    final AssignedField field1 = new MockField("field1", "value1");
    final AssignedField field2 = new MockField("field2", "value2");
    final AssignedField field3 = new MockField("field3", "value3");

    final IssueSpec first = new IssueSpec("summary", "description")
        .with(field1, field1.value())
        .with(field1, field2.value())
        .with(field3, field3.value());
    final AssignedField field4 = new MockField("field4", "value4");
    final IssueSpec second = new IssueSpec("summary", "description")
        .with(field1, field1.value())
        .with(field1, field2.value())
        .with(field4, field4.value());

    assertThat(new EqIssueSpec(first).isEqualTo(second)).isFalse();
  }
}
