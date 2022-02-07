// automatically generated by the FlatBuffers compiler, do not modify

package com.google.ar.university.lullmodel;

import java.nio.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * Data type for 3-dimensional vector values to be stored in a VariantDef.
 */
public final class DataVec3 extends Table {
  public static DataVec3 getRootAsDataVec3(ByteBuffer _bb) { return getRootAsDataVec3(_bb, new DataVec3()); }
  public static DataVec3 getRootAsDataVec3(ByteBuffer _bb, DataVec3 obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public DataVec3 __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public Vec3 value() { return value(new Vec3()); }
  public Vec3 value(Vec3 obj) { int o = __offset(4); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }

  public static void startDataVec3(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addValue(FlatBufferBuilder builder, int valueOffset) { builder.addStruct(0, valueOffset, 0); }
  public static int endDataVec3(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

