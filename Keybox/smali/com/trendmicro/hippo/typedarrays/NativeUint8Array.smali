.class public Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;
.super Lcom/trendmicro/hippo/typedarrays/NativeTypedArrayView;
.source "NativeUint8Array.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/trendmicro/hippo/typedarrays/NativeTypedArrayView<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# static fields
.field private static final CLASS_NAME:Ljava/lang/String; = "Uint8Array"

.field private static final serialVersionUID:J = -0x2e7b8779a3e233afL


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27
    invoke-direct {p0}, Lcom/trendmicro/hippo/typedarrays/NativeTypedArrayView;-><init>()V

    .line 28
    return-void
.end method

.method public constructor <init>(I)V
    .locals 3
    .param p1, "len"    # I

    .line 37
    new-instance v0, Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;

    int-to-double v1, p1

    invoke-direct {v0, v1, v2}, Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;-><init>(D)V

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;-><init>(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;II)V

    .line 38
    return-void
.end method

.method public constructor <init>(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;II)V
    .locals 0
    .param p1, "ab"    # Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;
    .param p2, "off"    # I
    .param p3, "len"    # I

    .line 32
    invoke-direct {p0, p1, p2, p3, p3}, Lcom/trendmicro/hippo/typedarrays/NativeTypedArrayView;-><init>(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;III)V

    .line 33
    return-void
.end method

.method public static init(Lcom/trendmicro/hippo/Context;Lcom/trendmicro/hippo/Scriptable;Z)V
    .locals 2
    .param p0, "cx"    # Lcom/trendmicro/hippo/Context;
    .param p1, "scope"    # Lcom/trendmicro/hippo/Scriptable;
    .param p2, "sealed"    # Z

    .line 48
    new-instance v0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;

    invoke-direct {v0}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;-><init>()V

    .line 49
    .local v0, "a":Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;
    const/4 v1, 0x6

    invoke-virtual {v0, v1, p1, p2}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->exportAsJSClass(ILcom/trendmicro/hippo/Scriptable;Z)Lcom/trendmicro/hippo/IdFunctionObject;

    .line 50
    return-void
.end method


# virtual methods
.method protected bridge synthetic construct(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;II)Lcom/trendmicro/hippo/typedarrays/NativeTypedArrayView;
    .locals 0

    .line 19
    invoke-virtual {p0, p1, p2, p3}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->construct(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;II)Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;

    move-result-object p1

    return-object p1
.end method

.method protected construct(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;II)Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;
    .locals 1
    .param p1, "ab"    # Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;
    .param p2, "off"    # I
    .param p3, "len"    # I

    .line 55
    new-instance v0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;

    invoke-direct {v0, p1, p2, p3}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;-><init>(Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;II)V

    return-object v0
.end method

.method public get(I)Ljava/lang/Integer;
    .locals 1
    .param p1, "i"    # I

    .line 96
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->checkIndex(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 99
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->js_get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0

    .line 97
    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public bridge synthetic get(I)Ljava/lang/Object;
    .locals 0

    .line 19
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->get(I)Ljava/lang/Integer;

    move-result-object p1

    return-object p1
.end method

.method public getBytesPerElement()I
    .locals 1

    .line 61
    const/4 v0, 0x1

    return v0
.end method

.method public getClassName()Ljava/lang/String;
    .locals 1

    .line 43
    const-string v0, "Uint8Array"

    return-object v0
.end method

.method protected js_get(I)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I

    .line 76
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->checkIndex(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 77
    sget-object v0, Lcom/trendmicro/hippo/Undefined;->instance:Ljava/lang/Object;

    return-object v0

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->arrayBuffer:Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;

    iget-object v0, v0, Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;->buffer:[B

    iget v1, p0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->offset:I

    add-int/2addr v1, p1

    invoke-static {v0, v1}, Lcom/trendmicro/hippo/typedarrays/ByteIo;->readUint8([BI)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected js_set(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "index"    # I
    .param p2, "c"    # Ljava/lang/Object;

    .line 85
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->checkIndex(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    sget-object v0, Lcom/trendmicro/hippo/Undefined;->instance:Ljava/lang/Object;

    return-object v0

    .line 88
    :cond_0
    invoke-static {p2}, Lcom/trendmicro/hippo/typedarrays/Conversions;->toUint8(Ljava/lang/Object;)I

    move-result v0

    .line 89
    .local v0, "val":I
    iget-object v1, p0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->arrayBuffer:Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;

    iget-object v1, v1, Lcom/trendmicro/hippo/typedarrays/NativeArrayBuffer;->buffer:[B

    iget v2, p0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->offset:I

    add-int/2addr v2, p1

    invoke-static {v1, v2, v0}, Lcom/trendmicro/hippo/typedarrays/ByteIo;->writeUint8([BII)V

    .line 90
    const/4 v1, 0x0

    return-object v1
.end method

.method protected bridge synthetic realThis(Lcom/trendmicro/hippo/Scriptable;Lcom/trendmicro/hippo/IdFunctionObject;)Lcom/trendmicro/hippo/typedarrays/NativeTypedArrayView;
    .locals 0

    .line 19
    invoke-virtual {p0, p1, p2}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->realThis(Lcom/trendmicro/hippo/Scriptable;Lcom/trendmicro/hippo/IdFunctionObject;)Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;

    move-result-object p1

    return-object p1
.end method

.method protected realThis(Lcom/trendmicro/hippo/Scriptable;Lcom/trendmicro/hippo/IdFunctionObject;)Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;
    .locals 1
    .param p1, "thisObj"    # Lcom/trendmicro/hippo/Scriptable;
    .param p2, "f"    # Lcom/trendmicro/hippo/IdFunctionObject;

    .line 67
    instance-of v0, p1, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;

    if-eqz v0, :cond_0

    .line 70
    move-object v0, p1

    check-cast v0, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;

    return-object v0

    .line 68
    :cond_0
    invoke-static {p2}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->incompatibleCallError(Lcom/trendmicro/hippo/IdFunctionObject;)Lcom/trendmicro/hippo/EcmaError;

    move-result-object v0

    throw v0
.end method

.method public set(ILjava/lang/Integer;)Ljava/lang/Integer;
    .locals 1
    .param p1, "i"    # I
    .param p2, "aByte"    # Ljava/lang/Integer;

    .line 105
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->checkIndex(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 108
    invoke-virtual {p0, p1, p2}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->js_set(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0

    .line 106
    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public bridge synthetic set(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 19
    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2}, Lcom/trendmicro/hippo/typedarrays/NativeUint8Array;->set(ILjava/lang/Integer;)Ljava/lang/Integer;

    move-result-object p1

    return-object p1
.end method
