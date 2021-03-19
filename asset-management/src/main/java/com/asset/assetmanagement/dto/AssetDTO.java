package com.asset.assetmanagement.dto;

import java.util.Date;

public class AssetDTO {

    private String name;
    private Long assetId;
    private Date purchaseDate;
    private String conditionNotes;
    private String category;
    private String assignmentStatus;

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }


    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getConditionNotes() {
        return conditionNotes;
    }

    public void setConditionNotes(String conditionNotes) {
        this.conditionNotes = conditionNotes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public AssetDTO() {
    }

    public AssetDTO(String name, Long assetId, Date purchaseDate, String conditionNotes, String category, String assignmentStatus) {
        this.name = name;
        this.assetId = assetId;
        this.purchaseDate = purchaseDate;
        this.conditionNotes = conditionNotes;
        this.category = category;
        this.assignmentStatus = assignmentStatus;
    }
}
