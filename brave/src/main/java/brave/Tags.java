/*
 * Copyright 2013-2020 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package brave;

import brave.propagation.TraceContext;

/**
 * Standard tags used in parsers
 *
 * @since 5.11
 */
public final class Tags {
  /**
   * This tags "error" as the message or simple name of the throwable.
   *
   * @see Span#error(Throwable)
   * @since 5.11
   */
  public static final Tag<Throwable> ERROR = new Tag<Throwable>("error") {
    @Override protected String parseValue(Throwable input, TraceContext context) {
      String message = input.getMessage();
      if (message == null) message = input.getClass().getSimpleName();
      return message;
    }
  };

  Tags() {
  }
}