package toolUtil.param;

/**
 * @Description:
 * @author: gwl
 * @date: 2025/1/22 16:32
 */
public class DriverContactParam {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 租户ID
     */
    private Long tenantId;
    /**
     * 司机ID
     */
    private Long driverId;
    /**
     * 联系人名称
     */
    private String name;
    /**
     * 联系人电话
     */
    private String phone;
    /**
     * 联系人通信地址
     */
    private String address;

    /**
     * 更新方式：1.管理后台更新 2.司机端更新
     */
    private Integer updateMode;

    /**
     * 创建者
     */
    private String createUser;
    /**
     * 修改者
     */
    private String modifiedUser;
    /**
     * 创建时间
     */
    private String gmtCreate;
    /**
     * 修改时间
     */
    private String gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(Integer updateMode) {
        this.updateMode = updateMode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }
}
