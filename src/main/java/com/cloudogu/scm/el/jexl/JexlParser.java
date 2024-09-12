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
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.UnifiedJEXL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JexlParser implements ElParser {

  private static final Logger LOG = LoggerFactory.getLogger(JexlParser.class);

  private final UnifiedJEXL uel = new UnifiedJEXL(new JexlEngine());

  @Override
  public JexlExpression parse(String urlPattern) {
    LOG.trace("try to parse url pattern: {}", urlPattern);
    return new JexlExpression(uel.parse(urlPattern));
  }
}
