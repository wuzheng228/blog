package com.zzspace.blog.service;

import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.dal.domain.TagDO;
import com.zzspace.blog.dal.repository.BlogTagRepository;
import com.zzspace.blog.model.dto.TagDTO;
import com.zzspace.blog.dal.repository.TagRepository;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.query.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/17 22:10
 */
@Service
public class TagService {

    @Resource
    private TagRepository tagRepository;
    @Resource
    private BlogTagRepository blogTagRepository;

    public PageDTO<TagDTO> listTag(Pageable pageable) {
        List<TagDO> tagDOS = tagRepository.listTag(pageable);
        List<TagDTO> tagDTOS = ConvertUtils.convertList(tagDOS, TagDTO.class);
        Long total = tagRepository.countNotDeleted();
        PageDTO<TagDTO> pageDTO = new PageDTO<>(pageable, total);
        pageDTO.setPageData(tagDTOS);
        return pageDTO;
    }

    public Long insertTag(TagDTO tagDTO) {
        TagDO convert = ConvertUtils.convert(tagDTO, TagDO.class);
        Long save = tagRepository.save(convert);
        return save;
    }

    @Transactional
    public Integer updateTagById(TagDTO tagDTO) {
        TagDO convert = ConvertUtils.convert(tagDTO, TagDO.class);
        return tagRepository.updateById(convert);
    }

    @Transactional
    public Integer deleteTagById(Long id) {
        Integer res = blogTagRepository.deleteByTagId(id);
        return tagRepository.deleteTagById(id);
    }

    public TagDTO findTagByName(TagDTO tagDTO) {
        TagDO tagDO = tagRepository.findTypeByName(tagDTO.getName());
        return ConvertUtils.convert(tagDO, TagDTO.class);
    }

}
