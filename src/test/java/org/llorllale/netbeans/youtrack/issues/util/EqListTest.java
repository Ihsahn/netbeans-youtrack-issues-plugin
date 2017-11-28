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

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * Unit tests for {@link EqList}.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class EqListTest {
  /**
   * {@link EqList#isEqualTo(java.util.List)} must be TRUE for two matching lists where the 
   * items are in the same order.
   * 
   * @since 0.2.0
   */
  @Test
  public void sameOrder() {
    final List<String> first = Arrays.asList("a", "b", "c", "d", "e");
    final List<String> second = Arrays.asList("a", "b", "c", "d", "e");

    assertThat(new EqList<>(first).isEqualTo(second)).isTrue();
  }

  /**
   * {@link EqList#isEqualTo(java.util.List)} must be TRUE for two matching lists where the 
   * items are NOT in the same order.
   * 
   * @since 0.2.0
   */
  @Test
  public void diffOrder() {
    final List<String> first = Arrays.asList("b", "a", "d", "c", "e");
    final List<String> second = Arrays.asList("a", "b", "c", "d", "e");

    assertThat(new EqList<>(first).isEqualTo(second)).isTrue();
  }

  /**
   * {@link EqList#isEqualTo(java.util.List)} must be FALSE for two lists of different length, 
   * even if they contain the same members.
   * 
   * @since 0.2.0
   */
  @Test
  public void lengthMismatch() {
    final List<String> first = Arrays.asList("b", "a", "d", "c", "e", "e");
    final List<String> second = Arrays.asList("a", "b", "c", "d", "e");

    assertThat(new EqList<>(first).isEqualTo(second)).isFalse();
  }
}
