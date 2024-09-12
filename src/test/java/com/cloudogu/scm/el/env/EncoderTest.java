/*
 * Copyright (c) 2020 - present Cloudogu GmbH
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see https://www.gnu.org/licenses/.
 */

package com.cloudogu.scm.el.env;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EncoderTest {

  @Test
  void shouldEncode() {
    assertThat(Encoder.encode("a/b")).isEqualTo("a%2Fb");
  }

  @Test
  void shouldEncodeList() {
    List<String> values = Encoder.encode(ImmutableList.of("a/b", "a;b"));
    assertThat(values.get(0)).isEqualTo("a%2Fb");
    assertThat(values.get(1)).isEqualTo("a%3Bb");
  }

}
