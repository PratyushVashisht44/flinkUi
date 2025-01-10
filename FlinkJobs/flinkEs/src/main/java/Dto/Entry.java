
package Dto;

import java.util.Date;


public class Entry {
    private String _id;
    private int priorityWarehouse;
    private String productVariantId;
    private int destinationPincode;
    private int count;
    private int warehouseCode;
    private String status;
    private String createDt;
    private String updateDt;
    private Date createdAt;
    private Date updatedAt;

    public String get_id() {
        return _id;
    }

    public int getPriorityWarehouse() {
        return priorityWarehouse;
    }

    public String getProductVariantId() {
        return productVariantId;
    }

    public int getDestinationPincode() {
        return destinationPincode;
    }

    public int getCount() {
        return count;
    }

    public int getWarehouseCode() {
        return warehouseCode;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateDt() {
        return createDt;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }



    public void set_id(String _id) {
        this._id = _id;
    }

    public void setPriorityWarehouse(int priorityWarehouse) {
        this.priorityWarehouse = priorityWarehouse;
    }

    public void setProductVariantId(String productVariantId) {
        this.productVariantId = productVariantId;
    }

    public void setDestinationPincode(int destinationPincode) {
        this.destinationPincode = destinationPincode;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWarehouseCode(int warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return "ProductVariantDTO{" +
                "id='" + _id + '\'' +
                ", priorityWarehouse=" + priorityWarehouse +
                ", productVariantId='" + productVariantId + '\'' +
                ", destinationPincode=" + destinationPincode +
                ", count=" + count +
                ", warehouseCode=" + warehouseCode +
                ", status='" + status + '\'' +
                ", createDt='" + createDt + '\'' +
                ", updateDt='" + updateDt + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

