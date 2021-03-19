package com.asset.assetmanagement.service;

import com.asset.assetmanagement.dao.AssetManagementDao;
import com.asset.assetmanagement.dto.AssetDTO;
import com.asset.assetmanagement.dto.AssignAssetDTO;
import com.asset.assetmanagement.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AssetManagementService {

    @Autowired
    private AssetManagementDao assetManagementDao;


    public CategoryDTO addCategory(CategoryDTO categoryDTO)
    {

        return assetManagementDao.addCategory(categoryDTO);
    }


    public List<CategoryDTO> findAll()
    {
        return assetManagementDao.findAllCategories();
    }


    public CategoryDTO modify(CategoryDTO categoryDTO)
    {

        return assetManagementDao.updateCategory(categoryDTO);
    }


    public AssetDTO saveAsset(AssetDTO assetDTO)
    {
        return assetManagementDao.addAsset(assetDTO);
    }


    public List<AssetDTO> getAll( )
    {
        return assetManagementDao.findAllAsset();
    }

    public List<AssetDTO> getByName(String name)
    {
        return assetManagementDao.findAllByName(name);
    }

    public AssetDTO modifyAsset(AssetDTO assetDTO)
    {
        return assetManagementDao.updateAssets(assetDTO);
    }


    public String delete (Long assetId)
    {
        return assetManagementDao.deleteAsset(assetId);
    }



    public  String assign(AssignAssetDTO assignAssetDTO)
    {
        return  this.assetManagementDao.assign(assignAssetDTO);
    }

    public String recover(AssignAssetDTO assignAsset)
    {
        return this.assetManagementDao.recover(assignAsset);
    }
}
