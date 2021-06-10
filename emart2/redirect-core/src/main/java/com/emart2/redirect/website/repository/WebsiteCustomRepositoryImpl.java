package com.emart2.redirect.website.repository;

import com.emart2.redirect.website.entity.WebsiteEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class WebsiteCustomRepositoryImpl extends QuerydslRepositorySupport implements WebsiteCustomRepository {

  private final JPAQueryFactory queryFactory;
  private final QWebsite qWebsite = QWebsite.website;

  public WebsiteCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
    super(WebsiteEntity.class);
    this.queryFactory = jpaQueryFactory;
  }

  @Override
  public List<WebsiteEntity> findFrequentlyUsedWebsiteList(int count) {
    return queryFactory.selectFrom(qWebsite)
        .orderBy(qWebsite.frequency.desc())
        .limit(count)
        .fetch();
  }

  @Override
  public void increaseFrequency(Long id) {
    update(qWebsite)
        .where(qWebsite.id.eq(id))
        .set(qWebsite.frequency, qWebsite.frequency.add(1))
        .execute();
  }
}
