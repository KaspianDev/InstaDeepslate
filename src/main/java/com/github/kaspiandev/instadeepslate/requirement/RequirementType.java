package com.github.kaspiandev.instadeepslate.requirement;

import java.util.Map;
import java.util.function.Function;

public enum RequirementType {

    ENCHANTMENT(EnchantmentRequirement::new),
    ITEM_TYPE(ItemTypeRequirement::new),
    EFFECT(EffectRequirement::new);

    private final Function<Map<String, Object>, Requirement> buildFunction;

    RequirementType(Function<Map<String, Object>, Requirement> buildFunction) {
        this.buildFunction = buildFunction;
    }

    public static Requirement buildMatching(Map<String, Object> data) {
        RequirementType type = RequirementType.valueOf((String) data.get("type"));
        return type.build(data);
    }

    public Requirement build(Map<String, Object> data) {
        return buildFunction.apply(data);
    }

}
