/*     */ package com.andrei1058.ageofempire.commands;
/*     */ 
/*     */ import com.andrei1058.ageofempire.configuration.Settings;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Setup
/*     */   implements CommandExecutor
/*     */ {
/*  23 */   private static ArrayList<Player> setup = new ArrayList<>();
/*  24 */   private static HashMap<Player, Location> loc = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender s, Command c, String st, String[] args) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: instanceof org/bukkit/command/ConsoleCommandSender
/*     */     //   4: ifeq -> 17
/*     */     //   7: aload_1
/*     */     //   8: ldc 'This plugin is for players!'
/*     */     //   10: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   15: iconst_1
/*     */     //   16: ireturn
/*     */     //   17: getstatic com/andrei1058/ageofempire/Main.SETUP : Z
/*     */     //   20: ifne -> 25
/*     */     //   23: iconst_1
/*     */     //   24: ireturn
/*     */     //   25: aload_1
/*     */     //   26: checkcast org/bukkit/entity/Player
/*     */     //   29: astore #5
/*     */     //   31: aload_2
/*     */     //   32: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   35: ldc 'setup'
/*     */     //   37: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   40: ifeq -> 4121
/*     */     //   43: aload #4
/*     */     //   45: arraylength
/*     */     //   46: ifne -> 191
/*     */     //   49: getstatic com/andrei1058/ageofempire/commands/Setup.setup : Ljava/util/ArrayList;
/*     */     //   52: aload #5
/*     */     //   54: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   57: ifeq -> 135
/*     */     //   60: aload #5
/*     */     //   62: ldc '§9§lAge Of Empire §c§lSetup:'
/*     */     //   64: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   69: aload #5
/*     */     //   71: ldc '§7/s setSpawn <Blue/Red/Green/Yellow>'
/*     */     //   73: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   78: aload #5
/*     */     //   80: ldc '§7/s addSmallPlot <team> <id>'
/*     */     //   82: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   87: aload #5
/*     */     //   89: ldc '§7/s addMediumPlot <team> <id>'
/*     */     //   91: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   96: aload #5
/*     */     //   98: ldc '§7/s addLargePlot <team> <id>'
/*     */     //   100: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   105: aload #5
/*     */     //   107: ldc '§7/s setForum <Blue/Red/Green/Yellow>'
/*     */     //   109: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   114: aload #5
/*     */     //   116: ldc '§7/s addXp'
/*     */     //   118: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   123: aload #5
/*     */     //   125: ldc '§e/s saveMap'
/*     */     //   127: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   132: goto -> 189
/*     */     //   135: aload #5
/*     */     //   137: ldc '§9§lAge Of Empire §c§lSetup:'
/*     */     //   139: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   144: aload #5
/*     */     //   146: ldc '§7/s setLobby'
/*     */     //   148: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   153: aload #5
/*     */     //   155: ldc '§7/s addMap <worldName>'
/*     */     //   157: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   162: aload #5
/*     */     //   164: ldc '§7/s editMap <worldName>'
/*     */     //   166: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   171: aload #5
/*     */     //   173: ldc '§7/s mapsList'
/*     */     //   175: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   180: aload #5
/*     */     //   182: ldc '§c/s finishSetup'
/*     */     //   184: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   189: iconst_1
/*     */     //   190: ireturn
/*     */     //   191: aload #4
/*     */     //   193: arraylength
/*     */     //   194: iconst_1
/*     */     //   195: if_icmpne -> 629
/*     */     //   198: aload #4
/*     */     //   200: iconst_0
/*     */     //   201: aaload
/*     */     //   202: ldc 'setlobby'
/*     */     //   204: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   207: ifeq -> 234
/*     */     //   210: aload #5
/*     */     //   212: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   217: ldc 'Spawns.Lobby'
/*     */     //   219: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   222: aload #5
/*     */     //   224: ldc '§3Lobby set!'
/*     */     //   226: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   231: goto -> 455
/*     */     //   234: aload #4
/*     */     //   236: iconst_0
/*     */     //   237: aaload
/*     */     //   238: ldc 'addmap'
/*     */     //   240: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   243: ifeq -> 258
/*     */     //   246: aload #5
/*     */     //   248: ldc '§eUsage: §7/s addMap <worldName>'
/*     */     //   250: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   255: goto -> 455
/*     */     //   258: aload #4
/*     */     //   260: iconst_0
/*     */     //   261: aaload
/*     */     //   262: ldc 'editmap'
/*     */     //   264: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   267: ifeq -> 282
/*     */     //   270: aload #5
/*     */     //   272: ldc '§eUsage: §7/s editMap <worldName>'
/*     */     //   274: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   279: goto -> 455
/*     */     //   282: aload #4
/*     */     //   284: iconst_0
/*     */     //   285: aaload
/*     */     //   286: ldc 'mapslist'
/*     */     //   288: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   291: ifeq -> 373
/*     */     //   294: aload #5
/*     */     //   296: ldc '§a§lAvailable Maps:'
/*     */     //   298: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   303: invokestatic load : ()Lorg/bukkit/configuration/file/YamlConfiguration;
/*     */     //   306: ldc 'Arenas'
/*     */     //   308: invokevirtual getStringList : (Ljava/lang/String;)Ljava/util/List;
/*     */     //   311: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   316: astore #6
/*     */     //   318: aload #6
/*     */     //   320: invokeinterface hasNext : ()Z
/*     */     //   325: ifeq -> 370
/*     */     //   328: aload #6
/*     */     //   330: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   335: checkcast java/lang/String
/*     */     //   338: astore #7
/*     */     //   340: aload #5
/*     */     //   342: new java/lang/StringBuilder
/*     */     //   345: dup
/*     */     //   346: invokespecial <init> : ()V
/*     */     //   349: ldc '§7- '
/*     */     //   351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   354: aload #7
/*     */     //   356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   359: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   362: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   367: goto -> 318
/*     */     //   370: goto -> 455
/*     */     //   373: aload #4
/*     */     //   375: iconst_0
/*     */     //   376: aaload
/*     */     //   377: ldc 'setspawn'
/*     */     //   379: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   382: ifeq -> 397
/*     */     //   385: aload #5
/*     */     //   387: ldc '§eUsage: §7/s setspawn <Blue/Red/Green/Yellow>'
/*     */     //   389: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   394: goto -> 455
/*     */     //   397: aload #4
/*     */     //   399: iconst_0
/*     */     //   400: aaload
/*     */     //   401: ldc 'finishsetup'
/*     */     //   403: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   406: ifeq -> 434
/*     */     //   409: iconst_0
/*     */     //   410: invokestatic togglesetup : (Z)V
/*     */     //   413: aload #5
/*     */     //   415: ldc '§cSetup done!'
/*     */     //   417: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   422: invokestatic getConsoleSender : ()Lorg/bukkit/command/ConsoleCommandSender;
/*     */     //   425: ldc 'restart'
/*     */     //   427: invokestatic dispatchCommand : (Lorg/bukkit/command/CommandSender;Ljava/lang/String;)Z
/*     */     //   430: pop
/*     */     //   431: goto -> 455
/*     */     //   434: aload #4
/*     */     //   436: iconst_0
/*     */     //   437: aaload
/*     */     //   438: ldc 'setpos'
/*     */     //   440: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   443: ifeq -> 455
/*     */     //   446: aload #5
/*     */     //   448: ldc '§eUsage: §7/s setPos <1/2> <Blue/Red/Green/Yellow>'
/*     */     //   450: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   455: getstatic com/andrei1058/ageofempire/commands/Setup.setup : Ljava/util/ArrayList;
/*     */     //   458: aload #5
/*     */     //   460: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   463: ifeq -> 4121
/*     */     //   466: aload #4
/*     */     //   468: iconst_0
/*     */     //   469: aaload
/*     */     //   470: ldc 'savemap'
/*     */     //   472: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   475: ifeq -> 509
/*     */     //   478: aload #5
/*     */     //   480: getstatic com/andrei1058/ageofempire/commands/Setup.loc : Ljava/util/HashMap;
/*     */     //   483: aload #5
/*     */     //   485: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   488: checkcast org/bukkit/Location
/*     */     //   491: invokeinterface teleport : (Lorg/bukkit/Location;)Z
/*     */     //   496: pop
/*     */     //   497: getstatic com/andrei1058/ageofempire/commands/Setup.setup : Ljava/util/ArrayList;
/*     */     //   500: aload #5
/*     */     //   502: invokevirtual remove : (Ljava/lang/Object;)Z
/*     */     //   505: pop
/*     */     //   506: goto -> 4121
/*     */     //   509: aload #4
/*     */     //   511: iconst_0
/*     */     //   512: aaload
/*     */     //   513: ldc 'addsmallplot'
/*     */     //   515: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   518: ifeq -> 533
/*     */     //   521: aload #5
/*     */     //   523: ldc '§cUsage: §7/s addSmallPlot <team> <id>'
/*     */     //   525: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   530: goto -> 4121
/*     */     //   533: aload #4
/*     */     //   535: iconst_0
/*     */     //   536: aaload
/*     */     //   537: ldc 'addmediumplot'
/*     */     //   539: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   542: ifeq -> 557
/*     */     //   545: aload #5
/*     */     //   547: ldc '§cUsage: §7/s addMediumPlot <team> <id>'
/*     */     //   549: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   554: goto -> 4121
/*     */     //   557: aload #4
/*     */     //   559: iconst_0
/*     */     //   560: aaload
/*     */     //   561: ldc 'addlargeplot'
/*     */     //   563: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   566: ifeq -> 581
/*     */     //   569: aload #5
/*     */     //   571: ldc '§cUsage: §7/s addLargePlot <team> <id>'
/*     */     //   573: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   578: goto -> 4121
/*     */     //   581: aload #4
/*     */     //   583: iconst_0
/*     */     //   584: aaload
/*     */     //   585: ldc 'setforum'
/*     */     //   587: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   590: ifeq -> 605
/*     */     //   593: aload #5
/*     */     //   595: ldc '§cUsage: §7/s setForum <Blue/Red/Yellow/Green>'
/*     */     //   597: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   602: goto -> 4121
/*     */     //   605: aload #4
/*     */     //   607: iconst_0
/*     */     //   608: aaload
/*     */     //   609: ldc 'addxp'
/*     */     //   611: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   614: ifeq -> 4121
/*     */     //   617: aload #5
/*     */     //   619: ldc '§cUsage: §7/s addxp <number>'
/*     */     //   621: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   626: goto -> 4121
/*     */     //   629: aload #4
/*     */     //   631: arraylength
/*     */     //   632: iconst_2
/*     */     //   633: if_icmpne -> 1889
/*     */     //   636: aload #4
/*     */     //   638: iconst_0
/*     */     //   639: aaload
/*     */     //   640: ldc 'addmap'
/*     */     //   642: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   645: ifeq -> 779
/*     */     //   648: new java/io/File
/*     */     //   651: dup
/*     */     //   652: aload #4
/*     */     //   654: iconst_1
/*     */     //   655: aaload
/*     */     //   656: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   659: invokevirtual exists : ()Z
/*     */     //   662: ifeq -> 767
/*     */     //   665: invokestatic load : ()Lorg/bukkit/configuration/file/YamlConfiguration;
/*     */     //   668: ldc 'Arenas'
/*     */     //   670: invokevirtual getStringList : (Ljava/lang/String;)Ljava/util/List;
/*     */     //   673: aload #4
/*     */     //   675: iconst_1
/*     */     //   676: aaload
/*     */     //   677: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   682: ifeq -> 716
/*     */     //   685: aload #5
/*     */     //   687: new java/lang/StringBuilder
/*     */     //   690: dup
/*     */     //   691: invokespecial <init> : ()V
/*     */     //   694: ldc '§ePlease use: §7/s editMap '
/*     */     //   696: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   699: aload #4
/*     */     //   701: iconst_1
/*     */     //   702: aaload
/*     */     //   703: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   706: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   709: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   714: iconst_1
/*     */     //   715: ireturn
/*     */     //   716: aload #5
/*     */     //   718: ldc '§ePlease wait!'
/*     */     //   720: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   725: new org/bukkit/WorldCreator
/*     */     //   728: dup
/*     */     //   729: aload #4
/*     */     //   731: iconst_1
/*     */     //   732: aaload
/*     */     //   733: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   736: invokestatic createWorld : (Lorg/bukkit/WorldCreator;)Lorg/bukkit/World;
/*     */     //   739: pop
/*     */     //   740: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
/*     */     //   743: getstatic com/andrei1058/ageofempire/Main.plugin : Lcom/andrei1058/ageofempire/Main;
/*     */     //   746: aload #5
/*     */     //   748: aload #4
/*     */     //   750: <illegal opcode> run : (Lorg/bukkit/entity/Player;[Ljava/lang/String;)Ljava/lang/Runnable;
/*     */     //   755: ldc2_w 100
/*     */     //   758: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
/*     */     //   763: pop
/*     */     //   764: goto -> 891
/*     */     //   767: aload #5
/*     */     //   769: ldc '§cI can't find this map!'
/*     */     //   771: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   776: goto -> 891
/*     */     //   779: aload #4
/*     */     //   781: iconst_0
/*     */     //   782: aaload
/*     */     //   783: ldc 'editmap'
/*     */     //   785: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   788: ifeq -> 891
/*     */     //   791: new java/io/File
/*     */     //   794: dup
/*     */     //   795: aload #4
/*     */     //   797: iconst_1
/*     */     //   798: aaload
/*     */     //   799: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   802: invokevirtual exists : ()Z
/*     */     //   805: ifeq -> 882
/*     */     //   808: invokestatic load : ()Lorg/bukkit/configuration/file/YamlConfiguration;
/*     */     //   811: ldc 'Arenas'
/*     */     //   813: invokevirtual getStringList : (Ljava/lang/String;)Ljava/util/List;
/*     */     //   816: aload #4
/*     */     //   818: iconst_1
/*     */     //   819: aaload
/*     */     //   820: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   825: ifeq -> 882
/*     */     //   828: aload #5
/*     */     //   830: ldc '§ePlease wait!'
/*     */     //   832: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   837: new org/bukkit/WorldCreator
/*     */     //   840: dup
/*     */     //   841: aload #4
/*     */     //   843: iconst_1
/*     */     //   844: aaload
/*     */     //   845: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   848: invokestatic createWorld : (Lorg/bukkit/WorldCreator;)Lorg/bukkit/World;
/*     */     //   851: pop
/*     */     //   852: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
/*     */     //   855: getstatic com/andrei1058/ageofempire/Main.plugin : Lcom/andrei1058/ageofempire/Main;
/*     */     //   858: new com/andrei1058/ageofempire/commands/Setup$1
/*     */     //   861: dup
/*     */     //   862: aload_0
/*     */     //   863: aload #5
/*     */     //   865: aload #4
/*     */     //   867: invokespecial <init> : (Lcom/andrei1058/ageofempire/commands/Setup;Lorg/bukkit/entity/Player;[Ljava/lang/String;)V
/*     */     //   870: ldc2_w 100
/*     */     //   873: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
/*     */     //   878: pop
/*     */     //   879: goto -> 891
/*     */     //   882: aload #5
/*     */     //   884: ldc '§cUnknown map!'
/*     */     //   886: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   891: getstatic com/andrei1058/ageofempire/commands/Setup.setup : Ljava/util/ArrayList;
/*     */     //   894: aload #5
/*     */     //   896: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   899: ifeq -> 4121
/*     */     //   902: aload #4
/*     */     //   904: iconst_0
/*     */     //   905: aaload
/*     */     //   906: ldc 'setspawn'
/*     */     //   908: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   911: ifeq -> 1304
/*     */     //   914: aload #4
/*     */     //   916: iconst_1
/*     */     //   917: aaload
/*     */     //   918: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   921: astore #6
/*     */     //   923: iconst_m1
/*     */     //   924: istore #7
/*     */     //   926: aload #6
/*     */     //   928: invokevirtual hashCode : ()I
/*     */     //   931: lookupswitch default -> 1033, -734239628 -> 1004, 112785 -> 988, 3027034 -> 972, 98619139 -> 1020
/*     */     //   972: aload #6
/*     */     //   974: ldc 'blue'
/*     */     //   976: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   979: ifeq -> 1033
/*     */     //   982: iconst_1
/*     */     //   983: istore #7
/*     */     //   985: goto -> 1033
/*     */     //   988: aload #6
/*     */     //   990: ldc 'red'
/*     */     //   992: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   995: ifeq -> 1033
/*     */     //   998: iconst_2
/*     */     //   999: istore #7
/*     */     //   1001: goto -> 1033
/*     */     //   1004: aload #6
/*     */     //   1006: ldc 'yellow'
/*     */     //   1008: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1011: ifeq -> 1033
/*     */     //   1014: iconst_3
/*     */     //   1015: istore #7
/*     */     //   1017: goto -> 1033
/*     */     //   1020: aload #6
/*     */     //   1022: ldc 'green'
/*     */     //   1024: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1027: ifeq -> 1033
/*     */     //   1030: iconst_4
/*     */     //   1031: istore #7
/*     */     //   1033: iload #7
/*     */     //   1035: tableswitch default -> 1064, 1 -> 1076, 2 -> 1133, 3 -> 1190, 4 -> 1247
/*     */     //   1064: aload #5
/*     */     //   1066: ldc '§cChoices: <Blue/Red/Green/Yellow>'
/*     */     //   1068: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1073: goto -> 1301
/*     */     //   1076: aload #5
/*     */     //   1078: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1083: new java/lang/StringBuilder
/*     */     //   1086: dup
/*     */     //   1087: invokespecial <init> : ()V
/*     */     //   1090: ldc 'Spawns.'
/*     */     //   1092: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1095: aload #5
/*     */     //   1097: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1102: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1110: ldc '.Blue'
/*     */     //   1112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1115: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1118: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1121: aload #5
/*     */     //   1123: ldc '§7Blue spawn set!'
/*     */     //   1125: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1130: goto -> 1301
/*     */     //   1133: aload #5
/*     */     //   1135: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1140: new java/lang/StringBuilder
/*     */     //   1143: dup
/*     */     //   1144: invokespecial <init> : ()V
/*     */     //   1147: ldc 'Spawns.'
/*     */     //   1149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1152: aload #5
/*     */     //   1154: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1159: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1167: ldc '.Red'
/*     */     //   1169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1172: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1175: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1178: aload #5
/*     */     //   1180: ldc '§7Red spawn set!'
/*     */     //   1182: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1187: goto -> 1301
/*     */     //   1190: aload #5
/*     */     //   1192: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1197: new java/lang/StringBuilder
/*     */     //   1200: dup
/*     */     //   1201: invokespecial <init> : ()V
/*     */     //   1204: ldc 'Spawns.'
/*     */     //   1206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1209: aload #5
/*     */     //   1211: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1216: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1224: ldc '.Yellow'
/*     */     //   1226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1229: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1232: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1235: aload #5
/*     */     //   1237: ldc '§7Yellow spawn set!'
/*     */     //   1239: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1244: goto -> 1301
/*     */     //   1247: aload #5
/*     */     //   1249: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1254: new java/lang/StringBuilder
/*     */     //   1257: dup
/*     */     //   1258: invokespecial <init> : ()V
/*     */     //   1261: ldc 'Spawns.'
/*     */     //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1266: aload #5
/*     */     //   1268: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1273: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1281: ldc '.Green'
/*     */     //   1283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1286: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1289: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1292: aload #5
/*     */     //   1294: ldc '§7Green spawn set!'
/*     */     //   1296: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1301: goto -> 4121
/*     */     //   1304: aload #4
/*     */     //   1306: iconst_0
/*     */     //   1307: aaload
/*     */     //   1308: ldc 'addsmallplot'
/*     */     //   1310: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   1313: ifeq -> 1328
/*     */     //   1316: aload #5
/*     */     //   1318: ldc '§cUsage: §7/s addSmallPlot <team> <id>'
/*     */     //   1320: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1325: goto -> 4121
/*     */     //   1328: aload #4
/*     */     //   1330: iconst_0
/*     */     //   1331: aaload
/*     */     //   1332: ldc 'addmediumplot'
/*     */     //   1334: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   1337: ifeq -> 1352
/*     */     //   1340: aload #5
/*     */     //   1342: ldc '§cUsage: §7/s addMediumPlot <team> <id>'
/*     */     //   1344: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1349: goto -> 4121
/*     */     //   1352: aload #4
/*     */     //   1354: iconst_0
/*     */     //   1355: aaload
/*     */     //   1356: ldc 'addlargeplot'
/*     */     //   1358: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   1361: ifeq -> 1376
/*     */     //   1364: aload #5
/*     */     //   1366: ldc '§cUsage: §7/s addLargePlot <team> <id>'
/*     */     //   1368: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1373: goto -> 4121
/*     */     //   1376: aload #4
/*     */     //   1378: iconst_0
/*     */     //   1379: aaload
/*     */     //   1380: ldc 'setforum'
/*     */     //   1382: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   1385: ifeq -> 1780
/*     */     //   1388: aload #4
/*     */     //   1390: iconst_1
/*     */     //   1391: aaload
/*     */     //   1392: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1395: astore #6
/*     */     //   1397: iconst_m1
/*     */     //   1398: istore #7
/*     */     //   1400: aload #6
/*     */     //   1402: invokevirtual hashCode : ()I
/*     */     //   1405: lookupswitch default -> 1509, -734239628 -> 1480, 112785 -> 1464, 3027034 -> 1448, 98619139 -> 1496
/*     */     //   1448: aload #6
/*     */     //   1450: ldc 'blue'
/*     */     //   1452: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1455: ifeq -> 1509
/*     */     //   1458: iconst_1
/*     */     //   1459: istore #7
/*     */     //   1461: goto -> 1509
/*     */     //   1464: aload #6
/*     */     //   1466: ldc 'red'
/*     */     //   1468: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1471: ifeq -> 1509
/*     */     //   1474: iconst_2
/*     */     //   1475: istore #7
/*     */     //   1477: goto -> 1509
/*     */     //   1480: aload #6
/*     */     //   1482: ldc 'yellow'
/*     */     //   1484: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1487: ifeq -> 1509
/*     */     //   1490: iconst_3
/*     */     //   1491: istore #7
/*     */     //   1493: goto -> 1509
/*     */     //   1496: aload #6
/*     */     //   1498: ldc 'green'
/*     */     //   1500: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1503: ifeq -> 1509
/*     */     //   1506: iconst_4
/*     */     //   1507: istore #7
/*     */     //   1509: iload #7
/*     */     //   1511: tableswitch default -> 1540, 1 -> 1552, 2 -> 1609, 3 -> 1666, 4 -> 1723
/*     */     //   1540: aload #5
/*     */     //   1542: ldc '§cUsage: §7/s setForum <Blue/Red/Yellow/Green>'
/*     */     //   1544: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1549: goto -> 1777
/*     */     //   1552: aload #5
/*     */     //   1554: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1559: new java/lang/StringBuilder
/*     */     //   1562: dup
/*     */     //   1563: invokespecial <init> : ()V
/*     */     //   1566: ldc 'Forums.'
/*     */     //   1568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1571: aload #5
/*     */     //   1573: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1578: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1583: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1586: ldc '.Blue'
/*     */     //   1588: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1591: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1594: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1597: aload #5
/*     */     //   1599: ldc '§7Blue forum set!'
/*     */     //   1601: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1606: goto -> 1777
/*     */     //   1609: aload #5
/*     */     //   1611: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1616: new java/lang/StringBuilder
/*     */     //   1619: dup
/*     */     //   1620: invokespecial <init> : ()V
/*     */     //   1623: ldc 'Forums.'
/*     */     //   1625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1628: aload #5
/*     */     //   1630: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1635: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1640: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1643: ldc '.Red'
/*     */     //   1645: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1648: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1651: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1654: aload #5
/*     */     //   1656: ldc '§7Red forum set!'
/*     */     //   1658: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1663: goto -> 1777
/*     */     //   1666: aload #5
/*     */     //   1668: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1673: new java/lang/StringBuilder
/*     */     //   1676: dup
/*     */     //   1677: invokespecial <init> : ()V
/*     */     //   1680: ldc 'Forums.'
/*     */     //   1682: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1685: aload #5
/*     */     //   1687: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1692: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1700: ldc '.Yellow'
/*     */     //   1702: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1705: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1708: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1711: aload #5
/*     */     //   1713: ldc '§7Yellow forum set!'
/*     */     //   1715: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1720: goto -> 1777
/*     */     //   1723: aload #5
/*     */     //   1725: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1730: new java/lang/StringBuilder
/*     */     //   1733: dup
/*     */     //   1734: invokespecial <init> : ()V
/*     */     //   1737: ldc 'Forums.'
/*     */     //   1739: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1742: aload #5
/*     */     //   1744: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1749: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1754: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1757: ldc '.Green'
/*     */     //   1759: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1762: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1765: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1768: aload #5
/*     */     //   1770: ldc '§7Green forum set!'
/*     */     //   1772: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1777: goto -> 4121
/*     */     //   1780: aload #4
/*     */     //   1782: iconst_0
/*     */     //   1783: aaload
/*     */     //   1784: ldc 'addxp'
/*     */     //   1786: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   1789: ifeq -> 4121
/*     */     //   1792: aload #5
/*     */     //   1794: new java/lang/StringBuilder
/*     */     //   1797: dup
/*     */     //   1798: invokespecial <init> : ()V
/*     */     //   1801: ldc '§eXp '
/*     */     //   1803: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1806: aload #4
/*     */     //   1808: iconst_1
/*     */     //   1809: aaload
/*     */     //   1810: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1813: ldc ' lantern set!'
/*     */     //   1815: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1818: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1821: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1826: aload #5
/*     */     //   1828: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   1833: dconst_0
/*     */     //   1834: ldc2_w -1.0
/*     */     //   1837: dconst_0
/*     */     //   1838: invokevirtual add : (DDD)Lorg/bukkit/Location;
/*     */     //   1841: new java/lang/StringBuilder
/*     */     //   1844: dup
/*     */     //   1845: invokespecial <init> : ()V
/*     */     //   1848: ldc 'xp.'
/*     */     //   1850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1853: aload #5
/*     */     //   1855: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   1860: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1868: ldc '.'
/*     */     //   1870: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1873: aload #4
/*     */     //   1875: iconst_1
/*     */     //   1876: aaload
/*     */     //   1877: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1880: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1883: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   1886: goto -> 4121
/*     */     //   1889: aload #4
/*     */     //   1891: arraylength
/*     */     //   1892: iconst_3
/*     */     //   1893: if_icmpne -> 4112
/*     */     //   1896: getstatic com/andrei1058/ageofempire/commands/Setup.setup : Ljava/util/ArrayList;
/*     */     //   1899: aload #5
/*     */     //   1901: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   1904: ifeq -> 1907
/*     */     //   1907: aload #4
/*     */     //   1909: iconst_0
/*     */     //   1910: aaload
/*     */     //   1911: ldc 'setpos'
/*     */     //   1913: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   1916: ifeq -> 2460
/*     */     //   1919: aload #4
/*     */     //   1921: iconst_1
/*     */     //   1922: aaload
/*     */     //   1923: invokestatic isInt : (Ljava/lang/String;)Z
/*     */     //   1926: ifne -> 1940
/*     */     //   1929: aload #5
/*     */     //   1931: ldc '§cUsage: §7/s setPos <id> <Blue/Red/Green/Yellow>'
/*     */     //   1933: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   1938: iconst_1
/*     */     //   1939: ireturn
/*     */     //   1940: aload #4
/*     */     //   1942: iconst_2
/*     */     //   1943: aaload
/*     */     //   1944: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1947: astore #6
/*     */     //   1949: iconst_m1
/*     */     //   1950: istore #7
/*     */     //   1952: aload #6
/*     */     //   1954: invokevirtual hashCode : ()I
/*     */     //   1957: lookupswitch default -> 2061, -734239628 -> 2048, 112785 -> 2016, 3027034 -> 2000, 98619139 -> 2032
/*     */     //   2000: aload #6
/*     */     //   2002: ldc 'blue'
/*     */     //   2004: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2007: ifeq -> 2061
/*     */     //   2010: iconst_1
/*     */     //   2011: istore #7
/*     */     //   2013: goto -> 2061
/*     */     //   2016: aload #6
/*     */     //   2018: ldc 'red'
/*     */     //   2020: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2023: ifeq -> 2061
/*     */     //   2026: iconst_2
/*     */     //   2027: istore #7
/*     */     //   2029: goto -> 2061
/*     */     //   2032: aload #6
/*     */     //   2034: ldc 'green'
/*     */     //   2036: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2039: ifeq -> 2061
/*     */     //   2042: iconst_3
/*     */     //   2043: istore #7
/*     */     //   2045: goto -> 2061
/*     */     //   2048: aload #6
/*     */     //   2050: ldc 'yellow'
/*     */     //   2052: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2055: ifeq -> 2061
/*     */     //   2058: iconst_4
/*     */     //   2059: istore #7
/*     */     //   2061: iload #7
/*     */     //   2063: tableswitch default -> 2092, 1 -> 2104, 2 -> 2193, 3 -> 2282, 4 -> 2371
/*     */     //   2092: aload #5
/*     */     //   2094: ldc '§cChoices: <Blue/Red/Green/Yellow>'
/*     */     //   2096: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2101: goto -> 2457
/*     */     //   2104: aload #5
/*     */     //   2106: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2111: new java/lang/StringBuilder
/*     */     //   2114: dup
/*     */     //   2115: invokespecial <init> : ()V
/*     */     //   2118: ldc 'Region.'
/*     */     //   2120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2123: aload #5
/*     */     //   2125: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2130: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2138: ldc '.Blue.Pos'
/*     */     //   2140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2143: aload #4
/*     */     //   2145: iconst_1
/*     */     //   2146: aaload
/*     */     //   2147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2150: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2153: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2156: aload #5
/*     */     //   2158: new java/lang/StringBuilder
/*     */     //   2161: dup
/*     */     //   2162: invokespecial <init> : ()V
/*     */     //   2165: ldc '§7Blue pos'
/*     */     //   2167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2170: aload #4
/*     */     //   2172: iconst_1
/*     */     //   2173: aaload
/*     */     //   2174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2177: ldc ' set!'
/*     */     //   2179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2182: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2185: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2190: goto -> 2457
/*     */     //   2193: aload #5
/*     */     //   2195: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2200: new java/lang/StringBuilder
/*     */     //   2203: dup
/*     */     //   2204: invokespecial <init> : ()V
/*     */     //   2207: ldc 'Region.'
/*     */     //   2209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2212: aload #5
/*     */     //   2214: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2219: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2227: ldc '.Red.Pos'
/*     */     //   2229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2232: aload #4
/*     */     //   2234: iconst_1
/*     */     //   2235: aaload
/*     */     //   2236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2239: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2242: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2245: aload #5
/*     */     //   2247: new java/lang/StringBuilder
/*     */     //   2250: dup
/*     */     //   2251: invokespecial <init> : ()V
/*     */     //   2254: ldc '§7Red pos'
/*     */     //   2256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2259: aload #4
/*     */     //   2261: iconst_1
/*     */     //   2262: aaload
/*     */     //   2263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2266: ldc ' set!'
/*     */     //   2268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2271: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2274: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2279: goto -> 2457
/*     */     //   2282: aload #5
/*     */     //   2284: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2289: new java/lang/StringBuilder
/*     */     //   2292: dup
/*     */     //   2293: invokespecial <init> : ()V
/*     */     //   2296: ldc 'Region.'
/*     */     //   2298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2301: aload #5
/*     */     //   2303: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2308: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2316: ldc '.Green.Pos'
/*     */     //   2318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2321: aload #4
/*     */     //   2323: iconst_1
/*     */     //   2324: aaload
/*     */     //   2325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2328: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2331: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2334: aload #5
/*     */     //   2336: new java/lang/StringBuilder
/*     */     //   2339: dup
/*     */     //   2340: invokespecial <init> : ()V
/*     */     //   2343: ldc '§7Green pos'
/*     */     //   2345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2348: aload #4
/*     */     //   2350: iconst_1
/*     */     //   2351: aaload
/*     */     //   2352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2355: ldc ' set!'
/*     */     //   2357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2360: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2363: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2368: goto -> 2457
/*     */     //   2371: aload #5
/*     */     //   2373: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2378: new java/lang/StringBuilder
/*     */     //   2381: dup
/*     */     //   2382: invokespecial <init> : ()V
/*     */     //   2385: ldc 'Region.'
/*     */     //   2387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2390: aload #5
/*     */     //   2392: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2397: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2405: ldc '.Yellow.Pos'
/*     */     //   2407: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2410: aload #4
/*     */     //   2412: iconst_1
/*     */     //   2413: aaload
/*     */     //   2414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2417: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2420: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2423: aload #5
/*     */     //   2425: new java/lang/StringBuilder
/*     */     //   2428: dup
/*     */     //   2429: invokespecial <init> : ()V
/*     */     //   2432: ldc '§7Yellow pos'
/*     */     //   2434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2437: aload #4
/*     */     //   2439: iconst_1
/*     */     //   2440: aaload
/*     */     //   2441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2444: ldc ' set!'
/*     */     //   2446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2449: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2452: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2457: goto -> 4121
/*     */     //   2460: aload #4
/*     */     //   2462: iconst_0
/*     */     //   2463: aaload
/*     */     //   2464: ldc 'addsmallplot'
/*     */     //   2466: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   2469: ifeq -> 3012
/*     */     //   2472: aload #4
/*     */     //   2474: iconst_2
/*     */     //   2475: aaload
/*     */     //   2476: invokestatic isInt : (Ljava/lang/String;)Z
/*     */     //   2479: ifne -> 2493
/*     */     //   2482: aload #5
/*     */     //   2484: ldc '§cUsage: §7/s addSmallPlot <Red/Blue/Yellow/Green> <1/2..>'
/*     */     //   2486: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2491: iconst_1
/*     */     //   2492: ireturn
/*     */     //   2493: aload #4
/*     */     //   2495: iconst_1
/*     */     //   2496: aaload
/*     */     //   2497: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   2500: astore #6
/*     */     //   2502: iconst_m1
/*     */     //   2503: istore #7
/*     */     //   2505: aload #6
/*     */     //   2507: invokevirtual hashCode : ()I
/*     */     //   2510: lookupswitch default -> 2613, -734239628 -> 2600, 112785 -> 2584, 3027034 -> 2552, 98619139 -> 2568
/*     */     //   2552: aload #6
/*     */     //   2554: ldc 'blue'
/*     */     //   2556: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2559: ifeq -> 2613
/*     */     //   2562: iconst_1
/*     */     //   2563: istore #7
/*     */     //   2565: goto -> 2613
/*     */     //   2568: aload #6
/*     */     //   2570: ldc 'green'
/*     */     //   2572: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2575: ifeq -> 2613
/*     */     //   2578: iconst_2
/*     */     //   2579: istore #7
/*     */     //   2581: goto -> 2613
/*     */     //   2584: aload #6
/*     */     //   2586: ldc 'red'
/*     */     //   2588: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2591: ifeq -> 2613
/*     */     //   2594: iconst_3
/*     */     //   2595: istore #7
/*     */     //   2597: goto -> 2613
/*     */     //   2600: aload #6
/*     */     //   2602: ldc 'yellow'
/*     */     //   2604: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2607: ifeq -> 2613
/*     */     //   2610: iconst_4
/*     */     //   2611: istore #7
/*     */     //   2613: iload #7
/*     */     //   2615: tableswitch default -> 2644, 1 -> 2656, 2 -> 2745, 3 -> 2834, 4 -> 2923
/*     */     //   2644: aload #5
/*     */     //   2646: ldc '§cUsage: §7/s addSmallPlot <Red/Blue/Yellow/Green> <1/2...>'
/*     */     //   2648: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2653: goto -> 3009
/*     */     //   2656: aload #5
/*     */     //   2658: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2663: new java/lang/StringBuilder
/*     */     //   2666: dup
/*     */     //   2667: invokespecial <init> : ()V
/*     */     //   2670: ldc 'Plots.'
/*     */     //   2672: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2675: aload #5
/*     */     //   2677: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2682: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2687: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2690: ldc '.Blue.Small.'
/*     */     //   2692: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2695: aload #4
/*     */     //   2697: iconst_2
/*     */     //   2698: aaload
/*     */     //   2699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2702: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2705: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2708: aload #5
/*     */     //   2710: new java/lang/StringBuilder
/*     */     //   2713: dup
/*     */     //   2714: invokespecial <init> : ()V
/*     */     //   2717: ldc '§7Small Plot '
/*     */     //   2719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2722: aload #4
/*     */     //   2724: iconst_2
/*     */     //   2725: aaload
/*     */     //   2726: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2729: ldc ' was added to the Blue Team'
/*     */     //   2731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2734: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2737: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2742: goto -> 3009
/*     */     //   2745: aload #5
/*     */     //   2747: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2752: new java/lang/StringBuilder
/*     */     //   2755: dup
/*     */     //   2756: invokespecial <init> : ()V
/*     */     //   2759: ldc 'Plots.'
/*     */     //   2761: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2764: aload #5
/*     */     //   2766: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2771: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2776: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2779: ldc '.Green.Small.'
/*     */     //   2781: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2784: aload #4
/*     */     //   2786: iconst_2
/*     */     //   2787: aaload
/*     */     //   2788: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2791: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2794: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2797: aload #5
/*     */     //   2799: new java/lang/StringBuilder
/*     */     //   2802: dup
/*     */     //   2803: invokespecial <init> : ()V
/*     */     //   2806: ldc '§7Small Plot '
/*     */     //   2808: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2811: aload #4
/*     */     //   2813: iconst_2
/*     */     //   2814: aaload
/*     */     //   2815: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2818: ldc ' was added to the Green Team'
/*     */     //   2820: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2823: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2826: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2831: goto -> 3009
/*     */     //   2834: aload #5
/*     */     //   2836: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2841: new java/lang/StringBuilder
/*     */     //   2844: dup
/*     */     //   2845: invokespecial <init> : ()V
/*     */     //   2848: ldc 'Plots.'
/*     */     //   2850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2853: aload #5
/*     */     //   2855: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2860: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2868: ldc '.Red.Small.'
/*     */     //   2870: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2873: aload #4
/*     */     //   2875: iconst_2
/*     */     //   2876: aaload
/*     */     //   2877: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2880: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2883: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2886: aload #5
/*     */     //   2888: new java/lang/StringBuilder
/*     */     //   2891: dup
/*     */     //   2892: invokespecial <init> : ()V
/*     */     //   2895: ldc '§7Small Plot '
/*     */     //   2897: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2900: aload #4
/*     */     //   2902: iconst_2
/*     */     //   2903: aaload
/*     */     //   2904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2907: ldc ' was added to the Red Team'
/*     */     //   2909: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2912: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2915: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   2920: goto -> 3009
/*     */     //   2923: aload #5
/*     */     //   2925: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   2930: new java/lang/StringBuilder
/*     */     //   2933: dup
/*     */     //   2934: invokespecial <init> : ()V
/*     */     //   2937: ldc 'Plots.'
/*     */     //   2939: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2942: aload #5
/*     */     //   2944: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   2949: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   2954: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2957: ldc '.Yellow.Small.'
/*     */     //   2959: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2962: aload #4
/*     */     //   2964: iconst_2
/*     */     //   2965: aaload
/*     */     //   2966: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2969: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2972: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   2975: aload #5
/*     */     //   2977: new java/lang/StringBuilder
/*     */     //   2980: dup
/*     */     //   2981: invokespecial <init> : ()V
/*     */     //   2984: ldc '§7Small Plot '
/*     */     //   2986: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2989: aload #4
/*     */     //   2991: iconst_2
/*     */     //   2992: aaload
/*     */     //   2993: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2996: ldc ' was added to the Yellow Team'
/*     */     //   2998: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3001: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3004: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3009: goto -> 4121
/*     */     //   3012: aload #4
/*     */     //   3014: iconst_0
/*     */     //   3015: aaload
/*     */     //   3016: ldc 'addmediumplot'
/*     */     //   3018: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   3021: ifeq -> 3563
/*     */     //   3024: aload #4
/*     */     //   3026: iconst_2
/*     */     //   3027: aaload
/*     */     //   3028: invokestatic isInt : (Ljava/lang/String;)Z
/*     */     //   3031: ifne -> 3043
/*     */     //   3034: aload #5
/*     */     //   3036: ldc '§cUsage: §7/s addMediumPlot <team> <1/2/3..>'
/*     */     //   3038: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3043: aload #4
/*     */     //   3045: iconst_1
/*     */     //   3046: aaload
/*     */     //   3047: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   3050: astore #6
/*     */     //   3052: iconst_m1
/*     */     //   3053: istore #7
/*     */     //   3055: aload #6
/*     */     //   3057: invokevirtual hashCode : ()I
/*     */     //   3060: lookupswitch default -> 3165, -734239628 -> 3136, 112785 -> 3120, 3027034 -> 3104, 98619139 -> 3152
/*     */     //   3104: aload #6
/*     */     //   3106: ldc 'blue'
/*     */     //   3108: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3111: ifeq -> 3165
/*     */     //   3114: iconst_1
/*     */     //   3115: istore #7
/*     */     //   3117: goto -> 3165
/*     */     //   3120: aload #6
/*     */     //   3122: ldc 'red'
/*     */     //   3124: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3127: ifeq -> 3165
/*     */     //   3130: iconst_2
/*     */     //   3131: istore #7
/*     */     //   3133: goto -> 3165
/*     */     //   3136: aload #6
/*     */     //   3138: ldc 'yellow'
/*     */     //   3140: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3143: ifeq -> 3165
/*     */     //   3146: iconst_3
/*     */     //   3147: istore #7
/*     */     //   3149: goto -> 3165
/*     */     //   3152: aload #6
/*     */     //   3154: ldc 'green'
/*     */     //   3156: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3159: ifeq -> 3165
/*     */     //   3162: iconst_4
/*     */     //   3163: istore #7
/*     */     //   3165: iload #7
/*     */     //   3167: tableswitch default -> 3196, 1 -> 3208, 2 -> 3297, 3 -> 3386, 4 -> 3475
/*     */     //   3196: aload #5
/*     */     //   3198: ldc '§cUsage: §7/s addMediumPlot <team> <1/2/3...>'
/*     */     //   3200: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3205: goto -> 3561
/*     */     //   3208: aload #5
/*     */     //   3210: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3215: new java/lang/StringBuilder
/*     */     //   3218: dup
/*     */     //   3219: invokespecial <init> : ()V
/*     */     //   3222: ldc 'Plots.'
/*     */     //   3224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3227: aload #5
/*     */     //   3229: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3234: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3242: ldc '.Blue.Medium.'
/*     */     //   3244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3247: aload #4
/*     */     //   3249: iconst_2
/*     */     //   3250: aaload
/*     */     //   3251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3254: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3257: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3260: aload #5
/*     */     //   3262: new java/lang/StringBuilder
/*     */     //   3265: dup
/*     */     //   3266: invokespecial <init> : ()V
/*     */     //   3269: ldc '§7Medium Plot '
/*     */     //   3271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3274: aload #4
/*     */     //   3276: iconst_2
/*     */     //   3277: aaload
/*     */     //   3278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3281: ldc ' was added to the Blue Team'
/*     */     //   3283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3286: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3289: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3294: goto -> 3561
/*     */     //   3297: aload #5
/*     */     //   3299: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3304: new java/lang/StringBuilder
/*     */     //   3307: dup
/*     */     //   3308: invokespecial <init> : ()V
/*     */     //   3311: ldc 'Plots.'
/*     */     //   3313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3316: aload #5
/*     */     //   3318: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3323: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3331: ldc '.Red.Medium.'
/*     */     //   3333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3336: aload #4
/*     */     //   3338: iconst_2
/*     */     //   3339: aaload
/*     */     //   3340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3343: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3346: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3349: aload #5
/*     */     //   3351: new java/lang/StringBuilder
/*     */     //   3354: dup
/*     */     //   3355: invokespecial <init> : ()V
/*     */     //   3358: ldc '§7Medium Plot '
/*     */     //   3360: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3363: aload #4
/*     */     //   3365: iconst_2
/*     */     //   3366: aaload
/*     */     //   3367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3370: ldc ' was added to the Red Team'
/*     */     //   3372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3375: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3378: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3383: goto -> 3561
/*     */     //   3386: aload #5
/*     */     //   3388: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3393: new java/lang/StringBuilder
/*     */     //   3396: dup
/*     */     //   3397: invokespecial <init> : ()V
/*     */     //   3400: ldc 'Plots.'
/*     */     //   3402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3405: aload #5
/*     */     //   3407: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3412: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3417: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3420: ldc '.Yellow.Medium.'
/*     */     //   3422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3425: aload #4
/*     */     //   3427: iconst_2
/*     */     //   3428: aaload
/*     */     //   3429: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3432: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3435: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3438: aload #5
/*     */     //   3440: new java/lang/StringBuilder
/*     */     //   3443: dup
/*     */     //   3444: invokespecial <init> : ()V
/*     */     //   3447: ldc '§7Medium Plot '
/*     */     //   3449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3452: aload #4
/*     */     //   3454: iconst_2
/*     */     //   3455: aaload
/*     */     //   3456: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3459: ldc ' was added to the Yellow Team'
/*     */     //   3461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3464: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3467: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3472: goto -> 3561
/*     */     //   3475: aload #5
/*     */     //   3477: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3482: new java/lang/StringBuilder
/*     */     //   3485: dup
/*     */     //   3486: invokespecial <init> : ()V
/*     */     //   3489: ldc 'Plots.'
/*     */     //   3491: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3494: aload #5
/*     */     //   3496: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3501: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3506: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3509: ldc '.Green.Medium.'
/*     */     //   3511: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3514: aload #4
/*     */     //   3516: iconst_2
/*     */     //   3517: aaload
/*     */     //   3518: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3521: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3524: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3527: aload #5
/*     */     //   3529: new java/lang/StringBuilder
/*     */     //   3532: dup
/*     */     //   3533: invokespecial <init> : ()V
/*     */     //   3536: ldc '§7Medium Plot '
/*     */     //   3538: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3541: aload #4
/*     */     //   3543: iconst_2
/*     */     //   3544: aaload
/*     */     //   3545: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3548: ldc ' was added to the Green Team'
/*     */     //   3550: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3553: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3556: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3561: iconst_1
/*     */     //   3562: ireturn
/*     */     //   3563: aload #4
/*     */     //   3565: iconst_0
/*     */     //   3566: aaload
/*     */     //   3567: ldc 'addlargeplot'
/*     */     //   3569: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
/*     */     //   3572: ifeq -> 4121
/*     */     //   3575: aload #4
/*     */     //   3577: iconst_2
/*     */     //   3578: aaload
/*     */     //   3579: invokestatic isInt : (Ljava/lang/String;)Z
/*     */     //   3582: ifne -> 3594
/*     */     //   3585: aload #5
/*     */     //   3587: ldc '§cUsage: §7/s addLargePlot <team> <1/2...>'
/*     */     //   3589: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3594: aload #4
/*     */     //   3596: iconst_1
/*     */     //   3597: aaload
/*     */     //   3598: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   3601: astore #6
/*     */     //   3603: iconst_m1
/*     */     //   3604: istore #7
/*     */     //   3606: aload #6
/*     */     //   3608: invokevirtual hashCode : ()I
/*     */     //   3611: lookupswitch default -> 3713, -734239628 -> 3684, 112785 -> 3668, 3027034 -> 3652, 98619139 -> 3700
/*     */     //   3652: aload #6
/*     */     //   3654: ldc 'blue'
/*     */     //   3656: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3659: ifeq -> 3713
/*     */     //   3662: iconst_1
/*     */     //   3663: istore #7
/*     */     //   3665: goto -> 3713
/*     */     //   3668: aload #6
/*     */     //   3670: ldc 'red'
/*     */     //   3672: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3675: ifeq -> 3713
/*     */     //   3678: iconst_2
/*     */     //   3679: istore #7
/*     */     //   3681: goto -> 3713
/*     */     //   3684: aload #6
/*     */     //   3686: ldc 'yellow'
/*     */     //   3688: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3691: ifeq -> 3713
/*     */     //   3694: iconst_3
/*     */     //   3695: istore #7
/*     */     //   3697: goto -> 3713
/*     */     //   3700: aload #6
/*     */     //   3702: ldc 'green'
/*     */     //   3704: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3707: ifeq -> 3713
/*     */     //   3710: iconst_4
/*     */     //   3711: istore #7
/*     */     //   3713: iload #7
/*     */     //   3715: tableswitch default -> 3744, 1 -> 3756, 2 -> 3845, 3 -> 3934, 4 -> 4023
/*     */     //   3744: aload #5
/*     */     //   3746: ldc '§cUsage: §7/s addLargePlot <team> <1/2...>'
/*     */     //   3748: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3753: goto -> 4109
/*     */     //   3756: aload #5
/*     */     //   3758: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3763: new java/lang/StringBuilder
/*     */     //   3766: dup
/*     */     //   3767: invokespecial <init> : ()V
/*     */     //   3770: ldc 'Plots.'
/*     */     //   3772: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3775: aload #5
/*     */     //   3777: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3782: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3787: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3790: ldc '.Blue.Large.'
/*     */     //   3792: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3795: aload #4
/*     */     //   3797: iconst_2
/*     */     //   3798: aaload
/*     */     //   3799: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3802: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3805: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3808: aload #5
/*     */     //   3810: new java/lang/StringBuilder
/*     */     //   3813: dup
/*     */     //   3814: invokespecial <init> : ()V
/*     */     //   3817: ldc '§7Large Plot '
/*     */     //   3819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3822: aload #4
/*     */     //   3824: iconst_2
/*     */     //   3825: aaload
/*     */     //   3826: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3829: ldc ' was added to the Blue Team'
/*     */     //   3831: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3834: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3837: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3842: goto -> 4109
/*     */     //   3845: aload #5
/*     */     //   3847: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3852: new java/lang/StringBuilder
/*     */     //   3855: dup
/*     */     //   3856: invokespecial <init> : ()V
/*     */     //   3859: ldc 'Plots.'
/*     */     //   3861: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3864: aload #5
/*     */     //   3866: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3871: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3876: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3879: ldc '.Red.Large.'
/*     */     //   3881: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3884: aload #4
/*     */     //   3886: iconst_2
/*     */     //   3887: aaload
/*     */     //   3888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3891: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3894: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3897: aload #5
/*     */     //   3899: new java/lang/StringBuilder
/*     */     //   3902: dup
/*     */     //   3903: invokespecial <init> : ()V
/*     */     //   3906: ldc '§7Large Plot '
/*     */     //   3908: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3911: aload #4
/*     */     //   3913: iconst_2
/*     */     //   3914: aaload
/*     */     //   3915: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3918: ldc ' was added to the Red Team'
/*     */     //   3920: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3923: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3926: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   3931: goto -> 4109
/*     */     //   3934: aload #5
/*     */     //   3936: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   3941: new java/lang/StringBuilder
/*     */     //   3944: dup
/*     */     //   3945: invokespecial <init> : ()V
/*     */     //   3948: ldc 'Plots.'
/*     */     //   3950: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3953: aload #5
/*     */     //   3955: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   3960: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   3965: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3968: ldc '.Yellow.Large.'
/*     */     //   3970: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3973: aload #4
/*     */     //   3975: iconst_2
/*     */     //   3976: aaload
/*     */     //   3977: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3980: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3983: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   3986: aload #5
/*     */     //   3988: new java/lang/StringBuilder
/*     */     //   3991: dup
/*     */     //   3992: invokespecial <init> : ()V
/*     */     //   3995: ldc '§7Large Plot '
/*     */     //   3997: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4000: aload #4
/*     */     //   4002: iconst_2
/*     */     //   4003: aaload
/*     */     //   4004: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4007: ldc ' was added to the Yellow Team'
/*     */     //   4009: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4012: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4015: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   4020: goto -> 4109
/*     */     //   4023: aload #5
/*     */     //   4025: invokeinterface getLocation : ()Lorg/bukkit/Location;
/*     */     //   4030: new java/lang/StringBuilder
/*     */     //   4033: dup
/*     */     //   4034: invokespecial <init> : ()V
/*     */     //   4037: ldc 'Plots.'
/*     */     //   4039: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4042: aload #5
/*     */     //   4044: invokeinterface getWorld : ()Lorg/bukkit/World;
/*     */     //   4049: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   4054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4057: ldc '.Green.Large.'
/*     */     //   4059: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4062: aload #4
/*     */     //   4064: iconst_2
/*     */     //   4065: aaload
/*     */     //   4066: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4069: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4072: invokestatic saveLoc : (Lorg/bukkit/Location;Ljava/lang/String;)V
/*     */     //   4075: aload #5
/*     */     //   4077: new java/lang/StringBuilder
/*     */     //   4080: dup
/*     */     //   4081: invokespecial <init> : ()V
/*     */     //   4084: ldc '§7Large Plot '
/*     */     //   4086: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4089: aload #4
/*     */     //   4091: iconst_2
/*     */     //   4092: aaload
/*     */     //   4093: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4096: ldc ' was added to the Green Team'
/*     */     //   4098: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4101: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4104: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   4109: goto -> 4121
/*     */     //   4112: aload #5
/*     */     //   4114: ldc '§cToo many arguments!'
/*     */     //   4116: invokeinterface sendMessage : (Ljava/lang/String;)V
/*     */     //   4121: iconst_0
/*     */     //   4122: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #28	-> 0
/*     */     //   #29	-> 7
/*     */     //   #30	-> 15
/*     */     //   #32	-> 17
/*     */     //   #33	-> 25
/*     */     //   #34	-> 31
/*     */     //   #35	-> 43
/*     */     //   #36	-> 49
/*     */     //   #37	-> 60
/*     */     //   #38	-> 69
/*     */     //   #39	-> 78
/*     */     //   #40	-> 87
/*     */     //   #41	-> 96
/*     */     //   #42	-> 105
/*     */     //   #43	-> 114
/*     */     //   #44	-> 123
/*     */     //   #46	-> 135
/*     */     //   #47	-> 144
/*     */     //   #48	-> 153
/*     */     //   #49	-> 162
/*     */     //   #50	-> 171
/*     */     //   #51	-> 180
/*     */     //   #53	-> 189
/*     */     //   #55	-> 191
/*     */     //   #56	-> 198
/*     */     //   #57	-> 210
/*     */     //   #58	-> 222
/*     */     //   #60	-> 234
/*     */     //   #61	-> 246
/*     */     //   #63	-> 258
/*     */     //   #64	-> 270
/*     */     //   #66	-> 282
/*     */     //   #67	-> 294
/*     */     //   #68	-> 303
/*     */     //   #69	-> 340
/*     */     //   #70	-> 367
/*     */     //   #72	-> 373
/*     */     //   #73	-> 385
/*     */     //   #75	-> 397
/*     */     //   #76	-> 409
/*     */     //   #77	-> 413
/*     */     //   #78	-> 422
/*     */     //   #80	-> 434
/*     */     //   #81	-> 446
/*     */     //   #83	-> 455
/*     */     //   #84	-> 466
/*     */     //   #85	-> 478
/*     */     //   #86	-> 497
/*     */     //   #88	-> 509
/*     */     //   #89	-> 521
/*     */     //   #91	-> 533
/*     */     //   #92	-> 545
/*     */     //   #94	-> 557
/*     */     //   #95	-> 569
/*     */     //   #97	-> 581
/*     */     //   #98	-> 593
/*     */     //   #100	-> 605
/*     */     //   #101	-> 617
/*     */     //   #104	-> 629
/*     */     //   #105	-> 636
/*     */     //   #106	-> 648
/*     */     //   #107	-> 665
/*     */     //   #108	-> 685
/*     */     //   #109	-> 714
/*     */     //   #111	-> 716
/*     */     //   #112	-> 725
/*     */     //   #113	-> 740
/*     */     //   #121	-> 767
/*     */     //   #124	-> 779
/*     */     //   #125	-> 791
/*     */     //   #126	-> 828
/*     */     //   #127	-> 837
/*     */     //   #128	-> 852
/*     */     //   #138	-> 882
/*     */     //   #141	-> 891
/*     */     //   #142	-> 902
/*     */     //   #143	-> 914
/*     */     //   #145	-> 1064
/*     */     //   #146	-> 1073
/*     */     //   #148	-> 1076
/*     */     //   #149	-> 1121
/*     */     //   #150	-> 1130
/*     */     //   #152	-> 1133
/*     */     //   #153	-> 1178
/*     */     //   #154	-> 1187
/*     */     //   #156	-> 1190
/*     */     //   #157	-> 1235
/*     */     //   #158	-> 1244
/*     */     //   #160	-> 1247
/*     */     //   #161	-> 1292
/*     */     //   #162	-> 1301
/*     */     //   #165	-> 1304
/*     */     //   #166	-> 1316
/*     */     //   #168	-> 1328
/*     */     //   #169	-> 1340
/*     */     //   #171	-> 1352
/*     */     //   #172	-> 1364
/*     */     //   #174	-> 1376
/*     */     //   #175	-> 1388
/*     */     //   #177	-> 1540
/*     */     //   #178	-> 1549
/*     */     //   #180	-> 1552
/*     */     //   #181	-> 1597
/*     */     //   #182	-> 1606
/*     */     //   #184	-> 1609
/*     */     //   #185	-> 1654
/*     */     //   #186	-> 1663
/*     */     //   #188	-> 1666
/*     */     //   #189	-> 1711
/*     */     //   #190	-> 1720
/*     */     //   #192	-> 1723
/*     */     //   #193	-> 1768
/*     */     //   #194	-> 1777
/*     */     //   #197	-> 1780
/*     */     //   #198	-> 1792
/*     */     //   #199	-> 1826
/*     */     //   #203	-> 1889
/*     */     //   #204	-> 1896
/*     */     //   #205	-> 1907
/*     */     //   #206	-> 1919
/*     */     //   #207	-> 1929
/*     */     //   #208	-> 1938
/*     */     //   #210	-> 1940
/*     */     //   #212	-> 2092
/*     */     //   #213	-> 2101
/*     */     //   #215	-> 2104
/*     */     //   #216	-> 2156
/*     */     //   #217	-> 2190
/*     */     //   #219	-> 2193
/*     */     //   #220	-> 2245
/*     */     //   #221	-> 2279
/*     */     //   #223	-> 2282
/*     */     //   #224	-> 2334
/*     */     //   #225	-> 2368
/*     */     //   #227	-> 2371
/*     */     //   #228	-> 2423
/*     */     //   #229	-> 2457
/*     */     //   #232	-> 2460
/*     */     //   #233	-> 2472
/*     */     //   #234	-> 2482
/*     */     //   #235	-> 2491
/*     */     //   #237	-> 2493
/*     */     //   #239	-> 2644
/*     */     //   #240	-> 2653
/*     */     //   #242	-> 2656
/*     */     //   #243	-> 2708
/*     */     //   #244	-> 2742
/*     */     //   #246	-> 2745
/*     */     //   #247	-> 2797
/*     */     //   #248	-> 2831
/*     */     //   #250	-> 2834
/*     */     //   #251	-> 2886
/*     */     //   #252	-> 2920
/*     */     //   #254	-> 2923
/*     */     //   #255	-> 2975
/*     */     //   #256	-> 3009
/*     */     //   #259	-> 3012
/*     */     //   #260	-> 3024
/*     */     //   #261	-> 3034
/*     */     //   #263	-> 3043
/*     */     //   #265	-> 3196
/*     */     //   #266	-> 3205
/*     */     //   #268	-> 3208
/*     */     //   #269	-> 3260
/*     */     //   #270	-> 3294
/*     */     //   #272	-> 3297
/*     */     //   #273	-> 3349
/*     */     //   #274	-> 3383
/*     */     //   #276	-> 3386
/*     */     //   #277	-> 3438
/*     */     //   #278	-> 3472
/*     */     //   #280	-> 3475
/*     */     //   #281	-> 3527
/*     */     //   #284	-> 3561
/*     */     //   #286	-> 3563
/*     */     //   #287	-> 3575
/*     */     //   #288	-> 3585
/*     */     //   #290	-> 3594
/*     */     //   #292	-> 3744
/*     */     //   #293	-> 3753
/*     */     //   #295	-> 3756
/*     */     //   #296	-> 3808
/*     */     //   #297	-> 3842
/*     */     //   #299	-> 3845
/*     */     //   #300	-> 3897
/*     */     //   #301	-> 3931
/*     */     //   #303	-> 3934
/*     */     //   #304	-> 3986
/*     */     //   #305	-> 4020
/*     */     //   #307	-> 4023
/*     */     //   #308	-> 4075
/*     */     //   #309	-> 4109
/*     */     //   #313	-> 4112
/*     */     //   #317	-> 4121
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   340	27	7	str	Ljava/lang/String;
/*     */     //   0	4123	0	this	Lcom/andrei1058/ageofempire/commands/Setup;
/*     */     //   0	4123	1	s	Lorg/bukkit/command/CommandSender;
/*     */     //   0	4123	2	c	Lorg/bukkit/command/Command;
/*     */     //   0	4123	3	st	Ljava/lang/String;
/*     */     //   0	4123	4	args	[Ljava/lang/String;
/*     */     //   31	4092	5	p	Lorg/bukkit/entity/Player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isInt(String str) {
/*     */     try {
/* 322 */       Integer.parseInt(str);
/* 323 */       return true;
/* 324 */     } catch (NumberFormatException e) {
/* 325 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\commands\Setup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */