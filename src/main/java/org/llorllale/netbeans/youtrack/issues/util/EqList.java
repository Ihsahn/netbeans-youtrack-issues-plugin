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

import java.util.List;

/**
 * Tests for equality without consideration of the ordering of the items in the lists.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @param <T> the enclosed list's generic parameter type
 * @since 0.2.0
 */
public final class EqList<T> implements Equality<List<T>> {
  private final List<T> base;

  /**
   * Ctor.
   * 
   * @param base the base list to test against
   * @since 0.2.0
   */
  public EqList(List<T> base) {
    this.base = base;
  }

  @Override
  public boolean isEqualTo(List<T> other) {
    boolean equals = true;
    
    if (this.base.size() != other.size()) {
      equals = false;
    } else {
      for (T item : this.base) {
        if (!other.contains(item)) {
          equals = false;
          break;
        }
      }
    }

    return equals;
  }
}
