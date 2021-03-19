package com.asset.assetmanagement.convertor;

import com.asset.assetmanagement.dto.AssetDTO;
import com.asset.assetmanagement.dto.AssignAssetDTO;
import com.asset.assetmanagement.dto.CategoryDTO;
import com.asset.assetmanagement.entity.Asset;
import com.asset.assetmanagement.entity.AssetRecord;
import com.asset.assetmanagement.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class AssetManagementConvertor {

    private ModelMapper getModelMapper()
    {
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;

    }

    public CategoryDTO map(Category category){
        CategoryDTO categoryDTO=new CategoryDTO();
        this.getModelMapper().map(category,categoryDTO);
        return  categoryDTO;
    }

    public Category map(CategoryDTO categoryDTO){
        Category category=new Category();
        this.getModelMapper().map(categoryDTO,category);
        return  category;

    }

    public List<AssetDTO> mapAsset(List<Asset> assets){
        AssetDTO assetDTO=new AssetDTO();
        List<AssetDTO> assetDTOS= null;
        for(Asset asset :assets)
        {
            assetDTOS=new ArrayList<>();
            assetDTO=this.map(asset);
            assetDTOS.add(assetDTO);
        }
        return assetDTOS;
    }

    public List<CategoryDTO> mapCategory(List<Category> categories){
        CategoryDTO categoryDTO=new CategoryDTO();
        List<CategoryDTO> categoryDTOList= null;
        for(Category category :categories)
        {
            categoryDTOList=new ArrayList<>();
            categoryDTO=this.map(category);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    public Asset map(AssetDTO assetDTO){
        Asset asset=new Asset();
        this.getModelMapper().map(assetDTO,asset);
        return asset;
    }

    public AssetDTO map(Asset asset){
        AssetDTO assetDTO=new AssetDTO();
        this.getModelMapper().map(asset,assetDTO);
        return assetDTO;
    }

    public AssignAssetDTO map(AssetRecord assetRecord){
        AssignAssetDTO assignAssetDTO=new AssignAssetDTO();
        this.getModelMapper().map(assetRecord,assignAssetDTO);
        return  assignAssetDTO;
    }

    public AssetRecord map(AssignAssetDTO assignAssetDTO){
        AssetRecord assetRecord=new AssetRecord();
        this.getModelMapper().map(assignAssetDTO,assetRecord);
        return  assetRecord;

    }

}
