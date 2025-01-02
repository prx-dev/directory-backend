package com.prx.directory.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * Entity class representing a campaign.
 * This class is mapped to the "campaign" table in the "directory_site" schema.
 * It includes a UUID as the primary key and various fields representing campaign details.
 */
@Entity
@Table(name = "campaign", schema = "directory_site")
public class CampaignEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 645006960930514117L;

    /**
     * The unique identifier for the campaign.
     * This field is automatically generated using the UUID generation strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("directory_site.uuid_generate_v4()")
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * The name of the campaign.
     * This field is required and has a maximum length of 120 characters.
     */
    @Size(max = 120)
    @NotNull
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    /**
     * The description of the campaign.
     * This field is optional and has a maximum length of 1200 characters.
     */
    @Size(max = 1200)
    @Column(name = "description", length = 1200)
    private String description;

    /**
     * The start date of the campaign.
     * This field is required.
     */
    @NotNull
    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    /**
     * The end date of the campaign.
     * This field is required.
     */
    @NotNull
    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    /**
     * Indicates whether the campaign is active.
     * This field is required and defaults to true.
     */
    @NotNull
    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    /**
     * The category to which the campaign belongs.
     * This field is required and is a many-to-one relationship with the CategoryEntity.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_fk", nullable = false)
    private CategoryEntity categoryFk;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_fk", nullable = false)
    private BusinessEntity businessFk;

    public BusinessEntity getBusinessFk() {
        return businessFk;
    }

    public void setBusinessFk(BusinessEntity businessFk) {
        this.businessFk = businessFk;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public CampaignEntity() {
        // Default constructor
    }

    /**
     * Gets the unique identifier for the campaign.
     *
     * @return the unique identifier for the campaign
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the campaign.
     *
     * @param id the unique identifier for the campaign
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the name of the campaign.
     *
     * @return the name of the campaign
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the campaign.
     *
     * @param name the name of the campaign
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the campaign.
     *
     * @return the description of the campaign
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the campaign.
     *
     * @param description the description of the campaign
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the start date of the campaign.
     *
     * @return the start date of the campaign
     */
    public Instant getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the campaign.
     *
     * @param startDate the start date of the campaign
     */
    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the campaign.
     *
     * @return the end date of the campaign
     */
    public Instant getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the campaign.
     *
     * @param endDate the end date of the campaign
     */
    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the active status of the campaign.
     *
     * @return the active status of the campaign
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the active status of the campaign.
     *
     * @param active the active status of the campaign
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Gets the category to which the campaign belongs.
     *
     * @return the category to which the campaign belongs
     */
    public CategoryEntity getCategoryFk() {
        return categoryFk;
    }

    /**
     * Sets the category to which the campaign belongs.
     *
     * @param categoryFk the category to which the campaign belongs
     */
    public void setCategoryFk(CategoryEntity categoryFk) {
        this.categoryFk = categoryFk;
    }

}
