package com.damon.product.core.query.handler.category;

import com.damon.product.api.dto.req.category.CreateCategoryReqDTO;
import com.damon.product.api.dto.req.category.QueryCategoryReqDTO;
import com.damon.product.api.dto.req.category.UpdateCategoryReqDTO;
import com.damon.product.api.dto.resp.category.CategoryInfoRespDTO;
import com.damon.product.domain.category.aggregate.CategoryId;
import com.damon.product.domain.category.command.CreateCategoryCommand;
import com.damon.product.domain.category.command.QueryCategoryCommand;
import com.damon.product.domain.category.command.UpdateCategoryCommand;
import com.damon.product.domain.category.entity.CategoryEntry;
import com.damon.shared.enums.YesNoEnum;
import com.querydsl.core.QueryResults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品类别实用工具
 * @author Damon S.
 * @version v1.0.1
 * @date 2019年02月28日 11:27
 */
@Component
public final class CategoryTranslator {


    /**
     * 转换Category对象
     */
    public CategoryInfoRespDTO translateToRespDTO(CategoryEntry categoryEntry) {
        CategoryInfoRespDTO categoryInfoRespDTO = new CategoryInfoRespDTO();
        BeanUtils.copyProperties(categoryEntry, categoryInfoRespDTO);

        // 处理其它未自动赋值的字段
        categoryInfoRespDTO.setNavState(YesNoEnum.nameOf(categoryEntry.getNavState()));
        categoryInfoRespDTO.setShowState(YesNoEnum.nameOf(categoryEntry.getShowState()));
        categoryInfoRespDTO.setCreatedAt(categoryEntry.getCreatedAt().getTime());
        categoryInfoRespDTO.setUpdatedAt(categoryEntry.getUpdatedAt().getTime());

        return categoryInfoRespDTO;
    }


    /**
     * 转换Category对象列表
     */
    public List<CategoryInfoRespDTO> translateToRespDTOs(
            QueryResults<CategoryEntry> entries) {
        return entries.getResults().stream()
                .map(this::translateToRespDTO)
                .collect(Collectors.toList());
    }


    /**
     * 转换为更新命令
     */
    public UpdateCategoryCommand translateFromReqDTO(UpdateCategoryReqDTO reqDTO) {
        Long currentUserId = 10000L;

        return UpdateCategoryCommand.builder()
                .categoryId(new CategoryId(reqDTO.getCategoryId()))
                .name(reqDTO.getName())
                .description(reqDTO.getDescription())
                .icon(reqDTO.getIcon())
                .keywords(reqDTO.getKeywords())
                .level(reqDTO.getLevel())
                .navState(YesNoEnum.parse(reqDTO.getNavState()))
                .showState(YesNoEnum.parse(reqDTO.getShowState()))
                .sort(reqDTO.getSort())
                .spuCount(reqDTO.getSpuCount())
                .spuUnit(reqDTO.getSpuUnit())
                .parentId(reqDTO.getParentId())
                .updatedBy(currentUserId)
                .build();
    }

    /**
     * 转换为查询命命令
     */
    public QueryCategoryCommand translateFromReqDTO(QueryCategoryReqDTO reqDTO) {
        return QueryCategoryCommand.builder()
                .name(reqDTO.getName())
                .keywords(reqDTO.getKeywords())
                .parentId(reqDTO.getParentId())
                .navState(YesNoEnum.parse(reqDTO.getNavState()))
                .showState(YesNoEnum.parse(reqDTO.getShowState()))
                .pageIndex(reqDTO.getPageIndex())
                .pageSize(reqDTO.getPageSize())
                .build();
    }


    /**
     * 转换为创建命令
     */
    public CreateCategoryCommand translateFromReqDTO(CreateCategoryReqDTO reqDTO) {
        Long currentUserId = 10000L;

        return CreateCategoryCommand.builder()
                .categoryId(new CategoryId())
                .name(reqDTO.getName())
                .description(reqDTO.getDescription())
                .icon(reqDTO.getIcon())
                .keywords(reqDTO.getKeywords())
                .level(reqDTO.getLevel())
                .navState(YesNoEnum.parse(reqDTO.getNavState()))
                .showState(YesNoEnum.parse(reqDTO.getShowState()))
                .sort(reqDTO.getSort())
                .spuCount(reqDTO.getSpuCount())
                .spuUnit(reqDTO.getSpuUnit())
                .parentId(reqDTO.getParentId())
                .createdBy(currentUserId)
                .build();
    }
}
