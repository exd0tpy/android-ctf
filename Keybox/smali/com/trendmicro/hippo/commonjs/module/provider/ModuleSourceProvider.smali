.class public interface abstract Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSourceProvider;
.super Ljava/lang/Object;
.source "ModuleSourceProvider.java"


# static fields
.field public static final NOT_MODIFIED:Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSource;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 26
    new-instance v6, Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSource;

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, v6

    invoke-direct/range {v0 .. v5}, Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSource;-><init>(Ljava/io/Reader;Ljava/lang/Object;Ljava/net/URI;Ljava/net/URI;Ljava/lang/Object;)V

    sput-object v6, Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSourceProvider;->NOT_MODIFIED:Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSource;

    return-void
.end method


# virtual methods
.method public abstract loadSource(Ljava/lang/String;Lcom/trendmicro/hippo/Scriptable;Ljava/lang/Object;)Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/URISyntaxException;
        }
    .end annotation
.end method

.method public abstract loadSource(Ljava/net/URI;Ljava/net/URI;Ljava/lang/Object;)Lcom/trendmicro/hippo/commonjs/module/provider/ModuleSource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/URISyntaxException;
        }
    .end annotation
.end method
