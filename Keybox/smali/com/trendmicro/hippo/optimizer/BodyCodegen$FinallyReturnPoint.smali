.class Lcom/trendmicro/hippo/optimizer/BodyCodegen$FinallyReturnPoint;
.super Ljava/lang/Object;
.source "Codegen.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/trendmicro/hippo/optimizer/BodyCodegen;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "FinallyReturnPoint"
.end annotation


# instance fields
.field public jsrPoints:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public tableLabel:I


# direct methods
.method constructor <init>()V
    .locals 1

    .line 5533
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 5534
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/trendmicro/hippo/optimizer/BodyCodegen$FinallyReturnPoint;->jsrPoints:Ljava/util/List;

    .line 5535
    const/4 v0, 0x0

    iput v0, p0, Lcom/trendmicro/hippo/optimizer/BodyCodegen$FinallyReturnPoint;->tableLabel:I

    return-void
.end method
