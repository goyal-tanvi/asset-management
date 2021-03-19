package com.asset.assetmanagement.dto;

public class AssignAssetDTO {
    private Long assetId;
    private String categoryId;
    private String empId;



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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public AssignAssetDTO(Long assetId, String categoryId, String empId) {
        this.assetId = assetId;
        this.categoryId = categoryId;
        this.empId = empId;
    }

    public AssignAssetDTO() {
    }
}
