package org.adligo.ctx.jse.api;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.adligo.ctx.jse.JseCtxMutant;
import org.adligo.ctx.shared.CtxParams;
import org.adligo.tests4j4jj.JjApiTrial;
import org.junit.jupiter.api.Test;

public class JseCtxMutantApiTrial extends JjApiTrial {

  @Test
  public void testCtxCreationSimpleDefaultClass() {
    JseCtxMutant ctx = new JseCtxMutant();
    String s = ctx.create(String.class);
    equals("", s);
    notSame(s, ctx.create(String.class));
    notSame(s, ctx.create(String.class.getName()));
    notSame(s, ctx.get(String.class));
    notSame(s, ctx.get(String.class.getName()));
  }

  @Test
  public void testCtxCreationSimpleDefaultString() {
    JseCtxMutant ctx = new JseCtxMutant();
    Object s = ctx.create(String.class.getName());
    equals("", s);
    notSame(s, ctx.create(String.class));
    notSame(s, ctx.create(String.class.getName()));
    notSame(s, ctx.get(String.class));
    notSame(s, ctx.get(String.class.getName()));
  }

  @Test
  public void testCtxCreationComplexDefaultClass() {
    JseCtxMutant ctx = new JseCtxMutant();
    CtxObjectExt s = ctx.create(CtxObjectExt.class);
    notNull(s);
    notSame(s, ctx.create(CtxObjectExt.class));
    notSame(s, ctx.create(CtxObjectExt.class.getName()));
    notSame(s, ctx.get(CtxObjectExt.class));
    notSame(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxCreationComplexDefaultString() {
    JseCtxMutant ctx = new JseCtxMutant();
    Object s = ctx.create(CtxObjectExt.class.getName());
    notNull(s);
    notSame(s, ctx.create(CtxObjectExt.class));
    notSame(s, ctx.create(CtxObjectExt.class.getName()));
    notSame(s, ctx.get(CtxObjectExt.class));
    notSame(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxCreationComplexOptionalClass() {
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setContextClasses(Set.of(CtxObjectExt.class)));
    CtxObjectExt s = ctx.create(CtxObjectExt.class);
    notNull(s);
    notSame(s, ctx.create(CtxObjectExt.class));
    notSame(s, ctx.create(CtxObjectExt.class.getName()));
    notSame(s, ctx.get(CtxObjectExt.class));
    notSame(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxCreationComplexOptionalString() {
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setContextClasses(Set.of(CtxObjectExt.class)));
    Object s = ctx.create(CtxObjectExt.class.getName());
    notNull(s);
    notSame(s, ctx.create(CtxObjectExt.class));
    notSame(s, ctx.create(CtxObjectExt.class.getName()));
    notSame(s, ctx.get(CtxObjectExt.class));
    notSame(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxCreationFunctionalSupplierClass() {
    AtomicInteger ai = new AtomicInteger();
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setCreator(String.class, () -> "hello world " + ai.incrementAndGet()));
    Object s = ctx.create(String.class);
    equals("hello world 1", s);
    notSame(s, ctx.create(String.class));
    notSame(s, ctx.create(String.class.getName()));
    notSame(s, ctx.get(String.class));
    notSame(s, ctx.get(String.class.getName()));
  }

  @Test
  public void testCtxCreationFunctionalSupplierString() {
    AtomicInteger ai = new AtomicInteger();
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setCreator(String.class, () -> "hello world " + ai.incrementAndGet()));
    Object s = ctx.create(String.class.getName());
    equals("hello world 1", s);
    notSame(s, ctx.create(String.class));
    notSame(s, ctx.create(String.class.getName()));
    notSame(s, ctx.get(String.class));
    notSame(s, ctx.get(String.class.getName()));
  }
  

  @Test
  public void testCtxGetSimpleDefaultClass() {
    JseCtxMutant ctx = new JseCtxMutant();
    String s = ctx.get(String.class);
    equals("", s);
    same(s, ctx.get(String.class));
    same(s, ctx.get(String.class.getName()));
  }

  @Test
  public void testCtxGetSimpleDefaultString() {
    JseCtxMutant ctx = new JseCtxMutant();
    Object s = ctx.get(String.class.getName());
    equals("", s);
    same(s, ctx.get(String.class));
    same(s, ctx.get(String.class.getName()));
  }

  @Test
  public void testCtxGetComplexDefaultClass() {
    JseCtxMutant ctx = new JseCtxMutant();
    CtxObjectExt s = ctx.get(CtxObjectExt.class);
    notNull(s);
    same(s, ctx.get(CtxObjectExt.class));
    same(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxGetComplexDefaultString() {
    JseCtxMutant ctx = new JseCtxMutant();
    Object s = ctx.get(CtxObjectExt.class.getName());
    notNull(s);
    same(s, ctx.get(CtxObjectExt.class));
    same(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxGetComplexOptionalClass() {
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setContextClasses(Set.of(CtxObjectExt.class)));
    CtxObjectExt s = ctx.get(CtxObjectExt.class);
    notNull(s);
    same(s, ctx.get(CtxObjectExt.class));
    same(s, ctx.get(CtxObjectExt.class.getName()));
  }

  @Test
  public void testCtxGetComplexOptionalString() {
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setContextClasses(Set.of(CtxObjectExt.class)));
    Object s = ctx.get(CtxObjectExt.class.getName());
    notNull(s);
    same(s, ctx.get(CtxObjectExt.class.getName()));
    same(s, ctx.get(CtxObjectExt.class));
  }

  @Test
  public void testCtxGetFunctionalSupplierClass() {
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setCreator(String.class, () -> "hello world"));
    Object s = ctx.get(String.class);
    equals("hello world", s);
    same(s, ctx.get(String.class));
    same(s, ctx.get(String.class.getName()));
  }

  @Test
  public void testCtxGetFunctionalSupplierString() {
    JseCtxMutant ctx = new JseCtxMutant(new CtxParams()
        .setCreator(String.class, () -> "hello world"));
    Object s = ctx.get(String.class.getName());
    equals("hello world", s);
    same(s, ctx.get(String.class.getName()));
    same(s, ctx.get(String.class));
  }
}

