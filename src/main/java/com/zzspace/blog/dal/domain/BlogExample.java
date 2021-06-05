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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andIsAppreciationOnIsNull() {
            addCriterion("is_appreciation_on is null");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnIsNotNull() {
            addCriterion("is_appreciation_on is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnEqualTo(Boolean value) {
            addCriterion("is_appreciation_on =", value, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnNotEqualTo(Boolean value) {
            addCriterion("is_appreciation_on <>", value, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnGreaterThan(Boolean value) {
            addCriterion("is_appreciation_on >", value, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_appreciation_on >=", value, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnLessThan(Boolean value) {
            addCriterion("is_appreciation_on <", value, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnLessThanOrEqualTo(Boolean value) {
            addCriterion("is_appreciation_on <=", value, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnIn(List<Boolean> values) {
            addCriterion("is_appreciation_on in", values, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnNotIn(List<Boolean> values) {
            addCriterion("is_appreciation_on not in", values, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnBetween(Boolean value1, Boolean value2) {
            addCriterion("is_appreciation_on between", value1, value2, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsAppreciationOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_appreciation_on not between", value1, value2, "isAppreciationOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnIsNull() {
            addCriterion("is_copyright_on is null");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnIsNotNull() {
            addCriterion("is_copyright_on is not null");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnEqualTo(Boolean value) {
            addCriterion("is_copyright_on =", value, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnNotEqualTo(Boolean value) {
            addCriterion("is_copyright_on <>", value, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnGreaterThan(Boolean value) {
            addCriterion("is_copyright_on >", value, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_copyright_on >=", value, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnLessThan(Boolean value) {
            addCriterion("is_copyright_on <", value, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnLessThanOrEqualTo(Boolean value) {
            addCriterion("is_copyright_on <=", value, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnIn(List<Boolean> values) {
            addCriterion("is_copyright_on in", values, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnNotIn(List<Boolean> values) {
            addCriterion("is_copyright_on not in", values, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnBetween(Boolean value1, Boolean value2) {
            addCriterion("is_copyright_on between", value1, value2, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCopyrightOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_copyright_on not between", value1, value2, "isCopyrightOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnIsNull() {
            addCriterion("is_comment_on is null");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnIsNotNull() {
            addCriterion("is_comment_on is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnEqualTo(Boolean value) {
            addCriterion("is_comment_on =", value, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnNotEqualTo(Boolean value) {
            addCriterion("is_comment_on <>", value, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnGreaterThan(Boolean value) {
            addCriterion("is_comment_on >", value, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_comment_on >=", value, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnLessThan(Boolean value) {
            addCriterion("is_comment_on <", value, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnLessThanOrEqualTo(Boolean value) {
            addCriterion("is_comment_on <=", value, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnIn(List<Boolean> values) {
            addCriterion("is_comment_on in", values, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnNotIn(List<Boolean> values) {
            addCriterion("is_comment_on not in", values, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnBetween(Boolean value1, Boolean value2) {
            addCriterion("is_comment_on between", value1, value2, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsCommentOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_comment_on not between", value1, value2, "isCommentOn");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedIsNull() {
            addCriterion("is_realeased is null");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedIsNotNull() {
            addCriterion("is_realeased is not null");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedEqualTo(Boolean value) {
            addCriterion("is_realeased =", value, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedNotEqualTo(Boolean value) {
            addCriterion("is_realeased <>", value, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedGreaterThan(Boolean value) {
            addCriterion("is_realeased >", value, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_realeased >=", value, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedLessThan(Boolean value) {
            addCriterion("is_realeased <", value, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_realeased <=", value, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedIn(List<Boolean> values) {
            addCriterion("is_realeased in", values, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedNotIn(List<Boolean> values) {
            addCriterion("is_realeased not in", values, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_realeased between", value1, value2, "isRealeased");
            return (Criteria) this;
        }

        public Criteria andIsRealeasedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_realeased not between", value1, value2, "isRealeased");
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