.class final enum Lcom/trendmicro/hippo/NativeCollectionIterator$Type;
.super Ljava/lang/Enum;
.source "NativeCollectionIterator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/trendmicro/hippo/NativeCollectionIterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/trendmicro/hippo/NativeCollectionIterator$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

.field public static final enum BOTH:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

.field public static final enum KEYS:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

.field public static final enum VALUES:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 16
    new-instance v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    const-string v1, "KEYS"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->KEYS:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    new-instance v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    const-string v1, "VALUES"

    const/4 v3, 0x1

    invoke-direct {v0, v1, v3}, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->VALUES:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    new-instance v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    const-string v1, "BOTH"

    const/4 v4, 0x2

    invoke-direct {v0, v1, v4}, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->BOTH:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    const/4 v1, 0x3

    new-array v1, v1, [Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    sget-object v5, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->KEYS:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    aput-object v5, v1, v2

    sget-object v2, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->VALUES:Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    aput-object v2, v1, v3

    aput-object v0, v1, v4

    sput-object v1, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->$VALUES:[Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 16
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/trendmicro/hippo/NativeCollectionIterator$Type;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .line 16
    const-class v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    return-object v0
.end method

.method public static values()[Lcom/trendmicro/hippo/NativeCollectionIterator$Type;
    .locals 1

    .line 16
    sget-object v0, Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->$VALUES:[Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    invoke-virtual {v0}, [Lcom/trendmicro/hippo/NativeCollectionIterator$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/trendmicro/hippo/NativeCollectionIterator$Type;

    return-object v0
.end method
