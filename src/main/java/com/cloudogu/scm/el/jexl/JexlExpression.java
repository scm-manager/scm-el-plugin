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

import org.apache.commons.jexl2.MapContext;
import org.apache.commons.jexl2.UnifiedJEXL.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sonia.scm.util.Util;

import java.util.Map;

public class JexlExpression implements com.cloudogu.scm.el.Expression {

  private static final Logger LOG = LoggerFactory.getLogger(JexlExpression.class);

  private final Expression expression;

  JexlExpression(Expression expression) {
    this.expression = expression;
  }

  @Override
  public String evaluate(Map<String, Object> environment) {
    String content = Util.EMPTY_STRING;
    Object result = expression.evaluate(new MapContext(environment));

    if (result != null) {
      content = result.toString();
    }

    LOG.trace("result of expression evaluation: {}", content);

    return content;
  }
}
