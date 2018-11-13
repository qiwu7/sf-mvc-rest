package qw.springfamework.repositories;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import qw.springfamework.api.v1.mapper.CategoryMapper;
import qw.springfamework.api.v1.model.CategoryDTO;
import qw.springfamework.domain.Category;
import qw.springfamework.services.CategoryService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {

    private CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() {
        //given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);
        //when
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();
        //then
        assertEquals(3, categoryDTOS.size());
    }

    @Test
    public void getCategoryByName() {
        //given
        Long ID = 1L;
        String NAME = "name";
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);
        when(categoryRepository.findByName(anyString())).thenReturn(category);
        //when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
        //then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}