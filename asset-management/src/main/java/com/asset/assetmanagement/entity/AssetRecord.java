package com.asset.assetmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "assetrecord")
public class AssetRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long assetId;
    private String categoryId;
    private String assignedStatus;
    private String empId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAssignedStatus() {
        return assignedStatus;
    }

    public void setAssignedStatus(String assignedStatus) {
        this.assignedStatus = assignedStatus;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public AssetRecord(Long id, Long assetId, String categoryId, String assignedStatus, String empId) {
        this.id = id;
        this.assetId = assetId;
        this.categoryId = categoryId;
        this.assignedStatus = assignedStatus;
        this.empId = empId;
    }

    public AssetRecord() {
    }
}
