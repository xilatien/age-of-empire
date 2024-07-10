/*    */ package org.jnbt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ByteTag
/*    */   extends Tag
/*    */ {
/*    */   private final byte value;
/*    */   
/*    */   public ByteTag(String name, byte value) {
/* 53 */     super(name);
/* 54 */     this.value = value;
/*    */   }
/*    */ 
/*    */   
/*    */   public Byte getValue() {
/* 59 */     return Byte.valueOf(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     String name = getName();
/* 65 */     String append = "";
/* 66 */     if (name != null && !name.equals("")) {
/* 67 */       append = "(\"" + getName() + "\")";
/*    */     }
/* 69 */     return "TAG_Byte" + append + ": " + this.value;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\org\jnbt\ByteTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */