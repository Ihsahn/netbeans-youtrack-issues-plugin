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

/**
 * Workaround for the fact that some of the types from {@code youtrack-api} don't implement 
 * {@link Object#equals(java.lang.Object)}. Also, checking for {@code null} is not required.
 * 
 * @author George Aristy (george.aristy@gmail.com)
 * @param <T> this equality's type
 * @since 0.2.0
 */
public interface Equality<T> {
  /**
   * Checks for equality between {@code this} and {@code other}.
   * 
   * @param other the other instance of the same type
   * @return {@code true} if {@code this} and {@code other} are "equal", {@code false} otherwise
   * @since 0.2.0
   */
  boolean isEqualTo(T other);
}
