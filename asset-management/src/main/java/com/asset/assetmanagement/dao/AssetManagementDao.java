package com.asset.assetmanagement.dao;

import com.asset.assetmanagement.convertor.AssetManagementConvertor;
import com.asset.assetmanagement.dto.AssetDTO;
import com.asset.assetmanagement.dto.AssignAssetDTO;
import com.asset.assetmanagement.dto.AssignmentStatus;
import com.asset.assetmanagement.dto.CategoryDTO;
import com.asset.assetmanagement.entity.Asset;
import com.asset.assetmanagement.entity.AssetRecord;
import com.asset.assetmanagement.entity.Category;
import com.asset.assetmanagement.repository.AssetRecordRepository;
import com.asset.assetmanagement.repository.AssetRepository;
import com.asset.assetmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssetManagementDao {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetRecordRepository assetRecordRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AssetManagementConvertor assetManagementConvertor;

    public CategoryDTO addCategory(CategoryDTO categoryDTO)
    {
        Category category= new Category();
        if(categoryDTO!=null){
            category=this.assetManagementConvertor.map(categoryDTO);
            category=this.categoryRepository.save(category);
        }

     return this.assetManagementConvertor.map(category);
    }

    public List<CategoryDTO> findAllCategories( )
    {
        List<CategoryDTO> categoryDTOList=null;
        categoryDTOList=new ArrayList<>();
        List<Category> categories= this.categoryRepository.findAll();
        categoryDTOList= this.assetManagementConvertor.mapCategory(categories);
        return categoryDTOList;
    }


    public CategoryDTO updateCategory(CategoryDTO categoryDTO)
    {
        Category category=new Category() ;
        if(categoryDTO!=null)
        {
         category= this.categoryRepository.findByCategoryId(categoryDTO.getCategory_id());
          category.setCategory_id(categoryDTO.getCategory_id());
          category.setDescription(categoryDTO.getDescription());
          category.setName(category.getName());
          this.categoryRepository.save(category);

        }
        return this.assetManagementConvertor.map(category) ;
    }

    public AssetDTO addAsset(AssetDTO assetDTO)
    {
        Asset asset= new Asset();
        if(assetDTO!=null){
            asset=this.assetManagementConvertor.map(assetDTO);
            asset=this.assetRepository.save(asset);
        }

        return this.assetManagementConvertor.map(asset);
    }



    public List<AssetDTO> findAllAsset()
    {
        List<AssetDTO> assetDTOList=null;
        assetDTOList=new ArrayList<>();
        List<Asset> assets= this.assetRepository.findAll();
        assetDTOList= this.assetManagementConvertor.mapAsset(assets);
        return assetDTOList;
    }

    public List<AssetDTO> findAllByName(String name)
    {
        List<AssetDTO> assetDTOList=null;
        assetDTOList=new ArrayList<>();
        List<Asset> assets= this.assetRepository.findAllByName(name);
        assetDTOList= this.assetManagementConvertor.mapAsset(assets);
        return assetDTOList;
    }




    public AssetDTO updateAssets(AssetDTO assetDTO)
    {
        Asset asset=new Asset() ;
        if(assetDTO!=null)
        {
            asset= this.assetRepository.findByName(assetDTO.getName());
            asset.setCategory(assetDTO.getCategory());
            asset.setAssetID(assetDTO.getAssetId());
            asset.setName(asset.getName());
            this.assetRepository.save(asset);

        }
        return this.assetManagementConvertor.map(asset) ;
    }


    public String deleteAsset (Long assetId) {
        if (assetId != null) {
            Asset asset = new Asset();
            asset = this.assetRepository.findByAssetId(assetId);
            if (asset != null) {
                if (!asset.getAssignmentStatus().equalsIgnoreCase(AssignmentStatus.Assigned.toString())) {
                    this.assetRepository.deleteByAssetId(assetId);
                    return "Asset deleted successfully";
                }
                return "Asset is assigned to employee that's why not deleted";
            }
            return "Asset not found";
        }
            return "Asset id is null";
        }



    public String assign(AssignAssetDTO assignAsset)
    {
        Asset asset=new Asset();
        AssetRecord assetRecord=new AssetRecord();
        if(assignAsset!=null)
        {
            asset=this.assetRepository.findByAssetId(assignAsset.getAssetId());
            if(asset.getAssignmentStatus().equalsIgnoreCase(AssignmentStatus.Available.toString()));
            {
                assetRecord.setAssetId(assignAsset.getAssetId());
                assetRecord.setCategoryId(assignAsset.getCategoryId());
                assetRecord.setAssignedStatus(AssignmentStatus.Assigned.toString());
                assetRecord.setEmpId(assignAsset.getEmpId());
                assetRecord=this.assetRecordRepository.save(assetRecord);
            if (assetRecord.getAssignedStatus().equalsIgnoreCase(AssignmentStatus.Assigned.toString()))
                asset.setAssignmentStatus(AssignmentStatus.Assigned.toString());
                asset=this.assetRepository.save(asset);
            }
            return "Asset Assigned Successfully";
        }
        return  " This Asset is not Available";
    }

    public String recover(AssignAssetDTO assignAsset)
    {
        Asset asset=new Asset();
        AssetRecord assetRecord=new AssetRecord();
        if(assignAsset!=null)
        {
            asset=this.assetRepository.findByAssetId(assignAsset.getAssetId());
            if(asset.getAssignmentStatus().equalsIgnoreCase(AssignmentStatus.Assigned.toString()));
            {
                assetRecord=this.assetRecordRepository.findByAssetId(assignAsset.getAssetId());
                assetRecord.setAssignedStatus(AssignmentStatus.Recovered.toString());
                assetRecord=this.assetRecordRepository.save(assetRecord);
                if (assetRecord.getAssignedStatus().equalsIgnoreCase(AssignmentStatus.Recovered.toString()))
                    asset.setAssignmentStatus(AssignmentStatus.Recovered.toString());
                asset=this.assetRepository.save(asset);
            }
            return "Asset Recovered Successfully";
        }
        return  " This Asset is not Assigned to anyone";
    }


}
