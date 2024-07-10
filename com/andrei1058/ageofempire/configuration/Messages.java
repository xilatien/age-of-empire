/*     */ package com.andrei1058.ageofempire.configuration;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Messages
/*     */ {
/*  15 */   private static File file = new File("plugins/Age-Of-Empire/messages.yml");
/*  16 */   private static YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
/*     */   
/*     */   public static void setupMessages() {
/*  19 */     if (!file.exists()) {
/*     */       try {
/*  21 */         file.createNewFile();
/*  22 */       } catch (IOException e) {
/*  23 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*  26 */     yml.addDefault("prefix", "&9[&7AOE&9]");
/*  27 */     yml.addDefault("player-join", "{prefix} &7%player% has joined the game!");
/*  28 */     yml.addDefault("action-player-join", "&e{player} &7has joined the game!");
/*  29 */     yml.addDefault("action-player-left", "&e{player} &7has left the game!");
/*  30 */     yml.addDefault("player-died", "{player} &adied!");
/*  31 */     yml.addDefault("help-item-on", "&aHelp On");
/*  32 */     yml.addDefault("help-item-off", "&cHelp Off");
/*  33 */     yml.addDefault("leave-item", "&aBack to Hub");
/*  34 */     yml.addDefault("team-choosing.blue", "&9Blue");
/*  35 */     yml.addDefault("team-choosing.green", "&aGreen");
/*  36 */     yml.addDefault("team-choosing.yellow", "&eYellow");
/*  37 */     yml.addDefault("team-choosing.red", "&cRed");
/*  38 */     yml.addDefault("team-choosing.green-join", "{prefix} &aYou're joining the team Green");
/*  39 */     yml.addDefault("team-choosing.red-join", "{prefix} &cYou're joining the team Red");
/*  40 */     yml.addDefault("team-choosing.yellow-join", "{prefix} &eYou're joining the team Yellow");
/*  41 */     yml.addDefault("team-choosing.blue-join", "{prefix} &9You're joining the team Blue");
/*  42 */     yml.addDefault("team-choosing.unbalanced-teams", "&eYou can't join this team right now!");
/*  43 */     yml.addDefault("game-start", "&6The game will start in &e{time} &6second(s).");
/*  44 */     yml.addDefault("help.ison", "{prefix} &9[&eHelp&9] &aHelp is on, use the /h command to &2Turn On&e/&cTurn Off &athe help.");
/*  45 */     yml.addDefault("help.cutting-wood", "{prefix} &9[&eHelp&9] &aCutting &2Wood &ayields resources for you and your base.");
/*  46 */     yml.addDefault("help.gold-stuff", "{prefix} &9[&eHelp&9] &2Gold &ais used to buy equipment in the buildings. You earn gold by collecting resources or by killing players.");
/*  47 */     yml.addDefault("help.stone", "{prefix} &9[&eHelp&9] &aMining &2Stone (Andesite) &ayields resources for you and your base.");
/*  48 */     yml.addDefault("help.start-guide", "{prefix} &9[&eHelp&9] &aWelcome to Age of Empire. This game consists of collecting resources for you and your kingdom. These resources will allow you to construct buildings");
/*  49 */     yml.addDefault("help.start-buildings", "{prefix} &9[&eHelp&9] &aThese buildings are used to develop your kingdom and allow you to buy various different items (weapons, food etc.).");
/*  50 */     yml.addDefault("help.start-resources", "{prefix} &9[&eHelp&9] &aTo start, go mine some Stone (Andesite) and Wood.");
/*  51 */     yml.addDefault("help.enough-res-forum", "{prefix} &9[&eHelp&9] &aYour Kingdom has enough resources for you to buy a building. Go back to your &2Forum&a, click on the NPC and select a building. Why not start with the &2Forge&a?");
/*  52 */     yml.addDefault("help.vote", "{prefix} &9[&eHelp&9] &aSomeone in your team has opened a vote. This vote lets you buy a new building or change Age! To validate your vote, you have to &2Right Click &awith the &2withe the &2Slimeball &afound in the &2last slot in your inventory&a. If you don't agree with the proposed motion, you don't have to do anything.");
/*  53 */     yml.addDefault("scoreboard.title", "&cAgeOfEmpire");
/*  54 */     yml.addDefault("scoreboard.14", "&6Age: &f");
/*  55 */     yml.addDefault("scoreboard.13", "§1");
/*  56 */     yml.addDefault("scoreboard.12", "&bWood: &f");
/*  57 */     yml.addDefault("scoreboard.11", "&bStone: &f");
/*  58 */     yml.addDefault("scoreboard.10", "&eGold: &f");
/*  59 */     yml.addDefault("scoreboard.9", "§2");
/*  60 */     yml.addDefault("scoreboard.8", "&aPlots");
/*  61 */     yml.addDefault("scoreboard.7", "&2Small: &f");
/*  62 */     yml.addDefault("scoreboard.6", "&2Medium: &f");
/*  63 */     yml.addDefault("scoreboard.5", "&2Large: &f");
/*  64 */     yml.addDefault("scoreboard.4", "§3");
/*  65 */     yml.addDefault("scoreboard.3", "&7PvP: &f");
/*  66 */     yml.addDefault("scoreboard.3_2", "&7Assault: &f");
/*  67 */     yml.addDefault("scoreboard.2", "§4");
/*  68 */     yml.addDefault("scoreboard.1", "&7play&b.ultramc.&7eu");
/*  69 */     yml.addDefault("villagers.forum", "&c&lForum");
/*  70 */     yml.addDefault("villagers.buy-buildings", "&b&lBuy buildings for your kingdom");
/*  71 */     yml.addDefault("pvp-on", "{prefix} &6Pvp On, rare ores have appeared in the middle of the map.");
/*  72 */     yml.addDefault("assaults-on", "{prefix} &6Assaults on.");
/*  73 */     yml.addDefault("chat.game", "(Team) {v_prefix}&f{player} {v_suffix}&f{message}");
/*  74 */     yml.addDefault("chat.lobby", "(All) {v_prefix}&f{player} {v_suffix}&f{message}");
/*  75 */     yml.addDefault("cant-break", "{prefix} &cYou can't break this block in a kingdom");
/*  76 */     yml.addDefault("cant-vote", "{prefix} &cYou can't vote at the moment (a vote is already in progress)");
/*  77 */     yml.addDefault("forum.age1", "&cAge 1");
/*  78 */     yml.addDefault("forum.age2", "&cAge 2");
/*  79 */     yml.addDefault("forum.age3", "&cAge 3");
/*  80 */     yml.addDefault("forum.age4", "&cAge 4");
/*  81 */     yml.addDefault("forum.age-buldings", "&6Buildings for this age ➤");
/*  82 */     yml.addDefault("forum.to-build", "&a&lTo build");
/*  83 */     yml.addDefault("forum.built", "&6&lAlready built");
/*  84 */     yml.addDefault("villager.forum-attacked", "&e&lForum Attacked");
/*  85 */     yml.addDefault("villager.cant-open", "{prefix} &6You can't open this menu.");
/*     */     
/*  87 */     yml.addDefault("forum.FORGE.displayname", "&e&lForge");
/*  88 */     yml.addDefault("forum.violence", "{prefix} &eOuch! You need to right click to open my menu... &cThere's no need for violence! :C");
/*  89 */     ArrayList<String> forge_lore = new ArrayList();
/*  90 */     forge_lore.add("&3Wood: &f150");
/*  91 */     forge_lore.add("&3Stone: &f75");
/*  92 */     forge_lore.add("&3Plot: &fSmall");
/*  93 */     forge_lore.add("&3Description: &bBuy hand-to-hand weapons.");
/*  94 */     yml.addDefault("forum.FORGE.lore", forge_lore);
/*  95 */     yml.addDefault("forum.FORGE.holo", "&bBuy hand-to-hand weapons");
/*     */     
/*  97 */     yml.addDefault("forum.MILL.displayname", "&e&lMill");
/*  98 */     ArrayList<String> mill_lore = new ArrayList();
/*  99 */     mill_lore.add("&3Wood: &f150");
/* 100 */     mill_lore.add("&3Stone: &f75");
/* 101 */     mill_lore.add("&3Plot: &fSmall");
/* 102 */     mill_lore.add("&3Description: &bBuy food.");
/* 103 */     yml.addDefault("forum.MILL.lore", mill_lore);
/* 104 */     yml.addDefault("forum.MILL.holo", "&bBuy food");
/*     */     
/* 106 */     yml.addDefault("forum.STONE_MINE.displayname", "&e&lStone Mine");
/* 107 */     ArrayList<String> stone_lore = new ArrayList();
/* 108 */     stone_lore.add("&3Wood: &f150");
/* 109 */     stone_lore.add("&3Stone: &f75");
/* 110 */     stone_lore.add("&3Plot: &fSmall");
/* 111 */     stone_lore.add("&3Description: &bYields Stone automatically.");
/* 112 */     yml.addDefault("forum.STONE_MINE.lore", stone_lore);
/* 113 */     yml.addDefault("forum.STONE_MINE.holo", "&bYields Stone automatically");
/*     */     
/* 115 */     yml.addDefault("forum.GOLD_MINE.displayname", "&e&lGold Mine");
/* 116 */     ArrayList<String> gold_lore = new ArrayList();
/* 117 */     gold_lore.add("&3Wood: &f150");
/* 118 */     gold_lore.add("&3Stone: &f100");
/* 119 */     gold_lore.add("&3Plot: &fSmall");
/* 120 */     gold_lore.add("&3Description: &bYields Gold automatically.");
/* 121 */     yml.addDefault("forum.GOLD_MINE.lore", gold_lore);
/* 122 */     yml.addDefault("forum.GOLD_MINE.holo", "&bYields Gold automatically");
/*     */     
/* 124 */     yml.addDefault("forum.SAWMILL.displayname", "&e&lSawmill");
/* 125 */     ArrayList<String> sawmill_lore = new ArrayList();
/* 126 */     sawmill_lore.add("&3Wood: &f150");
/* 127 */     sawmill_lore.add("&3Stone: &f75");
/* 128 */     sawmill_lore.add("&3Plot: &fSmall");
/* 129 */     sawmill_lore.add("&3Description: &bYields Wood automatically.");
/* 130 */     yml.addDefault("forum.SAWMILL.lore", sawmill_lore);
/* 131 */     yml.addDefault("forum.SAWMILL.holo", "&bYields Wood automatically");
/*     */     
/* 133 */     yml.addDefault("forum.MARKET.displayname", "&e&lMarket");
/* 134 */     ArrayList<String> market_lore = new ArrayList();
/* 135 */     market_lore.add("&3Wood: &f100");
/* 136 */     market_lore.add("&3Stone: &f50");
/* 137 */     market_lore.add("&3Plot: &fSmall");
/* 138 */     market_lore.add("&3Description: &bBuy various different items.");
/* 139 */     yml.addDefault("forum.MARKET.lore", market_lore);
/* 140 */     yml.addDefault("forum.MARKET.holo", "&bBuy various different items");
/*     */     
/* 142 */     yml.addDefault("forum.KENNEL.displayname", "&e&lKennel");
/* 143 */     ArrayList<String> kennel_lore = new ArrayList();
/* 144 */     kennel_lore.add("&3Wood: &f100");
/* 145 */     kennel_lore.add("&3Stone: &f50");
/* 146 */     kennel_lore.add("&3Plot: &fSmall");
/* 147 */     kennel_lore.add("&3Description: &bBuy dogs.");
/* 148 */     yml.addDefault("forum.KENNEL.lore", kennel_lore);
/* 149 */     yml.addDefault("forum.KENNEL.holo", "&bBuy dogs");
/*     */     
/* 151 */     yml.addDefault("forum.SABOTAGE_WORKSHOP.displayname", "&e&lSabotage Workshop");
/* 152 */     ArrayList<String> sabotagew_lore = new ArrayList();
/* 153 */     sabotagew_lore.add("&3Wood: &f100");
/* 154 */     sabotagew_lore.add("&3Stone: &f50");
/* 155 */     sabotagew_lore.add("&3Plot: &fSmall");
/* 156 */     sabotagew_lore.add("&3Description: &bBuy destructive items.");
/* 157 */     yml.addDefault("forum.SABOTAGE_WORKSHOP.lore", sabotagew_lore);
/* 158 */     yml.addDefault("forum.SABOTAGE_WORKSHOP.holo", "&bBuy destructive items");
/*     */     
/* 160 */     yml.addDefault("forum.WORKSHOP.displayname", "&e&lWorkshop");
/* 161 */     ArrayList<String> workshop_lore = new ArrayList();
/* 162 */     workshop_lore.add("&3Wood: &f100");
/* 163 */     workshop_lore.add("&3Stone: &f50");
/* 164 */     workshop_lore.add("&3Plot: &fSmall");
/* 165 */     workshop_lore.add("&3Description: &bBuy various blocks.");
/* 166 */     yml.addDefault("forum.WORKSHOP.lore", workshop_lore);
/* 167 */     yml.addDefault("forum.WORKSHOP.holo", "&bBuy various blocks");
/*     */     
/* 169 */     yml.addDefault("forum.ARCHERY_STORE.displayname", "&e&lArchery Store");
/* 170 */     ArrayList<String> archeryl = new ArrayList();
/* 171 */     archeryl.add("&3Wood: &f300");
/* 172 */     archeryl.add("&3Stone: &f150");
/* 173 */     archeryl.add("&3Plot: &fMedium");
/* 174 */     archeryl.add("&3Description: &bBuy ranged weapons.");
/* 175 */     yml.addDefault("forum.ARCHERY_STORE.lore", archeryl);
/* 176 */     yml.addDefault("forum.ARCHERY_STORE.holo", "&bBuy ranged weapons");
/*     */     
/* 178 */     yml.addDefault("forum.TRIFARROW.displayname", "&e&lTrifArrow");
/* 179 */     ArrayList<String> trifarrow_lore = new ArrayList();
/* 180 */     trifarrow_lore.add("&3Wood: &f375");
/* 181 */     trifarrow_lore.add("&3Stone: &f175");
/* 182 */     trifarrow_lore.add("&3Plot: &fMedium");
/* 183 */     trifarrow_lore.add("&3Description: &bBuy various different arrows.");
/* 184 */     yml.addDefault("forum.TRIFARROW.lore", trifarrow_lore);
/* 185 */     yml.addDefault("forum.TRIFARROW.holo", "&bBuy various different arrows");
/*     */     
/* 187 */     yml.addDefault("forum.STABLE.displayname", "&e&lStable");
/* 188 */     ArrayList<String> stable_lore = new ArrayList();
/* 189 */     stable_lore.add("&3Wood: &f200");
/* 190 */     stable_lore.add("&3Stone: &f100");
/* 191 */     stable_lore.add("&3Plot: &fMedium");
/* 192 */     stable_lore.add("&3Description: &bBuy horses.");
/* 193 */     yml.addDefault("forum.STABLE.lore", stable_lore);
/* 194 */     yml.addDefault("forum.STABLE.holo", "&bBuy horses");
/*     */     
/* 196 */     yml.addDefault("forum.ARMORY.displayname", "&e&lArmory");
/* 197 */     ArrayList<String> armory_lore = new ArrayList();
/* 198 */     armory_lore.add("&3Wood: &f300");
/* 199 */     armory_lore.add("&3Stone: &f150");
/* 200 */     armory_lore.add("&3Plot: &fMedium");
/* 201 */     armory_lore.add("&3Description: &bBuy armor.");
/* 202 */     yml.addDefault("forum.ARMORY.lore", armory_lore);
/* 203 */     yml.addDefault("forum.ARMORY.holo", "&bBuy armory_lore");
/*     */     
/* 205 */     yml.addDefault("forum.LABORATORY.displayname", "&e&lLaboratory");
/* 206 */     ArrayList<String> laboratory_lore = new ArrayList();
/* 207 */     laboratory_lore.add("&3Wood: &f300");
/* 208 */     laboratory_lore.add("&3Stone: &f150");
/* 209 */     laboratory_lore.add("&3Plot: &fMedium");
/* 210 */     laboratory_lore.add("&3Description: &bBuy potions.");
/* 211 */     yml.addDefault("forum.LABORATORY.lore", laboratory_lore);
/* 212 */     yml.addDefault("forum.LABORATORY.holo", "&bBuy potions");
/*     */     
/* 214 */     yml.addDefault("forum.GUILD.displayname", "&e&lGuild");
/* 215 */     ArrayList<String> guild_lore = new ArrayList();
/* 216 */     guild_lore.add("&3Wood: &f600");
/* 217 */     guild_lore.add("&3Stone: &f300");
/* 218 */     guild_lore.add("&3Plot: &fLarge");
/* 219 */     guild_lore.add("&3Description: &bBuy enchantments.");
/* 220 */     yml.addDefault("forum.GUILD.lore", guild_lore);
/* 221 */     yml.addDefault("forum.GUILD.holo", "&bBuy enchantments");
/*     */     
/* 223 */     yml.addDefault("forum.TRAINING_CENTER.displayname", "&e&lTraining Center");
/* 224 */     ArrayList<String> training_center_lore = new ArrayList();
/* 225 */     training_center_lore.add("&3Wood: &f500");
/* 226 */     training_center_lore.add("&3Stone: &f250");
/* 227 */     training_center_lore.add("&3Plot: &fLarge");
/* 228 */     training_center_lore.add("&3Description: &bYields XP automatically.");
/* 229 */     yml.addDefault("forum.TRAINING_CENTER.lore", training_center_lore);
/* 230 */     yml.addDefault("forum.TRAINING_CENTER.holo", "&bYields XP automatically");
/*     */     
/* 232 */     yml.addDefault("new-vote", "&9{player} &1would like to create a/an {building} &f. &2{votes}&f/&4{team}");
/* 233 */     yml.addDefault("vote-denied", "&c{player}&4's vote has been denied.");
/* 234 */     yml.addDefault("vote-accepted", "&2{player}&a's vote has been accepted.");
/* 235 */     yml.addDefault("insufficient-resources", "{prefix} &cYour team doesn't have enough &eresources &c{&6Wood missing&e: &f{wood}&6: Stones missing&e: &f{stone}&6).");
/* 236 */     yml.addDefault("insufficient-gold", "{prefix} &cInsufficient gold!");
/* 237 */     yml.addDefault("locked-slot", "&cSlot Locked");
/* 238 */     yml.addDefault("forum-paper", "Forum");
/* 239 */     yml.addDefault("validate-vote", "&aValidate your Vote");
/* 240 */     yml.addDefault("constructor.displayname", "&8Constructor");
/* 241 */     ArrayList<String> constructor_lore = new ArrayList<>();
/* 242 */     constructor_lore.add("&fRight click");
/* 243 */     constructor_lore.add("&fon one of your team's");
/* 244 */     constructor_lore.add("&fplots");
/* 245 */     constructor_lore.add("&fwith this item in your hand");
/* 246 */     constructor_lore.add("&fto build the");
/* 247 */     constructor_lore.add("&fselected building");
/* 248 */     constructor_lore.add("&cThrow to cancel");
/* 249 */     yml.addDefault("constructor.lore", constructor_lore);
/* 250 */     yml.addDefault("having-construct", "{prefix} &9You must construct a building before you can vote again");
/* 251 */     yml.addDefault("build-canceled", "{prefix} &6{player} has just canceled a building {building}");
/* 252 */     yml.addDefault("build-started", "{prefix} &2{player} has just started building {building}");
/* 253 */     yml.addDefault("already-built", "&c&lYou already built this!");
/* 254 */     yml.addDefault("vote-age", "&9{player} &1would like to change Age &f. &2{votes}&f/&4{team}");
/* 255 */     yml.addDefault("blue-changed-age", "{prefix} &fThe &9Blue &fteam has just changed to Age &e{age}");
/* 256 */     yml.addDefault("green-changed-age", "{prefix} &fThe &aGreen &fteam has just changed to Age &e{age}");
/* 257 */     yml.addDefault("yellow-changed-age", "{prefix} &fThe &eYellow &fteam has just changed to Age &e{age}");
/* 258 */     yml.addDefault("red-changed-age", "{prefix} &fThe &cRed &fteam has just changed to Age &e{age}");
/* 259 */     yml.addDefault("cant-construct-outside", "&cYou can't construct buildings outside your base.");
/* 260 */     yml.addDefault("cant-construct-here", "&cYou can't construct buildings right here.");
/* 261 */     yml.addDefault("cant-place-here", "{prefix} &cYou can't place blocks right here!");
/* 262 */     yml.addDefault("cant-construct-size", "&cYou must be in the right size plot to build this structure.");
/* 263 */     yml.addDefault("cant-vote-full", "&cYou can't vote for this building because you don't have any free plot of this type");
/* 264 */     yml.addDefault("built-success", "{prefix} &e&l{building} &abuilt successfully.");
/* 265 */     yml.addDefault("motd.lobby", "&aLobby");
/* 266 */     yml.addDefault("motd.starting", "&eStarting");
/* 267 */     yml.addDefault("motd.playing", "&cPlaying");
/* 268 */     yml.addDefault("motd.restarting", "&4Restarting");
/* 269 */     yml.addDefault("new-kill", "{prefix} {player} &awas killed by {killer}");
/* 270 */     yml.addDefault("victory.green", "&aGreen's Victory");
/* 271 */     yml.addDefault("victory.blue", "&9Blue's Victory");
/* 272 */     yml.addDefault("vicotry.red", "&cRed's Vicotory");
/* 273 */     yml.addDefault("victory.yellow", "&eYellow's Victory");
/* 274 */     yml.addDefault("base-destroyed.blue", "{prefix} &eThe &9Blue team's Base &2has been destroyed by the {team}");
/* 275 */     yml.addDefault("base-destroyed.green", "{prefix} &eThe &aGreen team's Base &2has been destroyed by the {team}");
/* 276 */     yml.addDefault("base-destroyed.yellow", "{prefix} &eThe Yellow team's Base &2has been destroyed by the {team}");
/* 277 */     yml.addDefault("base-destroyed.red", "{prefix} &eThe &cRed team's Base &2has been destroyed by the {team}");
/* 278 */     yml.addDefault("holo.gold", "&eGold &a+{amount}");
/* 279 */     yml.addDefault("holo.stone", "&eStone &a+{amount}");
/* 280 */     yml.addDefault("holo.wood", "&eWood &a+{amount}");
/* 281 */     yml.addDefault("plot.small", "&2Small Plot");
/* 282 */     yml.addDefault("plot.medium", "&2Medium Plot");
/* 283 */     yml.addDefault("plot.large", "&2Large Plot");
/*     */     
/* 285 */     yml.addDefault("forge.stonepickaxe.displayname", "&7Stone Pickaxe");
/* 286 */     ArrayList<String> stonepickaxe = new ArrayList<>();
/* 287 */     stonepickaxe.add("&6Gold: &f1");
/* 288 */     stonepickaxe.add("&2Quantity: &f1");
/* 289 */     yml.addDefault("forge.stonepickaxe.lore", stonepickaxe);
/*     */     
/* 291 */     yml.addDefault("forge.stonesword.displayname", "&7Stone Sword");
/* 292 */     ArrayList<String> stonesword = new ArrayList<>();
/* 293 */     stonesword.add("&6Gold: &f10");
/* 294 */     stonesword.add("&2Quantity: &f1");
/* 295 */     yml.addDefault("forge.stonesword.lore", stonesword);
/*     */     
/* 297 */     yml.addDefault("forge.ironsword.displayname", "&fIron Sword");
/* 298 */     ArrayList<String> ironsword = new ArrayList<>();
/* 299 */     ironsword.add("&6Gold: &f30");
/* 300 */     ironsword.add("&2Quantity: &f1");
/* 301 */     yml.addDefault("forge.ironsword.lore", ironsword);
/*     */     
/* 303 */     yml.addDefault("forge.stoneaxe.displayname", "&7Stone Axe");
/* 304 */     ArrayList<String> stoneaxe = new ArrayList<>();
/* 305 */     stoneaxe.add("&6Gold: &f5");
/* 306 */     stoneaxe.add("&2Quantity: &f1");
/* 307 */     yml.addDefault("forge.stoneaxe.lore", stoneaxe);
/*     */     
/* 309 */     yml.addDefault("forge.ironaxe.displayname", "&fIron Axe");
/* 310 */     ArrayList<String> ironaxe = new ArrayList<>();
/* 311 */     ironaxe.add("&6Gold: &f15");
/* 312 */     ironaxe.add("&2Quantity: &f1");
/* 313 */     yml.addDefault("forge.ironaxe.lore", ironaxe);
/*     */     
/* 315 */     yml.addDefault("forge.diamondsword.displayname", "&9Diamond Sword");
/* 316 */     ArrayList<String> diamondsowrd_l = new ArrayList<>();
/* 317 */     diamondsowrd_l.add("&6Gold: &f50");
/* 318 */     diamondsowrd_l.add("&2Quantity: &f1");
/* 319 */     yml.addDefault("forge.diamondsword.lore", diamondsowrd_l);
/*     */     
/* 321 */     yml.addDefault("forge.diamondaxe.displayname", "&9Diamond Axe");
/* 322 */     ArrayList<String> diamondaxe_l = new ArrayList<>();
/* 323 */     diamondaxe_l.add("&6Gold: &f25");
/* 324 */     diamondaxe_l.add("&2Quantity: &f1");
/* 325 */     yml.addDefault("forge.diamondaxe.lore", diamondaxe_l);
/*     */     
/* 327 */     yml.addDefault("mill.bread.displayname", "&7Bread");
/* 328 */     ArrayList<String> breadlore = new ArrayList<>();
/* 329 */     breadlore.add("&6Gold: &f10");
/* 330 */     breadlore.add("&2Quantity: &f5");
/* 331 */     yml.addDefault("mill.bread.lore", breadlore);
/*     */     
/* 333 */     yml.addDefault("mill.steak.displayname", "&7Steak");
/* 334 */     ArrayList<String> steak = new ArrayList<>();
/* 335 */     steak.add("&6Gold: &f22");
/* 336 */     steak.add("&2Quantity: &f5");
/* 337 */     yml.addDefault("mill.steak.lore", steak);
/*     */     
/* 339 */     yml.addDefault("mill.chicken.displayname", "&7Chicken");
/* 340 */     ArrayList<String> chicken = new ArrayList<>();
/* 341 */     chicken.add("&6Gold: &f20");
/* 342 */     chicken.add("&2Quantity: &f5");
/* 343 */     yml.addDefault("mill.chicken.lore", chicken);
/*     */     
/* 345 */     yml.addDefault("mill.potato.displayname", "&7Potato");
/* 346 */     ArrayList<String> potato = new ArrayList<>();
/* 347 */     potato.add("&6Gold: &f15");
/* 348 */     potato.add("&2Quantity: &f5");
/* 349 */     yml.addDefault("mill.potato.lore", potato);
/*     */ 
/*     */     
/* 352 */     yml.addDefault("workshop.grass.displayname", "&7Grass");
/* 353 */     ArrayList<String> grass = new ArrayList<>();
/* 354 */     grass.add("&6Gold: &f10");
/* 355 */     grass.add("&2Quantity: &f10");
/* 356 */     yml.addDefault("workshop.grass.lore", grass);
/*     */     
/* 358 */     yml.addDefault("workshop.dirt.displayname", "&7Dirt");
/* 359 */     ArrayList<String> dirt = new ArrayList<>();
/* 360 */     dirt.add("&6Gold: &f10");
/* 361 */     dirt.add("&2Quantity: &f10");
/* 362 */     yml.addDefault("workshop.dirt.lore", dirt);
/*     */     
/* 364 */     yml.addDefault("workshop.plank.displayname", "&7Plank");
/* 365 */     ArrayList<String> plank = new ArrayList<>();
/* 366 */     plank.add("&6Gold: &f10");
/* 367 */     plank.add("&2Quantity: &f5");
/* 368 */     yml.addDefault("workshop.plank.lore", plank);
/*     */     
/* 370 */     yml.addDefault("workshop.sand.displayname", "&7Sand");
/* 371 */     ArrayList<String> sand = new ArrayList<>();
/* 372 */     sand.add("&6Gold: &f10");
/* 373 */     sand.add("&2Quantity: &f5");
/* 374 */     yml.addDefault("workshop.sand.lore", sand);
/*     */     
/* 376 */     yml.addDefault("workshop.gravel.displayname", "&7Gravel");
/* 377 */     ArrayList<String> gravel = new ArrayList<>();
/* 378 */     gravel.add("&6Gold: &f10");
/* 379 */     gravel.add("&2Quantity: &f5");
/* 380 */     yml.addDefault("workshop.gravel.lore", gravel);
/*     */     
/* 382 */     yml.addDefault("workshop.sponge.displayname", "&7Sponge");
/* 383 */     ArrayList<String> sponge = new ArrayList<>();
/* 384 */     sponge.add("&6Gold: &f20");
/* 385 */     sponge.add("&2Quantity: &f5");
/* 386 */     yml.addDefault("workshop.sponge.lore", sponge);
/*     */     
/* 388 */     yml.addDefault("workshop.glass.displayname", "&7Glass");
/* 389 */     ArrayList<String> glass = new ArrayList<>();
/* 390 */     glass.add("&6Gold: &f15");
/* 391 */     glass.add("&2Quantity: &f10");
/* 392 */     yml.addDefault("workshop.glass.lore", glass);
/*     */     
/* 394 */     yml.addDefault("workshop.lapis.displayname", "&7Lapis Block");
/* 395 */     ArrayList<String> lapis = new ArrayList<>();
/* 396 */     lapis.add("&6Gold: &f25");
/* 397 */     lapis.add("&2Quantity: &f5");
/* 398 */     yml.addDefault("workshop.lapis.lore", lapis);
/*     */     
/* 400 */     yml.addDefault("workshop.whitewool.displayname", "&7White Wool");
/* 401 */     ArrayList<String> whitewool = new ArrayList<>();
/* 402 */     whitewool.add("&6Gold: &f10");
/* 403 */     whitewool.add("&2Quantity: &f10");
/* 404 */     yml.addDefault("workshop.whitewool.lore", whitewool);
/*     */     
/* 406 */     yml.addDefault("workshop.orangewool.displayname", "&7Orange Wool");
/* 407 */     ArrayList<String> orangewool = new ArrayList<>();
/* 408 */     orangewool.add("&6Gold: &f10");
/* 409 */     orangewool.add("&2Quantity: &f10");
/* 410 */     yml.addDefault("workshop.orangewool.lore", orangewool);
/*     */     
/* 412 */     yml.addDefault("workshop.magentawool.displayname", "&7Magenta Wool");
/* 413 */     ArrayList<String> magentawool = new ArrayList<>();
/* 414 */     magentawool.add("&6Gold: &f10");
/* 415 */     magentawool.add("&2Quantity: &f10");
/* 416 */     yml.addDefault("workshop.magentawool.lore", magentawool);
/*     */     
/* 418 */     yml.addDefault("workshop.lightbluewool.displayname", "&7Light Blue Wool");
/* 419 */     ArrayList<String> lightbluewool = new ArrayList<>();
/* 420 */     lightbluewool.add("&6Gold: &f10");
/* 421 */     lightbluewool.add("&2Quantity: &f10");
/* 422 */     yml.addDefault("workshop.lightbluewool.lore", lightbluewool);
/*     */     
/* 424 */     yml.addDefault("workshop.yellowwool.displayname", "&7Yellow Wool");
/* 425 */     ArrayList<String> yellowwool = new ArrayList<>();
/* 426 */     yellowwool.add("&6Gold: &f10");
/* 427 */     yellowwool.add("&2Quantity: &f10");
/* 428 */     yml.addDefault("workshop.yellowwool.lore", yellowwool);
/*     */     
/* 430 */     yml.addDefault("workshop.lightgreenwool.displayname", "&7Light Green Wool");
/* 431 */     ArrayList<String> lightgreenwool = new ArrayList<>();
/* 432 */     lightgreenwool.add("&6Gold: &f10");
/* 433 */     lightgreenwool.add("&2Quantity: &f10");
/* 434 */     yml.addDefault("workshop.lightgreenwool.lore", yellowwool);
/*     */     
/* 436 */     yml.addDefault("workshop.pinkwool.displayname", "&7Pink Wool");
/* 437 */     ArrayList<String> pinkwool = new ArrayList<>();
/* 438 */     pinkwool.add("&6Gold: &f10");
/* 439 */     pinkwool.add("&2Quantity: &f10");
/* 440 */     yml.addDefault("workshop.pinkwool.lore", pinkwool);
/*     */     
/* 442 */     yml.addDefault("workshop.graywool.displayname", "&7Gray Wool");
/* 443 */     ArrayList<String> graywool = new ArrayList<>();
/* 444 */     graywool.add("&6Gold: &f10");
/* 445 */     graywool.add("&2Quantity: &f10");
/* 446 */     yml.addDefault("workshop.graywool.lore", graywool);
/*     */     
/* 448 */     yml.addDefault("workshop.cyanwool.displayname", "&7Cyan Wool");
/* 449 */     ArrayList<String> cyanwool = new ArrayList<>();
/* 450 */     cyanwool.add("&6Gold: &f10");
/* 451 */     cyanwool.add("&2Quantity: &f10");
/* 452 */     yml.addDefault("workshop.cyanwool.lore", cyanwool);
/*     */     
/* 454 */     yml.addDefault("workshop.purplewool.displayname", "&7Purple Wool");
/* 455 */     ArrayList<String> purplewool = new ArrayList<>();
/* 456 */     purplewool.add("&6Gold: &f10");
/* 457 */     purplewool.add("&2Quantity: &f10");
/* 458 */     yml.addDefault("workshop.purplewool.lore", purplewool);
/*     */     
/* 460 */     yml.addDefault("workshop.bluewool.displayname", "&7Blue Wool");
/* 461 */     ArrayList<String> bluewool = new ArrayList<>();
/* 462 */     bluewool.add("&6Gold: &f10");
/* 463 */     bluewool.add("&2Quantity: &f10");
/* 464 */     yml.addDefault("workshop.bluewool.lore", bluewool);
/*     */     
/* 466 */     yml.addDefault("workshop.blackwool.displayname", "&7Back Wool");
/* 467 */     ArrayList<String> blackwool = new ArrayList<>();
/* 468 */     blackwool.add("&6Gold: &f10");
/* 469 */     blackwool.add("&2Quantity: &f10");
/* 470 */     yml.addDefault("workshop.blackwool.lore", blackwool);
/*     */     
/* 472 */     yml.addDefault("workshop.greenwool.displayname", "&7Green Wool");
/* 473 */     ArrayList<String> greenwool = new ArrayList<>();
/* 474 */     greenwool.add("&6Gold: &f10");
/* 475 */     greenwool.add("&2Quantity: &f10");
/* 476 */     yml.addDefault("workshop.greenwool.lore", greenwool);
/*     */     
/* 478 */     yml.addDefault("workshop.redwool.displayname", "&7Red Wool");
/* 479 */     ArrayList<String> redwool = new ArrayList<>();
/* 480 */     redwool.add("&6Gold: &f10");
/* 481 */     redwool.add("&2Quantity: &f10");
/* 482 */     yml.addDefault("workshop.redwool.lore", redwool);
/*     */     
/* 484 */     yml.addDefault("workshop.brownwool.displayname", "&7Brown Wool");
/* 485 */     ArrayList<String> brownwool = new ArrayList<>();
/* 486 */     brownwool.add("&6Gold: &f10");
/* 487 */     brownwool.add("&2Quantity: &f10");
/* 488 */     yml.addDefault("workshop.brownwool.lore", brownwool);
/*     */     
/* 490 */     yml.addDefault("workshop.bricks.displayname", "&7Bricks");
/* 491 */     ArrayList<String> bricks = new ArrayList<>();
/* 492 */     bricks.add("&6Gold: &f15");
/* 493 */     bricks.add("&2Quantity: &f10");
/* 494 */     yml.addDefault("workshop.bricks.lore", bricks);
/*     */     
/* 496 */     yml.addDefault("workshop.mossstone.displayname", "&7Moss Stone");
/* 497 */     ArrayList<String> mossstone = new ArrayList<>();
/* 498 */     mossstone.add("&6Gold: &f15");
/* 499 */     mossstone.add("&2Quantity: &f10");
/* 500 */     yml.addDefault("workshop.mossstone.lore", mossstone);
/*     */     
/* 502 */     yml.addDefault("workshop.leaves.displayname", "&7Leaves");
/* 503 */     ArrayList<String> leaves = new ArrayList<>();
/* 504 */     leaves.add("&6Gold: &f15");
/* 505 */     leaves.add("&2Quantity: &f10");
/* 506 */     yml.addDefault("workshop.leaves.lore", leaves);
/*     */ 
/*     */     
/* 509 */     yml.addDefault("market.flintandsteel.displayname", "&eFlint and Steel");
/* 510 */     ArrayList<String> flintandsteel = new ArrayList<>();
/* 511 */     flintandsteel.add("&6Gold: &f5");
/* 512 */     flintandsteel.add("&2Quantity: &f1");
/* 513 */     yml.addDefault("workshop.flintandsteel.lore", flintandsteel);
/*     */     
/* 515 */     yml.addDefault("market.cobweb.displayname", "&eCobweb");
/* 516 */     ArrayList<String> cobweb = new ArrayList<>();
/* 517 */     cobweb.add("&6Gold: &f5");
/* 518 */     cobweb.add("&2Quantity: &f5");
/* 519 */     yml.addDefault("workshop.cobweb.lore", cobweb);
/*     */     
/* 521 */     yml.addDefault("market.torches.displayname", "&eTorches");
/* 522 */     ArrayList<String> torches = new ArrayList<>();
/* 523 */     torches.add("&6Gold: &f5");
/* 524 */     torches.add("&2Quantity: &f12");
/* 525 */     yml.addDefault("workshop.torches.lore", torches);
/*     */     
/* 527 */     yml.addDefault("market.boat.displayname", "&eBoat");
/* 528 */     ArrayList<String> boat = new ArrayList<>();
/* 529 */     boat.add("&6Gold: &f2");
/* 530 */     boat.add("&2Quantity: &f1");
/* 531 */     yml.addDefault("workshop.boat.lore", boat);
/*     */     
/* 533 */     yml.addDefault("sabotage.tnt.displayname", "&cTNT");
/* 534 */     ArrayList<String> tnt = new ArrayList<>();
/* 535 */     tnt.add("&6Gold: &f5");
/* 536 */     tnt.add("&2Quantity: &f1");
/* 537 */     yml.addDefault("sabotage.tnt.lore", tnt);
/*     */     
/* 539 */     yml.addDefault("kennel.dog.displayname", "&cDog");
/* 540 */     ArrayList<String> dog = new ArrayList<>();
/* 541 */     dog.add("&6Gold: &f50");
/* 542 */     dog.add("&2Quantity: &f1");
/* 543 */     yml.addDefault("kennel.dog.lore", dog);
/*     */     
/* 545 */     yml.addDefault("kennel.dog2.displayname", "&cDogs");
/* 546 */     ArrayList<String> dog2 = new ArrayList<>();
/* 547 */     dog2.add("&6Gold: &f75");
/* 548 */     dog2.add("&2Quantity: &f2");
/* 549 */     yml.addDefault("kennel.dog2.lore", dog2);
/*     */     
/* 551 */     yml.addDefault("kennel.dog3.displayname", "&cDogs");
/* 552 */     ArrayList<String> dog3 = new ArrayList<>();
/* 553 */     dog3.add("&6Gold: &f100");
/* 554 */     dog3.add("&2Quantity: &f3");
/* 555 */     yml.addDefault("kennel.dog3.lore", dog3);
/*     */     
/* 557 */     yml.addDefault("armory.ironarmor.displayname", "&fIron Armor");
/* 558 */     ArrayList<String> iron_armor = new ArrayList();
/* 559 */     iron_armor.add("&6Gold: &f40");
/* 560 */     iron_armor.add("&2Quantity: &f1");
/* 561 */     yml.addDefault("armory.ironarmor.lore", iron_armor);
/*     */     
/* 563 */     yml.addDefault("armory.ironhorsearmor.displayname", "&fIron Horse Armor");
/* 564 */     ArrayList<String> ironhorsearmor = new ArrayList();
/* 565 */     ironhorsearmor.add("&6Gold: &f80");
/* 566 */     ironhorsearmor.add("&2Quantity: &f1");
/* 567 */     yml.addDefault("armory.ironhorsearmor.lore", ironhorsearmor);
/*     */     
/* 569 */     yml.addDefault("armory.diamondarmor.displayname", "&fDiamond Armor");
/* 570 */     ArrayList<String> diamondarmor = new ArrayList();
/* 571 */     diamondarmor.add("&6Gold: &f80");
/* 572 */     diamondarmor.add("&2Quantity: &f1");
/* 573 */     yml.addDefault("armory.diamondarmor.lore", diamondarmor);
/*     */     
/* 575 */     yml.addDefault("armory.diamondhorsearmor.displayname", "&fDiamond Horse Armor");
/* 576 */     ArrayList<String> diamondhorsearmor = new ArrayList();
/* 577 */     diamondhorsearmor.add("&6Gold: &f80");
/* 578 */     diamondhorsearmor.add("&2Quantity: &f1");
/* 579 */     yml.addDefault("armory.diamondhorsearmor.lore", diamondhorsearmor);
/*     */     
/* 581 */     yml.addDefault("pvp-disabled", "{prefix} &eP'rhaps wait for the PvP, get me? &a:p");
/* 582 */     yml.addDefault("x-attacked", "&e&l{villager} Attacked");
/* 583 */     yml.addDefault("yellow-building-explode", "{prefix} &eThe Yellow Team's {building} &6will explode in 15 seconds!");
/* 584 */     yml.addDefault("blue-building-explode", "{prefix} &eThe &9Blue Team's {building} &6will explode in 15 seconds!");
/* 585 */     yml.addDefault("green-building-explode", "{prefix} &eThe &aGreen Team's {building} &6will explode in 15 seconds!");
/* 586 */     yml.addDefault("red-building-explode", "{prefix} &eThe &cRed Team's {building} &6will explode in 15 seconds!");
/*     */     
/* 588 */     ArrayList<String> age2_lore = new ArrayList();
/* 589 */     age2_lore.add("&eChange to Age 2");
/* 590 */     age2_lore.add("&3Wood: &f1250");
/* 591 */     age2_lore.add("&3Stone: &f750");
/* 592 */     yml.addDefault("change.age2-lore", age2_lore);
/*     */     
/* 594 */     ArrayList<String> age3_lore = new ArrayList();
/* 595 */     age3_lore.add("&eChange to Age 3");
/* 596 */     age3_lore.add("&3Wood: &f2250");
/* 597 */     age3_lore.add("&3Stone: &f1250");
/* 598 */     yml.addDefault("change.age3-lore", age3_lore);
/*     */     
/* 600 */     ArrayList<String> age4_lore = new ArrayList();
/* 601 */     age4_lore.add("&eChange to Age 4");
/* 602 */     age4_lore.add("&3Wood: &f4250");
/* 603 */     age4_lore.add("&3Stone: &f3150");
/* 604 */     yml.addDefault("change.age4-lore", age4_lore);
/*     */     
/* 606 */     yml.addDefault("archery.bow.displayname", "&8Bow");
/* 607 */     ArrayList<String> bow_lore = new ArrayList<>();
/* 608 */     bow_lore.add("&6Gold: &f30");
/* 609 */     bow_lore.add("&2Quantity: &f1");
/* 610 */     yml.addDefault("archery.bow.lore", bow_lore);
/*     */     
/* 612 */     yml.addDefault("archery.arrows5.displayname", "&8Arrows");
/* 613 */     ArrayList<String> a5_lore = new ArrayList<>();
/* 614 */     a5_lore.add("&6Gold: &f5");
/* 615 */     a5_lore.add("&2Quantity: &f5");
/* 616 */     yml.addDefault("archery.arrows5.lore", a5_lore);
/*     */     
/* 618 */     yml.addDefault("archery.arrows10.displayname", "&8Arrows");
/* 619 */     ArrayList<String> a10_lore = new ArrayList<>();
/* 620 */     a10_lore.add("&6Gold: &f7");
/* 621 */     a10_lore.add("&2Quantity: &f10");
/* 622 */     yml.addDefault("archery.arrows10.lore", a10_lore);
/*     */     
/* 624 */     yml.addDefault("stable.horse.displayname", "&8Horse");
/* 625 */     ArrayList<String> horse_lore = new ArrayList<>();
/* 626 */     horse_lore.add("&6Gold: &f30");
/* 627 */     horse_lore.add("&2Quantity: &f1");
/* 628 */     yml.addDefault("stable.horse.lore", horse_lore);
/*     */     
/* 630 */     yml.addDefault("trifarrow.arrow.displayname", "&8Exploding Arrows");
/* 631 */     ArrayList<String> arrow_explode = new ArrayList<>();
/* 632 */     arrow_explode.add("&6Gold: &f20");
/* 633 */     arrow_explode.add("&2Quantity: &f1");
/* 634 */     yml.addDefault("trifarrow.arrow.lore", arrow_explode);
/*     */ 
/*     */     
/* 637 */     yml.addDefault("lab.swiftness.name", "&dPotion of Swiftness");
/* 638 */     yml.addDefault("lab.swiftness.lore", price(Integer.valueOf(35), Integer.valueOf(1)));
/* 639 */     yml.addDefault("lab.fireresistance.name", "&dPotion of Fire Resistance");
/* 640 */     yml.addDefault("lab.fireresistance.lore", price(Integer.valueOf(35), Integer.valueOf(1)));
/* 641 */     yml.addDefault("lab.healing.name", "&dPotion of Healing");
/* 642 */     yml.addDefault("lab.healing.lore", price(Integer.valueOf(35), Integer.valueOf(1)));
/* 643 */     yml.addDefault("lab.nightvision.name", "&dPotion of Night Vision");
/* 644 */     yml.addDefault("lab.nightvision.lore", price(Integer.valueOf(35), Integer.valueOf(1)));
/* 645 */     yml.addDefault("lab.leaping.name", "&dPotion of Leaping");
/* 646 */     yml.addDefault("lab.leaping.lore", price(Integer.valueOf(35), Integer.valueOf(1)));
/* 647 */     yml.addDefault("lab.waterbreathing.name", "&dPotion of Water Breathing");
/* 648 */     yml.addDefault("lab.waterbreathing.lore", price(Integer.valueOf(35), Integer.valueOf(1)));
/* 649 */     yml.addDefault("lab.splashswiftness.name", "&dPotion of Swiftness");
/* 650 */     yml.addDefault("lab.splashswiftness.lore", price(Integer.valueOf(75), Integer.valueOf(1)));
/* 651 */     yml.addDefault("lab.regeneration.name", "&dPotion of Regeneration");
/* 652 */     yml.addDefault("lab.regeneration.lore", price(Integer.valueOf(50), Integer.valueOf(1)));
/* 653 */     yml.addDefault("lab.splashleaping.name", "&dPotion of Leaping");
/* 654 */     yml.addDefault("lab.splashleaping.lore", price(Integer.valueOf(75), Integer.valueOf(1)));
/*     */ 
/*     */     
/* 657 */     yml.addDefault("guild.sharpness.name", "&bSharpness 1");
/* 658 */     yml.addDefault("guild.sharpness.lore", price(Integer.valueOf(20), Integer.valueOf(1)));
/* 659 */     yml.addDefault("guild.knockback.name", "&bKnockback 1");
/* 660 */     yml.addDefault("guild.knockback.lore", price(Integer.valueOf(10), Integer.valueOf(1)));
/* 661 */     yml.addDefault("guild.protection.name", "&bProtection 1");
/* 662 */     yml.addDefault("guild.protection.lore", price(Integer.valueOf(20), Integer.valueOf(1)));
/* 663 */     yml.addDefault("guild.thorns.name", "&bThorns 1");
/* 664 */     yml.addDefault("guild.thorns.lore", price(Integer.valueOf(10), Integer.valueOf(1)));
/* 665 */     yml.addDefault("guild.featherfalling.name", "&bFeather Falling 1");
/* 666 */     yml.addDefault("guild.featherfalling.lore", price(Integer.valueOf(10), Integer.valueOf(1)));
/* 667 */     yml.addDefault("guild.projectileprotection.name", "&bProjectile Protection 1");
/* 668 */     yml.addDefault("guild.projectileprotection.lore", price(Integer.valueOf(10), Integer.valueOf(1)));
/* 669 */     yml.addDefault("guild.fireprotection.name", "&bFire Protection 1");
/* 670 */     yml.addDefault("guild.fireprotection.lore", price(Integer.valueOf(10), Integer.valueOf(1)));
/* 671 */     yml.addDefault("guild.power.name", "&bFire Protection 1");
/* 672 */     yml.addDefault("guild.power.lore", price(Integer.valueOf(20), Integer.valueOf(1)));
/* 673 */     yml.addDefault("guild.punch.name", "&bPunch 1");
/* 674 */     yml.addDefault("guild.punch.lore", price(Integer.valueOf(10), Integer.valueOf(1)));
/* 675 */     yml.addDefault("stats.displayname", "&e&lMy stats");
/* 676 */     yml.addDefault("stats.wins", "&3Wins: &a%wins%");
/* 677 */     yml.addDefault("stats.kills", "&3Kills: &a%kills%");
/* 678 */     yml.addDefault("stats.deaths", "&3Deaths: &a%deaths%");
/* 679 */     yml.addDefault("stats.gamesplayed", "&3Games Played: &a%games%");
/* 680 */     yml.addDefault("stats.kingskilled", "&3Kings Killed: &a%kings%");
/* 681 */     yml.addDefault("vip-kick", "§cYou've got kicked because a vip joined the server.");
/*     */     
/* 683 */     yml.addDefault("cantDo", "{prefix} &cYou can't do this!");
/* 684 */     yml.addDefault("cantDoNow", "{prefix} &cYou can't do this right now!");
/* 685 */     yml.addDefault("notInGame", "{prefix} &cYou are not playing!");
/* 686 */     yml.addDefault("stuckTp", "{prefix} &7Teleporting in 5 seconds. Don't move!");
/* 687 */     yml.addDefault("stuckMove", "{prefix} &cYou moved! Teleport cancelled!");
/*     */     
/* 689 */     yml.options().copyDefaults(true);
/*     */     try {
/* 691 */       yml.save(file);
/* 692 */     } catch (IOException e) {
/* 693 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static ArrayList<String> price(Integer price, Integer quantity) {
/* 698 */     ArrayList<String> arrayList = new ArrayList();
/* 699 */     arrayList.add("&6Gold: &f" + price);
/* 700 */     arrayList.add("&2Quantity: &f" + quantity);
/* 701 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static String getMsg(String string) {
/* 705 */     return yml.getString(string).replace("{prefix}", Main.PREFIX).replace('&', '§');
/*     */   }
/*     */   
/*     */   public static ArrayList<String> getArray(String string) {
/* 709 */     return (ArrayList<String>)yml.getStringList(string);
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\configuration\Messages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */