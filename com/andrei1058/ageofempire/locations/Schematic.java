/*    */ package com.andrei1058.ageofempire.locations;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Schematic
/*    */ {
/*    */   private short[] blocks;
/*    */   private byte[] data;
/*    */   private short width;
/*    */   private short lenght;
/*    */   private short height;
/*    */   
/*    */   public Schematic(short[] blocks, byte[] data, short width, short lenght, short height) {
/* 14 */     this.blocks = blocks;
/* 15 */     this.data = data;
/* 16 */     this.width = width;
/* 17 */     this.lenght = lenght;
/* 18 */     this.height = height;
/*    */   }
/*    */ 
/*    */   
/*    */   public short[] getBlocks() {
/* 23 */     return this.blocks;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte[] getData() {
/* 28 */     return this.data;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getWidth() {
/* 33 */     return this.width;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getLenght() {
/* 38 */     return this.lenght;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getHeight() {
/* 43 */     return this.height;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\locations\Schematic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */