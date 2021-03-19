package com.asset.assetmanagement.controller;

import com.asset.assetmanagement.dto.AssetDTO;
import com.asset.assetmanagement.dto.AssignAssetDTO;
import com.asset.assetmanagement.dto.CategoryDTO;
import com.asset.assetmanagement.service.AssetManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "AssetManagementController", description="REST API related to asset management")
@RestController
@RequestMapping("/api")
public class AssetManagementController {

   @Autowired
   private AssetManagementService assetManagementService;



   @ApiOperation(value = "save asset category")
   @PostMapping(value = "/saveCategory")
   public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO)
   {
       return assetManagementService.addCategory(categoryDTO);
   }
    @ApiOperation(value = "get all asset category")
    @GetMapping(value = "/getCategory")
    public List<CategoryDTO> getAllCategory()
    {
        return assetManagementService.findAll();
    }
    @ApiOperation(value = "update asset category")
    @PutMapping({"/updateCategory"})
    public CategoryDTO modifyCategory(@RequestBody CategoryDTO categoryDTO)
    {
        return assetManagementService.modify(categoryDTO);
    }


    @ApiOperation(value = "save new asset")
    @PostMapping(value = "/saveAsset")
    public AssetDTO addAsset(@RequestBody AssetDTO assetDTO)
    {
        return assetManagementService.saveAsset(assetDTO);
    }

    @ApiOperation(value = "get all assets")
    @GetMapping(value = "/getAsset")
    public List<AssetDTO> getAllAsset()
    {
        return assetManagementService.getAll();
    }


    @ApiOperation(value = "get  asset by asset name")
    @GetMapping(value = "/find/{name}")
    public List<AssetDTO> getByName(@PathVariable String name)
    {
        return assetManagementService.getByName(name);
    }

    @ApiOperation(value = "update asset details")
    @PutMapping({"/updateAsset"})
    public AssetDTO updateAssets(@RequestBody AssetDTO assetDTO)
    {
        return assetManagementService.modifyAsset(assetDTO);
    }

    @ApiOperation(value = "delete asset by asset id")
    @DeleteMapping(value = "/delete/{assetId}")
    public String deleteAsset (@PathVariable Long assetId)
    {
        return assetManagementService.delete(assetId);
    }

    @ApiOperation(value = "assign asset to employee")
    @PostMapping(value = "/assign")
    public  String assign(AssignAssetDTO assignAssetDTO)
    {
        return this.assetManagementService.assign(assignAssetDTO );
    }

    @ApiOperation(value = "recover asset from employee")
    @PostMapping(value = "/recover")
    public  String recover(AssignAssetDTO assignAssetDTO)
    {
        return this.assetManagementService.recover(assignAssetDTO );
    }

}
