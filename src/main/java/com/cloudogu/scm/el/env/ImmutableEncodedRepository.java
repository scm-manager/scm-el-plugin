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

import sonia.scm.repository.Repository;

public final class ImmutableEncodedRepository {

  private final Repository repository;

  public ImmutableEncodedRepository(Repository repository) {
    this.repository = repository;
  }

  public String getContact() {
    return Encoder.encode(repository.getContact());
  }

  public Long getCreationDate() {
    return repository.getCreationDate();
  }

  public String getDescription() {
    return Encoder.encode(repository.getDescription());
  }

  public String getId() {
    return repository.getId();
  }

  public Long getLastModified() {
    return repository.getLastModified();
  }

  public String getName() {
    return repository.getName();
  }

  public String getNamespace() {
    return repository.getNamespace();
  }

  public String getType() {
    return repository.getType();
  }

}
