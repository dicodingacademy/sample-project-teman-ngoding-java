package com.dicoding.sampletemanngoding.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "id",
        "owner_id",
        "name",
        "summary",
        "description",
        "city_id",
        "address",
        "begin_time",
        "end_time",
        "quota",
        "point",
        "image_path",
        "header_image",
        "status",
        "created_at",
        "updated_at",
        "deleted_at",
        "sponsored",
        "finished",
        "locked",
        "wait_list",
        "listed",
        "category_id",
        "media_cover",
        "category",
        "owner_display_name",
        "owner_name",
        "city_name",
        "registrants",
        "attenders",
        "link"
})

public class Datum {
    @JsonProperty("id")
    private int id;
    @JsonProperty("owner_id")
    private int ownerId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("description")
    private String description;
    @JsonProperty("city_id")
    private int cityId;
    @JsonProperty("address")
    private String address;
    @JsonProperty("begin_time")
    private String beginTime;
    @JsonProperty("end_time")
    private String endTime;
    @JsonProperty("quota")
    private int quota;
    @JsonProperty("point")
    private int point;
    @JsonProperty("image_path")
    private String imagePath;
    @JsonProperty("header_image")
    private String headerImage;
    @JsonProperty("status")
    private String status;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("deleted_at")
    private Object deletedAt;
    @JsonProperty("sponsored")
    private String sponsored;
    @JsonProperty("finished")
    private String finished;
    @JsonProperty("locked")
    private String locked;
    @JsonProperty("wait_list")
    private String waitList;
    @JsonProperty("listed")
    private String listed;
    @JsonProperty("category_id")
    private int categoryId;
    @JsonProperty("media_cover")
    private String mediaCover;
    @JsonProperty("category")
    private String category;
    @JsonProperty("owner_display_name")
    private String ownerDisplayName;
    @JsonProperty("owner_name")
    private String ownerName;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("registrants")
    private int registrants;
    @JsonProperty("attenders")
    private int attenders;
    @JsonProperty("link")
    private String link;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("owner_id")
    public int getOwnerId() {
        return ownerId;
    }

    @JsonProperty("owner_id")
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("city_id")
    public int getCityId() {
        return cityId;
    }

    @JsonProperty("city_id")
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("begin_time")
    public String getBeginTime() {
        return beginTime;
    }

    @JsonProperty("begin_time")
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    @JsonProperty("end_time")
    public String getEndTime() {
        return endTime;
    }

    @JsonProperty("end_time")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("quota")
    public int getQuota() {
        return quota;
    }

    @JsonProperty("quota")
    public void setQuota(int quota) {
        this.quota = quota;
    }

    @JsonProperty("point")
    public int getPoint() {
        return point;
    }

    @JsonProperty("point")
    public void setPoint(int point) {
        this.point = point;
    }

    @JsonProperty("image_path")
    public String getImagePath() {
        return imagePath;
    }

    @JsonProperty("image_path")
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @JsonProperty("header_image")
    public String getHeaderImage() {
        return headerImage;
    }

    @JsonProperty("header_image")
    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("deleted_at")
    public Object getDeletedAt() {
        return deletedAt;
    }

    @JsonProperty("deleted_at")
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    @JsonProperty("sponsored")
    public String getSponsored() {
        return sponsored;
    }

    @JsonProperty("sponsored")
    public void setSponsored(String sponsored) {
        this.sponsored = sponsored;
    }

    @JsonProperty("finished")
    public String getFinished() {
        return finished;
    }

    @JsonProperty("finished")
    public void setFinished(String finished) {
        this.finished = finished;
    }

    @JsonProperty("locked")
    public String getLocked() {
        return locked;
    }

    @JsonProperty("locked")
    public void setLocked(String locked) {
        this.locked = locked;
    }

    @JsonProperty("wait_list")
    public String getWaitList() {
        return waitList;
    }

    @JsonProperty("wait_list")
    public void setWaitList(String waitList) {
        this.waitList = waitList;
    }

    @JsonProperty("listed")
    public String getListed() {
        return listed;
    }

    @JsonProperty("listed")
    public void setListed(String listed) {
        this.listed = listed;
    }

    @JsonProperty("category_id")
    public int getCategoryId() {
        return categoryId;
    }

    @JsonProperty("category_id")
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("media_cover")
    public String getMediaCover() {
        return mediaCover;
    }

    @JsonProperty("media_cover")
    public void setMediaCover(String mediaCover) {
        this.mediaCover = mediaCover;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("owner_display_name")
    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    @JsonProperty("owner_display_name")
    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    @JsonProperty("owner_name")
    public String getOwnerName() {
        return ownerName;
    }

    @JsonProperty("owner_name")
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("registrants")
    public int getRegistrants() {
        return registrants;
    }

    @JsonProperty("registrants")
    public void setRegistrants(int registrants) {
        this.registrants = registrants;
    }

    @JsonProperty("attenders")
    public int getAttenders() {
        return attenders;
    }

    @JsonProperty("attenders")
    public void setAttenders(int attenders) {
        this.attenders = attenders;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }
}
