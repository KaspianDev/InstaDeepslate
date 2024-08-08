package com.github.kaspiandev.instadeepslate.requirement;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class EffectRequirement extends Requirement {

    private static final String EFFECT_KEY = "effect";
    private static final String AMPLIFIER_KEY = "amplifier";

    private final PotionEffectType effect;
    private final int amplifier;

    public EffectRequirement(Map<String, Object> data) {
        super(RequirementType.EFFECT);
        this.effect = PotionEffectType.getByKey(NamespacedKey.minecraft((String) data.get(EFFECT_KEY)));
        this.amplifier = (int) data.get(AMPLIFIER_KEY);
    }

    public EffectRequirement(PotionEffectType effect, int amplifier) {
        super(RequirementType.EFFECT);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        PotionEffect potionEffect = player.getPotionEffect(effect);
        if (potionEffect == null) return false;

        return potionEffect.getAmplifier() >= amplifier;
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                EFFECT_KEY, effect.getKey().getKey(),
                AMPLIFIER_KEY, amplifier
        );
    }

}
