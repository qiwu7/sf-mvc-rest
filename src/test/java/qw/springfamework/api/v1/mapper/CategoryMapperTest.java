package qw.springfamework.api.v1.mapper;

import org.junit.Test;
import qw.springfamework.api.v1.model.CategoryDTO;
import qw.springfamework.domain.Category;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        //given
        String NAME = "Joe";
        Long ID = 1L;
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);
        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        //then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}