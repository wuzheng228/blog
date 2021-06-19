package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.TagDO;
import com.zzspace.blog.dal.domain.TagExample;
import com.zzspace.blog.dal.mapper.TagMapper;
import com.zzspace.blog.model.query.Pageable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/18 12:58
 */
@Repository
public class TagRepository extends BaseRepository<TagDO> {

    @Resource
    private TagMapper tagMapper;

    public List<TagDO> listTag(Pageable pageable) {
        TagExample tagExample = new TagExample();
        tagExample.setLimit(pageable.getLimit());
        tagExample.setOffset(pageable.getOffset());
        return tagMapper.selectByExample(tagExample);
    }

    public Long countNotDeleted() {
        return tagMapper.countByExample(new TagExample());
    }

    public Integer deleteTagById(Long id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

}
