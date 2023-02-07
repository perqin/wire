// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.redacted_test.RedactedChild in redacted_test.proto
package com.squareup.wire.protos.redacted;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class RedactedChild extends Message<RedactedChild, RedactedChild.Builder> {
  public static final ProtoAdapter<RedactedChild> ADAPTER = new ProtoAdapter_RedactedChild();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_A = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String a;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.protos.redacted.RedactedFields#ADAPTER"
  )
  public final RedactedFields b;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.protos.redacted.NotRedacted#ADAPTER"
  )
  public final NotRedacted c;

  public RedactedChild(String a, RedactedFields b, NotRedacted c) {
    this(a, b, c, ByteString.EMPTY);
  }

  public RedactedChild(String a, RedactedFields b, NotRedacted c, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.a = a;
    builder.b = b;
    builder.c = c;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof RedactedChild)) return false;
    RedactedChild o = (RedactedChild) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(a, o.a)
        && Internal.equals(b, o.b)
        && Internal.equals(c, o.c);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (a != null ? a.hashCode() : 0);
      result = result * 37 + (b != null ? b.hashCode() : 0);
      result = result * 37 + (c != null ? c.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (a != null) builder.append(", a=").append(Internal.sanitize(a));
    if (b != null) builder.append(", b=").append(b);
    if (c != null) builder.append(", c=").append(c);
    return builder.replace(0, 2, "RedactedChild{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<RedactedChild, Builder> {
    public String a;

    public RedactedFields b;

    public NotRedacted c;

    public Builder() {
    }

    public Builder a(String a) {
      this.a = a;
      return this;
    }

    public Builder b(RedactedFields b) {
      this.b = b;
      return this;
    }

    public Builder c(NotRedacted c) {
      this.c = c;
      return this;
    }

    @Override
    public RedactedChild build() {
      return new RedactedChild(a, b, c, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_RedactedChild extends ProtoAdapter<RedactedChild> {
    public ProtoAdapter_RedactedChild() {
      super(FieldEncoding.LENGTH_DELIMITED, RedactedChild.class, "type.googleapis.com/squareup.protos.redacted_test.RedactedChild", Syntax.PROTO_2, null, "redacted_test.proto");
    }

    @Override
    public int encodedSize(RedactedChild value) {
      int result = 0;
      result += ProtoAdapter.STRING.encodedSizeWithTag(1, value.a);
      result += RedactedFields.ADAPTER.encodedSizeWithTag(2, value.b);
      result += NotRedacted.ADAPTER.encodedSizeWithTag(3, value.c);
      result += value.unknownFields().size();
      return result;
    }

    @Override
    public void encode(ProtoWriter writer, RedactedChild value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.a);
      RedactedFields.ADAPTER.encodeWithTag(writer, 2, value.b);
      NotRedacted.ADAPTER.encodeWithTag(writer, 3, value.c);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public void encode(ReverseProtoWriter writer, RedactedChild value) throws IOException {
      writer.writeBytes(value.unknownFields());
      NotRedacted.ADAPTER.encodeWithTag(writer, 3, value.c);
      RedactedFields.ADAPTER.encodeWithTag(writer, 2, value.b);
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.a);
    }

    @Override
    public RedactedChild decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.a(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.b(RedactedFields.ADAPTER.decode(reader)); break;
          case 3: builder.c(NotRedacted.ADAPTER.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public RedactedChild redact(RedactedChild value) {
      Builder builder = value.newBuilder();
      if (builder.b != null) builder.b = RedactedFields.ADAPTER.redact(builder.b);
      if (builder.c != null) builder.c = NotRedacted.ADAPTER.redact(builder.c);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}