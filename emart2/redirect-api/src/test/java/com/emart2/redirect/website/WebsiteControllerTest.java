package com.emart2.redirect.website;

import com.emart2.redirect.common.RestDocsConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.Import;

@AutoConfigureRestDocs
@Import({RestDocsConfiguration.class})
public class WebsiteControllerTest {
}
