package partea.partea_expansion.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import partea.partea_expansion.potion.CustomPotionDoomedDeath;
import partea.partea_expansion.potion.EffectDurance;

import java.util.Random;

public class RandomStatusEffects {

    public static StatusEffect randomBeneficialEffect(){
        Random random = new Random();
        int key = random.nextInt(16);
        return switch (key) {
            case 0 -> StatusEffects.ABSORPTION;
            case 1 -> StatusEffects.CONDUIT_POWER;
            case 2 -> StatusEffects.DOLPHINS_GRACE;
            case 3 -> StatusEffects.FIRE_RESISTANCE;
            case 4 -> StatusEffects.HASTE;
            case 5 -> StatusEffects.HEALTH_BOOST;
            case 6 -> StatusEffects.INSTANT_HEALTH;
            case 7 -> StatusEffects.INVISIBILITY;
            case 8 -> StatusEffects.JUMP_BOOST;
            case 9 -> StatusEffects.LUCK;
            case 10 -> StatusEffects.NIGHT_VISION;
            case 11 -> StatusEffects.REGENERATION;
            case 12 -> StatusEffects.RESISTANCE;
            case 13 -> StatusEffects.SATURATION;
            case 14 -> StatusEffects.SPEED;
            case 15 -> StatusEffects.STRENGTH;
            default -> StatusEffects.WATER_BREATHING;
        };
    }
    public static StatusEffect randomHarmfulEffect(){
        Random random = new Random();
        int key = random.nextInt(14);
        return switch (key) {
            case 0 -> StatusEffects.DARKNESS;
            case 1 -> StatusEffects.BLINDNESS;
            case 2 -> StatusEffects.GLOWING;
            case 3 -> StatusEffects.HUNGER;
            case 4 -> StatusEffects.INSTANT_DAMAGE;
            case 5 -> StatusEffects.LEVITATION;
            case 6 -> StatusEffects.MINING_FATIGUE;
            case 7 -> StatusEffects.NAUSEA;
            case 8 -> StatusEffects.POISON;
            case 9 -> StatusEffects.SLOWNESS;
            case 10 -> StatusEffects.UNLUCK;
            case 11 -> StatusEffects.WEAKNESS;
            case 12 -> StatusEffects.WITHER;
            case 13 -> CustomPotionDoomedDeath.PotionDoomedDeath;
            default -> EffectDurance.EffectDurance;
        };
    }
    public static StatusEffect randomHarmfulEffectWithNoDot(){
        Random random = new Random();
        int key = random.nextInt(12);
        return switch (key) {
            case 0 -> StatusEffects.DARKNESS;
            case 1 -> StatusEffects.BLINDNESS;
            case 2 -> StatusEffects.GLOWING;
            case 3 -> StatusEffects.HUNGER;
            case 4 -> StatusEffects.INSTANT_DAMAGE;
            case 5 -> StatusEffects.LEVITATION;
            case 6 -> StatusEffects.MINING_FATIGUE;
            case 7 -> StatusEffects.NAUSEA;
            case 8 -> StatusEffects.SLOWNESS;
            case 9 -> StatusEffects.UNLUCK;
            case 10 -> StatusEffects.WEAKNESS;
            case 11 -> CustomPotionDoomedDeath.PotionDoomedDeath;
            default -> EffectDurance.EffectDurance;
        };
    }

}
