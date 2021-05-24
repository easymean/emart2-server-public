package com.example.emart2.redirect.repository;

import com.example.emart2.redirect.entity.QWebsite;
import com.example.emart2.redirect.entity.Website;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class WebsiteCustomRepositoryImpl extends QuerydslRepositorySupport implements WebsiteCustomRepository {

  private final JPAQueryFactory queryFactory;
  private final QWebsite qWebsite = QWebsite.website;

  public WebsiteCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
    super(Website.class);
    this.queryFactory = jpaQueryFactory;
  }

  @Override
  public List<Website> findTop3ByFreq() {
    final QWebsite qWebsite = QWebsite.website;
    return from(qWebsite)
        .limit(3)
        .orderBy(qWebsite.frequency.desc())
        .fetch();
  }
}
