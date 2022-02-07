// automatically generated by the FlatBuffers compiler, do not modify

package com.google.ar.university.lullmodel;

import java.nio.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * Internal table for VariantMapDef that associates a hash-value key with a
 * variant type.
 */
public final class KeyVariantPairDef extends Table {
  public static KeyVariantPairDef getRootAsKeyVariantPairDef(ByteBuffer _bb) { return getRootAsKeyVariantPairDef(_bb, new KeyVariantPairDef()); }
  public static KeyVariantPairDef getRootAsKeyVariantPairDef(ByteBuffer _bb, KeyVariantPairDef obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public KeyVariantPairDef __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String key() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer keyAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer keyInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public long hashKey() { int o = __offset(6); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }
  public byte valueType() { int o = __offset(8); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public Table value(Table obj) { int o = __offset(10); return o != 0 ? __union(obj, o) : null; }

  public static int createKeyVariantPairDef(FlatBufferBuilder builder,
      int keyOffset,
      long hash_key,
      byte value_type,
      int valueOffset) {
    builder.startObject(4);
    KeyVariantPairDef.addValue(builder, valueOffset);
    KeyVariantPairDef.addHashKey(builder, hash_key);
    KeyVariantPairDef.addKey(builder, keyOffset);
    KeyVariantPairDef.addValueType(builder, value_type);
    return KeyVariantPairDef.endKeyVariantPairDef(builder);
  }

  public static void startKeyVariantPairDef(FlatBufferBuilder builder) { builder.startObject(4); }
  public static void addKey(FlatBufferBuilder builder, int keyOffset) { builder.addOffset(0, keyOffset, 0); }
  public static void addHashKey(FlatBufferBuilder builder, long hashKey) { builder.addInt(1, (int)hashKey, (int)0L); }
  public static void addValueType(FlatBufferBuilder builder, byte valueType) { builder.addByte(2, valueType, 0); }
  public static void addValue(FlatBufferBuilder builder, int valueOffset) { builder.addOffset(3, valueOffset, 0); }
  public static int endKeyVariantPairDef(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

