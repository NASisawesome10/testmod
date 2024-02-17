package net.nasisawesome10.testmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.Difficulty;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.item.ModItemGroups;
import net.nasisawesome10.testmod.item.ModItems;
import net.nasisawesome10.testmod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.nasisawesome10.testmod.world.gen.ModWorldGeneration;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestMod implements ModInitializer {
    public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final UUID BASE_SPEED_MODIFIER_ID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278C");
	private static EntityAttributeModifier BASE_SPEED_MODIFIER;
	public static final Map<PlayerEntity, Integer> stamina = new HashMap<>();

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModWorldGeneration.generateModWorldGen();

		updateModifiers();
		/*
		ServerPlayNetworking.registerGlobalReceiver( id("strolling"), (server, player, handler, buf, responseSender) -> {
			EntityAttributeInstance movement = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
			boolean strollingP = buf.readBoolean();

		});
		 */

		ServerTickEvents.START_SERVER_TICK.register(id("stamina"), server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

				EntityAttributeInstance instance = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
				if (instance != null) {
					if (!instance.hasModifier(BASE_SPEED_MODIFIER)) {
						instance.addTemporaryModifier(BASE_SPEED_MODIFIER);
					}
					else if (instance.getModifier(BASE_SPEED_MODIFIER_ID).getValue() != BASE_SPEED_MODIFIER.getValue()) {
						instance.removeModifier(BASE_SPEED_MODIFIER_ID);
						instance.addTemporaryModifier(BASE_SPEED_MODIFIER);
					}
				}
				Difficulty difficulty = player.getWorld().getDifficulty();
				int max_stamina = (player.getHungerManager().getFoodLevel() * 400);
				int player_stamina = stamina.getOrDefault(player, max_stamina);

				if (player.isSprinting() && !player.isCreative() && (!player.hasStatusEffect(StatusEffects.STRENGTH) || !player.hasStatusEffect(StatusEffects.SPEED)))
					player_stamina -= 50;
				if (player_stamina <= 0) {
					player.setSprinting(false);
					player.addStatusEffect( new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 0, false, false));
				}
				if (!player.isSprinting() && player_stamina <= max_stamina && difficulty == Difficulty.EASY) {
					if (player_stamina < max_stamina / 32) {
						player_stamina += 6;
					}
					else {
						player_stamina += 70;
					}
				}
				if (!player.isSprinting() && player_stamina <= max_stamina && difficulty == Difficulty.NORMAL) {
					if (player_stamina < max_stamina / 32) {
						player_stamina += 2;
					}
					else {
						player_stamina += 50;
					}
				}
				if (!player.isSprinting() && player_stamina <= max_stamina && difficulty == Difficulty.HARD) {
					if (player_stamina < max_stamina / 32) {
						player_stamina += 1;
					}
					else {
						player_stamina += 45;
					}
				}
				System.out.println("Stamina: " + player_stamina);

				setStamina(player, MathHelper.clamp(player_stamina, 0, max_stamina));
			}
		});
	}
	public static void updateModifiers() {

		//LivingEntityAccessor.setSPRINTING_SPEED_BOOST(new EntityAttributeModifier(LivingEntityAccessor.getSPRINTING_SPEED_BOOST_ID(), "Sprinting speed boost", 0.3f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		BASE_SPEED_MODIFIER = new EntityAttributeModifier(BASE_SPEED_MODIFIER_ID, "WalkJogRun: Base speed modification",
				0, EntityAttributeModifier.Operation.MULTIPLY_BASE);
	}

	private void setStamina(ServerPlayerEntity player, int staminaP) {
		stamina.put(player, staminaP);

		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(staminaP);
		ServerPlayNetworking.send(player, TestMod.id("stamina"), buf);
	}

	public static Identifier id(String str) {
		return new Identifier("walk-jog-run", str);
	}
}