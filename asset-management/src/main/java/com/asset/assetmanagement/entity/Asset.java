package com.asset.assetmanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "asset")
public class Asset {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long assetId;
    private String name;
    private Date purchaseDate;
    private String conditionNotes;
    private String category;
    private String assignmentStatus;

    public Long getAssetID() {
        return assetId;
    }

    public void setAssetID(Long assetID) {
        this.assetId = assetID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public Asset(Long assetId, Long id, String name, Date purchaseDate, String conditionNotes, String category, String assignmentStatus) {
        this.assetId = assetId;
        this.id = id;
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.conditionNotes = conditionNotes;
        this.category = category;
        this.assignmentStatus = assignmentStatus;
    }

    public Asset() {
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetId=" + assetId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", conditionNotes='" + conditionNotes + '\'' +
                ", category='" + category + '\'' +
                ", assignmentStatus='" + assignmentStatus + '\'' +
                '}';
    }
}
