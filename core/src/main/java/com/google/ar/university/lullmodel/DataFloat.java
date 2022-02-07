// automatically generated by the FlatBuffers compiler, do not modify

package com.google.ar.university.lullmodel;

import java.nio.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * Data type for floating-point values to be stored in a VariantDef.
 */
public final class DataFloat extends Table {
  public static DataFloat getRootAsDataFloat(ByteBuffer _bb) { return getRootAsDataFloat(_bb, new DataFloat()); }
  public static DataFloat getRootAsDataFloat(ByteBuffer _bb, DataFloat obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public DataFloat __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public float value() { int o = __offset(4); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }

  public static int createDataFloat(FlatBufferBuilder builder,
      float value) {
    builder.startObject(1);
    DataFloat.addValue(builder, value);
    return DataFloat.endDataFloat(builder);
  }

  public static void startDataFloat(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addValue(FlatBufferBuilder builder, float value) { builder.addFloat(0, value, 0.0f); }
  public static int endDataFloat(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

