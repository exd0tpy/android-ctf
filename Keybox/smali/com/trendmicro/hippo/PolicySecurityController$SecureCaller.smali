.class public abstract Lcom/trendmicro/hippo/PolicySecurityController$SecureCaller;
.super Ljava/lang/Object;
.source "PolicySecurityController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/trendmicro/hippo/PolicySecurityController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "SecureCaller"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 159
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract call(Lcom/trendmicro/hippo/Callable;Lcom/trendmicro/hippo/Context;Lcom/trendmicro/hippo/Scriptable;Lcom/trendmicro/hippo/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;
.end method