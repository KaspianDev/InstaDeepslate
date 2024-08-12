package com.github.kaspiandev.instamine.requirement;

public enum RequirementType {

    ENCHANTMENT(EnchantmentRequirement.class),
    ITEM_TYPE(ItemTypeRequirement.class),
    EFFECT(EffectRequirement.class),
    MODEL(ModelDataRequirement.class),
    PERMISSION(PermissionRequirement.class);

    private final Class<? extends Requirement> clazz;

    RequirementType(Class<? extends Requirement> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Requirement> getRequirementClass() {
        return clazz;
    }

}
