package com.wms.oms.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum InventoryStatus implements IEnum<String> {
    /**
     * 未确认
     */
    NOT_CONFIRM("未确认", "0"),

    /**
     * 确认入库
     */
    CONFIRM_IN("确认入库", "1"),

    /**
     * 确认入库
     */
    CONFIRM_OUT("确认出库", "2");

    private String name;
    private String value;

    InventoryStatus(String name, String value) {
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

    public static InventoryStatus parse(Integer value) {
        for (InventoryStatus inventoryStatus : values()) {
            if (inventoryStatus.getValue().equals(value)) {
                return inventoryStatus;
            }
        }
        return null;
    }
}
