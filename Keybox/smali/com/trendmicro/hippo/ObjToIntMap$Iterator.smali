.class public Lcom/trendmicro/hippo/ObjToIntMap$Iterator;
.super Ljava/lang/Object;
.source "ObjToIntMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/trendmicro/hippo/ObjToIntMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Iterator"
.end annotation


# instance fields
.field private cursor:I

.field private keys:[Ljava/lang/Object;

.field master:Lcom/trendmicro/hippo/ObjToIntMap;

.field private remaining:I

.field private values:[I


# direct methods
.method constructor <init>(Lcom/trendmicro/hippo/ObjToIntMap;)V
    .locals 0
    .param p1, "master"    # Lcom/trendmicro/hippo/ObjToIntMap;

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->master:Lcom/trendmicro/hippo/ObjToIntMap;

    .line 37
    return-void
.end method


# virtual methods
.method public done()Z
    .locals 1

    .line 52
    iget v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    if-gez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public getKey()Ljava/lang/Object;
    .locals 2

    .line 72
    iget-object v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->keys:[Ljava/lang/Object;

    iget v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    aget-object v0, v0, v1

    .line 73
    .local v0, "key":Ljava/lang/Object;
    sget-object v1, Lcom/trendmicro/hippo/UniqueTag;->NULL_VALUE:Lcom/trendmicro/hippo/UniqueTag;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    .line 74
    :cond_0
    return-object v0
.end method

.method public getValue()I
    .locals 2

    .line 78
    iget-object v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->values:[I

    iget v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    aget v0, v0, v1

    return v0
.end method

.method final init([Ljava/lang/Object;[II)V
    .locals 1
    .param p1, "keys"    # [Ljava/lang/Object;
    .param p2, "values"    # [I
    .param p3, "keyCount"    # I

    .line 40
    iput-object p1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->keys:[Ljava/lang/Object;

    .line 41
    iput-object p2, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->values:[I

    .line 42
    const/4 v0, -0x1

    iput v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    .line 43
    iput p3, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    .line 44
    return-void
.end method

.method public next()V
    .locals 2

    .line 56
    iget v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/trendmicro/hippo/Kit;->codeBug()Ljava/lang/RuntimeException;

    .line 57
    :cond_0
    iget v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    if-nez v0, :cond_1

    .line 58
    iput v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    .line 59
    iput v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    goto :goto_1

    .line 61
    :cond_1
    iget v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    :goto_0
    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    .line 62
    iget-object v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->keys:[Ljava/lang/Object;

    iget v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    aget-object v0, v0, v1

    .line 63
    .local v0, "key":Ljava/lang/Object;
    if-eqz v0, :cond_2

    invoke-static {}, Lcom/trendmicro/hippo/ObjToIntMap;->access$000()Ljava/lang/Object;

    move-result-object v1

    if-eq v0, v1, :cond_2

    .line 64
    iget v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->remaining:I

    .line 65
    nop

    .line 69
    .end local v0    # "key":Ljava/lang/Object;
    :goto_1
    return-void

    .line 61
    :cond_2
    iget v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    goto :goto_0
.end method

.method public setValue(I)V
    .locals 2
    .param p1, "value"    # I

    .line 82
    iget-object v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->values:[I

    iget v1, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->cursor:I

    aput p1, v0, v1

    .line 83
    return-void
.end method

.method public start()V
    .locals 1

    .line 47
    iget-object v0, p0, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->master:Lcom/trendmicro/hippo/ObjToIntMap;

    invoke-virtual {v0, p0}, Lcom/trendmicro/hippo/ObjToIntMap;->initIterator(Lcom/trendmicro/hippo/ObjToIntMap$Iterator;)V

    .line 48
    invoke-virtual {p0}, Lcom/trendmicro/hippo/ObjToIntMap$Iterator;->next()V

    .line 49
    return-void
.end method