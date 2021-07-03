package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.FileDO;
import com.zzspace.blog.dal.domain.FileExample;
import com.zzspace.blog.dal.mapper.FileMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/7/1 21:08
 */
@Repository
public class FileRepository extends BaseRepository<FileDO> {
    @Resource
    private FileMapper fileMapper;

    public List<FileDO> listFileByParentId(Long id) {
        FileExample fileExample = new FileExample();
        fileExample.createCriteria().andParentIdEqualTo(id);
        return fileMapper.selectByExample(fileExample);
    }

    public FileDO findByFileNameAndParentId(String name, Long parentId) {
        FileExample example = new FileExample();
        FileExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        return fetchOne(fileMapper.selectByExample(example));
    }
}
