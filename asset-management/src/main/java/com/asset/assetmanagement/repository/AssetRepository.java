package com.asset.assetmanagement.repository;

import com.asset.assetmanagement.entity.Asset;
import com.asset.assetmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {
     Asset findByAssetId(Long assetId);
     void deleteByAssetId(Long assetId);
     Asset findByName(String name) ;
     List<Asset> findAllByName(String name);
}
