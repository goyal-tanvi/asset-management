package com.asset.assetmanagement.repository;

import com.asset.assetmanagement.entity.AssetRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRecordRepository extends JpaRepository<AssetRecord,Long> {
    AssetRecord findByAssetId(Long assetId);
}
