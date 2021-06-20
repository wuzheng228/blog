package com.zzspace.blog.service;

import com.zzspace.blog.common.strategy.Sorter;
import com.zzspace.blog.common.strategy.impl.Sorters;
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
import java.util.stream.Collectors;

/**
 * Created by 76973 on 2021/6/17 22:10
 */
@Service
public class TagService {

    @Resource
    private TagRepository tagRepository;
    @Resource
    private BlogTagRepository blogTagRepository;

    /**
     * 分页查询标签
     */
    public PageDTO<TagDTO> listTag(Pageable pageable) {
        List<TagDO> tagDOS = tagRepository.listTag(pageable);
        List<TagDTO> tagDTOS = ConvertUtils.convertList(tagDOS, TagDTO.class);
        Long total = tagRepository.countNotDeleted();
        PageDTO<TagDTO> pageDTO = new PageDTO<>(pageable, total);
        pageDTO.setPageData(tagDTOS);
        return pageDTO;
    }

    /**
     * 查询存在的标签
     */
    public List<TagDTO> listTag() {
        List<TagDO> tagDOS = tagRepository.listTag();
        return ConvertUtils.convertList(tagDOS, TagDTO.class);
    }

    /**
     * 插入一个标签
     */
    public Long insertTag(TagDTO tagDTO) {
        TagDO convert = ConvertUtils.convert(tagDTO, TagDO.class);
        Long save = tagRepository.save(convert);
        return save;
    }

    /**
     * 根据Id更新标签
     */
    @Transactional
    public Integer updateTagById(TagDTO tagDTO) {
        TagDO convert = ConvertUtils.convert(tagDTO, TagDO.class);
        return tagRepository.updateById(convert);
    }

    /**
     * 根据Id删除标签
     */
    @Transactional
    public Integer deleteTagById(Long id) {
        blogTagRepository.deleteByTagId(id);
        return tagRepository.deleteTagById(id);
    }

    /**
     * 根据标签名查询标签
     */
    public TagDTO findTagByName(TagDTO tagDTO) {
        TagDO tagDO = tagRepository.findTypeByName(tagDTO.getName());
        return ConvertUtils.convert(tagDO, TagDTO.class);
    }

    /**
     * 返回前k个标签
     */
    public List<TagDTO> findTopKTags(Integer topk) {
        List<TagDO> tagDOS = tagRepository.listTag();
        List<TagDTO> tagDTOS = ConvertUtils.convertList(tagDOS, TagDTO.class);
        List<TagDTO> res = tagDTOS.stream().peek(o -> {
            Long total = blogTagRepository.coutByTagId(o.getId());
            o.setTotal(total);
        }).collect(Collectors.toList());
        if (topk != null) {
            return Sorters.TOPK_PRIORITI_QUEUE.topK(res, topk, Sorter.DESC);
        }
        return res;
    }
}
