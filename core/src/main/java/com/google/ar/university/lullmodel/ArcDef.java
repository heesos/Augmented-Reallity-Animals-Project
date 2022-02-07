// automatically generated by the FlatBuffers compiler, do not modify

package com.google.ar.university.lullmodel;

import java.nio.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * ArcDef defines a portion of a circulur annulus.
 */
public final class ArcDef extends Struct {
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public ArcDef __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * The angle (in radians) in which the start of the arc should be poised at.
   * 0 = vertical [0,1]. PI = [0,-1], PI/2 = [1,0].
   */
  public float startAngle() { return bb.getFloat(bb_pos + 0); }
  /**
   * Size of the arc measured in radians. PI = half circle, 2 PI = full circle.
   */
  public float angleSize() { return bb.getFloat(bb_pos + 4); }
  /**
   * Inner radius of the arc.
   */
  public float innerRadius() { return bb.getFloat(bb_pos + 8); }
  /**
   * Outer radius of the arc.
   */
  public float outerRadius() { return bb.getFloat(bb_pos + 12); }
  /**
   * Number of samples used for drawing the arc.
   */
  public int numSamples() { return bb.getInt(bb_pos + 16); }

  public static int createArcDef(FlatBufferBuilder builder, float startAngle, float angleSize, float innerRadius, float outerRadius, int numSamples) {
    builder.prep(4, 20);
    builder.putInt(numSamples);
    builder.putFloat(outerRadius);
    builder.putFloat(innerRadius);
    builder.putFloat(angleSize);
    builder.putFloat(startAngle);
    return builder.offset();
  }
}

