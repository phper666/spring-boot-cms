/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.phper666.schemaregistry.rest.exception;

public class SchemaValidateException extends Exception {

  private final int status;
  private final int errCode;
  private final String errMsg;

  public SchemaValidateException(final String message, final int errCode, final int status) {
    super(message + "; error code: " + errCode);
    this.status = status;
    this.errMsg = message;
    this.errCode = errCode;
  }

  public int getStatus() {
    return status;
  }

  public int getErrCode() {
    return errCode;
  }

  public String getErrMsg() { return errMsg; }
}