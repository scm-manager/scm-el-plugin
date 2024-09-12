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

package com.cloudogu.scm.el.jexl;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import sonia.scm.repository.Changeset;
import sonia.scm.repository.Person;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JexlParserTest {

  private final JexlParser parser = new JexlParser();

  @Test
  void shouldParseSimpleExpression() {
    JexlExpression expression = parser.parse("Hello ${name}!");
    String evaluated = expression.evaluate(ImmutableMap.of("name", "Slarti"));
    assertThat(evaluated).isEqualTo("Hello Slarti!");
  }

  @Test
  void shouldParseWithoutExpression() {
    Map<String, Object> env = createChangesetEnv();

    String parsedUrl = parser.parse("http://hitchhiker.org").evaluate(env);
    assertThat(parsedUrl).isEqualTo("http://hitchhiker.org");
  }

  @Test
  void shouldParseExpression() {
    Map<String, Object> env = createChangesetEnv();

    String parsedUrl = parser.parse("http://${changeset.author.name}.org").evaluate(env);
    assertThat(parsedUrl).isEqualTo("http://trillian.org");
  }

  private Map<String, Object> createChangesetEnv() {
    Map<String, Object> env = new HashMap<>();
    env.put("changeset", new Changeset("1", 1L, Person.toPerson("trillian")));
    return env;
  }

}
