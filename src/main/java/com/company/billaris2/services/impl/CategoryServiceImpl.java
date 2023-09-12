package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.CategoryDTO;
import com.company.billaris2.entities.Category;
import com.company.billaris2.mappers.CategoryMapper;
import com.company.billaris2.repositories.CategoryRepository;
import com.company.billaris2.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper  modelMapper;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(CategoryDTO dto) {
//        Category category = Category.builder()
//                .name(dto.getName())
//                .description(dto.getDescription())
//                .build();

        Category category = modelMapper.map(dto, Category.class);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO dto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            modelMapper.map(dto, existingCategory);
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }
}
