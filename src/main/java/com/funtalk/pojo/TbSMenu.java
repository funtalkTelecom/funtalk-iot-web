package com.funtalk.pojo;

public class TbSMenu {

    private String menuId;
    private String menuName;
    private String menuType;
    private String menuParent;
    private String menuOrder;
    private String pageLink;
    private String ifValid;

    private String rMenuId;

    public String getrMenuId() { return rMenuId; }

    public void setrMenuId(String rMenuId) { this.rMenuId = rMenuId; }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(String menuParent) {
        this.menuParent = menuParent == null ? null : menuParent.trim();
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder == null ? null : menuOrder.trim();
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink == null ? null : pageLink.trim();
    }

    public String getIfValid() {
        return ifValid;
    }

    public void setIfValid(String ifValid) {
        this.ifValid = ifValid == null ? null : ifValid.trim();
    }
}