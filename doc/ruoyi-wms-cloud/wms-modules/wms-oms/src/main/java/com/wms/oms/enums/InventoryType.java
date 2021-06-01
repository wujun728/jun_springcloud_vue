package com.wms.oms.enums;

import com.baomidou.mybatisplus.annotation.IEnum;


/**
 * 库存类型
 */
public enum InventoryType implements IEnum<String> {
    /**
     * 采购入库
     */
    PURCHASE_IN("采购入库", "0"),

    /**
     * 销售出库
     */
    SALE_OUT("销售出库", "1");

    private String name;
    private String value;

    InventoryType(String name, String value) {
        this.name  = name;
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static InventoryType parse(Integer value) {
        for (InventoryType inventoryType : values()) {
            if (inventoryType.getValue().equals(value)) {
                return inventoryType;
            }
        }
        return null;
    }
}
