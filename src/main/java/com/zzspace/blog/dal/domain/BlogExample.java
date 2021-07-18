package com.zzspace.blog.dal.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSummeryIsNull() {
            addCriterion("summery is null");
            return (Criteria) this;
        }

        public Criteria andSummeryIsNotNull() {
            addCriterion("summery is not null");
            return (Criteria) this;
        }

        public Criteria andSummeryEqualTo(String value) {
            addCriterion("summery =", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryNotEqualTo(String value) {
            addCriterion("summery <>", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryGreaterThan(String value) {
            addCriterion("summery >", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryGreaterThanOrEqualTo(String value) {
            addCriterion("summery >=", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryLessThan(String value) {
            addCriterion("summery <", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryLessThanOrEqualTo(String value) {
            addCriterion("summery <=", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryLike(String value) {
            addCriterion("summery like", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryNotLike(String value) {
            addCriterion("summery not like", value, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryIn(List<String> values) {
            addCriterion("summery in", values, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryNotIn(List<String> values) {
            addCriterion("summery not in", values, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryBetween(String value1, String value2) {
            addCriterion("summery between", value1, value2, "summery");
            return (Criteria) this;
        }

        public Criteria andSummeryNotBetween(String value1, String value2) {
            addCriterion("summery not between", value1, value2, "summery");
            return (Criteria) this;
        }

        public Criteria andFirstPictureIsNull() {
            addCriterion("first_picture is null");
            return (Criteria) this;
        }

        public Criteria andFirstPictureIsNotNull() {
            addCriterion("first_picture is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPictureEqualTo(String value) {
            addCriterion("first_picture =", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureNotEqualTo(String value) {
            addCriterion("first_picture <>", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureGreaterThan(String value) {
            addCriterion("first_picture >", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureGreaterThanOrEqualTo(String value) {
            addCriterion("first_picture >=", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureLessThan(String value) {
            addCriterion("first_picture <", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureLessThanOrEqualTo(String value) {
            addCriterion("first_picture <=", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureLike(String value) {
            addCriterion("first_picture like", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureNotLike(String value) {
            addCriterion("first_picture not like", value, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureIn(List<String> values) {
            addCriterion("first_picture in", values, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureNotIn(List<String> values) {
            addCriterion("first_picture not in", values, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureBetween(String value1, String value2) {
            addCriterion("first_picture between", value1, value2, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFirstPictureNotBetween(String value1, String value2) {
            addCriterion("first_picture not between", value1, value2, "firstPicture");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andViewIsNull() {
            addCriterion("`view` is null");
            return (Criteria) this;
        }

        public Criteria andViewIsNotNull() {
            addCriterion("`view` is not null");
            return (Criteria) this;
        }

        public Criteria andViewEqualTo(Integer value) {
            addCriterion("`view` =", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewNotEqualTo(Integer value) {
            addCriterion("`view` <>", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewGreaterThan(Integer value) {
            addCriterion("`view` >", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("`view` >=", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewLessThan(Integer value) {
            addCriterion("`view` <", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewLessThanOrEqualTo(Integer value) {
            addCriterion("`view` <=", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewIn(List<Integer> values) {
            addCriterion("`view` in", values, "view");
            return (Criteria) this;
        }

        public Criteria andViewNotIn(List<Integer> values) {
            addCriterion("`view` not in", values, "view");
            return (Criteria) this;
        }

        public Criteria andViewBetween(Integer value1, Integer value2) {
            addCriterion("`view` between", value1, value2, "view");
            return (Criteria) this;
        }

        public Criteria andViewNotBetween(Integer value1, Integer value2) {
            addCriterion("`view` not between", value1, value2, "view");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnIsNull() {
            addCriterion("appreciation_on is null");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnIsNotNull() {
            addCriterion("appreciation_on is not null");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnEqualTo(Boolean value) {
            addCriterion("appreciation_on =", value, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnNotEqualTo(Boolean value) {
            addCriterion("appreciation_on <>", value, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnGreaterThan(Boolean value) {
            addCriterion("appreciation_on >", value, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("appreciation_on >=", value, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnLessThan(Boolean value) {
            addCriterion("appreciation_on <", value, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnLessThanOrEqualTo(Boolean value) {
            addCriterion("appreciation_on <=", value, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnIn(List<Boolean> values) {
            addCriterion("appreciation_on in", values, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnNotIn(List<Boolean> values) {
            addCriterion("appreciation_on not in", values, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnBetween(Boolean value1, Boolean value2) {
            addCriterion("appreciation_on between", value1, value2, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andAppreciationOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("appreciation_on not between", value1, value2, "appreciationOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnIsNull() {
            addCriterion("copyright_on is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnIsNotNull() {
            addCriterion("copyright_on is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnEqualTo(Boolean value) {
            addCriterion("copyright_on =", value, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnNotEqualTo(Boolean value) {
            addCriterion("copyright_on <>", value, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnGreaterThan(Boolean value) {
            addCriterion("copyright_on >", value, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("copyright_on >=", value, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnLessThan(Boolean value) {
            addCriterion("copyright_on <", value, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnLessThanOrEqualTo(Boolean value) {
            addCriterion("copyright_on <=", value, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnIn(List<Boolean> values) {
            addCriterion("copyright_on in", values, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnNotIn(List<Boolean> values) {
            addCriterion("copyright_on not in", values, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnBetween(Boolean value1, Boolean value2) {
            addCriterion("copyright_on between", value1, value2, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andCopyrightOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("copyright_on not between", value1, value2, "copyrightOn");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Boolean value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Boolean value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Boolean value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Boolean value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Boolean> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Boolean> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andCommentOnIsNull() {
            addCriterion("comment_on is null");
            return (Criteria) this;
        }

        public Criteria andCommentOnIsNotNull() {
            addCriterion("comment_on is not null");
            return (Criteria) this;
        }

        public Criteria andCommentOnEqualTo(Boolean value) {
            addCriterion("comment_on =", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotEqualTo(Boolean value) {
            addCriterion("comment_on <>", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnGreaterThan(Boolean value) {
            addCriterion("comment_on >", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("comment_on >=", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnLessThan(Boolean value) {
            addCriterion("comment_on <", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnLessThanOrEqualTo(Boolean value) {
            addCriterion("comment_on <=", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnIn(List<Boolean> values) {
            addCriterion("comment_on in", values, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotIn(List<Boolean> values) {
            addCriterion("comment_on not in", values, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnBetween(Boolean value1, Boolean value2) {
            addCriterion("comment_on between", value1, value2, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("comment_on not between", value1, value2, "commentOn");
            return (Criteria) this;
        }

        public Criteria andRealeasedIsNull() {
            addCriterion("realeased is null");
            return (Criteria) this;
        }

        public Criteria andRealeasedIsNotNull() {
            addCriterion("realeased is not null");
            return (Criteria) this;
        }

        public Criteria andRealeasedEqualTo(Boolean value) {
            addCriterion("realeased =", value, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedNotEqualTo(Boolean value) {
            addCriterion("realeased <>", value, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedGreaterThan(Boolean value) {
            addCriterion("realeased >", value, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("realeased >=", value, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedLessThan(Boolean value) {
            addCriterion("realeased <", value, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedLessThanOrEqualTo(Boolean value) {
            addCriterion("realeased <=", value, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedIn(List<Boolean> values) {
            addCriterion("realeased in", values, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedNotIn(List<Boolean> values) {
            addCriterion("realeased not in", values, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedBetween(Boolean value1, Boolean value2) {
            addCriterion("realeased between", value1, value2, "realeased");
            return (Criteria) this;
        }

        public Criteria andRealeasedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("realeased not between", value1, value2, "realeased");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andCustomCriterion(String criteria) {
            addCriterion(criteria);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}