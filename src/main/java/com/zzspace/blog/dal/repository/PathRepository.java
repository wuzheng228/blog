package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.PathDO;
import com.zzspace.blog.dal.domain.PathExample;
import com.zzspace.blog.dal.mapper.PathMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 76973 on 2021/7/3 12:43
 */
@Repository
public class PathRepository extends BaseRepository<PathDO> {

    @Resource
    private PathMapper pathMapper;

    public PathDO findPathByParentId(Long id) {
        PathExample pathExample = new PathExample();
        pathExample.createCriteria().andParentIdEqualTo(id);
        return fetchOne(pathMapper.selectByExample(pathExample));
    }

    public void updateByParentId(PathDO pathDO) {
        PathExample example = new PathExample();
        example.createCriteria().andParentIdEqualTo(pathDO.getParentId());
        pathMapper.updateByExampleSelective(pathDO,example);
    }

    public void deleteByParentId(Long parentId) {
        PathExample example = new PathExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        pathMapper.deleteByExample(example);
    }
}
