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

import com.cloudogu.scm.el.ElParser;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JexlModuleTest {

  @Test
  void shouldBindJexlParser() {
    Injector injector = Guice.createInjector(new JexlModule());
    ElParser parser = injector.getInstance(ElParser.class);
    assertThat(parser).isInstanceOf(JexlParser.class);
  }

}
