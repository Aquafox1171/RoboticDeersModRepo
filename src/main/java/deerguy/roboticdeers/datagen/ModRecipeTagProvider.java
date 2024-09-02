    package deerguy.roboticdeers.datagen;

    import deerguy.roboticdeers.block.ModBlocks;
    import deerguy.roboticdeers.item.ModItems;
    import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
    import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
    import net.minecraft.data.server.recipe.RecipeExporter;
    import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
    import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
    import net.minecraft.item.ItemConvertible;
    import net.minecraft.item.Items;
    import net.minecraft.recipe.book.RecipeCategory;
    import net.minecraft.registry.RegistryWrapper;
    import net.minecraft.registry.tag.ItemTags;

    import java.util.List;
    import java.util.concurrent.CompletableFuture;

    public class ModRecipeTagProvider extends FabricRecipeProvider {

        public ModRecipeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_BLOCK)
                    .input('E', ModItems.TITANIUM)
                    .pattern("EEE")
                    .pattern("EEE")
                    .pattern("EEE")
                    .criterion(hasItem(ModItems.TITANIUM), conditionsFromItem(ModItems.TITANIUM))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDISH_WOOD)
                    .input('E', Items.GOLD_INGOT)
                    .input('#', ItemTags.PLANKS)
                    .pattern("E#E")
                    .pattern("###")
                    .pattern("E#E")
                    .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_TITANIUM_BLOCK)
                    .input('E', ModItems.RAW_TITANIUM)
                    .pattern("EEE")
                    .pattern("EEE")
                    .pattern("EEE")
                    .criterion(hasItem(ModItems.RAW_TITANIUM), conditionsFromItem(ModItems.RAW_TITANIUM))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDISH_WOOD_SLABS)
                    .input('E', ModBlocks.GOLDISH_WOOD)
                    .pattern("")
                    .pattern("")
                    .pattern("EEE")
                    .criterion(hasItem(ModBlocks.GOLDISH_WOOD), conditionsFromItem(ModBlocks.GOLDISH_WOOD))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDISH_WOOD_STAIRS)
                    .input('E', ModBlocks.GOLDISH_WOOD)
                    .pattern("E")
                    .pattern("EE")
                    .pattern("EEE")
                    .criterion(hasItem(ModBlocks.GOLDISH_WOOD), conditionsFromItem(ModBlocks.GOLDISH_WOOD))
                    .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.TITANIUM, 9)
                    .input(ModBlocks.TITANIUM_BLOCK)
                    .criterion(hasItem(ModBlocks.TITANIUM_BLOCK),conditionsFromItem(ModBlocks.TITANIUM_BLOCK))
                    .offerTo(exporter);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RAW_TITANIUM, 9)
                    .input(ModBlocks.RAW_TITANIUM_BLOCK)
                    .criterion(hasItem(ModBlocks.RAW_TITANIUM_BLOCK),conditionsFromItem(ModBlocks.RAW_TITANIUM_BLOCK))
                    .offerTo(exporter);

            List<ItemConvertible> titaniumOres = List.of(ModItems.RAW_TITANIUM, ModBlocks.TITANIUM_ORE);
            offerBlasting(exporter, titaniumOres,RecipeCategory.MISC,ModItems.TITANIUM, 0.0f, 1000, "ores");

        }


    }
