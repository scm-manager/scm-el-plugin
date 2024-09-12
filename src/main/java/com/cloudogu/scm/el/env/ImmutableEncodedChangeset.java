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

//~--- non-JDK imports --------------------------------------------------------

import sonia.scm.repository.Changeset;

public final class ImmutableEncodedChangeset {

  private final Changeset changeset;

  public ImmutableEncodedChangeset(Changeset changeset) {
    this.changeset = changeset;
  }

  public ImmutableEncodedPerson getAuthor() {
    return new ImmutableEncodedPerson(changeset.getAuthor());
  }

  public EncodedStringList getBranches() {
    return new EncodedStringList(changeset.getBranches());
  }

  public Long getDate() {
    return changeset.getDate();
  }

  public String getDescription() {
    return Encoder.encode(changeset.getDescription());
  }

  public String getId() {
    return changeset.getId();
  }

  public EncodedStringList getParents() {
    return new EncodedStringList(changeset.getParents());
  }

  public EncodedStringList getTags() {
    return new EncodedStringList(changeset.getTags());
  }
}
