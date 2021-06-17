package com.emart2.redirect.common;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public interface ApiDocumentUtils {

  static OperationRequestPreprocessor getDocumentRequest() {
    return preprocessRequest(
        modifyUris()
            .scheme("http")
            .host("localhost:8080")
            .removePort(),
        prettyPrint());
  }

  static OperationRequestPreprocessor getDocumentResponse() {
    return preprocessRequest(prettyPrint());
  }
}
