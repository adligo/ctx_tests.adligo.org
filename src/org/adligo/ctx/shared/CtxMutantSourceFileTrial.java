package org.adligo.ctx.shared;

import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

public class CtxMutantSourceFileTrial extends JjSourceFileTrial {

  @Test
  public void testAddInstanceNullName() {
    isTrue(false);
  }

  @Test
  public void testAddInstanceNullInstance() {
    isTrue(false);
  }

  @Test
  public void testAddInstanceHappyPath() {
    isTrue(false);
  }

  @Test
  public void testAddSupplierNullName() {
    isTrue(false);
  }

  @Test
  public void testAddSupplierNullSupplier() {
    isTrue(false);
  }

  @Test
  public void testAddSupplierHappyPath() {
    isTrue(false);
  }
  
  @Test
  public void testConstructorWithZeroArgs() {
    notNull(new CtxParams());
  }
  
  @Test
  public void tesConstructorWithZeroArgs() {
    notNull(new CtxParams());
  }  

  @Test
  public void tesGetCreationMap() {
    notNull(new CtxParams().getCreationMap());
  }  
  
  @Test
  public void tesGetInstanceMap() {
    notNull(new CtxParams().getInstanceMap());
  }  
}
