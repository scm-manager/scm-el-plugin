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

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * The encoder is responsible for url safe string encoding.
 */
public final class Encoder {

  private static final String ENCODING = "UTF-8";
  private static final Logger logger = LoggerFactory.getLogger(Encoder.class);

  private Encoder() {
  }

  /**
   * Encodes the given string url safe.
   * @param value string to encode
   * @return encoded string
   */
  public static String encode(String value) {
    if (value != null) {
      try {
        value = URLEncoder.encode(value, ENCODING);
      } catch (UnsupportedEncodingException ex) {
        logger.error("encoding is not supported", ex);
      }
    }
    return value;
  }

  /**
   * Encodes a list of strings url safe.
   * @param values list strings
   * @return encoded list
   */
  public static List<String> encode(List<String> values) {
    return Lists.transform(values, Encoder::encode);
  }
}
