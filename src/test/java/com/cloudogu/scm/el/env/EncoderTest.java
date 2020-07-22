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
