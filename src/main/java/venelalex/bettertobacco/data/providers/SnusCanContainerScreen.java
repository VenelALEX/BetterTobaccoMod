package venelalex.bettertobacco.data.providers;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SnusCanContainerScreen extends ContainerScreen<SnusCanContainer>{

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	
	private final PlayerInventory playerInv;
	private final int inventoryRows;
	
	public SnusCanContainerScreen(SnusCanContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.playerInv = inv;
		this.inventoryRows = screenContainer.getInventoryRows();
	}
	
	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground();
		super.render(p_render_1_, p_render_2_, p_render_3_);
		this.renderHoveredToolTip(p_render_1_, p_render_2_);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.font.drawString(title.getFormattedText(), 8, 6, 4210752);
		this.font.drawString(playerInv.getDisplayName().getFormattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		if(minecraft == null) {
			return;
		}
		
		GlStateManager.color4f(1, 1, 1, 1);
		minecraft.getTextureManager().bindTexture(TEXTURE);
		
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		
		blit(posX, posY, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		blit(posX, posY + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
	}

}
