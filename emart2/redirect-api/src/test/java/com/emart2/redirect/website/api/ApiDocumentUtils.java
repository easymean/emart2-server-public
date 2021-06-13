package com.emart2.redirect.website.api;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public interface ApiDocumentUtils {

  static OperationRequestPreprocessor getDocumentRequest() {
    return preprocessRequest(
        modifyUris()
            .scheme("https")
            .host("docs.api.com")
            .removePort(),
        prettyPrint());
  }

  static OperationRequestPreprocessor getDocumentResponse() {
    return preprocessRequest(prettyPrint());
  }
}
